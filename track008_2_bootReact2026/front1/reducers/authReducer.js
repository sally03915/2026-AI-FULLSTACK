// reducers/authReducer.js
import { createSlice }  from "@reduxjs/toolkit";
//1. 초기화 상태 (공용)
const initialState={
    user: null ,     // 단건 조회된 사용자 정보
    loading: false,  // 로딩상태   
    error:   null,   // 에러메시지
    success: false,  // 성공여부
};
//2. 상태변화
const authReducer=createSlice({
    name : "user",
    initialState , 
    reducers : {
        // --- 회원 가입 ---
        signupRequest : (state)=>{
            state.loading = true;  
            state.error   = null;   
            state.success = false;  
        },
        signupSuccess : (state, action)=>{ 
            state.loading = false;  
            state.user    = action.payload;  //가입된 회원정보저장 
            state.success = true;  
        },
        signupFailure : (state, action)=>{
            state.loading = false;  
            state.error   = action.payload;  // 오류메시지
            state.success = false;  
        },

        // --- 사용자 단건조회 --- 
        fetchUserRequest : (state)=>{ 
            state.loading = true;  
            state.error   = null;   
            state.success = false;  
        },
        fetchUserSuccess : (state, action)=>{ 
            state.loading = false;  
            state.user    = action.payload;   
            state.success = true;  
        },
        fetchUserFailure : (state, action)=>{ 
            state.loading = false;  
            state.error   = action.payload;   
            state.success = false;  
        },  

        // --- 상태 초기화 ---
        resetUserState: (state)=>{
            state.loading = false;  
            state.error   = null;   
            state.success = false;  
        } , 
    },
});
//3.  action
export const {signupRequest , signupSuccess , signupFailure,
    fetchUserRequest,  fetchUserSuccess ,  fetchUserFailure,  resetUserState,
} = authReducer.actions;
//4.  export
export default  authReducer.reducer;