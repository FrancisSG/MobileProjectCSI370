package com.csi370.mobileprojectcsi370;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLDatabase extends SQLiteOpenHelper
{
    /**
     * 1- Database Name (FINAL STATIC)
     * @param context
     */
    private final static String DATABASE_NAME = "PcPro";

    /**
     * 2- Database Version (FINAL STATIC)
     * @param context
     */
    private final static int DATABASE_VERSION = 1;

    /**
     * 3- Table name (FINAL STATIC)
     * @param context
     */
    private final static String TABLE_NAME = "TABLE_USERS";
    private final static String TABLE_NAME2 = "TABLE_CHECKOUT";

    /**
     * 4- Columns (FINAL STATIC) (Column names)
     * @param context
     */
    private final static String COL_ID = "USER_ID";
    private final static String COL_EMAIL = "USER_ADDRESS";
    private final static String COL_PASSWORD = "USER_PASSWORD";
    private final static String COL_ADDRESS = "USER_ADDRESS";
    private final static String COL_NUMBER = "USER_NUMBER";
    private final static String COL_PRODUCTNAME = "PRODUCT_NAME";
    private final static String COL_PRODUCTPRICE = "PRODUCT_PRICE";
    private final static String COL_PURCHASEID = "PURCHASE_ID";



    /**
     * 5- We need to create the table now
     * @param context
     */
    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY, "
            + COL_EMAIL + "TEXT"
            + COL_PASSWORD + "TEXT"
            + COL_ADDRESS + "TEXT"
            + COL_NUMBER + "INTEGER)";

    private static final String CREATE_TABLE_PRODUCTS = "CREATE TABLE "
            + TABLE_NAME2 + "("
            + COL_ID + " INTEGER PRIMARY KEY, "
            + COL_PRODUCTNAME + "TEXT"
            + COL_PRODUCTPRICE + "INTEGER)";


    public SQLDatabase(Context context)
    {
        super (context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        /**
         * 6- On create i need to execute my table
         */
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
        sqLiteDatabase.execSQL(CREATE_TABLE_PRODUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        sqLiteDatabase.execSQL((" DROP TABLE IF EXISTS " + TABLE_NAME));

        /**
         * OR
         */
        //onCreate(sqLiteDatabase);

        /**
         * OR
         */
        //sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
    }

     //Always the parameter needs to be my module that i created (called:: Users)
    public long insertUser (AppUser user)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID, user.getId());
        values.put(COL_EMAIL, user.getEmail());
        values.put(COL_PASSWORD, user.getPassword());
        values.put(COL_ADDRESS, user.getAddress());
        values.put(COL_NUMBER, user.getPhone());

        // Now we can insert the row
        long insertRow = database.insert(TABLE_NAME, null, values);
        return insertRow;
    }

    public long insertProducts (Purchase cart)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID, cart.getUserId());
        values.put(COL_PRODUCTNAME, cart.getProductName());
        values.put(COL_PRODUCTPRICE, cart.getPrice());

        long insertRow = database.insert(TABLE_NAME, null, values);
        return insertRow;
    }
}
