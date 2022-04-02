import React from 'react';
import { Form, Input, Button, Checkbox, Alert } from 'antd';
import { useDispatch } from 'react-redux';
import { setToken, signIn } from "../../store/actions/user";
import { useNavigate } from 'react-router-dom';
import store from "../../store";
import { signIn as apiSignIn } from "../../api";

const Login = () => {
	const dispatch = useDispatch();
	const navigate = useNavigate();
	//登录操作
	const onFinish = async (value: any) => {
		let result = await apiSignIn(value);
		console.log(result);
		let userInfo = null;
		if (result.status == "failed") {
			alert(result.message);
		} else if (result.status == "success") {
			userInfo = result.data
			userInfo.token = result.token
			dispatch(signIn(userInfo));
			navigate("/admin");
		}
	};

	const onFinishFailed = (error: any): void => {
	};


	return (
		<div>
			<Form
				name="login"
				initialValues={{ remember: true }}
				onFinish={onFinish}
				onFinishFailed={onFinishFailed}
				wrapperCol={{ span: 4 }}
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

export default Login;