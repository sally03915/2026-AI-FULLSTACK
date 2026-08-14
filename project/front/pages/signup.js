//1. require / import
import { Row, Col, Form, Input, Button, Upload, Spin, message } from "antd";    
import { UploadOutlined } from "@ant-design/icons";   
//  store : useSelector(전역)      , useDispatch(스토어이벤트알림)  
//  감지 : useEffect(이벤트변경감지) , useState( 변수 ) 
//  경로 : useRouter
import React , {useState , useEffect , useRef}  from  "react";
import {useSelector , useDispatch}  from  "react-redux";
import {useRouter} from "next/router";
import { signupRequest , resetUserState } from "../reducers/authReducer";

import  api  from  "../api/axios";   //###

//2. function (부품)
function   SignupPage(){
    //5개부품  -  useEffect(이벤트변경감지) , useState( 변수 ) 
    const dispatch = useDispatch();  //이벤트변경감지
    const router   = useRouter();    // 경로
    const { user, error, success, loading  } = useSelector((state) => state.auth);   
    
    const [fileList, setFileList] = useState([]);
    const  isSubmittedRef         = useRef(false);  //##

    // 데이터 받아서 회원가입전송  - 네트워크가 느리면 0.5초 2~3회 연속으로 클릭 (회원가입요청중복)
    const onFinish  = ( values )=>{
        if( isSubmittedRef.current ) return;  //##
        isSubmittedRef.current = true;  //##

        const formData = new FormData();
        formData.append("email" ,values.email );
        formData.append("password" ,values.password );
        formData.append("nickname" ,values.nickname );
        if(fileList.length > 0 ){   formData.append("ufile" ,fileList[0].originFileObj);  } 
        dispatch( signupRequest(formData) );    
    };
    useEffect(()=> {
        if(success){
            message.success("회원가입이 성공적으로 완료되었습니다.");
            router.push(`/login`);
            //router.push(`/`);   //###
            dispatch( resetUserState() );   
        }
        return ()=>{
          isSubmittedRef.current = false;
        };

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
            rules={[ 
              { required: true , message: '이메일을 입력하세요.'} , 
              { validator: async( _ , value)=>{   
                    if(!value)  return  Promise.resolve();  // 값 없어서 그냥 바로반환

                    try{ // boot에 시도
                      const res = await  api.get(`/auth/check-email?email=${encodeURIComponent(value)}`);
                      if(res?.data === true){
                        return  Promise.reject(new Error("이미 사용중인 이메일입니다."));    //오류 바로 반환
                      }
                      return  Promise.resolve();   //성공했으니깐 바로 반환
                    }catch(err){
                       console.log('이메일 중복검사 오류' , err);
                       return  Promise.reject(new Error("중복검사 실패"));   //오류 바로 반환
                    }

                }
              },
             ]}
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
            rules={[ {required: true , message: '닉네임을 입력하세요.'}, 
              { validator: async( _ , value)=>{   
                    if(!value)  return  Promise.resolve();  // 값 없어서 그냥 바로반환

                    try{ // boot에 시도
                      const res = await  api.get(`/auth/check-nickname?nickname=${encodeURIComponent(value)}`);
                      if(res?.data === true){
                        return  Promise.reject(new Error("이미 사용중인 닉네임입니다."));    //오류 바로 반환
                      }
                      return  Promise.resolve();   //성공했으니깐 바로 반환
                    }catch(err){
                       console.log('닉네임 중복검사 오류' , err);
                       return  Promise.reject(new Error("중복검사 실패"));   //오류 바로 반환
                    }

                }
              },]}
          >  
            <Input/>
          </Form.Item>

          {/* 프로필 이미지 업로드 */}    
          <Form.Item  name="profileImage"  label="프로필 이미지">
            <Upload
              beforeUpload={()=>false}
              fileList={  fileList   }
              onChange={ ( {fileList} )=> setFileList(fileList)  }
              maxCount={1}
            >
                <Button  icon={ <UploadOutlined/> }>이미지 선택</Button>
            </Upload>
          </Form.Item>    


          <Button  type="primary"  htmlType="submit"  >회원가입</Button>
          </Form>
        )}  
        </Col>
    </Row>);
}
//3. export
export default SignupPage;


///// ver-0
// export default function SignupPage(){
//     return "SIGNUP";
// }