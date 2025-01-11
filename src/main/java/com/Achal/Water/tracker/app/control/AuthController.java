package com.Achal.Water.tracker.app.control;

import com.Achal.Water.tracker.app.config.JwtProvider;
import com.Achal.Water.tracker.app.models.LoginRequest;
import com.Achal.Water.tracker.app.models.User;
import com.Achal.Water.tracker.app.models.UserRequest;
import com.Achal.Water.tracker.app.repo.UserRepo;
import com.Achal.Water.tracker.app.response.AuthResponse;
import com.Achal.Water.tracker.app.userServices.CustomerUserDetailService;
import com.Achal.Water.tracker.app.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CustomerUserDetailService customerUserDetailService;


    @PostMapping(value = "/users/signup")
    public ResponseEntity<AuthResponse> createUser(@RequestBody UserRequest user) {
        try {
            String password = passwordEncoder.encode(user.getPassword());
            user.setPassword(password);

            Optional<User> isExist = userRepo.findByEmail(user.getEmail());
            if (isExist.isPresent()) {
                return new ResponseEntity<>(new AuthResponse("Email already in use", null), HttpStatus.BAD_REQUEST);
            }

            User newUser = new User();
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());

            User savedUser = userRepo.save(newUser);

            Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
            String token = JwtProvider.generateToken(authentication);

            return new ResponseEntity<>(new AuthResponse("User registered successfully", token), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new AuthResponse("An error occurred: " + e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



@PostMapping("/users/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody LoginRequest loginRequest){

        Authentication authentication;
        authentication = authentication(loginRequest.getEmail(),loginRequest.getPassword());
        String token = JwtProvider.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponse("Login successfully", token), HttpStatus.CREATED);

    }

    private Authentication authentication(String email, String password) {

        UserDetails userDetails= customerUserDetailService.loadUserByUsername(email);
        if(userDetails==null) {
            throw new BadCredentialsException("invalid user");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("invalid user name or password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

    }


}
