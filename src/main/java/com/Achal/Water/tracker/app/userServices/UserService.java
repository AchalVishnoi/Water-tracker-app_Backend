package com.Achal.Water.tracker.app.userServices;

import com.Achal.Water.tracker.app.models.User;
import com.Achal.Water.tracker.app.models.UserDetailsRequest;

public interface UserService {
    public User registerUser(User user);
    public User findUserById(Integer id) throws Exception;
    public void deleteUser(Integer id); // New method for deleting a user
      public User updateUserDetails(Integer userId, UserDetailsRequest detailsRequest);

      public User findUserByEmail(String email) throws Exception;

}
