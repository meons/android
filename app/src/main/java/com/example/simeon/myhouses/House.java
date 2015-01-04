package com.example.simeon.myhouses;

import java.util.List;

/**
 * Created by Simeon on 24.12.2014.
 */
public class House
{
    private int id;
    private String desc;
    private String address;
    private double surface;
    private List<Room> rooms;
    private List<Familymember> familymembers;

    public House()
    {

    }

    public House(int id, String desc, String address, double Surface)
    {
        this.id = id;
        this.desc = desc;
        this.address = address;
        this.surface = surface;
    }

    public int getId()
    {
        return id;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getAddress()
    {
        return address;
    }

    public double getSurface()
    {
        return surface;
    }

    public void addRoom(Room r)
    {
        rooms.add(r);
    }

    public void addFamilymember(Familymember fm)
    {
        familymembers.add(fm);
    }
}
