/**
 * passport/local.js
 * -------------------------------
 * 사용자가 로그인 시 입력한 email 과 passport를 db와 비교하여 인증
 * bcrypt 사용해서 비밀번호 해시비교
 */
const passport = require('passport');  // passport 모듈불러오기
const { Strategy: LocalStrategy } = require('passport-local'); // 로컬 로그인 전략  
const bcrypt = require('bcrypt');  // 비밀번호 해시 비교용
const { findUserByEmail } = require('../models/users');   // db사용자 조회함수

module.exports = () => {
  passport.use(new LocalStrategy(
           {  usernameField: 'email',        // 로그인시 사용할 필드명    req.body.email
              passwordField: 'password',     // 로그인시 사용할 필드명    req.body.password
           }, //설정
           async (email, password, done) => {
                try{
                    const user = await findUserByEmail(email);   //db에서 이메일로 사용자 조회
                    if (!user) {
                        return done(null, false, { message: '존재하지 않는 이메일입니다!' });
                    } //         에러없음, 인증실패, 실패정보
                    const match = await bcrypt.compare(password, user.PASSWORD); // 비밀번호 해시비교
                    if(match){ return done(null , user); }  
                    else{      return done(null,   false, {message:'비밀번호가 틀렸습니다.'});      } 
                }catch(error){
                    console.error('LocalStrategy Error' , error);
                    return done(error);   
                }
           }   
        )
    );
};