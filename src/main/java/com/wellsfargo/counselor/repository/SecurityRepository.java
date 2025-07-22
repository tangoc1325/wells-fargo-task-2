package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Security, Long> {
    
} 