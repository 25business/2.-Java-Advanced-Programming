package com.itsvet.komponente;

import java.math.BigDecimal;

public abstract class Komponenta {
    protected String naziv;
    protected String proizvodjac;
    protected BigDecimal cena;
    protected String serijski_broj;

    public Komponenta(String naziv, String proizvodjac, BigDecimal cena, String serijski_broj) {
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.cena = cena;
        this.serijski_broj = serijski_broj;
    }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }
    public String getProizvodjac() { return proizvodjac; }
    public void setProizvodjac(String proizvodjac) { this.proizvodjac = proizvodjac; }
    public BigDecimal getCena() { return cena; }
    public void setCena(BigDecimal cena) { this.cena = cena; }
    public String getSerijski_broj() { return serijski_broj; }
    public void setSerijski_broj(String serijski_broj) { this.serijski_broj = serijski_broj; }
}