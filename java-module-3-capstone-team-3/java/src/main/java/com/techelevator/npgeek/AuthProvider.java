package com.techelevator.npgeek;

import com.techelevator.npgeek.User;

public interface AuthProvider {
    boolean isLoggedIn();
    User getCurrentUser();
    boolean signIn(String username, String password);
    void logOff();
    void register(String username, String password, String emailAddress, String passswordHint);
}
