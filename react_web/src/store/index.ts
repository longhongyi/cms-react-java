import { createStore } from 'redux';
import allReducers from './reducers';
// 注册
const store = createStore(
  allReducers,
  // @ts-ignore
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__() // 引入Redux调试工具
);
// 导出
export default store;