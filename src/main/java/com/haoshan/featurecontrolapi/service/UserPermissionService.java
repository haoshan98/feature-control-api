package com.haoshan.featurecontrolapi.service;

import com.haoshan.featurecontrolapi.model.UserPermission;

import javax.transaction.Transactional;

public interface UserPermissionService {

    UserPermission getUserPermissionByUserIdAndFeatureId(int userId, int featureId);

    void updateOrAddUserPermission(UserPermission userPermission);

}

