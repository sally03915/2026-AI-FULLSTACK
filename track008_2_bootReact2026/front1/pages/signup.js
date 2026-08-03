//1. require / import
import { Row, Col, Form, Input, Button, Upload, Spin, message } from "antd";    
import { UploadOutlined } from "@ant-design/icons";   
// store : useSelector(전역)      , useDispatch(스토어이벤트알림)  
//  감지 : useEffect(이벤트변경감지) , useState( 변수 ) 
//  경로 : useRouter
import React , {useState , useEffect}  from  "react";
import {useSelector , useDispatch}  from  "react-redux";
import {useRouter} from "next/router";
import { signupRequest , resetUserState } from "../reducers/authReducer";

//2. function (부품)
function   SignupPage(){
    //5개부품  -  useEffect(이벤트변경감지) , useState( 변수 ) 
    const dispatch = useDispatch();  //이벤트변경감지
    const router   = useRouter();    // 경로
    const { user, error, success, loading  } = useSelector((state) => state.auth);  

    // 데이터 받아서 회원가입전송 
    const onFinish  = ( values )=>{
        const sendData = {
                email: values.email , 
                password: values.password,
                nickname: values.nickname
        } 
        dispatch( signupRequest(sendData) );    
    };
    useEffect(()=> {
        if(success){
            message.success("회원가입이 성공적으로 완료되었습니다.");
            router.push(`mypage`);
            dispatch( resetUserState() );   
        }
    } , [success, router , dispatch]);

    ///////////////////////  Layout > Row >  Col  Col
    //  모바일제일작은사이즈 : 24 xm={}   모바일2: 16  sm={}  태블릿:8  md={} / lg={}
    return (<Row  justify="center">
        <Col xm={24}  sm={16}  md={8}   >
        {  loading  && <Spin/>  }
        {  error    && <p  style={{color:"red"}}> {error} </p> }
        {  !success && ( 
        <Form layout="vertical" onFinish={onFinish}>
          {/* 이메일입력 + 중복검사 Form.Item    >  Input  /  name , hasFeedback 아이콘  */}
          <Form.Item
            label="이메일"
            name="email"
            hasFeedback
            rules={[ {required: true , message: '이메일을 입력하세요.'} ]}
          >  
            <Input/>
          </Form.Item>

         {/* 비밀번호 입력 */}
          <Form.Item
            label="비밀번호"
            name="password"
            rules={[ {required: true , message: '비밀번호를 입력하세요.'} ]}
          >  
            <Input.Password/>
          </Form.Item>
          
          {/* 닉네임 입력 + 중복검사  */}
          <Form.Item
            label="닉네임"
            name="nickname"
            hasFeedback
            rules={[ {required: true , message: '닉네임을 입력하세요.'} ]}
          >  
            <Input/>
          </Form.Item>
          <Button  type="primary"  htmlType="submit"  >회원가입</Button>
          </Form>
        )}  
        </Col>
    </Row>);
}
//3. export
export default SignupPage;



// export default function SignupPage(){
//     return "SIGNUP";
// }