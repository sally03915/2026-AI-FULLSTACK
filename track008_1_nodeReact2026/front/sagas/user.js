/**
 * sagas/user.js
 * ---------------------------------------
 * 사용자 관련 비동기 작업을 처리하는 saga
 * - 로그인, 로그아웃, 회원가입, 사용자 조회, 닉네임 수정, 사용자 삭제
 * - axios로 API를 호출 → 성공/실패에 따라 reducer로 액션 전달 
 */
import { all, fork , call, put, takeLatest} from 'redux-saga/effects';  // saga 기본함수
import  axios  from 'axios';  // http요청 라이브러리
import reducer, {
    initialState , 
    LOG_IN_REQUEST , LOG_IN_SUCCESS , LOG_IN_FAILURE , 
    LOG_OUT_REQUEST , LOG_OUT_SUCCESS , LOG_OUT_FAILURE , 
    SIGN_UP_REQUEST , SIGN_UP_SUCCESS , SIGN_UP_FAILURE , 
    LOAD_USERS_REQUEST , LOAD_USERS_SUCCESS , LOAD_USERS_FAILURE , 
    UPDATE_NICKNAME_REQUEST , UPDATE_NICKNAME_SUCCESS , UPDATE_NICKNAME_FAILURE , 
    DELETE_USER_REQUEST , DELETE_USER_SUCCESS , DELETE_USER_FAILURE , 
    CHECK_EMAIL_REQUEST , CHECK_EMAIL_SUCCESS , CHECK_EMAIL_FAILURE ,
}  from '../reducers/user';  // 액션 타입 불러오기

const client  = axios.create({
    baseURL : 'http://localhost:3065' ,   // API 서버 주소
    withCredentials : true,       //  쿠키/세션 인증포함
});

//  ------------------  로그아웃 ------------------    
//post : /user/logout   
export  function logoutApi(){
    return client.post( '/user/logout' );   // http://localhost:3065/user/logout
}
export  function* logout(){
    try{
        yield  call( logoutApi );  // API 호출 action.data: email, password
        yield  put( {type:LOG_OUT_SUCCESS }  );  // 성공 액션 dispatch 
        //return  {  ...state, isLoading: false ,  me: null  }; 
    }catch(err){
        yield  put({type:LOG_OUT_FAILURE , error: err.response?.data || err.message}); // 실패 액션 dispatch
        //  return {   ...state, isLoading: false , error:action.error?.message || action.error  };
    }
}
function* watchLogout(){
    yield takeLatest( LOG_OUT_REQUEST , logout ); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
    // return {  ...state , isLoading: true ,  error:  null } 
} 


//  ------------------  로그인  ------------------     
//post : /user/login    (requestBody)
export  function loginApi(data){
    return client.post( '/user/login' , data);   // http://localhost:3065/user/login
}
export  function* login(action){
    try{
        const result = yield  call( loginApi , action.data );  // API 호출 action.data: email, password
        const user   = {
            id:result.data.APP_USER_ID,
            email: result.data.EMAIL,
            nickname:result.data.NICKNAME
        };
        yield  put(  {type:LOG_IN_SUCCESS , data:user}  );  // 성공 액션 dispatch 
        //return  {  ...state, isLoading: false ,  me: action.data  }; 
    }catch(err){
        yield  put({type:LOG_IN_FAILURE , error: err.response?.data || err.message}); // 실패 액션 dispatch
        //  return {   ...state, isLoading: false , error:action.error?.message || action.error  };
    }
}
function* watchLogin(){
    yield takeLatest( LOG_IN_REQUEST , login ); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
    // return {  ...state , isLoading: true ,  error:  null } 
} 




//  ------------------  회원가입 ------------------     
//post : /user/register (requestBody)
export  function signUpApi(data){
    return client.post( '/user/register' , data);   // http://localhost:3065
}
export  function* signUp(action){
    try{
        yield  call( signUpApi , action.data );  // API 호출 - 결과물
        yield  put(  {type:SIGN_UP_SUCCESS}  );  // 성공 액션 dispatch
        //  return  {  ...state, isLoading: false ,  signUpDone: true  };
    }catch(err){
        yield  put({type:SIGN_UP_FAILURE , error: err.response?.data || err.message}); // 실패 액션 dispatch
        //  return {   ...state, isLoading: false , error:action.error?.message || action.error  };
    }
}
function* watchSignUp(){
    yield takeLatest( SIGN_UP_REQUEST , signUp ); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
    // return {  ...state , isLoading: true ,  error:  null } 
}

