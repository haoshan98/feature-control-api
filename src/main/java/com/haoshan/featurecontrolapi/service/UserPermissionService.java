package com.haoshan.featurecontrolapi.service;

import com.haoshan.featurecontrolapi.model.UserPermission;

public interface UserPermissionService {

    UserPermission getUserPermissionByUserIdAndFeatureId(int userId, int featureId);

    void updateOrAddUserPermission(UserPermission userPermission);

}

