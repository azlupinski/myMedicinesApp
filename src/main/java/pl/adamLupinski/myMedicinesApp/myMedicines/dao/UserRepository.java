package pl.adamLupinski.myMedicinesApp.myMedicines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstById(Long id);

    User findFirstByEmail(String email);

}
