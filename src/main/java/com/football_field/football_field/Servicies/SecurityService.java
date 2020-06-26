package com.football_field.football_field.Servicies;

public interface SecurityService {
    String findLoggedInUsername();

     void autoLogin(String username, String password);
}
