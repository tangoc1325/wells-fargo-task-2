package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    // custom query methods here if needed
} 