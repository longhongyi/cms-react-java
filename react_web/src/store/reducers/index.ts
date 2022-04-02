import { combineReducers } from "redux";
import  {loginReducer} from "./reducers";
// 整合
const allReducers = combineReducers(
    {
        user:loginReducer
    }
);
export default allReducers;
