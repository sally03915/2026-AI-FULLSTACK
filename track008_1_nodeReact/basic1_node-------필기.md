##1. node+react

###1. node.js
- javasciprt 런타임환경
- 비동기 이벤트 기반

#### (1) 설치
https://nodejs.org/ko

1. 다운로드
2. 설치
3. 설치확인
```cmd
C:\Users\TJ-BU-703-강사PC>node -v
v24.12.0
C:\Users\TJ-BU-703-강사PC>npm -v
11.6.2
C:\Users\TJ-BU-703-강사PC>
```
4. vs code에서 열기 ( node인식못하는경우)
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

4-1. power shell - node인식확인 (node -v)
4-2. 오류
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
4-3. 관리자권한으로 power shell 실행
```js
Get-ExecutionPolicy
Set-ExecutionPolicy  RemoteSigned

PS C:\Users\TJ-BU-703-강사PC> Get-ExecutionPolicy
Restricted
PS C:\Users\TJ-BU-703-강사PC> Set-ExecutionPolicy  RemoteSigned
y
PS C:\Users\TJ-BU-703-강사PC> Get-ExecutionPolicy
RemoteSigned

- RemoteSigned : 로컬에서 만든ㄷ 스크립트 실행가능

```



#### (2) 프로젝트 만들기
```js
npm init
```

■ [실습]
```
[project]
ㄴ back    # node  ✅
ㄴ front   # react
```


```js
mkdir back
cd back
npm init
```

■ 구조확인
back/
├── config/
│   └── db.js              #     Oracle Db 설정           
├── middlewares/
│   └── isAuthenticated.js #     로그인 인증 미들웨어      
├── models/
│   └── users.js           #     사용자 DB 모델 및 쿼리함수    
├── passport/
│   ├── index.js           #     Password 초기화  
│   └── local.js           #     Local 전략 설정   
├── routes/
│   └── user.js            #     사용자관련 api 라우터  
├── node_modules/          #     npm 패키지    
├── .env                   #     환경변수  
├── app.js                 #     서버 진입점        
├── package.json           # ✅ 프로젝트 설정 및 스크립트      
├── package-lock.json      #    패키지 버젼 고정 
├── test1_model_testUsers.js  # 테스트스크립트 

```js
사용하고자하는 모듈설정이 들어간 package.json 폴더에 넣기
npm install
```



#### (3) 서버진입점 (`app.js`)
1. app.js 작성
2. 실행
```js
npx  nodemon  app.js
```

### 2. 개발
### 1. model
(1) 테이블확인
```js
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

(2) db설정 
back/
├── config/
│   └── db.js              #     Oracle Db 설정        
├── .env                   #     환경변수  
├── models/
│   └── users.js           #     사용자 DB 모델 및 쿼리함수  
├── test1.js               #     테스트스크립트   

2-1. .env   
2-2. [config] - db.js 

(3) [models] - [users.js]

(4) 모델함수 테스트

```js
node test1.js
```

```js
PS D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back>
✅서버 실행중! http://localhost:3065
PS D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back> node  test1.js
createUser  Error Error: NJS-138: connections to this database server version are not supported by node-oracledb in Thin mode
    at Object.throwErr (D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\node_modules\oracledb\lib\errors.js:776:10)
    at ThinConnectionImpl.connect (D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\node_modules\oracledb\lib\thin\connection.js:897:14)
    at process.processTicksAndRejections (node:internal/process/task_queues:103:5)
    at async Object.getConnection (D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\node_modules\oracledb\lib\oracledb.js:791:3)
    at async Object.getConnection (D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\node_modules\oracledb\lib\util.js:298:16)
    at async createUser (D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\models\users.js:17:16)
    at async runTests (D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\test1.js:8:5) {  
  code: 'NJS-138',
  isRecoverable: false
}
D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\test1.js:38
   }catch(err){  console.err('❌ 테스트 중 오류 발생:' , err); }
                         ^

TypeError: console.err is not a function
    at runTests (D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back\test1.js:38:26)        
    at process.processTicksAndRejections (node:internal/process/task_queues:103:5)

Node.js v24.12.0
PS D:\hyojung\full_stack_20250825_com\msa-fullstack2025\track008_node+react\basic1_node_react\back>
```

> 


### 2. ROUTE (router)
back/
├── routes/
│   └── user.js            #     사용자관련 api 라우터  

주소경로
post : /user/register (requestBody)
post : /user/login    (requestBody)
post : /user/logout   
get  : /user/
patch: /user/{id}/nickname
※비교  /user/nickname?id=1
delete: /user/{id}

1. app.js
app.use('/user' , userRouter) 

2 [routes] - user.js



### 3. Passport / 미들웨어 로그인 흐름 확인
```js
back/       
├── middlewares/
│   └── isAuthenticated.js #     로그인 인증 미들웨어      
├── passport/
│   ├── index.js           #     Password 초기화  
│   └── local.js           #     Local 전략 설정   
```
1.   [passport] - local.js   Local 전략 설정   
2.   [passport] - index.js   Password 초기화  
3.   [middlewares] - isAuthenticated.js   로그인 인증 미들웨어  
4.   [router]   - user.js    
5.   app.js 


1. 클라이언트요청     /user/login
2. 라우터    rotes/user.js 
3. passport/local.js : ★LocalStategy - 이메일/비번검증해서 성공시 user반환
    DB조회   - findUserByEmail  성공 done(null, user) 사용자반환
4. passport/index.js : 로그인 성공시 호출 - user.APP_USER_ID 세션저장
    ★serializeUser : 세션에 pk저장
    ★deserializeUser : 세션의 pk로 db조회
5. app.js   :  세션저장 ( express-session) 쿠키(connect.sid) 발급
6. passport/index.js : 이후 요청마다 , deserializeUser 세션에 저장된 APP_USER_ID 꺼내 
                       사용자 정보 복원
7. middlewares/isAuthenticated.js : req.isAuthenticated()  로그인 여부 확인 , X면 401
    ★isAuthenticated: 로그인여부 체크
8. routes/users.js 로그아웃: 세션, 쿠키 제거
