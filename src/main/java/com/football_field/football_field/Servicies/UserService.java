package com.football_field.football_field.Servicies;

import com.football_field.football_field.Entities.User;
import com.football_field.football_field.side_models.LoginUserModel;
import com.football_field.football_field.side_models.SignUpUserModel;

public interface UserService extends BaseService<User> {
    User createUser(User customer);

    User findByUserName(String userName);

    User login(LoginUserModel loginUserModel);

    SignUpUserModel getSignUpModel(String userName);

}
