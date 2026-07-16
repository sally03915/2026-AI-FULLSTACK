const { 
    createUser, 
    findUserByEmail, 
    verifyUser, 
    getAllUsers, 
    updateUserNickname, 
    deleteUser, 
    findUserById, 
    findUserByNickname 
} = require('./models/users');

async function runTests() {
    try {
        console.log('--- 🧪 [테스트 시작] ---');

        // 1. 회원가입
        await createUser('t@t', 't', 'tt', '0101111111', 1, '1.png');  
        console.log('✅ 1. createUser 성공');

        // 2. 이메일로 조회
        const userByEmail = await findUserByEmail('t@t');  
        console.log('✅ 2. findUserByEmail 결과: ', userByEmail);

        // 3. 로그인 검증 (비밀번호 맞는 경우)
        const loginUser = await verifyUser('t@t', 't');  
        console.log('✅ 3. verifyUser 결과 (비밀번호 일치): ', loginUser);

        // 4. 로그인 검증 (비밀번호 틀린 경우)
        const failLogin = await verifyUser('t@t', 'wrong');  
        console.log('✅ 4. verifyUser 결과 (비밀번호 불일치): ', failLogin);
        
        // 5. 전체조회
        const allUsers = await getAllUsers();  
        console.log('✅ 5. getAllUsers 결과:', allUsers);
        
        // 6. 닉네임 수정 (순서 수정됨: nickname, id)
        await updateUserNickname('AA', userByEmail.APP_USER_ID);  
        const updateUser = await findUserById(userByEmail.APP_USER_ID);
        console.log('✅ 6. updateUserNickname 결과:', updateUser);

        // 7. 사용자 삭제
        // await deleteUser(userByEmail.APP_USER_ID);  
        // console.log('✅ 7-1. deleteUser 성공');
        // const deletedUser = await findUserById(userByEmail.APP_USER_ID);
        // console.log('✅ 7-2. findUserById (삭제 후 조회결과 - null 기대):', deletedUser);

 
 
        // 8-1. 이미 존재하는 닉네임 'tt'로 테스트용 사용자 회원가입
        await createUser('test2@test.com', 'pw', 'tt', '0101111111', 1, '1.png');
        console.log('✅ 8-1. createUser(tt) 성공');

        // 8-2. 닉네임 중복 검사 실행 (중복 발생 시나리오)
        const duplicateNickname = await findUserByNickname('tt');
        if (duplicateNickname) {
            console.log('✅ 8-2. findUserByNickname 결과: 닉네임 중복 확인됨 (값 있음)');
        } else {
            console.log('❌ 8-2. findUserByNickname 결과: 닉네임이 없다고 나옴 (검증 실패)');
        }

        // 8-3. 존재하지 않는 닉네임 검사 (사용 가능 시나리오)
        const newNickname = await findUserByNickname('uniqueName123');
        if (!newNickname) {
            console.log('✅ 8-3. findUserByNickname 결과: 닉네임 사용 가능 (값 없음)');
        }

    } catch (err) {
        console.error('❌ 닉네임 테스트 중 오류 발생:', err);
    }
}

runTests();

//  node   test1.js
