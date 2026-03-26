day001
TODO1:  GITHUB
TODO2:  JAVA SETTING


--- 
## Part001 
- TODO1:  GITHUB

■1. git, github
- git : 내컴퓨터에서 파일의 변화를 기록
- github : 협업시 저장공간

■2. 실습
1. Git 설치
   - [Git 공식 사이트](https://git-scm.com)에서 다운로드 후 설치.
   https://git-scm.com
   - 설치 후 git --version 으로 정상 설치 확인.

2. 사용자 정보 설정
   git config --global user.name "깃허브아이디"
   git config --global user.email "깃허브이메일"

   ```
   git config --list
   git config --global user.name "Sally An"
   git config --global user.email "sally03915@gmail.com"
   ```

3. GitHub 계정 준비
  - GitHub 회원가입 및 로그인.
  - 새 레포지토리(repository) 생성.                   
 
4. 레포지토리 연결
   - 새 컴퓨터에서 원하는 폴더로 이동 후: 
     git clone https://github.com/아이디/레포지토리명.git

     ```
     cd  D:\hyojung2
     git clone  https://github.com/sally03915/2026-AI-FULLSTACK.git
     ```
 
- 이미 만든 프로젝트를 올리고 싶다면: 
  git init
  git remote add origin https://github.com/아이디/레포지토리명.git 


5. 작업 파일 올리기
   git add .
   git commit -m "첫 커밋 메시지"
   git push origin main

   ⚠️ 여기서 main 대신 master 일 수도 있으니, 
   레포지토리 기본 브랜치 이름 확인 필요.
 
 
6. gitinore

- Git에게 “이건 안 가져가도 돼!”라고 알려주는 메모지

- Git = 장난감상자 (모든 장난감을  넣어두는 곳)  
- 파일들 = 장난감들  
- .gitignore - “이 장난감은 상자에 넣지 마!”라고 붙여둔 스티커   

※ vs code 설치

--- 
## Part002 
- TODO2:  JAVA SETTING
■1. JAVA
1. java.sun.com 
2. 다운로드 (11,17,21)
3. 설치
4. path등록 - C:\Program Files\Java
   JAVA_HOME   :   C:\Program Files\Java\jdk-11.0.30
                  C:\Program Files\Java\jdk-17.0.18
                  C:\Program Files\Java\jdk-21.0.10

   path        :   %JAVA_HOME%\bin                

5. java 확인
   CMD
   java -version


■2. eclipse



--- 
## Part003 
- 숙제 안내 (개별카톡 보내주세요~!)
1. 집에서 github 연동 - git clone                 ※ 스크린샷 제출
2. 집 내 컴퓨터에 java/ eclipse 설치 (11, 17, 21 ) ※ 스크린샷 제출
3. 복습문제 - 노트 준비

※ 카톡은 무조건 보내기~!
1. 설치가 잘안되셨다면~ 언제까지~ 도전! 
2. 숙제완료!
