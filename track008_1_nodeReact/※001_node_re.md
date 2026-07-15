
## 0. SSR  vs  CSR
1) SSR ( Server-Side Rendering )
→ 서버가 완성된 HTML 은 만들어 클라이언트(브라우저)에게 보낸다
기술스택 : BOOT+ security + thymeleaf  + oracle + mybatis(backend+frontend) 
- 렌더링주체 : 서버
- 초기로딩   : 빠름
- 화면전화   : 새로고침

2) CSR ( Client-Side Rendering )
→ 클라이언트(브라우저) HTML + JS를 이용해서 화면그리기
기술스택     : node(backend)  /  react + next(frontend)
- 렌더링주체 : 브라우저
- 초기로딩   : 느림
- 화면전화   : 부드러움

> backend  : boot + security + jwt + redis + jpa
> frontend : react + next 



## 1. 프로젝트구조

```
back/
├── config/
│   └── db.js                  # Oracle DB 설정
├── middlewares/
│   └── isAuthenticated.js     # 로그인 인증 미들웨어
├── models/
│   └── users.js               # 사용자 DB 모델 및 쿼리 함수
├── passport/
│   ├── index.js               # Passport 초기화
│   └── local.js               # Local 전략 설정
├── routes/
│   └── user.js                # 사용자 관련 API 라우터
├── node_modules/              # npm 패키지
├── .env                       # 환경변수
├── app.js                     # 서버 진입점
├── package.json               # 프로젝트 설정 및 스크립트
├── package-lock.json          # 패키지 버전 고정
├── test1_model_testUsers.js   # 모델 함수 테스트 스크립트
```

https://nodejs.org/ko
1) 다운로드 및 설치
2) 확인
```
node -v
npm  -v
```
3) 관리자 권한으로 power shell 실행 
★ vscode에서 node 사용이 안되면 power shell 문제 에러 확인
1. vs code에서 문제 발생
```js
PS D:\Hyunju\workspace\fullstack_hj\track008_node+react> node -v
node : 'node' 용어가 cmdlet, 함수, 스크립트 파일 또는 실행할 수 있는 프로그램 이름으로 인식되지 않습니다. 이름이 정확한지 확인하고 경로가 포함된 경우 경로가 올바른지 검증한 다음 다시 시도하십시오.
위치 줄:1 문자:1
+ node -v
+ ~~~~
    + CategoryInfo          : ObjectNotFound: (node:String) [], CommandNotFoundException
    + FullyQualifiedErrorId : CommandNotFoundException
 
PS D:\Hyunju\workspace\fullstack_hj\track008_node+react>
```
```js
PS C:\Users\tj-bu-703-22> npm -v
npm : 이 시스템에서 스크립트를 실행할 수 없으므로 C:\Program Files\nodejs\npm.ps1 파일을 로드할 수 없습니다. 자세한 내
용은 about_Execution_Policies(https://go.microsoft.com/fwlink/?LinkID=135170)를 참조하십시오.
위치 줄:1 문자:1
+ npm -v
+ ~~~
    + CategoryInfo          : 보안 오류: (:) [], PSSecurityException
    + FullyQualifiedErrorId : UnauthorizedAccess
PS C:\Users\tj-bu-703-22>
```


```cmd
--  power shell
Get-ExecutionPolicy
Set-ExecutionPolicy  RemoteSigned

PS C:\Users\TJ-BU-703-강사PC> Get-ExecutionPolicy
Restricted
PS C:\Users\TJ-BU-703-강사PC> Set-ExecutionPolicy  RemoteSigned
y
PS C:\Users\TJ-BU-703-강사PC> Get-ExecutionPolicy
RemoteSigned

- RemoteSigned : 로컬에서 만든  스크립트 실행가능
```



### 1) 프로젝트만들기
0. 구조확인
```
back/    node   
front/   react + next
```

1. 프로젝트만들기
```js
npm  init
```
2. 실습
```
mkdir back
cd    back
npm   init
```
 
### 2) 패키지 설치
```
npm  install
```

