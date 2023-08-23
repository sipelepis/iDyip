package com.example.idyip_mobilebasedfarecollectionsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class main_userscreen_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar2;
    Button button;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private RatingBar ratingBar;
    private TextView head,catcher,logout_head,confirm_logouttext;
    private EditText textual_feedback;
    private Button cancel, submit,nextbutton3,cancel_logout,confirm_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_userscreen_layout);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar2 = findViewById(R.id.toolbar1);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar2, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }
    public void OpenLogoutDialog(){
        dialogBuilder=new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.logout_dialogbox, null);

        logout_head = (TextView) contactPopupView.findViewById(R.id.logout_head);
        confirm_logouttext = (TextView) contactPopupView.findViewById(R.id.confirm_logouttext);
        cancel_logout = (Button) contactPopupView.findViewById(R.id.cancel_logout);
        confirm_logout = (Button) contactPopupView.findViewById(R.id.confirm_logout);

        dialogBuilder.setView(contactPopupView);
        dialog=dialogBuilder.create();
        dialog.show();
        cancel_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        confirm_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(main_userscreen_activity.this, MainActivity.class);
                startActivity(intent3);
            }
        });
    }
    public void OpenFeedbackDialog(){
        dialogBuilder=new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.feedback_messagebox, null);

        head = (TextView) contactPopupView.findViewById(R.id.confirm_logouttext);
        catcher = (TextView) contactPopupView.findViewById(R.id.catcher);
        ratingBar = (RatingBar) contactPopupView.findViewById(R.id.rating_bar);
        textual_feedback = (EditText) contactPopupView.findViewById(R.id.textual_feedback);
        cancel = (Button) contactPopupView.findViewById(R.id.cancel_feedback);
        submit = (Button) contactPopupView.findViewById(R.id.confirm_feedback);

        dialogBuilder.setView(contactPopupView);
        dialog=dialogBuilder.create();
        dialog.show();
       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                dialog.dismiss();
           }
       });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.Feedback){
            OpenFeedbackDialog();
        }
        else if (id == R.id.LogOut) {
            OpenLogoutDialog();
        }
            return true;
    }
}