package com.the703.basic010;

//1)  basic010, basic010_ex
class UserInfo{
	public     String name;		 // 아무데서나 다 접근가능
	protected  String safeCode;  // 자식에서 사용가능 (extends 시)
			   String house;     // 패키지(폴더)
	private    int   iQ;	     // 클래스내부	 - The value of the field UserInfo.iQ is not used  
	// alt + shift + s
	public int getiQ() { return iQ; }
	public void setiQ(int iQ) { this.iQ = iQ; }
} 
public class Class007_modifier {
	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보");
		UserInfo  user = new UserInfo();
		user.name ="홍상직";  // public 아무데서나 접근이 가능
		user.safeCode="1234";
		user.house="전라남도 장성군";
		//user.iQ = 148;   // The field UserInfo.iQ is not visible  A=B
		user.setiQ(148);
		System.out.println(user.getiQ());
	}
}

/*******    
1. 지정접근자
- 클래스의 구성요소에 대한 접근을 제한하는 역할
				클래스내부		패키지(폴더)	하위클래스 	그 외
public			O			O			O			O
protected		O			O			O			X
default			O			O			X			X
private			O			X			X			X

 */