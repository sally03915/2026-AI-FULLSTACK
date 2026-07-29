// pages/index.js

import { useEffect }  from 'react';        // 특정동작 실행
import { useRouter }  from 'next/router';  // 이동

export  default function  Home(){
    //1. 코드
    const router = useRouter();
    useEffect(  ()=>{
        router.replace('/users');   //      /users    뒤로가기남지 않음.
    }  , [ router ]);  // router 변경시 useEffect 실행

    //2. view
    return null;
};

// useSelector - 전역상태
// useEffect   - 변경감지
// dispatch    - 액션발생

////// ver-1
// export  default function  Home(){
//     return <h1>REACT PROJECET 정상실행</h1>;
// }
// npm run dev