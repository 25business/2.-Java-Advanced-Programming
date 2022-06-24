package com.itsvet.komponente;

import java.math.BigDecimal;

public class Procesor extends Komponenta {
    private int broj_jezgra;
    private BigDecimal takt;

    public Procesor(String naziv, String proizvodjac, BigDecimal cena, String serijski_broj, int broj_jezgra, BigDecimal takt) {
        super(naziv, proizvodjac, cena, serijski_broj);
        this.broj_jezgra = broj_jezgra;
        this.takt = takt;
    }

    public int getBroj_jezgra() { return broj_jezgra; }
    public void setBroj_jezgra(int broj_jezgra) { this.broj_jezgra = broj_jezgra; }
    public BigDecimal getTakt() { return takt; }
    public void setTakt(BigDecimal takt) { this.takt = takt; }

    public String toString() {
        return String.format("""
                === CPU ===
                Naziv: %s
                Proizvodjac: %s
                Cena: %.2f
                Serijski broj: %s
                Broj jezgra: %d
                Radni takt: %.2f GHz
                """, naziv, proizvodjac, cena, serijski_broj, broj_jezgra, takt);
    }
}
