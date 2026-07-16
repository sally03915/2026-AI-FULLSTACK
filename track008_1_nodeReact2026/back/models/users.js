//1.  require
const  dbConfig = require('../config/db');  //user, password, connectString
const  oracledb = require('oracledb');
const  bcrypt    = require('bcrypt');   //## bcrypt
// oracle 초기화
oracledb.initOracleClient(); 
const options = { outFormat: oracledb.OUT_FORMAT_OBJECT , autoCommit:true }; 

//2. 각기능 sql
// 1. create - insert
// ### 1. 사용자 등록 (Create - Insert)
// INSERT INTO appuser (
//     APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE,    CREATED_AT
// ) VALUES (
//     APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile,    SYSDATE
// )
async function  createUser( email,     password,    nickname,      mobile,    mbtiTypeId,      ufile){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const  hashedPassword = await  bcrypt.hash(password , 10);
        const  result = await conn.execute( 
            `INSERT INTO appuser (
                APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE,    CREATED_AT
             ) VALUES (
                APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile,    SYSDATE
             )` 
            , {email,     password:hashedPassword,    nickname,      mobile,    mbtiTypeId,      ufile} 
            , options);  // sql, 사용자입력값, 옵션
    }catch(err){
        console.log(  'createUser Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
}


// 2. 사용자조회 - email
// ### 2. 사용자 조회 (Email 기준)
// SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// WHERE EMAIL = :email 
async function  findUserByEmail(email){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
             FROM appuser 
             WHERE EMAIL = :email` 
             , {email} 
             , options); //실행
        return result.rows[0];  //결과처리    
    }catch(err){
        console.log(  'findUserByEmail Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
}


// 3. 사용자조회 - id
// ### 3. 사용자 조회 (ID 기준)
// SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// WHERE APP_USER_ID = :id
async function  findUserById(id){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
             FROM appuser 
             WHERE APP_USER_ID = :id` 
             , {id} 
             , options); //실행
        return result.rows[0];  //결과처리    
    }catch(err){
        console.log(  'findUserById Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
}

// 4. 로그인 - sql 빼기 pass /  로그아웃
// ### 4. 로그인 & 로그아웃
async function  verifyUser(   email, password ){
    const user = await  findUserByEmail(email);
    if(!user)  return null;

    const  match = await bcrypt.compare(  password , user.PASSWORD);
    if(!match)  return null;

    return {
        id:   user.APP_USER_ID, 
        email : user.EMAIL , 
        nickname: user.NICKNAME,
    }
} 


// 5. 전체조회 
// ### 5. 전체 사용자 조회 (Read All)
// SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// ORDER BY CREATED_AT DESC
async function  getAllUsers(){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
             FROM appuser 
             ORDER BY CREATED_AT DESC` 
             , {} 
             , options); //실행
        return result.rows;  //결과처리   
    }catch(err){
        console.log(  'getAllUsers Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

// 6. 닉네임수정
// ### 6. 닉네임 수정 (Update Nickname)
// UPDATE appuser 
// SET NICKNAME = :nickname 
// WHERE APP_USER_ID = :id
async function  updateUserNickname(  nickname , id  ){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `UPDATE appuser 
             SET NICKNAME = :nickname 
             WHERE APP_USER_ID = :id` 
             , {nickname , id } 
             , options); //실행
    }catch(err){
        console.log(  'updateUserNickname Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

// 7. 사용자 삭제
// ### 7. 사용자 삭제 (Delete)
// DELETE FROM appuser 
// WHERE APP_USER_ID = :id
async function  deleteUser( id ){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
            `DELETE FROM appuser  
             WHERE APP_USER_ID = :id` 
             , { id } 
             , options); //실행
    }catch(err){
        console.log(  'deleteUser Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

// 8. 닉네임조회
// ### 8. 닉네임 조회 
// SELECT APP_USER_ID, EMAIL, NICKNAME 
// FROM appuser 
// WHERE NICKNAME = :nickname  
async function  findUserByNickname(nickname){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await  conn.execute(
        `SELECT APP_USER_ID, EMAIL, NICKNAME 
        FROM appuser 
        WHERE NICKNAME = :nickname` 
        , {nickname} 
        , options); //실행
        return result.rows[0];  //결과처리  
    }catch(err){
        console.log(  'findUserByNickname Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
} 

//3. export
module.exports = {  createUser ,  findUserByEmail ,  findUserById, 
                    verifyUser , getAllUsers , updateUserNickname , deleteUser , findUserByNickname};


 