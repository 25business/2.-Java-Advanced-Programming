package com.itsvet.komponente;

import java.math.BigDecimal;

public class GrafickaKarta extends Komponenta {
    private String tip_memorije;
    private int virtuelna_memorija;
    private int radni_takt;

    public GrafickaKarta(String naziv, String proizvodjac, BigDecimal cena, String serijski_broj, String tip_memorije, int virtuelna_memorija, int radni_takt) {
        super(naziv, proizvodjac, cena, serijski_broj);
        this.tip_memorije = tip_memorije;
        this.virtuelna_memorija = virtuelna_memorija;
        this.radni_takt = radni_takt;
    }

    public String getTip_memorije() { return tip_memorije; }
    public void setTip_memorije(String tip_memorije) {this.tip_memorije = tip_memorije; }
    public int getVirtuelna_memorija() { return virtuelna_memorija; }
    public void setVirtuelna_memorija(int virtuelna_memorija) {this.virtuelna_memorija = virtuelna_memorija; }
    public int getRadni_takt() { return radni_takt; }
    public void setRadni_takt(int radni_takt) { this.radni_takt = radni_takt; }

    public String toString() {
        return String.format("""
                === GPU ===
                Naziv: %s
                Proizvodjac: %s
                Cena: %.2f
                Serijski broj: %s
                Tip memorije: %s
                Kapacitet virtuelne memorije: %d
                Radni takt: %d
                """, naziv, proizvodjac, cena, serijski_broj, tip_memorije, virtuelna_memorija, radni_takt);
    }
}