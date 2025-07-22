package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.service.AdvisorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/advisors")
public class AdvisorController {
    private final AdvisorService advisorService;

    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @GetMapping
    public List<Advisor> getAllAdvisors() {
        return advisorService.getAllAdvisors();
    }

    @GetMapping("/{id}")
    public Optional<Advisor> getAdvisorById(@PathVariable Long id) {
        return advisorService.getAdvisorById(id);
    }

    @PostMapping
    public Advisor createAdvisor(@RequestBody Advisor advisor) {
        return advisorService.createAdvisor(advisor);
    }

    /**
     * Updates an existing advisor by ID.
     * @param id : The ID of the advisor to update.
     * @param advisor : The advisor object with updated details.
     * @return The updated advisor, or null if not found.
     */
    @PutMapping("/{id}")
    public Advisor updateAdvisor(@PathVariable Long id, @RequestBody Advisor advisor) {
        return advisorService.updateAdvisor(id, advisor);
    }

    @DeleteMapping("/{id}")
    public void deleteAdvisor(@PathVariable Long id) {
        advisorService.deleteAdvisor(id);
    }
} 