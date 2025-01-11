package com.Achal.Water.tracker.app.userServices;

import com.Achal.Water.tracker.app.models.User;
import com.Achal.Water.tracker.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerUserDetailService implements UserDetailsService {


    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user=userRepo.findByEmail(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("user name not found with email"+username);
        }

        List<GrantedAuthority>authorities=new ArrayList<>();



        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),user.get().getPassword(),authorities);
    }
}
