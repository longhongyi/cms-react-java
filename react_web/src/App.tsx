import React from 'react';
import {BrowserRouter,Route,Routes} from 'react-router-dom';
import Login from './component/user/login';
import Register from './component/user/register';
import Home from './component/index';

class App extends React.Component{
	render(){
		return (
			<BrowserRouter>
				<Routes>
					<Route path='/' element={<Home />}/>
					<Route path='/user'>
						<Route path='login' element={<Login />}></Route>
						<Route path='register' element={<Register />}></Route>
					</Route>
				</Routes>
			</BrowserRouter>
		);
	}
}

export default App;