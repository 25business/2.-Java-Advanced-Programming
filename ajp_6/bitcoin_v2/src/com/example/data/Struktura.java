package com.example.data;

public class Struktura {
    private String naziv_polja;
    private String tip_polja;

    public Struktura(String naziv_polja, String tip_polja) {
        this.naziv_polja = naziv_polja;
        this.tip_polja = tip_polja;
    }

    public String getNaziv_polja() {
        return naziv_polja;
    }

    public String getTip_polja() {
        return tip_polja;
    }
}
