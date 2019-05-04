package pl.adamLupinski.myMedicinesApp.myMedicines.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_medicines")
public class UserMedicine implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_medicine_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;


    // additional fields

    @Column(name = "current_medicine_amount")
    private Long currentMedicineAmount;

    @Column(name = "current_medicine_week_dose")
    private Long currentMedicineWeekDose;


    public UserMedicine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Long getCurrentMedicineAmount() {
        return currentMedicineAmount;
    }

    public void setCurrentMedicineAmount(Long currentMedicineAmount) {
        this.currentMedicineAmount = currentMedicineAmount;
    }

    public Long getCurrentMedicineWeekDose() {
        return currentMedicineWeekDose;
    }

    public void setCurrentMedicineWeekDose(Long currentMedicineWeekDose) {
        this.currentMedicineWeekDose = currentMedicineWeekDose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserMedicine)) return false;

        UserMedicine that = (UserMedicine) o;

        if (!getId().equals(that.getId())) return false;
        if (!getUser().equals(that.getUser())) return false;
        if (!getMedicine().equals(that.getMedicine())) return false;
        if (getCurrentMedicineAmount() != null ? !getCurrentMedicineAmount().equals(that.getCurrentMedicineAmount()) : that.getCurrentMedicineAmount() != null)
            return false;
        return getCurrentMedicineWeekDose() != null ? getCurrentMedicineWeekDose().equals(that.getCurrentMedicineWeekDose()) : that.getCurrentMedicineWeekDose() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getMedicine().hashCode();
        result = 31 * result + (getCurrentMedicineAmount() != null ? getCurrentMedicineAmount().hashCode() : 0);
        result = 31 * result + (getCurrentMedicineWeekDose() != null ? getCurrentMedicineWeekDose().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserMedicine{" +
                "id=" + id +
                ", user=" + user +
                ", medicine=" + medicine +
                ", currentMedicineAmount=" + currentMedicineAmount +
                ", currentMedicineWeekDose=" + currentMedicineWeekDose +
                '}';
    }
}
