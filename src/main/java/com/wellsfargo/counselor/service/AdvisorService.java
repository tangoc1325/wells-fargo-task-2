package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvisorService {
    private final AdvisorRepository advisorRepository;

    public AdvisorService(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    public Optional<Advisor> getAdvisorById(Long id) {
        return advisorRepository.findById(id);
    }

    public Advisor createAdvisor(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    public void deleteAdvisor(Long id) {
        advisorRepository.deleteById(id);
    }

    /**
     * Updates an existing advisor's details.
     * @param id The ID of the advisor to update.
     * @param updatedAdvisor The advisor object containing updated details.
     * @return The updated advisor, or null if not found.
     */
    public Advisor updateAdvisor(Long id, Advisor updatedAdvisor) {
        return advisorRepository.findById(id).map(advisor -> {
            advisor.setFirstName(updatedAdvisor.getFirstName());
            advisor.setLastName(updatedAdvisor.getLastName());
            advisor.setAddress(updatedAdvisor.getAddress());
            advisor.setPhone(updatedAdvisor.getPhone());
            advisor.setEmail(updatedAdvisor.getEmail());
            return advisorRepository.save(advisor);
        }).orElse(null);
    }
} 