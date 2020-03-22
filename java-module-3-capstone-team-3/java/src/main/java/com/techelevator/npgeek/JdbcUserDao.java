package com.techelevator.npgeek;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.User;

@Component
public class JdbcUserDao implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;

	@Autowired
	public JdbcUserDao(DataSource dataSource, PasswordHasher passwordHasher) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.passwordHasher = passwordHasher;
	}

	@Override
	public User saveUser(String username, String password, String emailAddress, String passswordHint) {
		byte[] salt = passwordHasher.generateRandomSalt();
		String hashedPassword = passwordHasher.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
		int UserId = jdbcTemplate.queryForObject(
				"INSERT INTO users(username, password, salt, email, passwordhint) VALUES (?, ?, ?, ?, ?) RETURNING userid",
				int.class, username, hashedPassword, saltString, emailAddress, passswordHint);

		User newUser = new User();
		newUser.setUserId(UserId);
		newUser.setUsername(username);
		newUser.setEmailAddress(emailAddress);
		newUser.setPasswordHint(passswordHint);

		return newUser;
	}

	@Override
	public User getValidUserWithPassword(String username, String passsword) {
		String sqlSearchForUser = "SELECT * FROM users WHERE UPPER(username) = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, username.toUpperCase());
		if (results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(passsword, Base64.decode(storedSalt));
			if (storedPassword.equals(hashedPassword)) {
				return mapResultToUser(results);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		String sqlSelectAllUsers = "SELECT userid, username, email, password, passwordhint, FROM users";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUsers);

		while (results.next()) {
			User user = mapResultToUser(results);
			users.add(user);
		}

		return users;
	}

	@Override
	public User getPasswordHint(String username) {
		User aUser = new User();
		String sqlSelectPasswordHint = "SELECT passwordhint FROM users WHERE username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPasswordHint, username);

		while (results.next()) {
			aUser = mapResultToUser(results);
		}
		return aUser;
	}

	private User mapResultToUser(SqlRowSet results) {
		User user = new User();
		user.setUserId(results.getInt("userid"));
		user.setUsername(results.getString("username"));
		user.setEmailAddress(results.getString("email"));
		user.setPassword(results.getString("password"));
		user.setPasswordHint(results.getString("passwordhint"));
		return user;
	}

	@Override
	public LocalDateTime getLastLogin() {
		try {
			String sqlGetLastLogin = "SELECT lastlogin from users ORDER BY lastlogin desc LIMIT 1";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetLastLogin);
			while (results.next()) {
				return results.getTimestamp("lastlogin").toLocalDateTime();
			}
		} catch (Exception e) {
			return LocalDateTime.now();
		}
		return LocalDateTime.now();
	}
}
