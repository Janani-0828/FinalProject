package com.emergencycare.controller;

import com.emergencycare.model.Victim;
import com.emergencycare.repository.VictimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/victims")
@CrossOrigin(origins = "http://localhost:5173")
public class VictimController {

    @Autowired
    private VictimRepository victimRepository;

    @GetMapping
    public List<Victim> getAllVictims() {
        return victimRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Victim> getVictimById(@PathVariable Long id) {
        return victimRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Victim createVictim(@Valid @RequestBody Victim victim) {
        return victimRepository.save(victim);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Victim> updateVictim(@PathVariable Long id, @Valid @RequestBody Victim victimDetails) {
        return victimRepository.findById(id)
                .map(victim -> {
                    victim.setName(victimDetails.getName());
                    victim.setLocation(victimDetails.getLocation());
                    victim.setEmergencyType(victimDetails.getEmergencyType());
                    victim.setStatus(victimDetails.getStatus());
                    victim.setAssignedTeam(victimDetails.getAssignedTeam());
                    victim.setContactInfo(victimDetails.getContactInfo());
                    return ResponseEntity.ok(victimRepository.save(victim));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVictim(@PathVariable Long id) {
        return victimRepository.findById(id)
                .map(victim -> {
                    victimRepository.delete(victim);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public List<Victim> getVictimsByStatus(@PathVariable String status) {
        return victimRepository.findByStatus(status);
    }

    @GetMapping("/team/{team}")
    public List<Victim> getVictimsByTeam(@PathVariable String team) {
        return victimRepository.findByAssignedTeam(team);
    }
}