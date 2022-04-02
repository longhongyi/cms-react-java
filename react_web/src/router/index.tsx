import { useLocation, Navigate, Routes, Route } from "react-router-dom";
import { Suspense } from 'react';
import routes from './routerMap';


//把routersMap转换成Routes组件
const generateRouter = (routersMap: any) => {
    let routers = routersMap.map((item: any) => {
        if (item.children) {
            let children = generateRouter(item.children)
            return (<Route key={item.toString()} path={item.path}
                element={
                    <Suspense fallback={
                        <div>加载中...</div>
                    }>
                        {/* 把懒加载的异步路由变成组件装载进去 */}
                        <item.component />
                    </Suspense>}>
                {children}
            </Route>);
        } else {
            return (<Route key={item.toString()} path={item.path}
                element={
                    <Suspense fallback={
                        <div>加载中...</div>
                    }>
                        {/* 把懒加载的异步路由变成组件装载进去 */}
                        <item.component />
                    </Suspense>}>
            </Route>);
        }
    });
    return routers;
}

//根据权限过滤routersMap，获取不需要验证的路由
const filterRoutersMap = (routersMap: any) => {
    let filterMap: any = [];
    routersMap.forEach((item: any) => {
        if (item.children) {
            item.children = filterRoutersMap(item.children)
        }
        if (item.auth == false) {
            filterMap.push(item)
        }
    });
    return filterMap;
}
//找到当前访问的路由
const findRouter = (routersMap: any, pathname: string) => {
    let router = '';
    for (let item of routersMap) {
        if (item.children) {
            router = findRouter(item.children, pathname);
            if (router != '') {
                break;
            }
        }
        if (item.path == pathname) {
            router = item;
            break;
        }
    }
    return router;
}


// 根据store里的用户权限，动态创建路由
const Router = () => {
    const location = useLocation();
    const pathname = location.pathname;
    let token: string | null = localStorage.getItem("loginToken");
    const needRouter: any = findRouter(routes, pathname);
    //默认权限为未登录权限
    let loginedRouters = generateRouter(routes);
    let noLoginRoutersMap = filterRoutersMap(routes);
    let noLoginRouters = generateRouter(noLoginRoutersMap);
    if (needRouter != '') {
        //未登录的隐藏需要登录的路由组件
        if (token != null) {
            return (<Routes>{loginedRouters}</Routes>);
        } else {
            if (needRouter.auth == false) {
                return (<Routes>{noLoginRouters}</Routes>);
            } else {
                if (pathname == "/user/login") {
                    return (<Routes>{noLoginRouters}</Routes>);
                } else {
                    alert("需要登录后访问！");
                    return <Navigate to="/user/login" />;
                }
            }
        }
    } else {
        alert("您访问的路径不存在！");
        return <Navigate to="/home" />;
    }
}
export { Router }