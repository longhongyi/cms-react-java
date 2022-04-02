import React from "react";
import { Link, Outlet } from 'react-router-dom';
import Order from './order';
import Score from './order';

export default function UserInfo() {
  return (
    <div>
      <h1>用户</h1>
      <div>
        <Link to='/user/order'>我的订单</Link>
        <Link to='/user/score'>我的积分</Link>
      </div>
      <hr />
      <Outlet/>
    </div>
  );
}