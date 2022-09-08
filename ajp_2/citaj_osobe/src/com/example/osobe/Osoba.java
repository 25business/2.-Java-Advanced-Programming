package com.example.osobe;

public class Osoba {
    private int id;
    private String ime;
    private String prezime;
    private int godine;

    public Osoba(int id, String ime, String prezime, int godine) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String toString() {
        return String.format("[%d] %s %s (%d)", id, ime, prezime, godine);
    }
}
