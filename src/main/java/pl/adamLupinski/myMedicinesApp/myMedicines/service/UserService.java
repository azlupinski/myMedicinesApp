package pl.adamLupinski.myMedicinesApp.myMedicines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.adamLupinski.myMedicinesApp.myMedicines.dao.UserRepository;
import pl.adamLupinski.myMedicinesApp.myMedicines.dao.UserRoleRepository;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.User;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.UserRole;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addWithDefaultRole(User user){
        UserRole defaultRole = userRoleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}
