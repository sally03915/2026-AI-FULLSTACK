//pages/mypage.js 
import React , {useState}from "react";
import {useDispatch, useSelector}  from  "react-redux";
import {
  Card, Avatar, Spin, Descriptions, Form, Input, Button, Upload, List, Tabs, message,
} from "antd";
import {useRouter}  from  "next/router"; 
import {updateNicknameRequest , updateProfileImageRequest}  from "../reducers/authReducer"; 
import { UploadOutlined } from "@ant-design/icons";

//////   SSR 연동 
import { END } from "redux-saga";
import { loadUserRequest } from "../reducers/authReducer";
import { wrapper } from "../store/configureStore";


export default function MyPage(){//2. 부품 + export
    const dispatch = useDispatch();
    const router = useRouter();
    const {user} = useSelector( (state) => state.auth );// Redux에서 회원가입시 저장된 사용자 정보 가져오기 - user

    const [fileList, setFileList] = useState([]);

    const onFinishUpdateNickname = (value)=>{ 
        dispatch( updateNicknameRequest({ userId : user.id   ,nickname:value.nickname  }) );
    };
     
    if(!user){
        return (
            <div  style={{ maxWidth: 600 , margin: "40px auto"}}>
                <p>로그인된 사용자 없습니다.</p>
                <Button  type="primary"  onClick={()=> router.push("/signup")  } >
                    회원가입 하러가기
                </Button>
            </div>
        );
    } 
    ///////////////
    return (
        <div  style={{ maxWidth: 600 , margin: "40px auto"}}>
            <Card title="마이페이지 (회원 정보)">
                <div  style={{ display:"flex"  , alignItems:"center" ,  gap:"20px"  }} >
                    <Avatar src={`http://localhost:8080/${user.ufile}`} size={64}>{user.nickname?.[0]}</Avatar>
                    <Descriptions title="User Info"  bordered column={1}>
                        <Descriptions.Item label="회원 번호">{user.id}</Descriptions.Item>
                        <Descriptions.Item label="이메일">{user.email}</Descriptions.Item>
                        <Descriptions.Item label="닉네임">{user.nickname}</Descriptions.Item> 
                    </Descriptions>
                </div>
                {/*  닉네임 수정 - Q1. updateNicknameRequest 호출 */}
                <Form  
                    onFinish={onFinishUpdateNickname}
                    layout="inline"
                    style={{ marginBottom: 20 , marginTop: 40}}
                >
                    <Form.Item
                        name="nickname" 
                    >
                        <Input placeholder="새 닉네임" />
                    </Form.Item>
                    <Button type="primary" htmlType="submit">닉네임 변경</Button>
                </Form>
                {/*  프로필이미지 수정 - Q2.  updateProfileImageRequest  */}
                <Form layout="inline" style={{ marginBottom: 20 }}>
                    <Form.Item>
                        <Upload  
                            beforeUpload={()=>false}
                            fileList={  fileList   }
                            onChange={ ( {fileList} )=> setFileList(fileList)  }
                            maxCount={1}>
                            <Button icon={<UploadOutlined />}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>
                    <Button
                        type="primary"  
                        onClick={()=>{     
                            if( !user ||  fileList.length === 0  ){  
                                message.warning("변경할 이미지를 선택해주세요.");  return;
                            }   
                            const file = fileList[0]?.originFileObj;
                            dispatch(  updateProfileImageRequest({ userId: user.id, file })  );
                            setFileList([]);  // 전송 후 파일 선택 목록 초기화
                        }}
                    >
                        프로필 이미지 변경
                    </Button>
                </Form>                
            </Card>
        </div>
    );
}

// BEFORE
// 1) 사용자가 마이페이지(/mypage) 주소로 접속합니다.
// 2) 서버에서 getServerSideProps가 실행되면서 loadUserRequest 액션을 디스패치합니다.
// 3) 문제점: Redux-Saga는 비동기(Asynchronous)로 동작하기 때문에, 
//           서버는 사가가 백그라운드에서 백엔드 API(/auth/me)를 부르든 말든 기다리지 않고 
//           곧바로 return { props: {} }를 실행해버립니다.
// 4) 결과적으로 브라우저는 유저 정보가 아직 담기지 않은 텅 빈 스토어 상태로 페이지를 먼저 그려버리게 되므로, 
//            새로고침 시 로그인 정보가 안 뜬 것처럼 보이거나 깜빡임 현상이 발생합니다.

// 직접 API를 부르지 않고 , loadUserRequest 디스패치해서 사가완료 기다림
export const getServerSideProps = wrapper.getServerSideProps((store) => async (ctx) => { 
  //1. 요청헤더의 쿠키를 담아서 사용자 정보를 조회를 위한 사가 액션 디스패치  
  store.dispatch(loadUserRequest({ cookie: ctx.req.headers.cookie || "" }));
  //2. 서버사이드에서 사가작업이 끝날때까지 대기
  store.dispatch(END);  // 채널닫아 신호
  await store.sagaTask.toPromise();  
  // 3. 스토어 상태를 확인해서 유저정보없으면 로그인페이지로 리다이렉트
  const state = store.getState();
  const user = state.auth.user;

  if (!user || !user.nickname) {
    return {
      redirect: {
        destination: "/login",  
        permanent: false,  
      },
    };
  } 
  return { props: {} };
});
