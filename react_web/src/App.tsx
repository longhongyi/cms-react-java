import React from 'react';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import { Router } from './router';
import AdminHome from './pages/admin';
import UserInfo from "./pages/user/userInfo"
import Home from './pages/home';
import Login from './pages/user/login';
import Register from './pages/user/register';

class App extends React.Component {
	render(): React.ReactNode {
		return (
			<BrowserRouter>
				<Router />
				{/* <Routes>
					 <Route path='/' element={<Home />}/>
					<Route path='/home' element={<Home />}/>
					<Route path='/user' >
						<Route path='login' element={<Login />}></Route>
						<Route path='register' element={<Register />}></Route>
					</Route>
					<Route path='/admin' element={<AdminHome />}>

					</Route> 

				</Routes> */}
			</BrowserRouter>
		);
	}
}

export default App;