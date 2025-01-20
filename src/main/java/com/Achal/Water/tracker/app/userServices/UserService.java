package com.Achal.Water.tracker.app.userServices;

import com.Achal.Water.tracker.app.models.User;
import com.Achal.Water.tracker.app.models.UserDetailsRequest;
import com.Achal.Water.tracker.app.models.UserRequest;
import com.Achal.Water.tracker.app.response.response;

public interface UserService {
     public User findUserById(Integer id) throws Exception;
    public void deleteUser(Integer id); // New method for deleting a user
      public response updateUserDetails(Integer userId, UserDetailsRequest detailsRequest);

      public User findUserByEmail(String email) throws Exception;
      public User findUserByJwt(String jwt) throws Exception;

}
