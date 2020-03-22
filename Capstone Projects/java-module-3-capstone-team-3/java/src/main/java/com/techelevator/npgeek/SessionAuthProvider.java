package com.techelevator.npgeek;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.User;
import com.techelevator.npgeek.UserDao;

	@Component
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public class SessionAuthProvider implements AuthProvider {
	
	public static final String USER_KEY = "appCurrentUser";
	
	private HttpSession session;
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	public SessionAuthProvider(HttpSession session, UserDao dao) {
	    this.session = session;
	    this.dao = dao;
	}
	
	@Override
	public boolean isLoggedIn() {
	    return session.getAttribute(USER_KEY) != null;
	}
	
	@Override
	public User getCurrentUser() {
	    return (User) session.getAttribute(USER_KEY);
	}
	
	@Override
	public boolean signIn(String username, String password) {
	    User authenticatedUser = dao.getValidUserWithPassword(username, password);
	    if (authenticatedUser != null) {
	        session.setAttribute(USER_KEY, authenticatedUser);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	@Override
	public void logOff() {
	    session.removeAttribute(USER_KEY);
	    session.invalidate();
	}
	
	@Override
	public void register(String username, String password, String emailAddress, String passwordHint) {
		dao.saveUser(username, password, emailAddress, passwordHint);
		
	}

}
