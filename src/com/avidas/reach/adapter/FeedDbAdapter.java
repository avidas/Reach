package com.avidas.reach.adapter;

import com.avidas.reach.TopRatedFragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FeedDbAdapter {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_TYPE = "type";
	public static final String KEY_DESC = "desc";
	
	private static final String TAG = "FeedDbAdapter";
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;
	
	private static final String DATABASE_NAME = "Reach";
	private static final String SQLITE_TABLE = "Feed";
	private static final int DATABASE_VERSION = 1;
	
	private final Context mCtx;
	
	private static final String DATABASE_CREATE = 
			"CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
	KEY_ROWID + " integer PRIMARY KEY autoincrement," +
					KEY_TYPE + "," + 
					KEY_DESC + ");";
	
	 private static class DatabaseHelper extends SQLiteOpenHelper {
		 
		  DatabaseHelper(Context context) {
		   super(context, DATABASE_NAME, null, DATABASE_VERSION);
		  }
		 
		  @Override
		  public void onCreate(SQLiteDatabase db) {
		   Log.w(TAG, DATABASE_CREATE);
		   db.execSQL(DATABASE_CREATE);
		  }
		 
		  @Override
		  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		   Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
		     + newVersion + ", which will destroy all old data");
		   db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
		   onCreate(db);
		  }
		 }
	 
	 public FeedDbAdapter(Context topRatedFragment) {
		 this.mCtx = topRatedFragment;
	 }
//	 public FeedDbAdapter(TopRatedFragment topRatedFragment) {
		// TODO Auto-generated constructor stub
		// return new FeedDbAdapter(this);
	//}
	public FeedDbAdapter open() throws SQLException {
		  mDbHelper = new DatabaseHelper(mCtx);
		  mDb = mDbHelper.getWritableDatabase();
		  return this;
		 }
		 
		 public void close() {
		  if (mDbHelper != null) {
		   mDbHelper.close();
		  }
		 }
		 public long createFeed(String type, String desc) {
				 
				  ContentValues initialValues = new ContentValues();
				  initialValues.put(KEY_TYPE, type);
				  initialValues.put(KEY_DESC, desc);
				 
				  return mDb.insert(SQLITE_TABLE, null, initialValues);
				  
				 }	 
		 public boolean deleteAllCountries() {
			 
			  int doneDelete = 0;
			  doneDelete = mDb.delete(SQLITE_TABLE, null , null);
			  Log.w(TAG, Integer.toString(doneDelete));
			  return doneDelete > 0;
			 
			 }		 
		 public Cursor fetchAllCountries() {
			 
			  Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
			    KEY_TYPE, KEY_DESC}, 
			    null, null, null, null, null);
			 
			  if (mCursor != null) {
			   mCursor.moveToFirst();
			  }
			  return mCursor;
			 } 
		 public void insertSomeFeeds() {
			 
			  createFeed("ALERT","72 mothers at stage childbirth in Bangladesh have not responded to level 3 messages.");
			  createFeed("ALERT","39 mothers at stage childbirth in Bolivia have not responded to level 4 messages.");
			  createFeed("INFO","MaryAnn sent new information about vaccine IBP1 for Malaria to South Africa.");
			  createFeed("SUCCESS","40 mothers with one year old child signed up for messages.");
			  createFeed("INFO","Jamie created new workflow for expecting mothers in India. View/Edit");

			 
			 }

}
