// npm run test
// npx  jest  sagas/user.test.js

import {  call, put} from 'redux-saga/effects';  // saga 기본함수 
import {
    login,logout, signUp ,  loadUsers , updateNickname, deleteUser, 
    loginApi,logoutApi, signUpApi, loadUsersApi , updateNicknameApi , deleteUserApi  
}  from './user';
import reducer, {
    initialState , 
    LOG_IN_REQUEST , LOG_IN_SUCCESS , LOG_IN_FAILURE , 
    LOG_OUT_REQUEST , LOG_OUT_SUCCESS , LOG_OUT_FAILURE , 
    SIGN_UP_REQUEST , SIGN_UP_SUCCESS , SIGN_UP_FAILURE , 
    LOAD_USERS_REQUEST , LOAD_USERS_SUCCESS , LOAD_USERS_FAILURE , 
    UPDATE_NICKNAME_REQUEST , UPDATE_NICKNAME_SUCCESS , UPDATE_NICKNAME_FAILURE , 
    DELETE_USER_REQUEST , DELETE_USER_SUCCESS , DELETE_USER_FAILURE , 
}  from '../reducers/user';  // 액션 타입 불러오기

describe('user saga' , ()=>{
    it( 'signup success' , ()=>{
        const action = { type: SIGN_UP_REQUEST , 
                         data:{ email:'z@z' , password:'z' , nickname:'zzz' }  };
        const gen    = signUp(action);

        expect(gen.next().value).toEqual(call(signUpApi , action.data));
        expect(gen.next({}).value).toEqual( put(  { type: SIGN_UP_SUCCESS } ) );

        const error = {response:{ data : '이미 존재하는 이메일'}};
        expect(gen.throw(error).value)
                  .toEqual( put(  { type: SIGN_UP_FAILURE , error:'이미 존재하는 이메일'} ) );
    });

    it( 'login success' , ()=>{
        const action = { type: LOG_IN_REQUEST ,  data:{ email:'z@z' , password:'z' }  };
        const gen    = login(action);

        expect(gen.next().value).toEqual(call(loginApi , action.data));

        const apiResponse = {APP_USER_ID:1,  EMAIL : 'z@z' , NICKNAME:'zzz' };
        expect(gen.next({ data:apiResponse }).value)
                  .toEqual( put(  { type:LOG_IN_SUCCESS ,
                                    data:{id:1 , email:'z@z' , nickname:'zzz'}
                  } ) );
    });

    it( 'logout success' , ()=>{
        const action = { type: LOG_OUT_REQUEST };
        const gen    = logout(action);

        expect(gen.next().value).toEqual(call(logoutApi));
        expect(gen.next({}).value).toEqual(  put({type: LOG_OUT_SUCCESS}) );

        const error = {response:{ data : '로그아웃 실패'}};
        expect(gen.throw(error).value)
                  .toEqual( put(  { type: LOG_OUT_FAILURE , error:'로그아웃 실패'} ) );

    });


    it( 'loadUsers success' , ()=>{
        const action = { type: LOAD_USERS_REQUEST  };
        const gen    = loadUsers(action);

        expect(gen.next().value).toEqual(call(loadUsersApi));

        const fakeUsers = [{APP_USER_ID:1,  EMAIL : 'z@z' , NICKNAME:'zzz' }];
        expect(gen.next({ data:fakeUsers }).value)
                .toEqual( put(  { type:LOAD_USERS_SUCCESS ,
                                data: [{id:1 , email:'z@z' , nickname:'zzz'}]
                }) );
        const error = {response:{ data : '조회 실패'}};
        expect(gen.throw(error).value)
                  .toEqual( put(  { type: LOAD_USERS_FAILURE , error:'조회 실패'} ) ); 
    });

    it( 'updateNickname success' , ()=>{
        const action = { type: UPDATE_NICKNAME_REQUEST , data:{ id:1, nickname:'new'}  };
        const gen    = updateNickname(action);

        expect(gen.next().value).toEqual(call(updateNicknameApi , action.data));
 
        expect(gen.next({}).value).toEqual(put({ type:UPDATE_NICKNAME_SUCCESS 
                                                ,data:{id:1, nickname:'new'} }));

        const error = {response:{ data : '수정 실패'}};
        expect(gen.throw(error).value)
                  .toEqual( put(  { type: UPDATE_NICKNAME_FAILURE , error:'수정 실패'} ) ); 
    });

    it( 'deleteUser success' , ()=>{
        const action = { type: DELETE_USER_REQUEST , data:{ id:1 }  };
        const gen    = deleteUser(action);

        expect(gen.next().value).toEqual(call(deleteUserApi , action.data.id));
 
        expect(gen.next({}).value).toEqual(put({ type:DELETE_USER_SUCCESS ,data:{id:1} }));

        const error = {response:{ data : '삭제 실패'}};
        expect(gen.throw(error).value)
                  .toEqual( put(  { type: DELETE_USER_FAILURE , error:'삭제 실패'} ) ); 
    }); 
});
// npm run test
// npx  jest  sagas/user.test.js