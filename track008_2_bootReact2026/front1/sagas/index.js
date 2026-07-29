// sagas/index.js
import { all, fork }  from 'redux-saga/effects';

import  authSaga  from  './authSaga';
import  postSaga  from  './postSaga';
//import  commentSaga  from  './commentSaga';

export default  function  *rootSaga(){
    yield all([
        fork( authSaga ) ,
        fork( postSaga ) ,
       // fork( commentSaga ) ,
    ]);
}