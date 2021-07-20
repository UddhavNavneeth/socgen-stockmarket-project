package com.ud.stockexchangeservice.entities;

import javax.persistence.*;

@Entity
public class CompanyCode {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", length=5)
    private Long id;

    @Column(name="code", length=5)
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id", referencedColumnName = "id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_exchange_id", referencedColumnName = "id")
    private StockExchange stockExchange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }
}
