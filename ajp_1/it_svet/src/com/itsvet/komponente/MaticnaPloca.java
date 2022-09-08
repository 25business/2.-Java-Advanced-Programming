package com.itsvet.komponente;

import java.math.BigDecimal;

public class MaticnaPloca extends Komponenta {
    private String dimenzije;
    private String chipset;
    private String procesor;

    public MaticnaPloca(String naziv, String proizvodjac, BigDecimal cena, String serijskiBroj, String dimenzije, String chipset, String procesor) {
        super(naziv, proizvodjac, cena, serijskiBroj);
        this.dimenzije = dimenzije;
        this.chipset = chipset;
        this.procesor = procesor;
    }

    public String getDimenzije() {
        return dimenzije;
    }

    public void setDimenzije(String dimenzije) {
        this.dimenzije = dimenzije;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String toString() {
        return String.format("""
                -- MOTHERBOARD --
                Naziv: %s
                Proizvodjac: %s
                Cena: %.2f
                SKU: %s
                Dimenzije: %s
                Chipset: %s
                Procesor: %s
                """, naziv, proizvodjac, cena,
                serijskiBroj, dimenzije, chipset, procesor);
    }
}
