package com.emergencycare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "volunteers")
public class Volunteer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @NotBlank
    @Email
    @Size(max = 100)
    private String email;
    
    @Size(max = 20)
    private String phone;
    
    @Size(max = 500)
    private String skills;
    
    @Size(max = 50)
    private String experience;
    
    @Size(max = 100)
    private String availability;
    
    @Size(max = 100)
    private String location;
    
    @Size(max = 100)
    private String emergencyContact;
    
    @Size(max = 500)
    private String additionalInfo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;
    
    @PrePersist
    protected void onCreate() {
        registeredAt = new Date();
    }
}