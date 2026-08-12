//1. import / require
import React, { useEffect } from "react"; //4. 이벤트변경감지  , useState (변수)
import { useDispatch, useSelector } from "react-redux";  // 2. 스토어알림 ,  1.전역상태 
import { Row, Col, Form, Input, Button, Spin, message } from "antd";  
import { useRouter } from "next/router";   //3. 경로
import { loginRequest } from "../reducers/authReducer";


//2+3. 부품+export
export default function LoginPage() {  
    //Q1.   useDispatch ,   useRouter 초기화
    const dispatch = useDispatch();
    const router   = useRouter();
    
    //Q2.   useSelector 이용해서 user 상태 가져오기 -  user, loading, error
    const {user, loading, error} = useSelector((state)=>state.auth);

    //Q3.   로그인 버튼을 누르고나면  -  스토어알림(dispatch) 이용해서 loginRequest 처리
    //  {email:'1@1', password:'1', provider:'local'}
    const onFinish = (values)=>{   
        console.log( values  );
        dispatch(   loginRequest({ ...values  , provider:'local'})   );
    }; 
    //Q4.   로그인 성공시 oo님 환영합니다 메시지 띄우고 (message),  마이페이지로 이동 (router.push)
    // useSelect , useDispatch ,useRouter, useEffect , useState
    useEffect(()=>{
        if(user &&  user.email){
            message.success(`${user.nickname || user.email}님 환영합니다!`);
            router.push('/mypage');
        }
    } , [user , router]);

    const handleSocialLogin=(provider)=>{ 
        window.location.href = `http://localhost:8080/oauth2/authorization/${provider}`;
    }; 

    //////////////////////////////////////////////
    /*  Q5.  justify 이용해서 중앙으로 배치 ,  위쪽에 여백주기 40   */
    /*  Q6.  반응형처리  xs 제일작은모바일 24칸,  sm 16칸, md는 8칸 */  
    return ( 
        <Row  justify="center"   style={{marginTo:40}}>
            <Col  xs={24}  sm={16}  md={8} >   
                { loading && <Spin/> }
                { error   && <p  style={{color:"red"}}>{error}</p> }

                <Form  layout="vertical" onFinish={onFinish}> 
                    <Form.Item 
                        label="이메일"
                        name="email" 
                        rules={[  {required:true, message:"이메일을 입력하세요."} ]}
                    >
                        <Input   placeholder="aaa@email.com"/>
                    </Form.Item>

                    <Form.Item 
                        label="비밀번호"
                        name="password" 
                        rules={[  {required:true, message:"비밀번호를 입력하세요."} ]}
                    >
                        <Input.Password placeholder="*****" />
                    </Form.Item>         

                    <div style={{ textAlign: 'center', marginTop: 20 }}>
                        <Button 
                            type="primary" 
                            htmlType="submit"   
                            style={{ width: '200px', height: '50px' }}
                        >
                            로그인
                        </Button>
                    </div>
                </Form> 
                {/*   소셜  로그인 이미지 버튼 */}
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/google.png"       alt="Google Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("google")}
                    />
                </div> 
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/kakao.png"      alt="Kakao Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("kakao")}
                    />
                </div>
                <div style={{ marginTop: 20, textAlign: "center" }}>
                    <img
                        src="/images/naver.png"      alt="Naver Login"
                        style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }}
                        onClick={()=> handleSocialLogin("naver")}
                    />
                </div>
 

            </Col>
        </Row>
    );
}

// SSR 단순렌더 :  서버에서 데이터 가져오거나 가공하지 않고, 
// 그냥 페이지 컴포넌트를 서버에 그려서 내주기
export async function getServerSideProps() {
  return { props: {} };
}

