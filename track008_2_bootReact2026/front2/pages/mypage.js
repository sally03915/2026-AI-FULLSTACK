//pages/mypage.js 
import React , {useState}from "react";
import {useDispatch, useSelector}  from  "react-redux";
import {
  Card, Avatar, Spin, Descriptions, Form, Input, Button, Upload, List, Tabs, message,
} from "antd";
import {useRouter}  from  "next/router"; 
import {updateNicknameRequest , updateProfileImageRequest}  from "../reducers/authReducer"; 
import { UploadOutlined } from "@ant-design/icons";

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