package com.example.simeon.myhouses;

/**
 * Created by Simeon on 24.12.2014.
 */
public class Familymember
{
    private int id;
    private String firstname;
    private String lastname;
    private String nickname;
    private int idhouse;

    public Familymember()
    {

    }

    public Familymember(int id, String firstname, String lastname, String nickname, int idhouse)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.idhouse = idhouse;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getNickname()
    {
        return nickname;
    }

    public int getIdhouse()
    {
        return idhouse;
    }
}
