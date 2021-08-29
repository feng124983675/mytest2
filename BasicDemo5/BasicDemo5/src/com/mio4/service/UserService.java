package com.mio4.service;

import com.mio4.dao.UserDao;
import com.mio4.domain.User;

import java.sql.SQLException;

public class UserService {

	/**
	 *
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(User user) throws SQLException{
		//调用dao
		UserDao dao = new UserDao();
		return dao.getUserByUsernameAndPwd(user);
	}

	public  int register(User user) throws SQLException {
		UserDao dao = new UserDao();
		return dao.addUser(user);
	}
}
