import { lazy } from 'react';
const routes = [
    {
        path: '/',
        auth: false,
        component: lazy(() => import('../pages/home'))
    },
    {
        path: '/home',
        auth: false,
        component: lazy(() => import('../pages/home'))
    },
    {
        path: '/admin',
        auth: true,
        component: lazy(() => import('../pages/admin'))
    },
    {
        path: '/user',
        auth: false,
        component: lazy(() => import('../pages/user/userInfo')),
        children: [
            {
                path: '/user/order',
                auth: false,
                component: lazy(() => import('../pages/user/order'))
            },
            {
                path: '/user/score',
                auth: false,
                component: lazy(() => import('../pages/user/score'))
            },
        ]
    },
    {
        path: '/user/login',
        auth: false,
        component: lazy(() => import('../pages/user/login'))
    },
    {
        path: '/user/register',
        auth: false,
        component: lazy(() => import('../pages/user/register'))
    }
];

export default routes;