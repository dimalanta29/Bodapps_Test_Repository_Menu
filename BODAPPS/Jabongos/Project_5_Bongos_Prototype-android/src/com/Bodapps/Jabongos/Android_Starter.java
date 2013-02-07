package com.Bodapps.Jabongos;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.Bodapps.Jabongos.Bongos_EXE;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mobclix.android.sdk.Mobclix;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixMMABannerXLAdView;

public class Android_Starter extends AndroidApplication 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        
        //-----[ Ad Banner Setup ]-----
        Mobclix.onCreate(this);
        RelativeLayout Layout = new RelativeLayout(this); // --> Set and initialize the layout. 
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        
        View Game_View = initializeForView(new Bongos_EXE(), cfg); // --> Set and initialize the game view.
        
        MobclixAdView ads = new MobclixMMABannerXLAdView(this);
        ads.getAd();
        ads.setRefreshTime(10000);
        
        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams
        		(
        				RelativeLayout.LayoutParams.WRAP_CONTENT,
        				RelativeLayout.LayoutParams.WRAP_CONTENT
        		);
        
        adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        
        Layout.addView(Game_View);
        Layout.addView(ads, adParams);
        setContentView(Layout);
    }
}