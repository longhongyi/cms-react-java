import { tokenAction, signInAction } from "../type";

export const setToken = (token: string): tokenAction => ({
  type: "SET_TOKEN",
  token
});
export const deleteToken = (): tokenAction => ({
  type: "DELETE_TOKEN"
});

export const signIn = (userInfo:any): signInAction => {
  return {
    type:"SIGN_IN",
    userInfo:userInfo
  }
}
// export const logout = (): loginAction => {
//   return {
//     type: "LOGOUT"
//   }
// }