package com.itsvet.komponente;

import java.math.BigDecimal;

public class RAM extends Komponenta {
    private int kapacitet;
    private int brzina;

    public RAM(String naziv, String proizvodjac, BigDecimal cena, String serijski_broj, int kapacitet, int brzina) {
        super(naziv, proizvodjac, cena, serijski_broj);
        this.kapacitet = kapacitet;
        this.brzina = brzina;
    }

    public int getKapacitet() { return kapacitet; }
    public void setKapacitet(int kapacitet) { this.kapacitet = kapacitet; }
    public int getBrzina() { return brzina; }
    public void setBrzina(int brzina) { this.brzina = brzina; }

    public String toString() {
        return String.format("""
                === RAM ===
                Naziv: %s
                Proizvodjac: %s
                Cena: %.2f
                Serijski broj: %s
                Kapacitet: %d
                Brzina: %d MHz
                """, naziv, proizvodjac, cena, serijski_broj, kapacitet, brzina);
    }
}