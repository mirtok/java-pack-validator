package com.pack.controller;

import com.pack.entity.LoginForm;
import com.pack.message.ReturnObject;
import com.pack.message.ReturnUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(tags = "用户管理相关接口")
@RestController
@RequestMapping("testController")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四", required = true),
        @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123446", required = true)
    })
    @GetMapping("testValidator")
    public ReturnObject testValidator(@Valid LoginForm loginForm){
        Map<String,String> map = new HashMap<>();
        map.put("token",UUID.randomUUID().toString().replace("-",""));
        return ReturnUtils.successResult(map);
    }
}
