package com.emergencycare.repository;

import com.emergencycare.model.Victim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VictimRepository extends JpaRepository<Victim, Long> {
    List<Victim> findByStatus(String status);
    List<Victim> findByAssignedTeam(String assignedTeam);
    List<Victim> findByEmergencyType(String emergencyType);
}