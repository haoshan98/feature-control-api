package com.haoshan.featurecontrolapi.service.implement;

import com.haoshan.featurecontrolapi.exception.CustomNotFoundException;
import com.haoshan.featurecontrolapi.model.UserPermission;
import com.haoshan.featurecontrolapi.repository.UserPermissionRepository;
import com.haoshan.featurecontrolapi.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    UserPermissionRepository userPermissionRepository;

    @Override
    public UserPermission getUserPermissionByUserIdAndFeatureId(int userId, int featureId) {
        return userPermissionRepository
                .getUserPermissionByUserIdAndFeatureId(userId, featureId)
                .orElseThrow(() ->
                        new CustomNotFoundException(
                                "User with id: {0} for permission {1} was not exist in the database.",
                                userId,
                                featureId)
                );
    }

    @Override
    public void updateOrAddUserPermission(UserPermission userPermission) {
        userPermissionRepository.save(userPermission);
    }

}

