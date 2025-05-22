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
@Table(name = "hospitals")
public class Hospital {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @NotBlank
    @Size(max = 200)
    private String location;
    
    @Min(0)
    private int capacity;
    
    @Min(0)
    private int available;
    
    @Size(max = 20)
    private String contact;
    
    @Size(max = 200)
    private String specialization;
    
    @Size(max = 20)
    private String status; // Available, Limited, Full
}