package pl.adamLupinski.myMedicinesApp.myMedicines.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Medicine findFirstById(Long id);

    Medicine findFirstByMedicineName(String name);
}
