package com.haoshan.featurecontrolapi.service;

import com.haoshan.featurecontrolapi.model.User;

public interface UserService{

    User getUserByEmail(String email);

}
