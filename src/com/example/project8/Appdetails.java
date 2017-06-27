package com.example.project8;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;	 
import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
	 
public class Appdetails  extends Activity {
	 
	    private ListView list_lv;
	    private DB db;
	 
	    private ArrayList<String> collist_1;
	    private ArrayList<String> collist_2;
	    private ArrayList<String> collist_3;
	    private ArrayList<String> collist_4;
	    private ArrayList<String> collist_5;
	    private ArrayList<String> collist_6;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_appdetails);
	        collist_1 = new ArrayList<String>();
	        collist_2 = new ArrayList<String>();
	        collist_3 = new ArrayList<String>();
	        collist_4 = new ArrayList<String>();
	        collist_5 = new ArrayList<String>();
	        collist_6 = new ArrayList<String>();
	        
	    }
	 
	    
	 
	 
	    public void getData() {
	        
	 
	        db = new DB(this);
	        try {
	            db.open();
	            Cursor cur = db.getAllTitles();
	            while (cur.moveToNext()) {
	                String valueofcol1 = cur.getString(1);
	                String valueofcol2 = cur.getString(2);
	                String valueofcol3 = cur.getString(3);
	                String valueofcol4 = cur.getString(4);
	                String valueofcol5 = cur.getString(5);
	                String valueofcol6 = cur.getString(6);
//	              Log.e("---****---", "***********   col 1 = " + valueofcol1);
//	              Log.e("---****---", "***********   col 2 = " + valueofcol2);
	 
	                collist_1.add(valueofcol1);
	                collist_2.add(valueofcol2);
	                collist_3.add(valueofcol3);
	                collist_4.add(valueofcol4);
	                collist_5.add(valueofcol5);
	                collist_6.add(valueofcol6);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            db.close();
	        }
	        printList();
	        setDataIntoList();
	    }
	 
	    private void printList() {
	        for (int i = 0; i < collist_1.size(); i++) {
	            Log.e("***************",
	                    collist_1.get(i) + " " + collist_2.get(i)+" " + collist_3.get(i)+
	                    " " + collist_3.get(i) +" " + collist_5.get(i)+" " + collist_6.get(i));
	        }
	    }
	 
	    private void setDataIntoList() {
	 
	        // create the list item mapping
	        String[] from = new String[] { "col_1", "col_2" , "col_3" , "col_4", "col_5", "col_6"};
	        int[] to = new int[] { R.id.editText1, R.id.editText2, R.id.editText3, R.id.editText4, R.id.editText5, R.id.editText6 };
	 
	        // prepare the list of all records
	        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
	        for (int i = 0; i < collist_1.size(); i++) {
	            HashMap<String, String> map = new HashMap<String, String>();
	            map.put("col_1", collist_1.get(i));
	            map.put("col_2", collist_2.get(i));
	            map.put("col_3", collist_3.get(i));
	            map.put("col_4", collist_4.get(i));
	            map.put("col_5", collist_5.get(i));
	            map.put("col_6", collist_6.get(i));
	            fillMaps.add(map);
	        }
	 
	        // fill in the grid_item layout
	        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps,
	                R.layout.custom, from, to);
	        list_lv.setAdapter(adapter);
	    }
	}



