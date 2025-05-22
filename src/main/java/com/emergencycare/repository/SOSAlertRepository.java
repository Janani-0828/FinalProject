package com.emergencycare.repository;

import com.emergencycare.model.SOSAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SOSAlertRepository extends JpaRepository<SOSAlert, Long> {
    List<SOSAlert> findByStatus(String status);
    List<SOSAlert> findByEmergencyType(String emergencyType);
}