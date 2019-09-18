package com.proadvisor.service;

import com.proadvisor.model.Role;
import com.proadvisor.model.entity.common.User;
import com.proadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByLogin(username);
    }
    
    @Transactional
    public boolean addNewUser(User user) {
        if (userRepository.hasUserWithLoginOrEmail(user.getEmail(), user.getLogin())) {
            return false;
        }
        user.setActive(true);
        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
        return true;
    }
    
    public boolean hasUserWithLogin(String login) {
        return userRepository.hasUserWithLogin(login);
    }
    
    public boolean hasUserWithEmail(String email) {
        return userRepository.hasUserWithEmail(email);
    }
    
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }
}
