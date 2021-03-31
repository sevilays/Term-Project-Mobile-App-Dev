package com.example.healthyus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "HealthyUs.db";
    final static int DATABASE_VERSION = 2;
    final static String TABLE1_NAME = "Users";
    final static String TABLE2_NAME = "Doctor";
    final static String TABLE3_NAME ="Consumed_Food";
    final static String TABLE4_NAME ="Appointment";
    final static String TABLE5_NAME= "Complaints";

    //Table -1 Users
    final static String T1COL_1 = "User_Id";
    final static String T1Col_2 = "Full_Name";
    final static String T1Col_3 = "Disease";
    final static String T1Col_4 = "Medication";
    final static String T1Col_5 = "Email";
    final static String T1Col_6 = "Password";
    final static String T1Col_7 = "Postal_Code";

    //Table - 2 Doctors
    /*final static String T2COL_1 = "Doctor_Id";
    final static String T2Col_2 = "Doctor_Name";
    final static String T2col_3 = "Postal_Code";
    final static String T2Col_4 = "Email";
    final static String T2Col_5 = "Availability";
    final static String T2Col_6 = "Timings";*/

    //Table - 3 Consumed Food
    final static String T3COL_1 = "Consumed_Food_Id";
    final static String T3Col_2 = "Food_Item";
    final static String T3Col_3 = "Calories";
    final static String T3Col_4 = "User_Email";
    final static String T3Col_5 = "Date";

    //Table - 4 Appointment
    final static String T4COL_1 = "Appointment_Id";
    final static String T4Col_2 = "User_Name";
    final static String T4Col_3 = "Email";
    final static String T4Col_4 = "Date_Time";
    final static String T4Col_5 = "Doctor_Name";


    //Table - 5 Complaints
    final static String T5COL_1 = "Complaints_Id";
    final static String T5Col_2 = "User_Email";
    final static String T5Col_3 = "Doctor_Name";
    final static String T5Col_4 = "Complaints";



    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    //Table creation queries
    @Override
    public void onCreate(SQLiteDatabase db) {
    //Table -1 creation
    String query = "CREATE TABLE " + TABLE1_NAME + " (" + T1COL_1 + " INTEGER PRIMARY KEY," + T1Col_2 + " TEXT," + T1Col_3 + " TEXT," + T1Col_4 + " TEXT,"
            + T1Col_5 + " TEXT," + T1Col_6 + " TEXT,"+ T1Col_7 + " TEXT)";
    db.execSQL(query);

    //Table -2 Creation
       /* String dQuery = "CREATE TABLE " + TABLE2_NAME + " (" + T2COL_1 + " INTEGER PRIMARY KEY," + T2Col_2 +  " TEXT," + T2col_3 + " TEXT," + T2Col_4 + " TEXT,"
                + T2Col_5 + " TEXT," + T2Col_6 + " TEXT)";
        db.execSQL(dQuery);
*/
    //Table-3 Creation
    String fQuery = "CREATE TABLE " + TABLE3_NAME + " (" + T3COL_1 + " INTEGER PRIMARY KEY," + T3Col_2 + " TEXT," + T3Col_3 + " TEXT," + T3Col_4 + " TEXT,"
        + T3Col_5 + " TEXT)";
    db.execSQL(fQuery);

    //Table - 4 Creation
    String aQuery = "CREATE TABLE " + TABLE4_NAME + " (" + T4COL_1 + " INTEGER PRIMARY KEY," + T4Col_2 + " TEXT," + T4Col_3 + " TEXT," + T4Col_4 + " TEXT,"
    + T4Col_5 + " TEXT)";
    db.execSQL(aQuery);

    //Table - 5 Creation
    String cQuery = " CREATE TABLE " + TABLE5_NAME + " (" + T5COL_1 + " INTEGER PRIMARY KEY," + T5Col_2 + " TEXT," + T5Col_3 + " TEXT," + T5Col_4 + " TEXT)";
    db.execSQL(cQuery);

    }

    //Upgrading query
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists "+ TABLE1_NAME);
       db.execSQL("DROP table if exists "+ TABLE2_NAME);
        db.execSQL("DROP table if exists "+ TABLE3_NAME);
        db.execSQL("DROP table if exists "+ TABLE4_NAME);
        db.execSQL("DROP table if exists "+ TABLE5_NAME);
        onCreate(db);
    }

    //Signup method to save user entry into database
    public boolean signUp(String fN, String dis, String med, String eId, String pass, String pCode){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1Col_2, fN);
        values.put(T1Col_3, dis);
        values.put(T1Col_4, med);
        values.put(T1Col_5, eId);
        values.put(T1Col_6, pass);
        values.put(T1Col_7, pCode);

        long r = sqLiteDatabase.insert(TABLE1_NAME,null,values);
        if(r>0)
            return true;
        else
            return false;
    }

    //Caloriecount method to save the user entries into consumed food table
    public boolean caloriecount(String fI,String cal, String uEmail, String tDate){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T3Col_2, fI);
        values.put(T3Col_3, cal);
        values.put(T3Col_4, uEmail);
        values.put(T3Col_5, tDate);

        long r = sqLiteDatabase.insert(TABLE3_NAME,null,values);
        if(r>0)
            return true;
        else
            return false;
    }

    //Saving user entries into Appointments table
    public boolean bookAppointment(String uN, String eM, String dTime, String dName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T4Col_2, uN);
        values.put(T4Col_3, eM);
        values.put(T4Col_4, dTime);
        values.put(T4Col_5, dName);


        long r = sqLiteDatabase.insert(TABLE4_NAME, null,values);
        if(r>0)
            return true;
        else
            return false;
    }

    //saving the user information on online help to keep track of appointments
    public boolean onlineHelp ( String uE, String dN, String com){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T5Col_2, uE);
        values.put(T5Col_3, dN);
        values.put(T5Col_4, com);


        long r = sqLiteDatabase.insert(TABLE5_NAME,null,values);
        if(r>0)
            return true;
        else
            return false;
    }
    /*public boolean doctorSignUp (String dN, String pCode, String email, String aV,String time){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T2Col_2,dN);
        values.put(T2col_3, pCode);
        values.put(T2Col_4,email);
        values.put(T2Col_5, aV);
        values.put(T2Col_6, time);

        long r = sqLiteDatabase.insert(TABLE2_NAME,null,values);
        if(r>0)
            return true;
        else
            return false;
    }*/

    //Method to check whether entered email is already exists or not in the databse
    public boolean signUpDupeCheck(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Users WHERE Email = \"" + email.trim() + "\"", null);
        boolean result;
        if(c.getCount() == 0) {
            result = false;
        } else{
            result = true;
        }
        return result;
    }

    /*public boolean doctorSignUpDupeCheck(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Doctor WHERE Email = \"" + email.trim() + "\"", null);
        boolean result;
        if(c.getCount() == 0) {
            result = false;
        } else{
            result = true;
        }
        return result;
    }*/

}
