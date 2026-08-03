// sagas/__tests__/authSaga.test.js  
// call - 동기 - 제너레이터함수 function* 일시중단 후 결과물 받기 / fork (비동기)
// put  - redux 액션처리
import { call, put }  from 'redux-saga/effects';
import axios from  'axios'; 
import   {signupRequest , signupSuccess , signupFailure,
    fetchUserRequest,  fetchUserSuccess ,  fetchUserFailure,  resetUserState,
} from '../../reducers/authReducer';
import { signup , fetchUser }  from  '../authSaga';

jest.mock('axios');

describe('auth saga' , ()=>{
    afterEach(()=>{  jest.clearAllMocks()  });  //  afterEach  - 
    // --- 회원가입 ---
    it('signup success' , ()=>{  
        const userData = { email: '1@1' , password:'1' };  //##1
        const action   = signupRequest(userData);  //##2
        const generator= signup(action);

        //1. 1단계 API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //2. api 성공했다라는 가정하에 결과 값을 전달
        const mockResponse = { data:  { id:1, email: '1@1'} };  //##3
        const putStep = generator.next(  mockResponse  ).value;

        //3. 2단계 성공액션 디스패치
        expect(putStep).toEqual(  put(signupSuccess(mockResponse.data))   );  //##4
        expect(generator.next().done).toBe(true);  // 제너레이터 완전종료 done
    }); 
    // --- 단건조회 ---
    it('fetchUser' , ()=>{
        const action   = fetchUserRequest(1);   
        const generator= fetchUser(action);

        expect(generator.next().value.type).toBe('CALL');
 
        const mockUser = { data:  { id:1, email: '1@1'} };  //##3 서버에서 전달된값
        const putStep = generator.next(  mockUser  ).value;

        expect(putStep).toEqual( put( fetchUserSuccess(mockUser.data))    );
    });
});

// npm test  authSaga.test.js