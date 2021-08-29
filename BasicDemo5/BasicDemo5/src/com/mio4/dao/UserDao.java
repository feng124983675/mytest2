package com.mio4.dao;

import com.mio4.domain.User;
import com.mio4.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

	/**
	 *
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User getUserByUsernameAndPwd(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return 	user = qr.query(sql, new BeanHandler<>(User.class), user.getUsername(),user.getPassword());
	}

	/**
	 * 注册用户
	 * @param user 用户
	 * @return 注册是否成功
	 */
	public int addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user(username,password,email,name,sex,birthday,hobby) values(?,?,?,?,?,?,?)";
			return qr.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),
					user.getName(),user.getSex(),user.getBirthday(),
					user.getHobby());
	}
}
