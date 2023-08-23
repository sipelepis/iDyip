package com.example.idyip_mobilebasedfarecollectionsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class thirdpart_registerform extends AppCompatActivity {
    private Button nextbutton3, proceed;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private ImageView idyip;
    private TextView popupinfo;

//    public Intent intenproceed = new Intent(this, MainActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_3rd);
        ImageView back= (ImageView) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdpart_registerform.this, secondpart_registerform.class);
                startActivity(intent);
            }
        });
        nextbutton3 = (Button) findViewById(R.id.confirm_3);
        nextbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNewContactDialog();
            }
        });

    }
    public void createNewContactDialog(){
        dialogBuilder=new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.account_creation_success_dialog, null);
        idyip = (ImageView) contactPopupView.findViewById(R.id.congrats_popup_icon);
        popupinfo = (TextView) contactPopupView.findViewById(R.id.congrats_popup_textview);
        proceed = (Button) contactPopupView.findViewById(R.id.congrats_popup_proceed);
        dialogBuilder.setView(contactPopupView);
        dialog=dialogBuilder.create();
        dialog.show();
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewNextRegForm3();
            }
        });
    }
    public void ViewNextRegForm3(){

        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);

    }
}