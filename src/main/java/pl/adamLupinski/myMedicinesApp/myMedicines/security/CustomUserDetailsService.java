package pl.adamLupinski.myMedicinesApp.myMedicines.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.adamLupinski.myMedicinesApp.myMedicines.dao.UserRepository;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.User;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.UserRole;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//    username  = our email

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        convertAuthorities(user.getRoles()));
        return userDetails;
    }

    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserRole userRole : userRoles){
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return authorities;
    }
}
