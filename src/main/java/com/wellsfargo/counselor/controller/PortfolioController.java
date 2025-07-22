package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @GetMapping("/{id}")
    public Optional<Portfolio> getPortfolioById(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
    }
} 