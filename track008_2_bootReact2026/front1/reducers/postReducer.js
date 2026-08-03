// reducers/postReducer.js
import { createSlice }  from "@reduxjs/toolkit";

const initialState={
    posts : [] ,       // 전체게시글 목록
    currentPost: null, // 단건 조회된 상세 게시글
    loading: false,
    error: null,
    success : false,
};

const postReducer=  createSlice({
    name: "post",
    initialState , 
    reducers :{
        // --- 전체 게시글 ---
        fetchPostsRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        fetchPostsSuccess: (state , action)=>{ 
            state.loading = false;
            state.posts   = action.payload;
            state.success = true;
        },
        fetchPostsFailure: (state , action)=>{ 
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },
        // --- 단건 게시글 ---
        fetchPostDetailRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        fetchPostDetailSuccess: (state , action)=>{ 
            state.loading = false;
            state.currentPost   = action.payload;
            state.success = true;
        },
        fetchPostDetailFailure: (state , action)=>{ 
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },

        // --- 게시글 작성 ---
        createPostRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        createPostSuccess: (state , action)=>{ 
            state.loading = false;
            state.posts   = [action.payload,   ...state.posts];  // 새글을 목록상단추가
            state.success = true;
        },
        createPostFailure: (state , action)=>{ 
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },

        // --- 게시글 수정 ---
        updatePostRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        updatePostSuccess: (state , action)=>{ 
            state.loading = false;
            state.posts   = state.posts.map(  post => 
                post.id === action.payload.id ? action.payload : post
            );   
            state.currentPost = action.payload;
            state.success = true;
        },
        updatePostFailure: (state , action)=>{ 
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },

        // --- 게시글 삭제 ---
        deletePostRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        deletePostSuccess: (state , action)=>{ 
            state.loading = false;
            // 삭제된 게시글의 id받아서 목록에서 제외
            state.posts   = state.posts.filter(post=>  post.id !== action.payload);   
            state.success = true;
        },
        deletePostFailure: (state , action)=>{ 
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
    }
}); 
export const {  fetchPostsRequest , fetchPostsSuccess, fetchPostsFailure ,   //  전체글
                fetchPostDetailRequest  , fetchPostDetailSuccess  , fetchPostDetailFailure,  //상세글 
                createPostRequest , createPostSuccess , createPostFailure ,  // 글쓰기
                updatePostRequest ,  updatePostSuccess ,  updatePostFailure ,  // 글수정
                deletePostRequest ,  deletePostSuccess ,  deletePostFailure ,  // 글삭제
                resetUserState // 초기화
} = postReducer.actions; 
export default postReducer.reducer;