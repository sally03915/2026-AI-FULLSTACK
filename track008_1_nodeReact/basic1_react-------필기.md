## 📁 프로젝트 구조

```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
├── reducers/               # ✅ Redux 리듀서 폴더
│   ├── index.js            # 루트 리듀서 (combineReducers)
│   ├── user.js             # 사용자 관련 리듀서
│   └── user.test.js        # 리듀서 테스트 코드
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
├── .babelrc                # Babel 설정 파일
├── .eslintrc               # ESLint 설정 파일
├── package-lock.json       # npm 의존성 잠금 파일
├── package.json            # 프로젝트 메타 정보 및 의존성
└── setupTests.js           # 테스트 환경 설정 파일

```

---
## 1. 프로젝트초기화

### 1. 프로젝트 만들기
```
npm init
```

[실습]
```
mkdir front
cd front
npm init
```

### 2. 프로그램 설치
```
npm install
```

[실습]
```
package.json 프로젝트 폴더에 넣기
npm install
```

### 3. 서버진입점
```
front/
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더 
│   ├── index.js            # 메인 페이지
```

```
npm run dev
```


### 4. 구조안내,개발

1. 프로젝트 생성  `package.json`   , `node_modules` , `pages`
2. 앱 진입점     `pages/index.js` , `pages/_app.js`
3. 스타일   적용 `styles/globals.css` 가  `_app.js`에서 import됨
4. 실행확인      `npm run dev` 

```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
├── reducers/               # ✅ Redux 리듀서 폴더
│   ├── index.js            # 루트 리듀서 (combineReducers)
│   ├── user.js             # 사용자 관련 리듀서
│   └── user.test.js        # 리듀서 테스트 코드
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
├── .babelrc                # Babel 설정 파일
├── .eslintrc               # ESLint 설정 파일
├── package-lock.json       # npm 의존성 잠금 파일
├── package.json            # 프로젝트 메타 정보 및 의존성
└── setupTests.js           # 테스트 환경 설정 파일

```

1. 각구조만들기(폴더생성)
2. 각설정파일
```
front/
├── .babelrc                # Babel 설정 파일  : JSX →  일반 JS로 변환 브라우저가 이해할수 있게
                                            최신문법(async/await , optional chaining 등)
├── .eslintrc               # ESLint 설정 파일 : 일관된 코드스타일 유지 (들여쓰기,세미콜론,따옴) / 팀규칙
└── setupTests.js           # 테스트 환경 설정 파일 : 테스트환경 설정파일 환경초기
```

3. css
```
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
```


4. page
```
front/
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
```

1. components/Layout.js 
2. pages/_app.js
3. pages/index.js

1)  login.js 호출  → `_app.js`   → `<Layout>` 렌더링
2)  `<Layout>` 안에서 Navbar, Footer 렌더링
3)  Component 가 `children`으로 들어가서 본문영역에 표시



### 5. 개발 ( reducer - saga - view )  (1) 상태 - reducer
1. reducer (주방 레시피대로 상태바꾸기 - 치킨의 상태) 조리시작, 조리중, 조리완료
2. saga    (배달기사 - 서버에 다녀오기)
3. store   (치킨집  - 모든상태를 모아두는 중앙창고 / 주방(reducer),배달(saga))

1) `View` 손님이 주문 `/users/login.js` →  (store에 액션 전달: 치킨집) 
                                      →  액션을 saga/reducer로 전달    
2) 배달기사가 서버에 다녀오고       (saga)      성공/실패
3) 주방레시피대로 상태바꾸기        (reducer)   결과에 따라 상태(state)를 변경
4) 치킨집(store) 업데이트         
5) `View` 화면반영  → 상태감지하고 화면에 그림그리기

```
사용자 액션 (버튼클릭, 로그인 요청 등)
             ↓
        [View  컴포넌트]   
    _______________________________
    - dispatch({type:LOG_IN_REQUEST , data})
    - 화면에서 액션발생    

             ↓
          [Store]
    _______________________________
    - 중앙창고 (Redux Store)
    - 모든상태(state)저장
    - 액션을  reducer/saga 로 전달

             ↓
          [Saga (Middleware)]
    _______________________________
    - 비동기 작업 담당 (API)
    - 예) axios.post('/user/login')
    - 성공 -  LOG_IN_SUCCESS
    - 실패 -  LOG_IN_FAILURE
    
             ↓
          [Reducer]
    _______________________________
    - 상태(state) 변경 규칙서
    - LOG_IN_SUCCESS → me 업데이트
    - LOG_IN_FAILURE → error 저장

             ↓
          [Store]
    _______________________________
    - 변경된 상태를 중앙창고에 반영

             ↓

        [View  리렌더링]   
    _______________________________
    - useSelector로 상태읽기

```






1. [reducers] - user.js    ※ post.js, hashtag.js,,,,,
2. [reducers] - index.js
3. [reducers] - user.test.js

 
 
### 6. 개발 ( reducer - saga - view )  (2) 서버연결 - saga

front/
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드

1. sagas/index.js 
2. sagas/user.js  
3. sagas/user.test.js   

--

1. 제너레이터 함수 : 중간정산

```js
function* g1(){
    let i=0;
    while(true){
        yield i++;
    }
}
const gen1 = g1();   //제너레이터 객체 생성

console.log(   gen1.next().value  );  // gen1.next() 호출
console.log(   gen1.next().value  );  // gen1.next() 호출
```
```js
function* g2(){
    console.log("first");
    yield 1; //첫 번째 반환
    
    console.log("second");
    yield 2; //두 번째 반환
        
    console.log("third");
    yield 3; //세 번째 반환
}

const gen2 = g2();   //제너레이터 객체 생성

console.log(   gen2.next() );
console.log(   gen2.next() );
console.log(   gen2.next() );
```

2.  saga 기본함수
1) all  - 여러 safa를 동시에 실행
2) fork - [비동기]로 saga 실행 
3) call - api를 호출하고 결과를 기다림( blocking )  > 동기
4) put  - redux 액션을 dispatch
5) takeLatest - 특정액션을 감지하고 가장 마지막 액션만 처리

##
1. post: /user/register  - data
 *               email: { type: string }
 *               password: { type: string }
 *               nickname: { type: string }
 *               mobile: { type: string }
 *               mbtiTypeId: { type: integer }
 *               ufile: { type: string }

2. post: /user/login    - data
 *               email: { type: string }
 *               password: { type: string }

3. post: /user/logout  

4. get: /user/   

5. patch: /user/{id}/nickname  - data
 *               nickname: { type: string }

6. delete : /user/{id} 






### 7. 개발 ( reducer - saga - view )  (3) Store
```
front/
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
```

1. store/configureStore.js
2. store/configureStore.test.js


### 8. view
```
front/
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
```

1. `useSelector`  → Redux store에서 사용자 상태 가져오기
2. `useEffect`    → 로그인 여부 확인 및 사용자 목록 불러오기
3. `dispatch`     → 액션발생 (로그인, 사용자 삭제,,,)

1. 회원가입
2. 로그인
3. 로그아웃
4. 사용자리스트
5. 닉네임 수정
6. 유저삭제
