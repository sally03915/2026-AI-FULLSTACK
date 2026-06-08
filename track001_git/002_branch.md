■1.  git branch
🛠️ 팀장 작업 흐름
1. 깃허브저장소 만들기
2. 팀원초대 - [Settings] - Collaborators
> https://github.com/sally03915/2026-ai_branch.git


🛠️ 팀원 작업 흐름  (1)
1. 저장소 클론하기
git clone <팀장이 만든 저장소 주소>
cd <저장소 폴더>

```
git clone   https://github.com/sally03915/2026-ai_branch.git
cd  2026-ai_branch
```

2. 브랜치 생성하기
git branch                           -- 브랜치 확인
git checkout -b feature-브랜치이름
git branch   브랜치이름                -- 브랜치 바꾸기

```
git branch    
git checkout -b  feature-ahj
```

3. 작업 후 커밋하기
git add .
git commit -m "작업 내용 설명"

4. 원격 저장소에 브랜치 푸시하기
git push origin feature-브랜치이름

```
git push origin feature-ahj
```


🛠️ 팀장과 팀원 작업 흐름  
1.  팀원은 Pull Request 작성 
2.  팀장은 GitHub/GitLab 등에서 Pull Request (PR) 확인
3.  코드 리뷰를 진행하고 필요하면 팀원에게 수정 요청
4.  문제가 없으면 팀장이 해당 브랜치를 main/master 브랜치에 머지



