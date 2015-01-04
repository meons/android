package com.example.simeon.myhouses;

/**
 * Created by Simeon on 24.12.2014.
 */
public class Furniture
{
    private int id;
    private String desc;
    private double length;
    private double width;
    private int idroom;

    public Furniture()
    {

    }

    public Furniture(int id, String desc, double length, double width, int idroom)
    {
        this.id = id;
        this.desc = desc;
        this.length = length;
        this.width = width;
        this.idroom = idroom;
    }

    public int getId()
    {
        return id;
    }

    public String getDesc()
    {
        return desc;
    }

    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }

    public int getIdroom()
    {
        return idroom;
    }

}
