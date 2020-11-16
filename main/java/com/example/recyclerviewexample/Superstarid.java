package com.example.recyclerviewexample;

public class Superstarid {

   private int imageid;
   private int rank;
   private double height;
    private String name;

    public Superstarid(String name,int imageid, int rank, double height) {
        this.imageid = imageid;
        this.rank = rank;
        this.height = height;
        this.name=name;
    }
    public int getImaged() {
        return imageid;
    }

    public int getRank() {
        return rank;
    }

    public double getHeight() {
        return height;
    }
    public String getName() {
        return name;
    }
}
