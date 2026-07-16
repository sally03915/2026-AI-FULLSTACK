////////////////////////////////////////////////////////// require
// router
const  express = require('express');
const  session = require('express-session');    //##
const  passport = require('passport');        //##

// 환경변수 .env
const dotenv = require('dotenv');
// 로그기록용 (개발시 요청/응답 확인) 미들웨어
const morgan = require('morgan');
// cors(다른도메인에서 api 호출허용) 미들웨어
const cors = require('cors');
const fs = require('fs');                      //##
const https = require('https');             //##

// swaggerUi (api문서 자동화)
const  swaggerUi    = require('swagger-ui-express'); 
const  swaggerJsdoc = require('swagger-jsdoc');
// 라우터연결
const  userRouter = require('./routes/user');  
//const  postRouter = require('./routes/post'); 예시
////////////////////////////////////////////////////////// setting
//  .env 파일로드 (환경변수 사용가능)
dotenv.config();
//  express 인스턴스 생성
const  app = express();
// json 파싱 미들웨어 (POST요청  body를 json 읽기)
app.use(express.json());
// form 데이터처리
app.use(express.urlencoded({extended: true}));
// 모든 도메인에 api 호출 허용
//app.use(cors());
// 개발모드에서 요청로그출력
//app.use( morgan('dev'));
app.use(cors({
  origin: 'http://localhost:3000' ,   
  credentials: true                   
}));

//세션설정
app.use(session({
  secret: process.env.COOKIE_SECRET,       //.env에 저장된 쿠키 암호화 키
  resave: false ,                          // 매 요청마다 세션 강제 저장 여부(false 권장)
  saveUninitialized: false,                // 초기화되지 않은 세션 저장 여부(false 권장)
  cookie: {httpOnly: true, secure: false}  // httpOnly: JS 접근 불가 , secure: HTTPS만 사용여부
}));
// Passport 초기화 및 세션설정 
app.use(passport.initialize());
app.use(passport.session()); 
 
const passportConfig = require('./passport');
passportConfig();

const swaggerOptions = {
  definition: {
    openapi: '3.0.0',   
    info: {
      title: 'User API',    
      version: '1.0.0',      
      description: '회원가입, 로그인, 사용자 조회/수정/삭제 API 문서', //설명
    },
  },
  apis: ['./routes/*.js'],  
}; 
// Swagger  문서생성
const swaggerSpecs = swaggerJsdoc(swaggerOptions);

//////////////////////////////////////////////////////////  router
// Swagger UI 엔드포인트 등록
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpecs));
app.use('/user' , userRouter)   
app.get('/' , (req, res)=>{    res.send('hello express');   }); 

app.use((err, req, res, next) => {
  console.error('서버 에러:', err.stack);         
  res.status(500).json({ message: '서버 내부 오류 발생' });  
});
 
const PORT = process.env.PORT || 3065; 
if (fs.existsSync('./cert/server.key') && fs.existsSync('./cert/server.crt')) {
  const options = {
    key: fs.readFileSync('./cert/server.key'),    
    cert: fs.readFileSync('./cert/server.crt'),  
  };
  https.createServer(options, app).listen(PORT, () => {
    console.log(`✅ HTTPS 서버 실행 중! https://localhost:${PORT}`);
    console.log(`✅ Swagger UI: https://localhost:${PORT}/api-docs`);
  });
} else {
  app.listen(PORT, () => {
    console.log(`✅ HTTP 서버 실행 중! http://localhost:${PORT}`);
    console.log(`✅ Swagger UI: http://localhost:${PORT}/api-docs`);
  });
}

//실행 : npx  nodemon app.js