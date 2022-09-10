package com.example.creatlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class NewLayout extends Activity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.newlayout);
            Button btnBack= (Button)
                    findViewById(R.id.btnBacktoMainActivity);
            btnBack.setOnClickListener(new
                                               View.OnClickListener() {
                                                   public void onClick(View v) {
                                                       finish();
                                                   }
                                               });
    }
}