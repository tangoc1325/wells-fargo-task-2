package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
} 