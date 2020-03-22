package com.techelevator.npgeek;

import java.time.LocalDateTime;
import java.util.List;

public interface UserDao {
	
	public User saveUser(String username, String password, String emailAddress, String passwordHint);
	
    public User getValidUserWithPassword(String username, String password);
    
    public User getPasswordHint (String username);
    
    public List<User> getAllUsers();
    
    public LocalDateTime getLastLogin();
}
