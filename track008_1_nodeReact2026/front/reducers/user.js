/**
 * reducers/user.js
 * --------------------------
 * 사용자 관련 상태( user state ) 를 관리하는 리듀서
 * - 로그인, 로그아웃, 회원가입, 사용자목록, 닉네임 수정, 사용자삭제
 * - 1. 각 액션타입 정의   2. 초기상태  3. reducer 함수    LOG_IN_REQUEST
 */

// 1. 각 액션타입 정의   
export  const   LOG_IN_REQUEST = 'LOG_IN_REQUEST';  // 로그인 요청
export  const   LOG_IN_SUCCESS = 'LOG_IN_SUCCESS';  // 로그인 성공
export  const   LOG_IN_FAILURE = 'LOG_IN_FAILURE';  // 로그인 실패

export  const   LOG_OUT_REQUEST = 'LOG_OUT_REQUEST';  // 로그아웃 요청
export  const   LOG_OUT_SUCCESS = 'LOG_OUT_SUCCESS';  // 로그아웃 성공
export  const   LOG_OUT_FAILURE = 'LOG_OUT_FAILURE';  // 로그아웃 실패

export  const   SIGN_UP_REQUEST = 'SIGN_UP_REQUEST';  // 회원가입 요청
export  const   SIGN_UP_SUCCESS = 'SIGN_UP_SUCCESS';  // 회원가입 성공
export  const   SIGN_UP_FAILURE = 'SIGN_UP_FAILURE';  // 회원가입 실패

export  const   LOAD_USERS_REQUEST = 'LOAD_USERS_REQUEST';  // 사용자 목록 요청
export  const   LOAD_USERS_SUCCESS = 'LOAD_USERS_SUCCESS';  // 사용자 목록 성공
export  const   LOAD_USERS_FAILURE = 'LOAD_USERS_FAILURE';  // 사용자 목록 실패

export  const   UPDATE_NICKNAME_REQUEST = 'UPDATE_NICKNAME_REQUEST';  // 닉네임 수정 요청
export  const   UPDATE_NICKNAME_SUCCESS = 'UPDATE_NICKNAME_SUCCESS';  // 닉네임 수정 성공
export  const   UPDATE_NICKNAME_FAILURE = 'UPDATE_NICKNAME_FAILURE';  // 닉네임 수정 실패

export  const   DELETE_USER_REQUEST = 'DELETE_USER_REQUEST';  // 사용자삭제  요청
export  const   DELETE_USER_SUCCESS = 'DELETE_USER_SUCCESS';  // 사용자삭제  성공
export  const   DELETE_USER_FAILURE = 'DELETE_USER_FAILURE';  // 사용자삭제  실패

// 2. 초기상태  
export  const initialState={
    me: null  ,    // 로그인사용자정보 {  id,  email, nickname  }
    users: [] ,    // 전체 사용자 목록 [ {  id,  email, nickname  } ]
    isLoading: false,  // api 요청 중 여부
    error:  null    ,  // 에러메시지
    signUpDone: false, // 회원가입 완료여부
};

 
// 3. reducer 함수
const reducer = (   state=initialState   ,   action    )=>{   // 현재상태,  요청액션
    switch(  action.type ){
        // 요청 액션 → 로딩시작
        case LOG_IN_REQUEST:
        case LOG_OUT_REQUEST:
        case SIGN_UP_REQUEST:
        case LOAD_USERS_REQUEST:
        case UPDATE_NICKNAME_REQUEST:
        case DELETE_USER_REQUEST:
            return {  ...state , isLoading: true ,  error:  null }
        
        // 성공 액션 → 상태 업데이트
        case  LOG_IN_SUCCESS:
                return  {  ...state, isLoading: false ,  me: action.data  };
        case  LOG_OUT_SUCCESS:
                return  {  ...state, isLoading: false ,  me: null  };
        case  SIGN_UP_SUCCESS:
                return  {  ...state, isLoading: false ,  signUpDone: true  };
        case  LOAD_USERS_SUCCESS:
                return  {  ...state, isLoading: false ,  users: action.data  }; 
        case UPDATE_NICKNAME_SUCCESS:
                return  {  ...state, isLoading: false , 
                           me: state.me  &&  state.me.id === action.data.id
                            ? { ...state.me ,  nickname:action.data.nickname } 
                            : state.me  ,
                           users: state.users.map( (u)=> u.id === action.data.id ? {  ...u , nickname: action.data.nickname } : u)
                };
        case DELETE_USER_SUCCESS:
                return { ...state, isLoading: false , 
                    me : state.me?.id === action.data.id? null : state.me , 
                    users: state.users.filter(  (u) => u.id !== action.data.id )
                };

        // 실패 액션 → 에러메시지 저장
        case LOG_IN_FAILURE:
        case LOG_OUT_FAILURE:
        case SIGN_UP_FAILURE:
        case LOAD_USERS_FAILURE:
        case UPDATE_NICKNAME_FAILURE:
        case DELETE_USER_FAILURE:
            return {   ...state, isLoading: false , error:action.error?.message || action.error  };

        // 기본값 → 상태변경없음
        default : 
            return state;
    }
};
export default reducer;