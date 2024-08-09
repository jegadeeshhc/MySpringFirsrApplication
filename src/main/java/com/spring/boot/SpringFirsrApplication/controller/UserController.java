package com.spring.boot.SpringFirsrApplication.controller;

import com.spring.boot.SpringFirsrApplication.dto.UserDto;
import com.spring.boot.SpringFirsrApplication.model.User;
import com.spring.boot.SpringFirsrApplication.response.CommonResponse;
import com.spring.boot.SpringFirsrApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public  CommonResponse<List<UserDto>> getAllUserDetails(){
        return userService.getAllUserDetails();
    }

    @GetMapping("/getUserByID/{id}")
    public  CommonResponse<UserDto> getuserdetailsById(@PathVariable int id){
        return userService.getuserdetailsById(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public CommonResponse<UserDto> getUserDetailsByEmailId(@PathVariable String email){
        return userService.getUserDetailsByEmailId(email);
    }

    @PostMapping("/createUser")
    public  CommonResponse<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/updateUserById/{id}")
    public  CommonResponse<UserDto> upadteUserDetailsById(@PathVariable int id,@RequestBody User user){
         return userService.upadteUserDetailsById(id,user);
    }

    @PutMapping("/updateUserByEmail/{email}")
    public CommonResponse<UserDto> updateUserDetailsByEmail(@RequestBody User user,@PathVariable String email){
        return userService.updateUserDetailsByEmail(user,email);
    }
    @DeleteMapping("/deleteUserById/{id}")
    public CommonResponse delateUser(@PathVariable int id){
        return userService.delateUser(id);
    }

    @DeleteMapping("/deleteUserByEmail/{email}")
    public CommonResponse deleteUserByEmail(@PathVariable String email){
        return userService.deleteUserByEmail(email);
    }

}



