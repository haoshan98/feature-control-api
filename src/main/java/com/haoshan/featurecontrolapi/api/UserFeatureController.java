package com.haoshan.featurecontrolapi.api;

import com.haoshan.featurecontrolapi.model.Feature;
import com.haoshan.featurecontrolapi.model.User;
import com.haoshan.featurecontrolapi.model.UserPermission;
import com.haoshan.featurecontrolapi.payload.FeatureResponse;
import com.haoshan.featurecontrolapi.payload.FeatureToggleRequest;
import com.haoshan.featurecontrolapi.service.FeatureService;
import com.haoshan.featurecontrolapi.service.UserPermissionService;

import com.haoshan.featurecontrolapi.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@RestController
@RequestMapping("api/v1/feature")
public class UserFeatureController {

    @Autowired
    UserService userService;
    @Autowired
    FeatureService featureService;
    @Autowired
    UserPermissionService userPermissionService;

    @GetMapping
    ResponseEntity<FeatureResponse> checkUserPermission(@Valid @NotNull @RequestParam String featureName,
                                                        @Valid @NotNull @RequestParam String email) {
        try {
            User user = userService.getUserByEmail(email);
            Feature feature = featureService.getFeatureByName(featureName);
            UserPermission userPermission =
                    userPermissionService.getUserPermissionByUserIdAndFeatureId(user.getId(), feature.getId());

            return ResponseEntity
                    .ok()
                    .body(new FeatureResponse(userPermission.isEnabled()));

        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    @PostMapping
    ResponseEntity<String> featureToggle(@Valid @NotNull @RequestBody FeatureToggleRequest featureToggleRequest) {

        try {
            User user = userService.getUserByEmail(featureToggleRequest.getEmail());
            Feature feature = featureService.getFeatureByName(featureToggleRequest.getFeatureName());
            UserPermission currentPermission = userPermissionService.getUserPermissionByUserIdAndFeatureId(user.getId(), feature.getId());
            UserPermission newPermission = new UserPermission(user.getId(), feature.getId(), featureToggleRequest.isEnable());
            if (currentPermission != null) {
                newPermission.setId(currentPermission.getId());
            }

            userPermissionService.updateOrAddUserPermission(newPermission);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
}
