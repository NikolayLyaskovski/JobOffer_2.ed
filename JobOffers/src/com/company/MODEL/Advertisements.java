package com.company.MODEL;

public class Advertisements {

    public String firm;
    public String position;
    public String type;
    public String description;
    public int numberCandidates = 0;


    public Advertisements(String firm, String position, String type, String description, int numberCandidates) {
        this.firm = firm;
        this.position = position;
        this.type = type;
        this.description = description;
        this.numberCandidates = numberCandidates;
    }
}
