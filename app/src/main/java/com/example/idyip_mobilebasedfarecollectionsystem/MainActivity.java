package com.example.idyip_mobilebasedfarecollectionsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.santalu.maskara.widget.MaskEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button register, login;
    private MaskEditText phone_num_action;
    private TextInputEditText pass_action;
    private TextInputLayout phone_num_action_cont, pass_action_cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        login = (Button) findViewById(R.id.login1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUI();
            }
        });

        phone_num_action = (MaskEditText) findViewById(R.id.phone_num1);
        pass_action = (TextInputEditText) findViewById(R.id.password_setup1_1);
        phone_num_action_cont = (TextInputLayout) findViewById(R.id.phone_num);
        pass_action_cont = (TextInputLayout) findViewById(R.id.Password_setup1);
        register = (Button) findViewById(R.id.reg_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegForm();

            }
        });

    }

    private boolean validate_phone() {
        String val = phone_num_action_cont.getEditText().getText().toString();
        String rawval = phone_num_action.getUnMasked().toString();
        String phNumber = "^(9|\\+639)\\d{9}$";
        if (val.isEmpty()) {
            phone_num_action_cont.setError("Field cannot be Empty!");

            phone_num_action_cont.requestFocus();
            return false;
        } else if (rawval.length() != 10) {
            phone_num_action_cont.setError("Please provide a 10 digit phone number!");
            return false;
        } else if (!rawval.matches(phNumber)) {
            phone_num_action_cont.setError("Please provide a valid phone number!");
            return false;
        } else {
            phone_num_action_cont.setError(null);
            return true;

        }
    }

    private boolean validate_password() {
        String val = pass_action_cont.getEditText().getText().toString();
        if (val.isEmpty()) {

            pass_action_cont.setError("Field cannot be Empty!");
            return false;
        }
        else {

            pass_action_cont.setError(null);
            return true;
        }
    }
    public void OpenUI(){
        if(!validate_phone() |!validate_password()){
            return;
        }
        else{
            Intent intent1 = new Intent(MainActivity.this, main_userscreen_activity.class);
            startActivity(intent1);
        }
    }
    public void OpenRegForm() {

        Intent intent1 = new Intent(this, firstpart_registerform.class);
        startActivity(intent1);


    }

}