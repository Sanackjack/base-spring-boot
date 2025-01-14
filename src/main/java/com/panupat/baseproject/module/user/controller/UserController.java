package com.panupat.baseproject.module.user.controller;

import com.panupat.baseproject.module.BaseResponse;
import com.panupat.baseproject.module.user.model.UserRegisterRequest;
import com.panupat.baseproject.module.user.model.UserResponse;
import com.panupat.baseproject.module.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/v1/user/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<UserResponse> register(@RequestBody UserRegisterRequest request) {
        log.info("===== Start: user register =====");
        UserResponse response = userService.register(request);
        log.info("===== End: user register =====");
        return BaseResponse.success(response);
    }

    @GetMapping(value = "/v1/user/{id}")
    public BaseResponse<UserResponse> getUserInfo(@PathVariable Long id) {
        log.info("===== Start: get user info =====");
        UserResponse response = userService.getUserInfo(id);
        log.info("===== End: get user info =====");
        return BaseResponse.success(response);
    }
}
