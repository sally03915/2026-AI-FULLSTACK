// components/AppLayout.js   # 재사용 가능한 UI 컴포넌트 폴더 
//1. require
import { Layout, Menu, Input, Row, Col, Drawer, Button, Grid } from "antd";  
import { MenuOutlined, SearchOutlined } from "@ant-design/icons";   
import { useSelector, useDispatch}  from 'react-redux'; // 전역상태 , 액션스토어알림
import { useRouter }                from 'next/router'; // 경로이동
import { useEffect,  useState   }  from 'react';       // 이벤트변경감지, 변수
import  Link                        from 'next/link';

const  {Header, Content} = Layout;    // <Layout.Header> → <Header>  
const  {useBreakpoint} = Grid;
import {logoutRequest , loginSuccess }  from '../reducers/authReducer';  //##

import  axios from "axios";

//2. 부품
// Header / Drawer
function AppLayout({  children , initialUser  }){   //★ 대체부품, 초기값
    // 변수, 셋팅함수
    const [ drawerOpen , setDrawerOpen ] = useState(false);  
    const router       = useRouter();
    const dispatch     = useDispatch();
    const {user}       = useSelector((state)=> state.auth); 
    
    const handleLogout = ()=>{   dispatch(logoutRequest());   router.replace('/login');  };  // 디스패치(logoutRequest()) / 경로 login 넘기기   //##

    const menuItems = [
       ...( user  &&  user.nickname
        ? [
            { key: "new",       label: <Link href="/posts/new">✏️ NEW POST</Link> },
            { key: "profile",   label: <Link href="/mypage">👤 MYPAGE </Link> },
            { key: "logout",    label: <a onClick={handleLogout}  style={{cursor:"pointer"}} >🔓 로그아웃</a> },
        ]
        : [ 
            { key: "login",     label: <Link href="/login">🔒 Login</Link> },
            { key: "signup",    label: <Link href="/signup">👤 Signup</Link> },
        ]
      ) 
    ]; 
    ////////////#1) Row (줄) - Col(칸)   /  Col
    ////////////#2) 반응형속성 (모바일 : xs, sm, 태블릿: md, pc: lg) - 24칸 
    //  display:"flex"  자식요소 배치 알아서
    //  justify="space-between"  양쪽에 콘텐츠 배치 
    return   (<Layout>
    {/* Header */}
    <Header  style={{display:"flex"}}>  
        <Row align="middle" justify="space-between"  style={{width:"100%"}} >
            <Col  flex="none">
                <Link href="/">    
                    <a style={{color:"#fff", fontWeight:"bold", fontSize:"18px"}}>
                        THEJOA703 ( BOOT  + REACT VER) 
                    </a>
                </Link>
            </Col>
            {/*  xs, sm (모바일): 0 숨김처리  ,  md (테블릿) : 16  24칸중에 16 , lg(pc) : 18 */}
            <Col flex="auto" xs={0}  sm={0}  md={16}  lg={18}>
                <Menu
                theme="dark"
                mode="horizontal" 
                items={menuItems} 
                />
            </Col>
            {/*  button 종류 : primary , default(하얀색), text(없음) , link(a링크형식모양)  */}
            <Col  flex="none"  xs={2}   md={0}>
                <Button 
                type="text" 
                icon={ <MenuOutlined  style={{color:"white" , fontSize:20 }} />}
                onClick={()=>setDrawerOpen(true)}> 
                </Button>
            </Col>
        </Row>
    </Header> 
    <Drawer
    title="MENU"
    placement="right" 
    onClose={()=> setDrawerOpen(false)}
    open={drawerOpen}
    >
        <Menu 
        mode="vertical" 
        items={menuItems}  
        />
    </Drawer>
    <Content  style={{ padding: "40px" }}>{children}</Content>
    </Layout>);
}
//3. export
export   default  AppLayout;

// Layout: https://ant.design/components/layout 
// Menu: https://ant.design/components/menu 
// Input: https://ant.design/components/input 
// Drawer: https://ant.design/components/drawer 
// Grid(Row/Col): https://ant.design/components/grid 
// Button: https://ant.design/components/button