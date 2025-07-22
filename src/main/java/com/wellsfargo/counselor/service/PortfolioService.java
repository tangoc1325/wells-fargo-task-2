package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> getPortfolioById(Long id) {
        return portfolioRepository.findById(id);
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }
} 