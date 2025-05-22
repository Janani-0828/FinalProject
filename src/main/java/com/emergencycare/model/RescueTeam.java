package com.emergencycare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rescue_teams")
public class RescueTeam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @Min(1)
    private int teamSize;
    
    @Size(max = 200)
    private String expertise;
    
    @Size(max = 20)
    private String status; // Available, Deployed, Unavailable, On Standby
    
    @Size(max = 20)
    private String contactInfo;
}