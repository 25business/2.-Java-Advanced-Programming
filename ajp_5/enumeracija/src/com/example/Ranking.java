package com.example;

public enum Ranking {
    BEGINNER(1, "Beginner"), NOVICE(10, "Novice"),
    EXPERIENCED(20, "Experienced"), MASTER(50, "Master");

    private int rank;
    private String rank_name;

    Ranking(int rank, String rank_name) {
        this.rank = rank;
        this.rank_name = rank_name;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
       return  rank_name + ": " + rank;
    }
}
