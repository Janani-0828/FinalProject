package com.emergencycare.repository;

import com.emergencycare.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findByStatus(String status);
    List<Hospital> findByAvailableGreaterThan(int available);
}