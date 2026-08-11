//__test__/authRucer.test.js
import  userReducer, {signupRequest , signupSuccess , signupFailure,  resetUserState,
    loginRequest,loginSuccess,loginFailure,
    logoutRequest,logoutSuccess,logoutFailure,
    updateNicknameRequest, updateNicknameSuccess ,  updateNicknameFailure,
    updateProfileImageRequest , updateProfileImageSuccess , updateProfileImageFailure
}from '../authReducer';

describe('user slice reducer' , ()=>{
    const initialState={
        user: null ,     // 단건 조회된 사용자 정보
        loading: false,  // 로딩상태   
        error:   null,   // 에러메시지
        success: false,  // 성공여부 (오타 수정)
    };

    it('signupRequest' , ()=>{
        const state = userReducer( initialState , signupRequest() ); // 상태, 액션
        // 1. signupRequest() 실행하면 - 인자 없음
        // 2. 리듀서 툴킷에서 { type: signupRequest, payload: undefined } 객체 만들기
        // 3. 리듀서의 signupRequest: (state, action) => {} 액션 받아서 처리
        //  action = { type: signupRequest, payload: undefined } 
        expect(state.loading).toBe(true);  // state.loading = true
        expect(state.error).toBeNull();    // state.error = null
        expect(state.success).toBe(false); // state.success = false  
    });

    it('signupSuccess' , ()=>{     
        const userData = {id:1 , email:'1@1'};
        const state = userReducer( initialState , signupSuccess(userData) );
        // 1. signupSuccess(userData) 실행하면   - {id:1 , email:'1@1'};
        // 2. 리듀서 툴킷에서 { type: signupSuccess, payload: userData } 객체 만들기
        // 3. 리듀서의 signupSuccess: (state, action) => {} 액션 받아서 처리
        //    action = { type: signupSuccess, payload: userData }
        expect(state.loading).toBe(false);   // state.loading = false
        expect(state.user).toEqual(userData);// state.user = action.payload
        expect(state.success).toBe(true);   
    });

    it('signupFailure' , ()=>{     
        const state = userReducer( initialState , signupFailure('회원가입 실패') );
        // 1. signupFailure('회원가입 실패') 실행하면 - '회원가입 실패' 전달
        // 2. 리듀서 툴킷에서 { type: signupFailure, payload: '회원가입 실패' } 객체 만들기
        // 3. 리듀서의 signupFailure: (state, action) => {} 액션 받아서 처리
        //    action = { type: signupFailure, payload: '회원가입 실패' }
        expect(state.loading).toBe(false);    
        expect(state.error).toBe('회원가입 실패');  // state.error = action.payload
    });
    ////////////////////////////////////////////
 
    it('resetUserState' , ()=>{      
        const prev = {user:{id:1} , loading:true , error:'err' , success: true};// 상태꼬임
        const state = userReducer(prev, resetUserState());
        //1. resetUserState() 실행 - 인자없음
        //2. 리듀서 툴킷 - { type:resetUserState   , payload:undefined }  객체만들기
        //3. 리듀서의   resetUserState : (state,action)=>{}  액션받아서처리 - 상태초기화
        // action = { type:resetUserState   , payload:undefined }
        expect(state.loading).toBe(false);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);
    });  
    //////////////////////////////////////////// 로그인
     it('loginSuccess' , ()=>{    
        const payload = {id:1 , email:'1@1'};
        const state = userReducer(initialState, loginSuccess(payload));
        expect( state.loading ).toBe(  false );
        expect( state.user    ).toEqual(payload);
     });
    //////////////////////////////////////////// 로그아웃  ( loading, user, error  )
     it('logoutSuccess' , ()=>{    
        const prev = { ...initialState ,  user:{  id:1 } };
        const state = userReducer(prev, loginSuccess());
        expect( state.loading ).toBe(  false );
        expect( state.user     ).toBeNull();
        expect( state.error    ).toBeNull();
     });
    //////////////////////////////////////////// 닉네임변경
     it('updateNicknameSuccess' , ()=>{    
        const payload = {id:1 , email:'1@1' , nickname:'new'};
        const state = userReducer(initialState, updateNicknameSuccess(payload));
        expect( state.loading ).toBe(  false );
        expect( state.user    ).toEqual(payload);
     }); 
    //////////////////////////////////////////// 프로필이미지변경
     it('updateProfileImageSuccess' , ()=>{    
        const payload = {id:1 ,   ufile:'1.png'};
        const state = userReducer(initialState, updateProfileImageSuccess(payload));
        expect( state.loading ).toBe(  false );
        expect( state.user    ).toEqual(payload);
     });
});
//  npm  test  authReducer