package com.haoshan.featurecontrolapi.repository;

import com.haoshan.featurecontrolapi.model.UserPermission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPermissionRepository extends CrudRepository<UserPermission, Integer> {

    @Query(value = "SELECT * FROM user_permission " +
                   "WHERE user_id = :user_id AND feature_id = :feature_id ", nativeQuery = true)
    Optional<UserPermission> getUserPermissionByUserIdAndFeatureId(
            @Param("user_id") int userId,
            @Param("feature_id") int featureId
    );
}
