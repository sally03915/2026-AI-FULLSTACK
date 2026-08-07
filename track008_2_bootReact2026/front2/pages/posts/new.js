//  pages/posts/new.js
//1. import
import React, { useState , useEffect }  from  "react";   //5. 변수  4.이벤트알림 
import { Card, Form, Input, Button , message , Upload , Select }  from "antd";
import { useSelector ,  useDispatch } from "react-redux";  // 1. 전역정보,  2.이벤트발생
import { useRouter } from "next/router";  // 3. 화면이동
import { createPostRequest , resetPostState } from "../../reducers/postReducer";  // 액션
import { UpOutlined } from "@ant-design/icons";

//2. export + 부품
export default function NewPostPage(){
    //1. 글정보(state.post) 유저정보(state.user) 가져오기  ( useSelector : 전역정보)   Q2. 
    const router = useRouter();
    const dispatch = useDispatch();

    const {loading, error, success } = useSelector( (state)=> state.post);  // 글정보
    const {user}           = useSelector( (state)=> state.auth);  // 유저정보  user

    const [fileList, setFileList] = useState([]);

    //2.  게시글작성 ( dispatch(createPostRequest(dto)) : 이벤트발생알림 )   Q3 글쓰고나면 /
    // {userId, dto(content, 해쉬태그), files }
    const onFinish = (values)=>{
        const dto = {
            content:values.content,
            hashtags: values.hashtags? values.hashtags.join(",") : "",
        };
        const files = fileList.map( (f)=> f.originFileObj );

        dispatch(createPostRequest({ userId: user.id , dto, files })); 
    };
    // useSelect(전역) / useDispatch(알림) / useState(변수) / useEffect(이벤트변화감지) / 리스트
    useEffect( ()=> {
        if(success){  
            message.success("게시글이 성공적으로 작성되었습니다.");
            setFileList([]); 
            dispatch(resetPostState());
            router.push("/");
        } 
        return ()=>{
            if(success) {  dispatch(resetPostState());  }
        };

    } , [success, router, dispatch]);

    ////////////////////////  Q1. view
    return (
        <Card  title="게시글 작성"   style={{maxWidth:600 , margin:"0 auto"}}>
            <Form  onFinish={onFinish}  layout="vertical">
                <Form.Item
                    label="내용"
                    name="content"
                    hasFeedback
                    rules={[ { required: true,  message: '내용을 입력하세요.'}  ]}
                >
                    <Input.TextArea  rows={4}  placeholder="게시글 내용을 입력하세요." />
                </Form.Item>
                {/* 해시태그 입력 */}
                <Form.Item  label="해시태그"   name="hashtags" >
                    <Select mode="tags"  style={{width:"100%"}}  placeholder="해시태그 입력 후 Enter"  />
                </Form.Item>
                {/* 이미지 업로드 */}
                <Form.Item  label="이미지 업로드">
                   <Upload multiple    beforeUpload={()=>false}   fileList={fileList} 
                        onChange={( {fileList} )=>setFileList(fileList)}
                        listType="picture-card"
                    >
                       <Button  icon={<UpOutlined/>} >이미지 선택</Button>     
                   </Upload>
                </Form.Item>

                <Button  type="primary"  htmlType="submit"  loading={loading} >
                    게시글 작성
                </Button>
                {error  && <p  style={{ color: "red" }}>{error}</p>}
            </Form>
        </Card>
    );
}


// export default function NewPostPage(){
//     return "NewPostPage";
// }