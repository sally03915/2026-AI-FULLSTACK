// sagas/authSaga.js
import { all, call, put, takeLatest} from  'redux-saga/effects';
import  axios  from  'axios';
import {signupRequest , signupSuccess , signupFailure,  resetUserState,
    loginRequest,loginSuccess,loginFailure,
    logoutRequest,logoutSuccess,logoutFailure,
    updateNicknameRequest, updateNicknameSuccess ,  updateNicknameFailure,
    updateProfileImageRequest , updateProfileImageSuccess , updateProfileImageFailure
} from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/auth';

// ---  회원가입  POST  /api/users ---
// POST : http://localhost:8080/auth/signup
export  const  signupApi = ( formData )=> axios.post(  `${USER_API_BASE}/signup` , formData , {
    headers: { "Content-Type": "multipart/form-data"  },
} ); // /api/users

//■2.  signup(action) - action.payload 사용자가 입력한 값 (회원정보)
export  function*   signup(action){
    // action = { type: auth/signupRequest, payload: { email:'1@1' , password:'1'} }
    try{
        const result = yield  call( signupApi,  action.payload  );  //■3.  result.data
        yield  put(signupSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(signupFailure(err.response?.data?.message || err.message));
    }
}  

// ---  로그인       ---
// POST :     /auth/login
export  const  loginApi = ( payload )=> axios.post( `${USER_API_BASE}/login`, payload); 
export function*  login( action ){
    // {email:'1@1', password:'1', provider:'local'}
    // action = {type:user/fetchUserRequest , payload:1}
    try{
        const result = yield call(loginApi , action.payload);  //■3) 
        yield put(  loginSuccess( result.data ) );
    }catch(err){
        yield put(  loginFailure( err.response?.data?.message || err.message ) );
    }
} 
// ---  로그아웃  POST  :  /auth/logout  넘겨줄 데이터 x    ---
export  const  logoutApi = (  )=> axios.post( `${USER_API_BASE}/logout`);

export function*  logout(){ 
    try{
        yield call(logoutApi);  
        yield put(  logoutSuccess() );
    }catch(err){
        yield put(  logoutFailure( err.response?.data?.message || err.message ) );
    }
}


// ---  업데이트 닉네임  PATCH :  /auth/{userId}/nickname  ,  params를 통해서 닉네임넘기기 ---
export const updateNicknameApi=({userId,nickname})=> axios.patch( `${USER_API_BASE}/${userId}/nickname`, null ,{
    params:{nickname} ,
}); 
export function*  updateNickname( action ){ 
    try{
        const result = yield call(updateNicknameApi , action.payload);   
        yield put( updateNicknameSuccess( result.data ) );
    }catch(err){
        yield put(  updateNicknameFailure( err.response?.data?.message || err.message ) );
    }
}   
// ---  업데이트 프로필이미지  PATCH:  /auth/{userId}/profile-image  , formData  ---
export   function updateProfileImageApi({userId,file}){ 
    const formData = new FormData();
    formData.append("ufile" , file);
    return  axios.patch( `${USER_API_BASE}/${userId}/profile-image`, formData ,{
          headers : {"Content-Type": "multipart/form-data" }
    });    
}
export function*  updateProfileImage( action ){ 
    try{
        const result = yield call(updateProfileImageApi , action.payload);   
        yield put( updateProfileImageSuccess( result.data ) );
    }catch(err){
        yield put(  updateProfileImageFailure( err.response?.data?.message || err.message ) );
    }
}   
//■1) takeLatest : 여러번요청와도 1번만 
function* watchSignup(){            yield  takeLatest( signupRequest.type              , signup);       } 
function* watchLogin(){             yield  takeLatest( loginRequest.type               , login );       }
function* watchLogout(){            yield  takeLatest( logoutRequest.type              , logout );      }
function* watchUpdateNickname(){    yield  takeLatest( updateNicknameRequest.type      , updateNickname );    }
function* watchUpdateProfileImage(){yield  takeLatest( updateProfileImageRequest.type  , updateProfileImage );   }

export default  function * authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
    ]);
}
 
