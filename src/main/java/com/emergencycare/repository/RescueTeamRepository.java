package com.emergencycare.repository;

import com.emergencycare.model.RescueTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RescueTeamRepository extends JpaRepository<RescueTeam, Long> {
    List<RescueTeam> findByStatus(String status);
    List<RescueTeam> findByExpertiseContaining(String expertise);
}