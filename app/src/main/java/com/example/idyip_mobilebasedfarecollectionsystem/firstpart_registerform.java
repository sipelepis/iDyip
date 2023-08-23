package com.example.idyip_mobilebasedfarecollectionsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.santalu.maskara.widget.MaskEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class firstpart_registerform extends AppCompatActivity {
    private static final String TAG = "firstpart_registerform";
    private Button nextbutton1;
    final Calendar myCalendar = Calendar.getInstance();
    private TextInputEditText DisplayDate;
    private TextInputEditText pass_action;
    private MaskEditText phone_num_format;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private TextInputLayout phone_num_cont, first_name_cont, last_name_cont, birthdate_cont, address_cont, email_cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_1st);
        phone_num_format = (MaskEditText) findViewById(R.id.phone_num1);
        DisplayDate = (TextInputEditText) findViewById(R.id.Birthday);
        first_name_cont = (TextInputLayout) findViewById(R.id.first_name1);
        last_name_cont = (TextInputLayout) findViewById(R.id.last_name1);
        birthdate_cont = (TextInputLayout) findViewById(R.id.Birthdate1);
        phone_num_cont = (TextInputLayout) findViewById(R.id.phone_num);
        address_cont = (TextInputLayout) findViewById(R.id.Address1);
        email_cont = (TextInputLayout) findViewById(R.id.Email1);
        nextbutton1 = (Button) findViewById(R.id.confirm_1);
        ImageView back = (ImageView) findViewById(R.id.back_button);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        DisplayDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(firstpart_registerform.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(firstpart_registerform.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nextbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewNextRegForm1();
            }
        });
    }

    private boolean validate_firstname() {
        String val = first_name_cont.getEditText().getText().toString();
        String regexs = "^[A-Za-z]+$";
        if (val.isEmpty()) {

            first_name_cont.setError("First Name cannot be Empty!");
            return false;
        } else if (!val.matches(regexs)) {
            first_name_cont.setError("Please provide a valid first name!");
            return false;
        } else {
            first_name_cont.setErrorEnabled(false);
            first_name_cont.setError(null);
            return true;
        }
    }

    private boolean validate_lastname() {
        String val = last_name_cont.getEditText().getText().toString();
        String regexs = "^[A-Za-z]+$";
        if (val.isEmpty()) {

            last_name_cont.setError("Last Name cannot be Empty!");
            return false;
        } else if (!val.matches(regexs)) {
            last_name_cont.setError("Please provide a valid Last Name!");
            return false;
        } else {
            last_name_cont.setErrorEnabled(false);
            last_name_cont.setError(null);
            return true;
        }
    }

    private boolean validate_birhtdate() {
        String val = birthdate_cont.getEditText().getText().toString();
        Date birthdate = myCalendar.getTime();
        if (val.isEmpty()) {

            birthdate_cont.setError("Birthdate cannot be Empty!");
            return false;
        } else if (new Date().before(birthdate)) {
            birthdate_cont.setError("Invalid Birthday Input! ");
            return false;
        } else {
            birthdate_cont.setErrorEnabled(false);
            birthdate_cont.setError(null);
            return true;
        }
    }

    private boolean validate_phone() {
        String val = phone_num_cont.getEditText().getText().toString();
        String rawval = phone_num_format.getUnMasked().toString();
        String phNumber = "^(9|\\+639)\\d{9}$";
        if (val.isEmpty()) {
            phone_num_cont.setError("Phone Number cannot be Empty!");

            return false;
        } else if (rawval.length() != 10) {
            phone_num_cont.setError("Please provide a 10 digit phone number!");
            return false;
        } else if (!rawval.matches(phNumber)) {
            phone_num_cont.setError("Please provide a valid phone number!");
            return false;
        } else {
            phone_num_cont.setErrorEnabled(false);
            phone_num_cont.setError(null);
            return true;

        }
    }

    private Boolean validate_address() {
        String val = address_cont.getEditText().getText().toString();


        if (val.isEmpty()) {
            address_cont.setError("Field cannot be empty");
            return false;
        } else {
            address_cont.setError(null);
            address_cont.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validate_email() {
        String val = email_cont.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email_cont.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            email_cont.setError("Invalid email address");
            return false;
        } else {
            email_cont.setError(null);
            email_cont.setErrorEnabled(false);
            return true;
        }
    }


    public void ViewNextRegForm1() {
        if (!validate_firstname() | !validate_lastname() | !validate_birhtdate() | !validate_phone() | !validate_email() |!validate_address()) {
            return;
        } else {
            Intent intent1 = new Intent(this, secondpart_registerform.class);
            startActivity(intent1);
        }

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        DisplayDate.setText(sdf.format(myCalendar.getTime()));
    }
}