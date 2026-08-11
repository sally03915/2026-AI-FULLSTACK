import { useEffect, useRef } from "react";
import { useRouter } from "next/router";
import { useDispatch } from "react-redux";
import { loginSuccess } from "../../reducers/authReducer";

export default function OAuth2CallbackPage() {
    const router = useRouter();
    const dispatch = useDispatch();
    
    // 중복 요청 방지용 Ref
    const hasFetched = useRef(false);

    useEffect(() => {
        if (!router.isReady) return;

        const { accessToken } = router.query;

        // accessToken이 있고, 아직 fetch를 수행하지 않았을 때만 실행
        if (accessToken && !hasFetched.current) {
            hasFetched.current = true; // 플래그를 true로 변경하여 중복 방지
            
            try {
                localStorage.setItem("accessToken", accessToken);
                fetchUser(accessToken);
            } catch (err) {
                console.error("OAuth2 callback error:", err);
                router.push("/login");
            }
        }
    }, [router.isReady, router.query.accessToken]); // 의존성을 query 전체가 아닌 필요한 accessToken으로 한정

    const fetchUser = async (accessToken) => {
        try {
            const res = await fetch("http://localhost:8080/auth/me", {
                headers: { Authorization: `Bearer ${accessToken}` },
                credentials: "include",
            });

            if (res.ok) {
                const user = await res.json();
                dispatch(loginSuccess({ user, accessToken }));
                router.push("/mypage");
            } else {
                console.error("Auth failed with status:", res.status);
                router.push("/login");
            }
        } catch (err) {
            console.error("User fetch error:", err);
            router.push("/login");
        }
    };

    return <p>소셜 로그인 처리 중입니다....</p>;
}