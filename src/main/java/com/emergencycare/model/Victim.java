package com.emergencycare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "victims")
public class Victim {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @NotBlank
    @Size(max = 200)
    private String location;
    
    @Size(max = 50)
    private String emergencyType;
    
    @Size(max = 50)
    private String status; // Pending Rescue, In Progress, Rescued, etc.
    
    @Size(max = 100)
    private String assignedTeam;
    
    @Size(max = 20)
    private String contactInfo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    
    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }
}