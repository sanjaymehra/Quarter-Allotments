package com.example.project8;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity1 extends Activity {
	
	ImageView imageview;
	Intent i=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);
		imageview=(ImageView)findViewById(R.id.imageView1);
		
		imageview.setImageResource(R.drawable.pic2);
	
	
	}
	
	public void login_sigin(View v)
	{
		switch(v.getId())
		{
		case R.id.log_in:
			i=new Intent(this,Login.class);
			startActivityForResult(i,200);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); 
			break;
		case R.id.sign_in:
			i=new Intent(this,Signin.class);
			startActivityForResult(i,200);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);;
			break;	
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	
	} 
}