import  { makeStore }  from './configureStore.js'; 
import  {  LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_OUT_SUCCESS  } from '../reducers/user';
 
describe( 'store configuration' ,  ()=>{
    it( 'store success'   , ()=>{
        const store =  makeStore();
        // 초기상태확인
        expect(store.getState().user.isLoading).toBe(false);
 
        // 로그인 요청액션
        store.dispatch({type: LOG_IN_REQUEST});
        expect(store.getState().user.isLoading).toBe(true);
        
        // 로그인 성공액션 dispatch
        const fakeUser = {id:1, email:'z@z' , nickname:'zzz'};
        store.dispatch({type: LOG_IN_SUCCESS , data: fakeUser});
        expect(store.getState().user.me.email).toBe('z@z');
  
        // 로그아웃 성공액션 dispatch
        store.dispatch({type: LOG_OUT_SUCCESS});
        expect(store.getState().user.me).toBeNull();
    });  
});

// npm  run test
// npx  jest  store/configureStore.test.js