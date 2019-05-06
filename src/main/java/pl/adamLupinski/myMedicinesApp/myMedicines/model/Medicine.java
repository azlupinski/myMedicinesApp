package pl.adamLupinski.myMedicinesApp.myMedicines.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "medicines")
public class Medicine implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medicine_id", nullable = false)
    private Long id;

    @Column(name = "medicine_name", nullable = false)
    private String medicineName;

    @Column(name = "medicine_info", nullable = false)
    private String medicineInfo;

    @Column(name = "on_prescription", nullable = false)
    private boolean onPresc;

    @OneToMany(mappedBy = "medicine")
    private Set<UserMedicine> userMedicines;

    public Medicine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineInfo() {
        return medicineInfo;
    }

    public void setMedicineInfo(String medicineInfo) {
        this.medicineInfo = medicineInfo;
    }

    public boolean isOnPresc() {
        return onPresc;
    }

    public void setOnPresc(boolean onPresc) {
        this.onPresc = onPresc;
    }

    public Set<UserMedicine> getUserMedicines() {
        return userMedicines;
    }

    public void setUserMedicines(Set<UserMedicine> userMedicines) {
        this.userMedicines = userMedicines;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;

        Medicine medicine = (Medicine) o;

        if (isOnPresc() != medicine.isOnPresc()) return false;
        if (!getId().equals(medicine.getId())) return false;
        if (!getMedicineName().equals(medicine.getMedicineName())) return false;
        if (!getMedicineInfo().equals(medicine.getMedicineInfo())) return false;
        return getUserMedicines() != null ? getUserMedicines().equals(medicine.getUserMedicines()) : medicine.getUserMedicines() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getMedicineName().hashCode();
        result = 31 * result + getMedicineInfo().hashCode();
        result = 31 * result + (isOnPresc() ? 1 : 0);
        result = 31 * result + (getUserMedicines() != null ? getUserMedicines().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                ", medicineInfo='" + medicineInfo + '\'' +
                ", onPresc=" + onPresc +
                ", userMedicines=" + userMedicines +
                '}';
    }
}
