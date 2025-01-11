package com.Achal.Water.tracker.app.control;

import com.Achal.Water.tracker.app.models.User;
import com.Achal.Water.tracker.app.models.UserDetailsRequest;
import com.Achal.Water.tracker.app.models.UserRequest;
import com.Achal.Water.tracker.app.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PutMapping("/api/users/{userId}/add")
    public ResponseEntity<User> addDetails( @PathVariable Integer userId, @RequestBody UserDetailsRequest userDetails){
        return new ResponseEntity<>(userService.updateUserDetails(userId,userDetails),HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteAccount(@PathVariable Integer userId){
        userService.deleteUser(userId);
    }







}