//  ------------------  사용자 조회 ------------------   
//get  : /user/
export  function loadUsersApi(){
    return client.get( '/user' );   // http://localhost:3065/user
}
export  function* loadUsers(){
    try{
        const result = yield  call( loadUsersApi );  // API 호출 action.data: email, password
        const users   = result.data.map((u)=>({
            id: u.APP_USER_ID,  email: u.EMAIL,  nickname: u.NICKNAME
        }));
        yield  put(  {type:LOAD_USERS_SUCCESS , data:users}  );  // 성공 액션 dispatch 
        //return  {  ...state, isLoading: false ,  me: action.data  }; 
    }catch(err){
        yield  put({type:LOAD_USERS_FAILURE , error: err.response?.data || err.message}); // 실패 액션 dispatch
        //  return {   ...state, isLoading: false , error:action.error?.message || action.error  };
    }
}
function* watchLoadUsers(){
    yield takeLatest( LOAD_USERS_REQUEST , loadUsers ); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
    // return {  ...state , isLoading: true ,  error:  null } 
} 



//  ------------------  닉네임 수정 ------------------   
//patch: /user/{id}/nickname 
export  function updateNicknameApi(data){
    return client.patch( `/user/${data.id}/nickname` , {nickname:data.nickname});   
}
export  function* updateNickname(action){
    try{
        yield  call( updateNicknameApi , action.data );   
        yield  put(  { type:UPDATE_NICKNAME_SUCCESS , 
                       data:{id:action.data.id , nickname:action.data.nickname}}  );  // 성공 액션 dispatch 
        //return  {  ...state, isLoading: false ,  me: action.data  }; 
    }catch(err){
        yield  put({type:UPDATE_NICKNAME_FAILURE , error: err.response?.data || err.message}); // 실패 액션 dispatch
        //  return {   ...state, isLoading: false , error:action.error?.message || action.error  };
    }
}
function* watchUpdateNickname(){
    yield takeLatest( UPDATE_NICKNAME_REQUEST , updateNickname ); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
    // return {  ...state , isLoading: true ,  error:  null } 
} 




//  ------------------  사용자 삭제 ------------------   
//delete: /user/{id} 

export  function deleteUserApi(id){
    return client.delete( `/user/${id}` );   
}
export  function* deleteUser(action){
    try{
        yield  call( deleteUserApi , action.data.id );   
        yield  put(  { type: DELETE_USER_SUCCESS , data:{id:action.data.id } });  // 성공 액션 dispatch 
    }catch(err){
        yield  put({type: DELETE_USER_FAILURE , error: err.response?.data || err.message}); // 실패 액션 dispatch
        //  return {   ...state, isLoading: false , error:action.error?.message || action.error  };
    }
}
function* watchDeleteUser(){
    yield takeLatest( DELETE_USER_REQUEST , deleteUser ); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
    // return {  ...state , isLoading: true ,  error:  null } 
} 


//  ------------------  이메일 중복 확인 ------------------   
//  get :   /user/check-email?email=xxx
export  function checkEmailApi(email){
    return client.get( `/user/check-email?email=${email}` );   
}
export  function* checkEmail(action){
    try{
        const result = yield  call( checkEmailApi , action.data );   
        yield  put(  { type: CHECK_EMAIL_SUCCESS   , data:result.data });  // 성공 액션 dispatch 
    }catch(err){
        yield  put({type: CHECK_EMAIL_FAILURE  , error: err.response?.data || err.message}); // 실패 액션 dispatch
        //  return {   ...state, isLoading: false , error:action.error?.message || action.error  };
    }
}
function* watchCheckEmail(){
    yield takeLatest( CHECK_EMAIL_REQUEST , checkEmail ); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
    // return {  ...state , isLoading: true ,  error:  null } 
} 




export default  function* userSaga(){
    yield all([
        fork(watchLogin) , 
        fork(watchLogout) , 
        fork(watchSignUp) , 
        fork(watchLoadUsers) , 
        fork(watchUpdateNickname) , 
        fork(watchDeleteUser) , 
        fork( watchCheckEmail) ,
    ]);
}


// 1. all  - 여러 saga를 동시에 실행
// 2. fork - [비동기]로 saga 실행
// 3. call - api를 호출하고 결과를 기다림 (blocking) > 동기
// 4. put  - redux 액션을 dispatch 
// 5. takeLatest - 특정액션을 감지하고 가장 마지막 액션만 처리