// sagas/__tests__/postSaga.test.js  
import { call, put }  from 'redux-saga/effects';
import axios from  'axios'; 
import   {  fetchPostsRequest , fetchPostsSuccess, fetchPostsFailure ,   //  전체글
    fetchPostDetailRequest  , fetchPostDetailSuccess  , fetchPostDetailFailure,  //상세글 
    createPostRequest , createPostSuccess , createPostFailure ,  // 글쓰기
    updatePostRequest ,  updatePostSuccess ,  updatePostFailure ,  // 글수정
    deletePostRequest ,  deletePostSuccess ,  deletePostFailure ,  // 글삭제
    resetUserState // 초기화
} from '../../reducers/postReducer';
import { fetchPosts , fetchPostDetail , 
         createPost, updatePost, deletePost }  from  '../postSaga';

jest.mock('axios'); 
describe('auth saga' , ()=>{
    afterEach(()=>{  jest.clearAllMocks()  });  //  afterEach  
    // --- 전체글 게시글조회 ---  
    it('fetchUser' , ()=>{
        //1. 화면요청
       const generator= fetchPosts(fetchPostsRequest());
       expect( generator.next().value.type ).toBe('CALL');
        //2. 결과물받기
       const mockData = [{ id: 1, content: 'post 1' }];
       const putStep  = generator.next({data:mockData}).value;
       //3. 결과물확인
       expect( putStep ).toEqual( put(fetchPostsSuccess(mockData)) );
    });
    
    // --- 단건조회 --- 
    it('fetchPostDetail success', () => {
        const generator = fetchPostDetail(fetchPostDetailRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 1, content: 'detail' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(fetchPostDetailSuccess(mockData)));
    });
 

    // --- 글쓰기 --- 
    it('createPost success', () => {
        const payload = { content: 'new' };
        const generator = createPost(createPostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 10, content: 'new' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(createPostSuccess(mockData)));
    });
 
    // --- 글수정 --- 
    it('updatePost success', () => {
        const payload = { id: 10, content: 'updated' };
        const generator = updatePost(updatePostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next({ data: payload }).value;
        
        expect(putStep).toEqual(put(updatePostSuccess(payload)));
    });
 
    // --- 글삭제 ---  
    it('deletePost success', () => {
        const generator = deletePost(deletePostRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next().value;
        
        expect(putStep).toEqual(put(deletePostSuccess(1)));
    });
});

// npm test  authSaga.test.js

