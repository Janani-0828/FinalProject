package com.emergencycare.repository;

import com.emergencycare.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    List<Volunteer> findBySkillsContaining(String skill);
    List<Volunteer> findByLocation(String location);
}