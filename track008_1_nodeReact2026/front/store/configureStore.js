/**
 * store/configureStrore.js
 * --------------------------------------
 * Redux Strore 설정파일
 */

import { configureStore} from  '@reduxjs/toolkit';    // Redux 기본스토어 생성함수
import  createSagaMiddleware from 'redux-saga';       // Redux-saga 미들웨어 생성함수
import { createWrapper } from 'next-redux-wrapper'; 
import reducer  from '../reducers';                 
import rootSaga from '../sagas';                 

export const  makeStore = ()=> {
   const sagaMiddleware =  createSagaMiddleware();     // saga (배달기사 - node/boot,,,)
   const store = configureStore({  // redux
    reducer,                            
    middleware: (getDefaultMiddleware) =>  
      getDefaultMiddleware({ 
        thunk: false,           //  thunk(비동기처리) 비활성화 ( saga 사용 )              
        serializableCheck: false,     // 직렬화 검사 비활성화 (saga 처리)
      }).concat(sagaMiddleware),   // saga 추가   
    devTools: process.env.NODE_ENV !== 'production',   // 개발환경에서만 활성화
  });
  
   store.sagaTask = sagaMiddleware.run(rootSaga);  // saga 실행
   return store;  
};
// next.js 와 redux 를 연결하는 wrapper 생성
export  const wrapper = createWrapper(  makeStore , {
    debug: process.env.NODE_ENV !== 'production'     // 개발환경에서만 활성화
} );
