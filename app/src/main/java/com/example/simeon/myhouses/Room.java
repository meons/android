package com.example.simeon.myhouses;

import java.util.List;

/**
 * Created by sbob on 22.12.2014.
 */
public class Room
{
    private int id;
    private String desc;
    private double surface;
    private int idhouse;
    private List<Furniture> furnitures;

    public Room()
    {

    }

    public Room(int id, String desc, double surface, int idhouse)
    {
        this.id = id;
        this.desc = desc;
        this.surface = surface;
        this.idhouse = idhouse;
    }

    public int getId()
    {
        return id;
    }

    public String getDesc()
    {
        return desc;
    }

    public double getSurface()
    {
        return surface;
    }

    public int getIdhouse()
    {
        return idhouse;
    }

    public void addFurniture(Furniture f)
    {
        furnitures.add(f);
    }
}
