/*******
 * routes-user.js
 * ----------------
 *  사용자관련 API 라우터
 */
const express = require('express');
const passport = require('passport');  
const {    createUser,  getAllUsers,  updateUserNickname
        ,  deleteUser , findUserByEmail , findUserByNickname} = require('../models/users');
const isAuthenticated = require('../middlewares/isAuthenticated'); 
const router = express.Router();   

//회원가입
/**
 * @swagger
 * /user/register:
 *   post:
 *     summary: 회원가입
 *     description: 새로운 사용자를 등록합니다.
 *     requestBody:                       
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email: { type: string }
 *               password: { type: string }
 *               nickname: { type: string }
 *               mobile: { type: string }
 *               mbtiTypeId: { type: integer }
 *               ufile: { type: string }
 *     responses:
 *       201:
 *         description: 회원가입 성공
 */     // swagger에서  password 오타확인~!
 
router.post('/register'      , async(req, res)=>{   
    try{
        const {email, password, nickname, mobile, mbtiTypeId, ufile} = req.body;
        await  createUser(email, password, nickname, mobile, mbtiTypeId, ufile);  
        res.status(201).json({message:'회원가입 성공'}); //200 ok  , 201 created
    }catch(err){
        console.error('Register Error' , err);
        res.status(500).json({message:'회원가입 실패'});
    }
});

//로그인
/**
 * @swagger
 * /user/login:
 *   post:
 *     summary: 로그인
 *     description: Passport LocalStrategy로 이메일/비밀번호 인증 후 세션 저장
 *     requestBody:                      
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email: { type: string }
 *               password: { type: string }
 *     responses:
 *       200:
 *         description: 로그인 성공
 *       401:
 *         description: 로그인 실패
 */  //    /user/login
router.post('/login', (req, res, next) => {
    //실행 → passport/local.js , LocalStrategy 호출
    passport.authenticate('local', (err, user, info) => { //err 인증과정발생에러, 성공반환된사용자객체, 실패메시지객체 
        if (err) return next(err);
        if (!user) return res.status(401).json({ message: info?.message || '로그인 실패' });

        req.login(user, (loginErr) => {// poassport가 제공하는 함수 , 인증된 사용자객체를 세션에저장하는 과정
            // 내부적으로 serializeUser호출되면 세션에 저장 , 이후 deserializeUser 실행되서 req.user사용자 객체 복원 
            if (loginErr) return next(loginErr);
            const { PASSWORD, ...safeUser } = user; // DB에서 가져온 사용자객체에서 PASSWORD 필드제거 (비번빼기)
            //     뺄필드   ,   나머지속성들 새로운객체
            return res.status(200).json({message:'로그인 성공' , user: safeUser}); // 사용자정보반환
        });
    })(req, res, next);   
});
 
//로그아웃
/**
 * @swagger
 * /user/logout:
 *   post:
 *     summary: 로그아웃
 *     description: Passport 세션 기반으로 세션 종료
 *     responses:
 *       200:
 *         description: 로그아웃 성공
 */
router.post('/logout', (req, res) => {  //isAuthenticated   로그인한 유저만다음진행 ,x 401
    req.logout((err)=>{ // poassport가 제공하는 함수 , 현재 로그인된 사용자정보를 세션에서 제거
        if(err) return res.status(500).json({message: '로그아웃 실패'});
        req.session.destroy( ()=>{ // 세션을 제거
            res.clearCookie('connect.sid');  // 브라우저에 저장된 세션쿠기 삭제 , 쿠키가 없으면 브라우저가 세션식별 못함
            res.json({ message: '로그아웃 성공' });
        });
    });
}); 

//전체 사용자 조회
/**
 * @swagger
 * /user/:
 *   get:
 *     summary: 전체 사용자 조회
 *     description: 로그인된 사용자만 전체 사용자 목록을 조회할 수 있습니다.
 *     responses:
 *       200:
 *         description: 사용자 목록 반환
 *       401:
 *         description: 인증 필요
 */
router.get('/'        ,   isAuthenticated   , async(req, res)=>{  
    try{ 
        const users = await getAllUsers();
        res.json(users);
    }catch(err){
        console.error('GetAllUsers Error' , err);
        res.status(500).json({message:'사용자 조회 실패'});
    }
});

//닉네임 수정
/**
 * @swagger
 * /user/{id}/nickname:
 *   patch:
 *     summary: 닉네임 수정
 *     description: 특정 사용자의 닉네임을 수정합니다. (로그인 필요)
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema: { type: integer }
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               nickname: { type: string }
 *     responses:
 *       200:
 *         description: 닉네임 수정 완료
 *       401:
 *         description: 인증 필요
 */
router.patch('/:id/nickname'  ,   isAuthenticated  , async(req, res)=>{    
    try{ 
        const {nickname} = req.body;
        await  updateUserNickname( nickname, req.params.id   );
        res.json({message : '닉네임 수정 완료'});
    }catch(err){
        console.error('UpdateUserNickname Error' , err);
        res.status(500).json({message:'닉네임 수정 실패'});
    }
});

//사용자 삭제  
/**
 * @swagger
 * /user/{id}:
 *   delete:
 *     summary: 사용자 삭제
 *     description: 특정 사용자를 삭제합니다. (로그인 필요)
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema: { type: integer }
 *     responses:
 *       200:
 *         description: 사용자 삭제 완료
 *       401:
 *         description: 인증 필요
 * 
 */
router.delete('/:id'   ,   isAuthenticated   , async(req, res)=>{
    try{  
        await  deleteUser( req.params.id);
        res.json({message : '사용자 삭제 완료'});
    }catch(err){
        console.error('DeleteUser Error' , err);
        res.status(500).json({message:'사용자 삭제 실패'});
    }
}); 

//3. export
module.exports = router;