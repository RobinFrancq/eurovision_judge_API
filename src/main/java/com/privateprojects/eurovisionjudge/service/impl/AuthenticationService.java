package com.privateprojects.eurovisionjudge.service.impl;

import com.privateprojects.eurovisionjudge.model.entity.User;
import com.privateprojects.eurovisionjudge.model.security.EurovisionJudgeUserDetails;
import com.privateprojects.eurovisionjudge.repository.UserRepository;
import com.privateprojects.eurovisionjudge.service.IAuthenticationService;
import com.privateprojects.eurovisionjudge.service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("authenticationService")
public class AuthenticationService implements IAuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findUserDetailsByUsername(s).orElseThrow(
                () -> new UsernameNotFoundException(String.format("Could not find user with email %s", s))
        );
    }

    private Optional<UserDetails> findUserDetailsByUsername(String username) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser != null) {
            return Optional.of(new EurovisionJudgeUserDetails(foundUser));
        } else {
            return Optional.empty();
        }
    }
}
