package com.appsflyer.myapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn, btn2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button);

         btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> eventValue = new HashMap<String, Object>();
                eventValue.put(AFInAppEventParameterName.REVENUE,1258);
                eventValue.put(AFInAppEventParameterName.ACHIEVEMENT_ID, "31");
                eventValue.put(AFInAppEventParameterName.PRICE,"515$");
                eventValue.put(AFInAppEventParameterName.CURRENCY,"USD");
                AppsFlyerLib.getInstance().logEvent(getApplicationContext() , AFInAppEventType.PURCHASE , eventValue);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> eventValue = new HashMap<String, Object>();
                eventValue.put(AFInAppEventParameterName.REVENUE,-200);
                eventValue.put(AFInAppEventParameterName.CONTENT_TYPE,"shoes");
                eventValue.put(AFInAppEventParameterName.CONTENT_ID,"4875");
                eventValue.put(AFInAppEventParameterName.CURRENCY,"USD");
                AppsFlyerLib.getInstance().logEvent(getApplicationContext() , "cancel_purchase" , eventValue);
            }
        });
    }
}