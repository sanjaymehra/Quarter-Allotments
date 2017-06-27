package com.example.project8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.database.Cursor;
import android.database.SQLException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
 
public class First1 extends Activity {
	private GestureDetector gestureDetector;
    private EditText et1,et2,et3,et4,et5,et6;
    private Button sub_btn;
    private Button ref_btn;
    private DB db;
 
    private ArrayList<String> collist_1;
    private ArrayList<String> collist_2;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first1);
        collist_1 = new ArrayList<String>();
        collist_2 = new ArrayList<String>();
        gestureDetector = new GestureDetector(new SwipeGestureDetector());
        items();
        
    }
 
    private void items() {
        sub_btn = (Button) findViewById(R.id.submit_btn);
        ref_btn = (Button) findViewById(R.id.refresh_btn);
        et1 = (EditText) findViewById(R.id.ed1);
        et2= (EditText) findViewById(R.id.ed2);
        et3 = (EditText) findViewById(R.id.editText1);
        et4 = (EditText) findViewById(R.id.editText2);
        et5 = (EditText) findViewById(R.id.editText3);
        et6 = (EditText) findViewById(R.id.editText4);
       
 
        ref_btn.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
                et1.setText(" ");
                et2.setText(" ");
                et3.setText(" ");
                et4.setText(" ");
                et5.setText(" ");
                et6.setText(" ");
            }
        });
 
        sub_btn.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
                submitData();
            }
        });
    }
 
    protected void submitData() {
        String a = et1.getText().toString();
        String b = et2.getText().toString();
        String c = et3.getText().toString();
        String d = et4.getText().toString();
        String e = et5.getText().toString();
        String f = et6.getText().toString();
 
        db = new DB(this);
        long num;
        try {
            db.open();
            num = db.insertmaster(a, b,c,d,e,f);
            db.close();
        } catch (SQLException e1) {
            num = -5;
        } 
        
        if (num > 0)
            Toast.makeText(this, "Row number: " + num, 2000).show();
        else if (num == -1)
            Toast.makeText(this, "Error Duplicate value", 4000).show();
        else
            Toast.makeText(this, "Error while inserting", 2000).show();
    }

    
 
 
	 @Override
	  public boolean onTouchEvent(MotionEvent event) {
	    if (gestureDetector.onTouchEvent(event)) {
	      return true;
	    }
	    return super.onTouchEvent(event);
	  }

	  private void onLeftSwipe() {
		  Intent i = new Intent(getApplicationContext(),Left.class);
		  startActivity(i);
		  finish();
	    // Do something
	  }
 

	  // Private class for gestures
	  private class SwipeGestureDetector
	          extends SimpleOnGestureListener {
	    // Swipe properties, you can change it to make the swipe
	    // longer or shorter and speed
	    private static final int SWIPE_MIN_DISTANCE = 120;
	    private static final int SWIPE_MAX_OFF_PATH = 200;
	    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

	    public boolean onFling(MotionEvent e1, MotionEvent e2,
	                         float velocityX, float velocityY) {
	      try {
	        float diffAbs = Math.abs(e1.getY() - e2.getY());
	        float diff = e1.getX() - e2.getX();

	        if (diffAbs > SWIPE_MAX_OFF_PATH)
	          return false;
	       
	        // Left swipe
	        if (diff > SWIPE_MIN_DISTANCE
	        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
	           First1.this.onLeftSwipe();

	        }
	      } catch (Exception e) {
	        Log.e("YourActivity", "Error on gestures");
	      }
	      return false;
	    }
	  }
	

	

}
