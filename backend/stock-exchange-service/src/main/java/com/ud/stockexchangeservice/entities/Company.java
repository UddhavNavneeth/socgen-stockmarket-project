package com.ud.stockexchangeservice.entities;

import javax.persistence.*;

@Entity
@Table(name="companies")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", length=5)
    private Long id;

    @Column(name="name", length=50)
    private String name;

    @Column(name="turnover", length=10)
    private Long turnover;

    @Column(name="ceo", length=20)
    private String ceo;

    @Column(name="brief", length=100)
    private String brief;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sector_id")
    private Sector sector;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTurnover() {
        return turnover;
    }

    public void setTurnover(Long turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
