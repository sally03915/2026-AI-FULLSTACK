### 1. 프로젝트 

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


1. 프로젝트만들기
2. 프로그램설치
3. 서버진입점

#### 1. 프로젝트만들기
```js
npm init
```
> 실습)
```
mkdir front
cd    front
npm   init
```

#### 2. 프로그램설치
```js
npm install
```
```js
- package.json

{
  "name": "front",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "dev": "next -p 3000",   // 3000 포트로 로컬개발
    "build": "cross-env ANALYZE=true NODE_ENV=production next build",//배포빌드
    "start": "cross-env NODE_ENV=production next start -p 3060", // 배포 - 3060 포트실행
    "test": "jest"  // jest 활용해서 테스트코드 실행
  },
  "author": "sally",
  "license": "ISC",
  "dependencies": {
    "@ant-design/icons": "^4.3.0",   // ant design UI 라이브러이 
    "@next/bundle-analyzer": "^12.3.4",  // 사용하는 용량- 시각분석도구
    "@reduxjs/toolkit": "^1.9.7",  // 전역저장공간
    "antd": "^4.8.6",
    "axios": "^1.3.4",   // 백엔드 api 서버와 통신 http 라이브러리
    "babel-plugin-styled-components": "^1.12.0",  // ssr환경 클래스명 충돌방지
    "bootstrap": "^5.3.8",  // 전반적인 웹스타일링
    "cross-env": "^7.0.2",  // 운영체제 상관없이 (window, mac, linux) 환경변수 설정
    "dotenv": "^16.0.1",  // 중요키
    "express": "^5.2.1", // 웹서버
    "faker": "^4.1.0",   // 가짜데이터 무작위생성도구
    "immer": "^9.0.19",  // 코드 짧게 줄이기
    "jest": "^29.7.0",   // 테스트도구 
    "moment": "^2.29.1", // 날짜 및 시간데이터 포맷팅 
    "next": "^12.3.4",  // react 에서 ssr 지원프레임워크
    "next-redux-wrapper": "^6.0.2",  // 연결
    "pm2": "^4.5.0",  // 배포환경에서 node.js 프로세스 계속실행되게 관리
    "prop-types": "^15.7.2",  // 전달되는 props타입 검사
    "react": "^17.0.2", 
    "react-dom": "^17.0.2",  // 브라우저 dom 렌더링
    "react-redux": "^8.0.5",
    "react-slick": "^0.28.1",  // 이미지 슬라이더 및 캐러셀
    "redux": "^4.0.5",
    "redux-devtools-extension": "^2.13.8",
    "redux-saga": "^1.1.3",   // 비동기처리 
    "shortid": "^2.2.16",   // 고유id
    "styled-components": "^5.2.1",  // css 작성가능하게
    "swr": "^0.3.9"
  },
  "devDependencies": {
    "@testing-library/jest-dom": "^6.0.0",
    "@testing-library/react": "12.1.5",
    "babel-eslint": "^10.1.0",
    "babel-jest": "^30.2.0",
    "eslint": "^7.14.0",
    "eslint-config-airbnb": "^18.2.1",
    "eslint-plugin-import": "^2.22.1",
    "eslint-plugin-jsx-a11y": "^6.4.1",
    "eslint-plugin-react": "^7.21.5",
    "eslint-plugin-react-hooks": "^4.2.0",
    "identity-obj-proxy": "^3.0.0",
    "jest-environment-jsdom": "^29.7.0",
    "nodemon": "^2.0.4",
    "webpack": "^5.65.0"
  },
  "jest": {
    "testEnvironment": "jsdom",  // 테스트 가상환경 dom
    "setupFilesAfterEnv": [
      "<rootDir>/setupTests.js"
    ],
    "moduleNameMapper": {
      "\\.(css|less|scss|sass)$": "identity-obj-proxy",
      "\\.(jpg|jpeg|png|gif|webp|svg)$": "<rootDir>/__mocks__/fileMock.js"
    }
  }
}

```

#### 3. 서버진입점
```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   └── index.js            # 메인 페이지 
├── package-lock.json       # npm 의존성 잠금 파일
└── package.json            # 프로젝트 메타 정보 및 의존성 
```

1. [pages] - index.js
```
export  default function  Home(){
    return <h1>REACT PROJECET 정상실행</h1>;
}
```

2. 서버실행
```
npm run dev
```


### 2. 구조안내 , 개발시작

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

1. 각 구조만들기 ( 폴더생성 )
2. 설정파일
front/
├── .babelrc                # Babel 설정 파일 : jsx → 일반 js로 변환 브라우저 이해할수 있게, 
                                               최신문법( async/await , optional chaining 등)
├── .eslintrc               # ESLint 설정 파일 : 일관된 코드스타일 유지 (들여쓰기,세미콜론, 따옴) / 팀규칙
└── setupTests.js           # 테스트 환경 설정 파일 : 테스트환경 설정파일 환경초기

> setupTests.js
```
//1. React Test Library - dom
import '@testing-library/jest-dom';

//2. react 테스트 끝나면 cleanup 자동실행- dom 정리
import { cleanup } from '@testing-library/react';
afterEach(() => {
  cleanup();
});
```

3. 글로벌 css
front/
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일

```
/* styles/globals.css */
body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Noto Sans KR', sans-serif;
  background-color: #f8f9fa; /* Bootstrap 기본 배경색 */
} 
```

4. page  기본셋팅
```
front/ 
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트 
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   └── index.js            # 메인 페이지 
```

1) [components] - Layout.js  공통틀 (헤더, 네이게이션, 푸터)
2) [pages]      - _app.js    모든페이지들을 `Layout`감싸는 진입점
3) [pages]      - index.js   본문콘텐츠

> _app.js  Layout 감싸서 영역안에 {children} 
step1) localhost:3000 접속
step2) Layout에서의  헤더, 네이게이션, 푸터 렌더링
step3) 본문영역 main.container 안에 콘텐츠 출력
 

##### 1) [components] - Layout.js  공통틀 (헤더, 네이게이션, 푸터)
```
```
##### 2) [pages]      - _app.js    모든페이지들을 `Layout`감싸는 진입점
```
```
##### 3) [pages]      - index.js   본문콘텐츠
```
```


5. 개발 ( reducer - saga - view )  (1) reducer
1. reducer (주방 레시피대로 상태바꾸기 - 치킨의 상태) 조리시작, 조리중, 조리완료
2. saga    (배달기사 - 서버에 다녀오기)
3. store   (치킨집  - 모든상태를 모아두는 중앙창고 / 주방(reducer),배달(saga))

1) `View` 손님이 주문 `/users/login.js` →  (store에 액션 전달: 치킨집) 
                                      →  액션을 saga/reducer로 전달    
2) 배달기사가 서버에 다녀오고       (saga)      성공/실패
3) 주방레시피대로 상태바꾸기        (reducer)   결과에 따라 상태(state)를 변경
4) 치킨집(store) 업데이트         
5) `View` 화면반영  → 상태감지하고 화면에 그림그리기

1. [reducers] - user.js    ※ post.js, hashtag.js,,,,,
2. [reducers] - index.js
3. [reducers] - user.test.js


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

