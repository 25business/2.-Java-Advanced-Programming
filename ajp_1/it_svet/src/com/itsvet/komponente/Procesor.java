package com.itsvet.komponente;

import java.math.BigDecimal;

public class Procesor extends Komponenta {
    private int broj_jezgara;
    private BigDecimal brzina;

    public Procesor(String naziv, String proizvodjac, BigDecimal cena, String serijskiBroj, int broj_jezgara, BigDecimal brzina) {
        super(naziv, proizvodjac, cena, serijskiBroj);
        this.broj_jezgara = broj_jezgara;
        this.brzina = brzina;
    }

    public int getBroj_jezgara() {
        return broj_jezgara;
    }

    public void setBroj_jezgara(int broj_jezgara) {
        this.broj_jezgara = broj_jezgara;
    }

    public BigDecimal getBrzina() {
        return brzina;
    }

    public void setBrzina(BigDecimal brzina) {
        this.brzina = brzina;
    }

    public String toString() {
        return String.format("""
                -- CPU --
                Naziv: %s
                Proizvodjac: %s
                Cena: %.2f
                SKU: %s
                Broj jezgara: %d
                Brzina (takt): %.2f GHz
                """, naziv, proizvodjac, cena,
                serijskiBroj, broj_jezgara, brzina);
    }
}
