/**
 * saga/index.js
 * ------------------------------------
 * 루트 사가(rootSata) 설정 파일
 * - 모든 개별 saga(userSaga 등)를 합쳐서 실행
 * - Redux-Saga의 all, fork 를 사용해서 병렬 실행
 */

import {all, fork}  from  'redux-saga/effects';  // 여러 saga를 동시에 실행하기 위해 함수
import userSaga     from  './user';

export  default function*  rootSaga(){
    yield  all([
        fork(userSaga),     //  userSaga를 병렬 실행
        //fork(postSaga),   예시
    ]);
}