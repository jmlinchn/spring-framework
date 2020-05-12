package cn.linjianming.spring5.service;

/**
 * @Author: James Lin
 * @Date: 2020/05/01
 */
public class LoginServiceImpl implements ILoginService {

	private String username;
	private String password;

	@Override
	public String login() {
		System.out.println("hello");
		System.out.println("username={" + username + "}\t password={" + password + "}");
		return "Ok";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}