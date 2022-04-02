import { tokenAction, signInAction } from "../type";

const tokenReducer = (state = '', action: tokenAction) => {
  switch (action.type) {
    case "SET_TOKEN":
      state = action.token as string;
      localStorage.setItem('loginToken', state);
      break;
    case "DELETE_TOKEN":
      localStorage.removeItem('loginToken');
      state = '';
      break;
    default:
      state = localStorage.getItem('loginToken') || '';
  }
  return state;
};
const initUserState = {
  loginStatus: "loginNo",
  userInfo: null
};
const loginReducer = (state: any = initUserState, action: signInAction) => {
  switch (action.type) {
    case "SIGN_IN":
      localStorage.setItem('loginToken', action.userInfo.token);
      return {
        userInfo: action.userInfo
      };
    default:
      return state;
  }
}


export { loginReducer };