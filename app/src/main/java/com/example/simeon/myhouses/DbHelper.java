package com.example.simeon.myhouses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simeon on 06.12.2014.
 */
public class DbHelper extends SQLiteOpenHelper
{
    // DB name
    private static final String DATABASE_NAME = "house.db";

    // DB version
    private static final int DATABASE_VERSION = 1;

    // Table names
    public static final String TABLE_HOUSE = "house";
    public static final String TABLE_FAMILYMEMBER = "familymember";
    public static final String TABLE_ROOM = "room";
    public static final String TABLE_FURNITURE = "furniture";

    // Common column names
    public static final String KEY_ID = "id";
    public static final String KEY_DESC = "desc";
    public static final String KEY_SURFACE = "surface";
    public static final String KEY_IDHOUSE = "idhouse";

    // HOUSE table column names
    public static final String KEY_ADDRESS = "address";

    // FAMILYMEMBER table column names
    public static final String KEY_FIRSTNAME = "firstname";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_NICKNAME = "nickname";

    // FURNITURE table column names
    public static final String KEY_WIDTH = "width";
    public static final String KEY_LENGTH = "length";
    public static final String KEY_IDROOM = "idroom";

    // Tables creation statements
    // FOREIGN KEYS -> http://www.sqlite.org/foreignkeys.html
    // http://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/

    // House table creation
    private static final String CREATE_TABLE_HOUSE = "CREATE TABLE "
            + TABLE_HOUSE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DESC
            + " TEXT," + KEY_ADDRESS + " TEXT," + KEY_SURFACE
            + " NUMERIC)";

    // FamilyMember table creation
    private static final String CREATE_TABLE_FAMILYMEMBER = "CREATE TABLE "
            + TABLE_FAMILYMEMBER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRSTNAME
            + " TEXT," + KEY_LASTNAME + " TEXT," + KEY_NICKNAME
            + " TEXT," + KEY_IDHOUSE + " INTEGER)";

    // Room table creation
    private static final String CREATE_TABLE_ROOM = "CREATE TABLE "
            + TABLE_ROOM + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DESC
            + " TEXT," + KEY_SURFACE + " NUMERIC," + KEY_IDHOUSE + " INTEGER)";

    // Furniture table creation
    private static final String CREATE_TABLE_FURNITURE = "CREATE TABLE "
            + TABLE_FURNITURE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DESC
            + " TEXT," + KEY_WIDTH + " NUMERIC," + KEY_LENGTH
            + " NUMERIC," + KEY_IDROOM + " INTEGER)";

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Add a house
    public void addHouse(House h)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DESC, h.getDesc());
        values.put(KEY_ADDRESS, h.getAddress());
        values.put(KEY_SURFACE, h.getSurface());

        db.insert(TABLE_HOUSE, null, values);
    }

    // Add a familymember to a house
    public void addFamilymember(Familymember fm)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, fm.getFirstname());
        values.put(KEY_LASTNAME, fm.getLastname());
        values.put(KEY_NICKNAME, fm.getNickname());
        values.put(KEY_IDHOUSE, fm.getIdhouse());

        db.insert(TABLE_FAMILYMEMBER, null, values);
    }

    // Add a room in a house
    public void addRoom(Room r)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DESC, r.getDesc());
        values.put(KEY_SURFACE, r.getSurface());
        values.put(KEY_IDHOUSE, r.getIdhouse());

        db.insert(TABLE_ROOM, null, values);
    }

    // Add a furniture in a room
    public void addFurniture(Furniture f)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DESC, f.getDesc());
        values.put(KEY_WIDTH, f.getWidth());
        values.put(KEY_LENGTH, f.getLength());
        values.put(KEY_IDROOM, f.getIdroom());

        db.insert(TABLE_FURNITURE, null, values);
    }

    // Get all houses
    public List<House> getHouses()
    {
        List<House> houses = new ArrayList<House>();
        String selectQuery = "SELECT * FROM " + TABLE_HOUSE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // Loop trough all found rows and add to the list
        c.moveToFirst();
        while(c.moveToNext())
        {
            House h = new House(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_DESC)), c.getString(c.getColumnIndex(KEY_ADDRESS)), c.getDouble(c.getColumnIndex(KEY_SURFACE)));
            houses.add(h);
        }
        return houses;

    }

    // Get all familymembers for a house

    // Get all rooms for a house
    public List<Room> getRoomsByHouse(int idhouse)
    {
        List<Room> rooms = new ArrayList<Room>();
        String selectQuery = "SELECT * FROM " + TABLE_ROOM + " WHERE " + KEY_IDHOUSE + " = " + idhouse;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // Loop trough all found rows and add to the list
        c.moveToFirst();
        while(c.moveToNext())
        {
            Room r = new Room(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_DESC)), c.getDouble(c.getColumnIndex(KEY_SURFACE)), idhouse);
            rooms.add(r);
        }
        return rooms;
    }

    // Get all furnitures for a room

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        // Creating tables
        database.execSQL(CREATE_TABLE_HOUSE);
        database.execSQL(CREATE_TABLE_FAMILYMEMBER);
        database.execSQL(CREATE_TABLE_ROOM);
        database.execSQL(CREATE_TABLE_FURNITURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // TODO Auto-generated method stub

    }
}
