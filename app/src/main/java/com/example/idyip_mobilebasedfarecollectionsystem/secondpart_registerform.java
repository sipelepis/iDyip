package com.example.idyip_mobilebasedfarecollectionsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class secondpart_registerform extends AppCompatActivity {
    private Button nextbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_2nd);
        ImageView back= (ImageView) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondpart_registerform.this, firstpart_registerform.class);
                startActivity(intent);
            }
        });
        nextbutton2 = (Button) findViewById(R.id.confirm_2);
        nextbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ViewNextRegForm2();
            }

        });
    }
    public void ViewNextRegForm2(){

        Intent intent2 = new Intent(this, thirdpart_registerform.class);
        startActivity(intent2);

    }
}