package com.easydrivesdp2.easy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Anup on 20/04/2017.
 */

public class Welcome extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        String name= getIntent().getStringExtra("name");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(name);
    }
    public void openmain(View view) {
        Intent intent = new Intent(Welcome.this, MainActivity.class);
        startActivity(intent);

    }


}


