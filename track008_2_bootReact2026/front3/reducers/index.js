// reducers/index.js
import {combineReducers}  from "@reduxjs/toolkit";
import authReducer from './authReducer';
import postReducer from './postReducer';

const rootReducer = combineReducers({
    auth: authReducer ,   // state.auth
    post: postReducer ,   // state.post
});

export default rootReducer;