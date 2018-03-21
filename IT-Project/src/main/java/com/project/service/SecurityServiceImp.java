package com.project.service;

public interface SecurityServiceImp {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
