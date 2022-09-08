package com.itsvet.komponente;

import java.math.BigDecimal;

public class GrafickaKarta extends Komponenta {
    private String tip_memorije;
    private int velicina_memorije;
    private BigDecimal radni_takt;

    public GrafickaKarta(String naziv, String proizvodjac, BigDecimal cena, String serijskiBroj, String tip_memorije, int velicina_memorije, BigDecimal radni_takt) {
        super(naziv, proizvodjac, cena, serijskiBroj);
        this.tip_memorije = tip_memorije;
        this.velicina_memorije = velicina_memorije;
        this.radni_takt = radni_takt;
    }

    public String getTip_memorije() {
        return tip_memorije;
    }

    public void setTip_memorije(String tip_memorije) {
        this.tip_memorije = tip_memorije;
    }
    public int getVelicina_memorije() {
        return velicina_memorije;
    }

    public void setVelicina_memorije(int velicina_memorije) {
        this.velicina_memorije = velicina_memorije;
    }

    public BigDecimal getRadni_takt() {
        return radni_takt;
    }

    public void setRadni_takt(BigDecimal radni_takt) {
        this.radni_takt = radni_takt;
    }

    public String toString() {
        return String.format("""
                -- GPU --
                Naziv: %s
                Proizvodjac: %s
                Cena: %.2f
                SKU: %s
                Tip memorije: %s
                Velicina memorije: %d
                Brzina (takt): %.2f GHz
                """, naziv, proizvodjac, cena,
                serijskiBroj, tip_memorije, velicina_memorije,
                radni_takt);
    }
}
