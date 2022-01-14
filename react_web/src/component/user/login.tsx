import React from 'react';
import { Form, Input, Button, Checkbox } from 'antd';

class Login extends React.Component{
	onFinish= (value:any):void=>{
		fetch('/api/user/login',{
			method:'POST',
			headers:{
				'Content-Type': 'application/json; charset=UTF-8'
			},
			body:JSON.stringify(value)
		}).then(result=>{
			result.json();
		}).then(data=>{
			console.log(data);
		});
	};
	
	onFinishFailed=(error:any):void=>{
	}
	
	render(){
		return (
			<div>
				<Form
				      name="login"
				      initialValues={{ remember: true }}
				      onFinish={this.onFinish}
				      onFinishFailed={this.onFinishFailed}
					  wrapperCol={{span:4}}
				      autoComplete="off"
					  layout="horizontal"
					  size="large"
				    >
				      <Form.Item
				        label="用户名"
				        name="username"
				        rules={[{ required: true, message: '请输入用户名' }]}
				      >
				        <Input />
				      </Form.Item>
				
				      <Form.Item
				        label="密码"
				        name="password"
				        rules={[{ required: true, message: '请输入密码' }]}
				      >
				        <Input.Password />
				      </Form.Item>
				
				      <Form.Item name="remember" valuePropName="checked">
				        <Checkbox>记住我</Checkbox>
				      </Form.Item>
				
				      <Form.Item>
				        <Button type="primary" htmlType="submit">
				          登录
				        </Button>
				      </Form.Item>
				    </Form>
			</div>
		);
	}
}

export default Login;