package com.Achal.Water.tracker.app.userServices;

import com.Achal.Water.tracker.app.models.User;
import com.Achal.Water.tracker.app.models.UserDetailsRequest;
import com.Achal.Water.tracker.app.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServicesImplimentation  implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User registerUser(User user) {

        User newUser=new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setId(user.getId());

        newUser.setDetailsComplete(true);

        return userRepo.save(newUser);

    }

    @Override
    public User updateUserDetails(Integer userId, UserDetailsRequest detailsRequest) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));


        user.setGender(detailsRequest.getGender());
        user.setAge(detailsRequest.getAge());
        user.setWeight(detailsRequest.getWeight());
        user.setWakeUpTime(detailsRequest.getWakeUpTime());
        user.setSleepTime(detailsRequest.getSleepTime());
        user.setDetailsComplete(true);

        return userRepo.save(user);


    }


    @Override
    public User findUserById(Integer id) throws Exception {
        Optional<User> m=userRepo.findById(id);
        if(m.isPresent()) return m.get();


        throw new Exception("user not found with id "+id);
    }

    @Override
    public void deleteUser(Integer id) {
        if (!userRepo.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }
        userRepo.deleteById(id);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new Exception("User with email " + email + " not found"));
    }





}
