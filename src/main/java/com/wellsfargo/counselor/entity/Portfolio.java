package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @Column(nullable = false)
    private Date creationDate;

    @OneToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client clientId;

    protected Portfolio() {

    }

    public Portfolio(long portfolioId, Date creationDate, Client clientId) {
        this.portfolioId = portfolioId;
        this.creationDate = creationDate;
        this.clientId = clientId;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }
}
