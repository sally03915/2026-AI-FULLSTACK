// components/Layout.js
import Link  from 'next/link';
//1. 부품 export  default function 부품명
//2. code   / return
export  default function Layout( { children } ){   //children  x
    return(
        <div> 
            {/* 헤더 */}
            <div className="p-5 bg-primary text-white text-center">
                <h1>My First React Page</h1>
            </div>

            {/* 네비게이션바 */}
            <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
            <div className="container-fluid">
                <ul className="navbar-nav">
                <li className="nav-item">
                    {/* Home */}
                    <Link  href="/users">
                        <a className="nav-link active" href="#">HOME</a>
                    </Link>
                </li>
                <li className="nav-item">
                    {/* 로그인 */}
                    <Link  href="/login">
                        <a className="nav-link" href="#">로그인</a>
                    </Link>
                </li>
                <li className="nav-item"> 
                    {/* 회원가입 */}
                    <Link  href="/join">
                        <a className="nav-link" href="#">회원가입</a>
                    </Link>
                </li> 
                </ul>
            </div>
            </nav>
            {/* 본문    */}
            <main  className="container mt-5">{ children }</main>

            {/* 푸터 */}
            <footer className="mt-5 p-4 bg-dark text-white text-center">
            <p>Footer</p>
            </footer>            
        </div>
    );
}