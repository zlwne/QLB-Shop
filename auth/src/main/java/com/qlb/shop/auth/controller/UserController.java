package com.qlb.shop.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.qlb.shop.auth.model.User;
import com.qlb.shop.auth.model.vo.ResultVO;
import com.qlb.shop.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: wzl
 * @CreateDate: 2019/9/29$ 10:25$
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    public ResultVO login(){
        return ResultVO.ok();
    }

    @PostMapping("/register")
    public User userRegister(@RequestBody @NotNull JSONObject param) {
        return userService.insertUser(param.getString("username"), param.getString("password"));
    }

    @GetMapping("/listAll")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> test() {
        List<User> list = userService.list(new User());
        return list;
    }
}
