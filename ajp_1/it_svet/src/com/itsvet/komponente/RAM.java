package com.itsvet.komponente;

import java.math.BigDecimal;

public class RAM extends Komponenta {
    private int velicina;
    private BigDecimal brzina;

    public RAM(String naziv, String proizvodjac, BigDecimal cena, String serijskiBroj, int velicina, BigDecimal brzina) {
        super(naziv, proizvodjac, cena, serijskiBroj);
        this.velicina = velicina;
        this.brzina = brzina;
    }

    public int getVelicina() {
        return velicina;
    }

    public void setVelicina(int velicina) {
        this.velicina = velicina;
    }

    public BigDecimal getBrzina() {
        return brzina;
    }

    public void setBrzina(BigDecimal brzina) {
        this.brzina = brzina;
    }

    public String toString() {
        return String.format("""
                -- RAM --
                Naziv: %s
                Proizvodjac: %s
                Cena: %.2f
                SKU: %s
                Velicina: %d
                Brzina (takt): %.2f MHz
                """, naziv, proizvodjac, cena,
                serijskiBroj, velicina, brzina);
    }
}
