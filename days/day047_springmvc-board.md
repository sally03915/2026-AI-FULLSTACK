1. Board 진행 - service / controller / view 중간까지

진행1. Service
진행2. view 연동
진행3. 연습문제 


### 🛠️ 팀원 작업 흐름
1. **저장소 클론하기**
   ```bash
   git clone <팀장이 만든 저장소 주소>
   cd <저장소 폴더>
   ```
2. **브랜치 생성하기**
   ```bash
   git checkout -b feature-브랜치이름
   ```
3. **작업 후 커밋하기**
   ```bash
   git add .
   git commit -m "작업 내용 설명"
   ```
4. **원격 저장소에 브랜치 푸시하기**
   ```bash
   git push origin feature-브랜치이름
   ```

### 👩‍💼 팀장 확인 및 머지 흐름
1. 팀장은 GitHub/GitLab 등에서 **Pull Request (PR)** 또는 **Merge Request (MR)**를 확인합니다.
2. 코드 리뷰를 진행하고 필요하면 팀원에게 수정 요청을 합니다.
3. 문제가 없으면 팀장이 해당 브랜치를 **main/master 브랜치에 머지**합니다.
   - GitHub 예시:
     - Pull Request → "Merge pull request" 버튼 클릭
   - CLI 예시:
     ```bash
     git checkout main
     git pull origin main
     git merge feature-브랜치이름
     git push origin main
     ```

### 📌 핵심 포인트
- 팀원은 **직접 main에 올리지 않고 브랜치에서 작업**합니다.
- 팀장은 **PR/MR을 통해 코드 리뷰 후 머지**합니다.
- 협업 시에는 **브랜치 전략**(예: Git Flow, GitHub Flow)을 정해두면 더 체계적으로 관리할 수 있습니다.