package com.example.project8;



import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Details extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);        
        
        WebView wv = (WebView) findViewById(R.id.webView1);          
        wv.loadUrl("file:///android_asset/a.html");        
        
            
    }
    
    private class Callback extends WebViewClient {
    	@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return(false);
		}
	}	
}