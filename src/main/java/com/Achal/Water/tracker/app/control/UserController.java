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


    @PutMapping("/api/users/add")
    public ResponseEntity<User> addDetails( @RequestHeader("Authorization") String jwt, @RequestBody UserDetailsRequest userDetails) throws Exception {

        Integer userId= Math.toIntExact(getUserByJwt(jwt).getId());
        return new ResponseEntity<>(userService.updateUserDetails(userId,userDetails),HttpStatus.OK);
    }

    @DeleteMapping("/api/users/delete")
    public void deleteAccount(@RequestHeader("Authorization") String jwt) throws Exception {

        Integer userId= Math.toIntExact(getUserByJwt(jwt).getId());
        userService.deleteUser(userId);
    }

@GetMapping ("/api/users/profile")
    public User getUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwt(jwt);
        user.setPassword("********");
        return user;
    }




}
