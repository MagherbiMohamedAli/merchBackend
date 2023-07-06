package com.pfa.backendpfa.security.jwt.service;

import com.pfa.backendpfa.dao.UserDao;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.pfa.backendpfa.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByUsernameOrEmail(username,username).orElseThrow(()->new UsernameNotFoundException("User not Found "));
        return UserPrincipal.build(user);
    }
}
