package com.itsvet.komponente;

import java.math.BigDecimal;

public abstract class Komponenta {
    protected String naziv;
    protected String proizvodjac;
    protected BigDecimal cena;
    protected String serijskiBroj;

    public Komponenta(String naziv, String proizvodjac, BigDecimal cena, String serijskiBroj) {
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.cena = cena;
        this.serijskiBroj = serijskiBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(String serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }
}
