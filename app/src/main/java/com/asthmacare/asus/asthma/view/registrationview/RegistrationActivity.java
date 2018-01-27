package com.asthmacare.asus.asthma.view.registrationview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.presenter.presenterreg.PresenterRegistration;
import com.asthmacare.asus.asthma.view.loginingview.LoginActivity;

public class RegistrationActivity extends AppCompatActivity {
    private EditText familyEditText;
    private EditText nameEditText;
    private EditText snameEeditText;
    private EditText growthEditText;
    private EditText birthdayEditText;
    private EditText genderEditText;
    private EditText loginEditText;
    private EditText passwordEditText;

    private String fname;
    private String name;
    private String sname;
    private String growth;
    private String birthday;
    private String gender;
    private String login;
    private String password;

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;

    AlertDialog.Builder genderEdit;
    Context context;



    private Button buttonRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        context = RegistrationActivity.this;
        addListenerOnButton();

        buttonRegistration = (Button) findViewById(R.id.reg_button);
        familyEditText = (EditText) findViewById(R.id.fname_editText);
        nameEditText = (EditText) findViewById(R.id.name_editText);
        snameEeditText = (EditText) findViewById(R.id.sname_editText);
        growthEditText = (EditText) findViewById(R.id.growth_editText);
        birthdayEditText = (EditText) findViewById(R.id.bdate_editText);
        genderEditText = (EditText) findViewById(R.id.sex_editText);
        loginEditText = (EditText) findViewById(R.id.login_editText);
        passwordEditText = (EditText) findViewById(R.id.password_editText);

        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname = familyEditText.getText().toString();
                name = nameEditText.getText().toString();
                sname = snameEeditText.getText().toString();
                growth = growthEditText.getText().toString();
                gender = genderEditText.getText().toString();
                login = loginEditText.getText().toString();
                password = passwordEditText.getText().toString();
                birthday = birthdayEditText.getText().toString();

                if (fname.equals("") | name.equals("") | sname.equals("") | growth.equals("") | gender.equals("")
                        | login.equals("") | password.equals("") | birthday.equals("")) {
                    Toast.makeText(getApplicationContext(), "Вы заполнили не все поля", Toast.LENGTH_SHORT).show();

                }else{

                    PresenterRegistration presenterRegistration = new PresenterRegistration(fname, password, login, birthday, growth,
                            name, sname, gender);

                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public void addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

// get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

// find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(RegistrationActivity.this,
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}