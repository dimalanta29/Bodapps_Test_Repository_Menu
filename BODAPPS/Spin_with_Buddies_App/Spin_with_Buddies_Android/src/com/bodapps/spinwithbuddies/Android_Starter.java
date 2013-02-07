package com.bodapps.spinwithbuddies;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.bodapps.spinwithbuddies.Start;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Android_Starter extends AndroidApplication implements Ad_Request_Handler
{
	//TODO __________[ Field data ]__________
	protected AdView ad_view;
	private AdRequest test_ad; // --> Use it for testing purposes.
	private final int SHOW_ADS = 1;
	private final int HIDE_ADS = 0;
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Handler Setup ]__________
	protected Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) 
        {
            switch(msg.what) 
            {
                case SHOW_ADS:
                {
                    ad_view.setVisibility(View.VISIBLE);
                    break;
                }
                case HIDE_ADS:
                {
                    ad_view.setVisibility(View.GONE);
                    break;
                }
            }
        }
    };
	
    
    
    
    

	
	
	
	
    //TODO __________[ Android Setup ]__________
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	//-----[ Android Configuration Setup ]-----
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        
        
        
        //-----[ Ad Banner Setup ]-----
        RelativeLayout Layout = new RelativeLayout(this); // --> Set and initialize the layout. 
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        
        View Game_View = initializeForView(new Start(this), cfg); // --> Set and initialize the game view.
        
        ad_view = new AdView(this, AdSize.BANNER, "WHAT_ID_NUMBER"); // --> Sir Dayle, replace "WHAT_ID_NUMBER" your publisher ID at the third one (one with quotation). Take note that it's a string value and it has to be a string value, okay?
        test_ad = new AdRequest();
        test_ad.addTestDevice(AdRequest.TEST_EMULATOR); // --> Set dummy ads for testing.
        ad_view.loadAd(test_ad);
        
        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams
        		(
        				RelativeLayout.LayoutParams.WRAP_CONTENT,
        				RelativeLayout.LayoutParams.WRAP_CONTENT
        		);
        
        adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        
        Layout.addView(Game_View);
        Layout.addView(ad_view, adParams);
        setContentView(Layout);
    }










	@Override
	public void show_ads(boolean show) 
	{
		handler.sendEmptyMessage(show ? SHOW_ADS : HIDE_ADS);
	}
}

















































