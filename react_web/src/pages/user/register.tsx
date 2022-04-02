import React from 'react';
import {Form,Button,Input} from 'antd';
import {register} from "../../api";

class Register extends React.Component{
	onFinish=async (value: any) => {
		let result = await register(value);
		console.log(result);
	};
	
	onFinishFailed=(error:any):void=>{
	}
	
	render(){
		return (
			<div>
				<Form
					name="register"
					onFinish={this.onFinish}
					onFinishFailed={this.onFinishFailed}
					wrapperCol={{span:4}}
				>
					<Form.Item
						name="username"
						label="用户名"
						rules={[{required:true,message:"请输入用户名"}]}
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
					<Form.Item>
					  <Button type="primary" htmlType="submit">
					    注册
					  </Button>
					</Form.Item>
				</Form>
			</div>
		);
	}
}

export default Register;