```
{
  "name": "back",  
  "version": "1.0.0",
  "main": "app.js",
  "scripts": {
    "dev": "nodemon app",   -- 개발시
    "start": "cross-env NODE_ENV=production pm2 start app.js"  -- 운영환경
  },
  "dependencies": {
    "aws-sdk": "^2.710.0",   -- aws  서비스 연동
    "bcrypt": "^5.1.0",      -- 비밀번호 암호화
    "cookie-parser": "^1.4.6",  -- 쿠키 데이터 파싱
    "cors": "^2.8.5",           -- 웹보안정책 cors
    "cross-env": "^7.0.3",   -- 운영체제별 환경변수 통일
    "dotenv": "^16.3.1",   -- 환경변수 파일관리
    "express": "^4.21.2",   -- node.js 웹서버 프레임워크
    "express-session": "^1.17.3",  -- 로그인 상태 세션관리
    "helmet": "^7.0.0",    -- 보안관련 http 헤더설정
    "hpp": "^0.2.3",       -- http 파라미터 오염방지 보안
    "morgan": "^1.10.0",   -- 서버 요청 로그기록
    "multer": "^1.4.5-lts.1",  -- 파일업로드 미들웨어
    "oracledb": "^6.4.0",   -- oracle 
    "passport": "^0.7.0",  -- 인증처리
    "passport-local": "^1.0.0",  -- 이메일/비번 로그인
    "pm2": "^5.3.0",  -- 서버 무중단 관리
    "swagger-jsdoc": "^6.2.8",  -- api 문서화엔진
    "swagger-ui-express": "^5.0.1"  -- 페이지처리
  },
  "devDependencies": {
    "nodemon": "^3.0.1"   -- 개발중에 코드변경 자동반영
  }
}

```

### 3) 서버진입점
```
back/
├── app.js                     # 서버 진입점 
```
1. app.js
```

```
2. 실행
```
npx  nodemon  app.js
```
3. 브라우저 실행
브라우저에서   http://localhost:3065


## 2. 개발

```
back/
├── config/
│   └── db.js                  # Oracle DB 설정
├── middlewares/
│   └── isAuthenticated.js     # 로그인 인증 미들웨어
├── models/
│   └── users.js               # 사용자 DB 모델 및 쿼리 함수
├── passport/
│   ├── index.js               # Passport 초기화
│   └── local.js               # Local 전략 설정
├── routes/
│   └── user.js                # 사용자 관련 API 라우터
├── node_modules/              # npm 패키지
├── .env                       # 환경변수
├── app.js                     # 서버 진입점
├── package.json               # 프로젝트 설정 및 스크립트
├── package-lock.json          # 패키지 버전 고정
├── test1_model_testUsers.js   # 모델 함수 테스트 스크립트
```

### 1) model

```
back/
├── config/
│   └── db.js                  # Oracle DB 설정
├── models/
│   └── users.js               # 사용자 DB 모델 및 쿼리 함수 
├── .env                       # 환경변수 
├── test1.js                   # 모델 함수 테스트 스크립트
```

1.  id: node / pass: react  oracle유저만들기
2.  appuser 테이블
3.  .env
4.  [config] - db.js 
5.  [models] - users.js 
6.  모델함수 테스트


#### 1.  id: node / pass: react  oracle유저만들기
```sql
-- cmd
-- sqlplus
-- conn  system/1234
 
-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user node  identified by react;

-- 권한부여
grant  connect , resource  to node;

ALTER USER node DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to node;
```

#### 2.  appuser 테이블
```sql
SQL> desc appuser;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 APP_USER_ID                               NOT NULL NUMBER
 EMAIL                                     NOT NULL VARCHAR2(255)
 PASSWORD                                  NOT NULL VARCHAR2(255)
 NICKNAME                                           VARCHAR2(100)
 MOBILE                                             VARCHAR2(20)
 MBTI_TYPE_ID                                       NUMBER
 UFILE                                              VARCHAR2(255)
 CREATED_AT                                         DATE

SQL> create sequence  APPUSER_SEQ;
```

```sql
DROP  TABLE APPUSER  CASCADE CONSTRAINTS;

CREATE TABLE APPUSER (
    APP_USER_ID     NUMBER NOT NULL,
    EMAIL           VARCHAR2(255) NOT NULL UNIQUE,
    PASSWORD        VARCHAR2(255) NOT NULL,
    NICKNAME        VARCHAR2(100),
    MOBILE          VARCHAR2(20),
    MBTI_TYPE_ID    NUMBER,
    UFILE           VARCHAR2(255),
    CREATED_AT      DATE DEFAULT SYSDATE,
    CONSTRAINT PK_APPUSER PRIMARY KEY (APP_USER_ID)
);

CREATE SEQUENCE APPUSER_SEQ;
```

