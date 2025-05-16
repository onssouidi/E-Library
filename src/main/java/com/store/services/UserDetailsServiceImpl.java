package com.store.services;

import com.store.models.UserModel;
import com.store.repository.UsersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailsServiceImpl {

    @Bean
    public UserDetailsService userDetailsService(UsersRepository usersRepository) {
        return username -> {
            UserModel user = usersRepository.findByLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            return User.builder()
                    .username(user.getLogin())
                    .password(user.getPassword()) // already encoded in registerUser
                    .roles("USER") // add real roles later if needed
                    .build();
        };
    }
}
