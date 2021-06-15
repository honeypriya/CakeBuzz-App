package com.example.cakebuzz_cakeorderingapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String TAG = "DatabaseHelper";
    public static final String TABLE_NAME = "cakebuzzOrder";
    public static final String COL1 = "CUSTOMER_ID";
    public static final String COL2 = "CustomerName";
    public static final String COL3 = "Phoneno";
    public static final String COL4 = "Cakename";
    public static final String COL5 = "CakeDes";
    public static final String COL6= "Price";
    public static final String COL7= "msgoncake";
    public static final String COL8= "occ";
    Context context;
    public DatabaseHandler(Context context)
    {
        super(context, TABLE_NAME, null, 1);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT , "+ COL3+" TEXT , "+COL4+" TEXT ,"+COL5+" TEXT ,"+COL6+" TEXT ,"+COL7+" TEXT, "+COL8+" TEXT)";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(String.format("DROP IF TABLE EXISTS %s", TABLE_NAME));
        onCreate(db);
    }
    public boolean addCakeData(String CustomerName, String phoneno,String Cakename, String des , String price, String cakedes, String occ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, CustomerName);
        contentValues.put(COL3, phoneno);
        contentValues.put(COL4, Cakename);
        contentValues.put(COL5, des);
        contentValues.put(COL6, price);
        contentValues.put(COL7, cakedes);
        contentValues.put(COL8, occ);
        // Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


    public Cursor viewdata(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query= "Select * from "+ TABLE_NAME;
        Cursor cursor= db.rawQuery(query,null);
        return cursor;
    }

    public void deleteName(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE  " + COL4 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }
    /*SQLiteDatabase db = helper.getReadableDatabase();

String table = "table2";
String[] columns = {"column1", "column3"};
String selection = "column3 =?";
String[] selectionArgs = {"apple"};
String groupBy = null;
String having = null;
String orderBy = "column3 DESC";
String limit = "10";

Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);*/
//    public SimpleCursorAdapter popuatelistviewfromdb(){
//        SQLiteDatabase db = this.getReadableDatabase();
//            String columns[] = {DatabaseHandler.COL4};Cursor cursor = db.query(DatabaseHandler.TABLE_NAME,columns,null,null,null,null,null);
//    String[] fromfieldname= new String[]{DatabaseHandler.COL4};
//    int[] toviewid = new int[] {R.id.orderItemName};
//    SimpleCursorAdapter orderadapter= new SimpleCursorAdapter( context,
//            R.layout.orderlistsamplelist,cursor, fromfieldname, toviewid );
//    return orderadapter;
//        }
//
//    public Cursor getItemID(String name){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
//                " WHERE " + COL4 + " = '" + name + "'";
//        Cursor data = db.rawQuery(query, null);
//        return data;
//    }

    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

}
