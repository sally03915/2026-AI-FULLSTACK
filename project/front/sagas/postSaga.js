// sagas/postSaga.js
import { all, call, put, takeLatest} from  'redux-saga/effects';
import  api  from  '../api/axios';
import { fetchPostsRequest , fetchPostsSuccess, fetchPostsFailure ,   //  전체글
        fetchPostDetailRequest  , fetchPostDetailSuccess  , fetchPostDetailFailure,  //상세글 
        createPostRequest , createPostSuccess , createPostFailure ,  // 글쓰기
        updatePostRequest ,  updatePostSuccess ,  updatePostFailure ,  // 글수정
        deletePostRequest ,  deletePostSuccess ,  deletePostFailure ,  // 글삭제
        resetPostState // 초기화
} from '../reducers/postReducer';

const POST_API_BASE = '/api/posts';

//   watchFetchPosts      -   GET      /api/posts      전체 게시글 조회  
export  const fetchPostsAPI   = ()=> api.get(POST_API_BASE);
export  function* fetchPosts(){
    try{
        const  result = yield call(fetchPostsAPI);  // action.payload: 사용자가 넘겨준값
        yield put( fetchPostsSuccess(result.data));
    }catch(err){
        yield put( fetchPostsFailure(err.response?.data?.message || err.message));
    }
}

//   watchFetchPostDetail - GET      /api/posts/{id}      게시글 단건 조회   /api/posts/1
export  const fetchPostDetailAPI = (id)=> api.get(`${POST_API_BASE}/${id}`);
export  function* fetchPostDetail(action){
    // action = { type:   , payload:{}}
    try{
        const  result = yield call(fetchPostDetailAPI , action.payload);  // action.payload: 사용자가 넘겨준값
        yield put( fetchPostDetailSuccess(result.data));
    }catch(err){
        yield put( fetchPostDetailFailure(err.response?.data?.message || err.message));
    }
}

//   watchCreatePost      -   POST     /api/posts      게시글 작성   
export  function createPostAPI(payload){
    const {userId, dto, files } =  payload;   // 1. boot의 컨트롤러  - controller 
    const formData = new FormData();       // 2. form 만들기
    Object.entries(dto || {}).forEach(([k, v]) => {  //3. dto - content / hashtags
      if (v !== undefined && v !== null) {
        formData.append(k, v);
      }
    });
    if (files && files.length > 0) {   // 4. 이미지 파일들
      files.forEach((f) => formData.append('files', f));
    }
    //http://localhost:8080/api/posts?userId
    return   api.post( `${POST_API_BASE}?userId=${userId}` , formData , {
        headers: { 'Content-Type': 'multipart/form-data' },
    });
}
export  function* createPost( action ){ 
    try{
        const  result = yield call(createPostAPI , action.payload);  // action.payload: 사용자가 넘겨준값
        yield put( createPostSuccess(result.data));
    }catch(err){
        yield put( createPostFailure(err.response?.data?.message || err.message));
    }
}

//   watchUpdatePost      -   PUT      /api/posts/{id} 게시글 수정  
//   => 줄바꿈
export function updatePostAPI(payload){
    const {userId , postId , dto, files } =  payload;   // 1. boot의 컨트롤러  - controller 
    const formData = new FormData();       // 2. form 만들기
    Object.entries(dto || {}).forEach(([k, v]) => {  //3. dto - content / hashtags
      if (v !== undefined && v !== null) {
        formData.append(k, v);
      }
    });
    if (files && files.length > 0) {   // 4. 이미지 파일들
      files.forEach((f) => formData.append('files', f));
    }
    //http://localhost:8080/api/posts/${postId}?userId=1
    return   api.patch( `${POST_API_BASE}/${postId}?userId=${userId}` , formData , {
        headers: { 'Content-Type': 'multipart/form-data' },
    });
}
export  function* updatePost(action){
    try{
        const result = yield call(updatePostAPI , action.payload);  // action.payload: 사용자가 넘겨준값
        yield put( updatePostSuccess(result.data));
    }catch(err){
        yield put( updatePostFailure(err.response?.data?.message || err.message));
    }
}

//   watchDeletePost      -   DELETE   /api/posts/{id} 게시글 삭제  ##
export  const deletePostAPI = (id)=> api.delete(`${POST_API_BASE}/${id}`);
export  function* deletePost(action){
    // action = { type:   , payload:{}}
    try{
        yield call(deletePostAPI , action.payload);  // action.payload: 사용자가 넘겨준값
        yield put( deletePostSuccess(action.payload));
    }catch(err){
        yield put( deletePostFailure(err.response?.data?.message || err.message));
    }
}

//  --- watch saga들 ---
function* watchFetchPosts(){        yield takeLatest( fetchPostsRequest.type      , fetchPosts ); }
function* watchFetchPostDetail(){   yield takeLatest( fetchPostDetailRequest.type , fetchPostDetail ); }
function* watchCreatePost(){        yield takeLatest( createPostRequest.type      , createPost ); }
function* watchUpdatePost(){        yield takeLatest( updatePostRequest.type      , updatePost ); }
function* watchDeletePost(){        yield takeLatest( deletePostRequest.type      , deletePost ); }

export  default function* postSaga(){
    yield  all([
        call(watchFetchPosts),
        call(watchFetchPostDetail),
        call(watchCreatePost),
        call(watchUpdatePost),
        call(watchDeletePost), 
    ]);
}