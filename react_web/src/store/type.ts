export interface tokenAction {
    type: "SET_TOKEN" | "DELETE_TOKEN";
    token?: string;
}
export interface signInAction {
    type: "SIGN_IN";
    userInfo:any;
}