#### 3.  .env
```
# 세션 쿠키 암호화 키
COOKIE_SECRET=appsecret

# Oracle DB 접속 정보
DB_USER=node
DB_PASSWORD=react
DB_CONNECT=localhost:1521/XE
```

#### 4.  [config] - db.js 
```js
// config/db.js
require('dotenv').config();
module.exports = {
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  connectString: process.env.DB_CONNECT  //localhost:1521/XE
};
```
#### 5.  [models] - users.js 
```js
//1.  require
const  dbConfig = require('../config/db');  //user, password, connectString
const  oracledb = require('oracledb');
const  bcrypt    = require('bcrypt');   //## bcrypt
// oracle 초기화
oracledb.initOracleClient(); 
const options = { outFormat: oracledb.OUT_FORMAT_OBJECT , autoCommit:true }; 

//2. 각기능 sql
// 1. create - insert
// ### 1. 사용자 등록 (Create - Insert)
// INSERT INTO appuser (
//     APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE,    CREATED_AT
// ) VALUES (
//     APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile,    SYSDATE
// )
async function  createUser( email,     password,    nickname,      mobile,    mbtiTypeId,      ufile){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const  hashedPassword = await  bcrypt.hash(password , 10);
        const  result = await conn.execute( 
            `INSERT INTO appuser (
                APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE,    CREATED_AT
             ) VALUES (
                APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile,    SYSDATE
             )` 
            , {email,     password:hashedPassword,    nickname,      mobile,    mbtiTypeId,      ufile} 
            , options);  // sql, 사용자입력값, 옵션
    }catch(err){
        console.log(  'createUser Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
}


// 2. 사용자조회 - email
// ### 2. 사용자 조회 (Email 기준)
// SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// WHERE EMAIL = :email 
async function  findUserByEmail(email){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
             FROM appuser 
             WHERE EMAIL = :email` 
             , {email} 
             , options); //실행
        return result.rows[0];  //결과처리    
    }catch(err){
        console.log(  'findUserByEmail Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
}


// 3. 사용자조회 - id
// ### 3. 사용자 조회 (ID 기준)
// SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// WHERE APP_USER_ID = :id
async function  findUserById(id){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
             FROM appuser 
             WHERE APP_USER_ID = :id` 
             , {id} 
             , options); //실행
        return result.rows[0];  //결과처리    
    }catch(err){
        console.log(  'findUserById Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
}

// 4. 로그인 - sql 빼기 pass /  로그아웃
// ### 4. 로그인 & 로그아웃
async function  verifyUser(   email, password ){
    const user = await  findUserByEmail(email);
    if(!user)  return null;

    const  match = await bcrypt.compare(  password , user.PASSWORD);
    if(!user)  return null;

    return {
        id:   user.APP_USER_ID, 
        email : user.EMAIL , 
        nickname: user.NICKNAME,
    }
} 


// 5. 전체조회 
// ### 5. 전체 사용자 조회 (Read All)
// SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// ORDER BY CREATED_AT DESC
async function  getAllUsers(){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
             FROM appuser 
             ORDER BY CREATED_AT DESC` 
             , {} 
             , options); //실행
        return result.rows;  //결과처리   
    }catch(err){
        console.log(  'getAllUsers Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

// 6. 닉네임수정
// ### 6. 닉네임 수정 (Update Nickname)
// UPDATE appuser 
// SET NICKNAME = :nickname 
// WHERE APP_USER_ID = :id
async function  updateUserNickname(  nickname , id  ){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `UPDATE appuser 
             SET NICKNAME = :nickname 
             WHERE APP_USER_ID = :id` 
             , {nickname , id } 
             , options); //실행
    }catch(err){
        console.log(  'updateUserNickname Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

// 7. 사용자 삭제
// ### 7. 사용자 삭제 (Delete)
// DELETE FROM appuser 
// WHERE APP_USER_ID = :id
async function  deleteUser( id ){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `DELETE FROM appuser  
             WHERE APP_USER_ID = :id` 
             , { id } 
             , options); //실행
    }catch(err){
        console.log(  'deleteUser Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

// 8. 닉네임조회
// ### 8. 닉네임 조회 
// SELECT APP_USER_ID, EMAIL, NICKNAME 
// FROM appuser 
// WHERE NICKNAME = :nickname  
async function  findUserByNickname(nickname){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
        `SELECT APP_USER_ID, EMAIL, NICKNAME 
        FROM appuser 
        WHERE NICKNAME = :nickname` 
        , {nickname} 
        , options); //실행
        return result.rows[0];  //결과처리  
    }catch(err){
        console.log(  'findUserByNickname Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

//3. export
module.exports = {  createUser ,  findUserByEmail ,  findUserById, 
                    verifyUser , getAllUsers , updateUserNickname , deleteUser , findUserByNickname};

```
#### 6.  모델함수 테스트
```js
const { 
    createUser, 
    findUserByEmail, 
    verifyUser, 
    getAllUsers, 
    updateUserNickname, 
    deleteUser, 
    findUserById, 
    findUserByNickname 
} = require('./models/users');

async function runTests() {
    try {
        console.log('--- 🧪 [테스트 시작] ---');

        // 1. 회원가입
        await createUser('t@t', 't', 'tt', '0101111111', 1, '1.png');  
        console.log('✅ 1. createUser 성공');

        // 2. 이메일로 조회
        const userByEmail = await findUserByEmail('t@t');  
        console.log('✅ 2. findUserByEmail 결과: ', userByEmail);

        // 3. 로그인 검증 (비밀번호 맞는 경우)
        const loginUser = await verifyUser('t@t', 't');  
        console.log('✅ 3. verifyUser 결과 (비밀번호 일치): ', loginUser);

        // 4. 로그인 검증 (비밀번호 틀린 경우)
        const failLogin = await verifyUser('t@t', 'wrong');  
        console.log('✅ 4. verifyUser 결과 (비밀번호 불일치): ', failLogin);
        
        // 5. 전체조회
        const allUsers = await getAllUsers();  
        console.log('✅ 5. getAllUsers 결과:', allUsers);
        
        // 6. 닉네임 수정 (순서 수정됨: nickname, id)
        await updateUserNickname('AA', userByEmail.APP_USER_ID);  
        const updateUser = await findUserById(userByEmail.APP_USER_ID);
        console.log('✅ 6. updateUserNickname 결과:', updateUser);

        // 7. 사용자 삭제
        // await deleteUser(userByEmail.APP_USER_ID);  
        // console.log('✅ 7-1. deleteUser 성공');
        // const deletedUser = await findUserById(userByEmail.APP_USER_ID);
        // console.log('✅ 7-2. findUserById (삭제 후 조회결과 - null 기대):', deletedUser);

 
 
        // 8-1. 이미 존재하는 닉네임 'tt'로 테스트용 사용자 회원가입
        await createUser('test2@test.com', 'pw', 'tt', '0101111111', 1, '1.png');
        console.log('✅ 8-1. createUser(tt) 성공');

        // 8-2. 닉네임 중복 검사 실행 (중복 발생 시나리오)
        const duplicateNickname = await findUserByNickname('tt');
        if (duplicateNickname) {
            console.log('✅ 8-2. findUserByNickname 결과: 닉네임 중복 확인됨 (값 있음)');
        } else {
            console.log('❌ 8-2. findUserByNickname 결과: 닉네임이 없다고 나옴 (검증 실패)');
        }

        // 8-3. 존재하지 않는 닉네임 검사 (사용 가능 시나리오)
        const newNickname = await findUserByNickname('uniqueName123');
        if (!newNickname) {
            console.log('✅ 8-3. findUserByNickname 결과: 닉네임 사용 가능 (값 없음)');
        }

    } catch (err) {
        console.error('❌ 닉네임 테스트 중 오류 발생:', err);
    }
}

runTests();

//  node   test1.js


``` 


### 2) controller
back/
├── routes/
│   └── user.js                # 사용자 관련 API 라우터 
├── app.js

1. [routers] - user.js
```
주소경로
post : /user/register (requestBody)
post : /user/login    (requestBody)
post : /user/logout   
get  : /user/
patch: /user/{id}/nickname
※비교  /user/nickname?id=1
delete: /user/{id}
```

patch: /user/{id}/nickname   ← rest 방식     데이터접근방식 : url 자원소스가 포함
※비교  /user/nickname?id=1   ← 쿼리스트링     데이터접근방식 : url ?key=value


2. app.js
```

```


### 3) security
back/
├── middlewares/
│   └── isAuthenticated.js     # 로그인 인증 미들웨어
├── passport/
│   ├── index.js               # Passport 초기화
│   └── local.js               # Local 전략 설정
├── routes/
│   └── user.js                # 사용자 관련 API 라우터 
├── app.js


3. [passport] -  index.js /  local.js
4. [middlewares] -  isAuthenticated.js 