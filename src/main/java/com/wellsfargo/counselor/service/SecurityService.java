package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.repository.SecurityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityService {
    private final SecurityRepository securityRepository;

    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    public Optional<Security> getSecurityById(Long id) {
        return securityRepository.findById(id);
    }

    public Security createSecurity(Security security) {
        return securityRepository.save(security);
    }

    public void deleteSecurity(Long id) {
        securityRepository.deleteById(id);
    }
} 