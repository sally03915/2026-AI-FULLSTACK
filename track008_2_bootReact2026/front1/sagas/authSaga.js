// sagas/authSaga.js
import { all, call, put, takeLatest} from  'redux-saga/effects';
import  axios  from  'axios';
import { signupRequest , signupSuccess , signupFailure,
    fetchUserRequest,  fetchUserSuccess ,  fetchUserFailure,  resetUserState,
} from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/api/users';

// ---  회원가입  POST  /api/users ---
export  const  signupApi = ( userData )=> axios.post(  USER_API_BASE , userData  ); // /api/users
//■2.  signup(action) - action.payload 사용자가 입력한 값 (회원정보)
export  function*   signup(action){
    // action = { type: user/signupRequest, payload: { email:'1@1' , password:'1'} }
    try{
        const result = yield  call( signupApi,  action.payload  );  //■3.  result.data
        yield  put(signupSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(signupFailure(err.response?.data?.message || err.message));
    }
}
//■1.takeLatest( signupRequest.type , signup) :  takeLatest - 요청이 여러번, 가장마지막발생요청 처리
function* watchSignup(){   yield  takeLatest( signupRequest.type , signup);  } 


// ---  단건조회  GET  /api/users/1    ---
export  const  fetchUserApi = ( userId )=> axios.get( `${USER_API_BASE}/${userId}` );
//■2) 
export function*  fetchUser( action ){
    // action = {type:user/fetchUserRequest , payload:1}
    try{
        const result = yield call(fetchUserApi , action.payload);  //■3) 
        yield put(  fetchUserSuccess( result.data ) );
    }catch(err){
        yield put(  fetchUserFailure( err.response?.data?.message || err.message ) );
    }
}
//■1) takeLatest : 여러번요청와도 1번만
function* watchFetchUser(){   yield  takeLatest( fetchUserRequest.type , fetchUser );   }

export default  function * authSaga(){
    yield all([
        call(watchSignup),
        call(watchFetchUser),
    ]);
}
 
