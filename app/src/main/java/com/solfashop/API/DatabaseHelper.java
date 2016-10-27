package com.solfashop.API;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.solfashop.model.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 10/25/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CART = "cart";

    // Contacts Table Columns names
    private static final String KEY_ID="id";
    private static final String KEY_IDPRODUK = "id_produk";
    private static final String KEY_JUMLAH = "jumlah";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CART + "("+KEY_ID +"INTEGER,"
                + KEY_IDPRODUK + " TEXT," + KEY_JUMLAH + " INTEGER," + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IDPRODUK, cart.getId_produk()); // Contact Name
        values.put(KEY_JUMLAH, cart.getJumlah()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_CART, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Cart getCart(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CART, new String[] { KEY_ID,
                        KEY_IDPRODUK, KEY_JUMLAH }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Cart cart = new Cart(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        // return contact
        return cart;
    }

    // Getting All Contacts
    public List<Cart> getAllCart() {
        List<Cart> cartList = new ArrayList<Cart>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CART;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Cart cart = new Cart(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)));
                cart.setId(Integer.parseInt(cursor.getString(0)));
                cart.setId_produk(cursor.getString(1));
                cart.setJumlah(Integer.parseInt(cursor.getString(2)));
                // Adding contact to list
                cartList.add(cart);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cartList;
    }

    // Updating single contact
    public int updateCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName());
        values.put(KEY_JUMLAH, cart.getJumlah());

        // updating row
        return db.update(TABLE_CART, values, KEY_ID + " = ?",
                new String[] { String.valueOf(cart.getId()) });
    }

    // Deleting single contact
    public void deleteCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, KEY_ID + " = ?",
                new String[] { String.valueOf(cart.getId()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CART;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}