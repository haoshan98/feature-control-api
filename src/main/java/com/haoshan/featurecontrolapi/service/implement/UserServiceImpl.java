package com.haoshan.featurecontrolapi.service.implement;


import com.haoshan.featurecontrolapi.exception.CustomNotFoundException;
import com.haoshan.featurecontrolapi.model.User;
import com.haoshan.featurecontrolapi.repository.UserRepository;
import com.haoshan.featurecontrolapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository
                .selectUserByEmail(email)
                .orElseThrow(() ->
                    new CustomNotFoundException("User with email: {0} was not exist in the database.", email)
                );
    }

}
