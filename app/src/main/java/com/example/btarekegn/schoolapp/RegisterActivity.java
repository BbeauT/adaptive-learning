package com.example.btarekegn.schoolapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.btarekegn.schoolapp.repository.SchoolAppContract;
import com.example.btarekegn.schoolapp.repository.SchoolAppDbHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mConfirmPasswordView;
    private EditText mFullNameView;
    private RadioGroup mGenderRadioGroupView;
    private RadioGroup mRoleRadioGroupView;
    SchoolAppDbHelper dbHelper;

    private String gender = "Male";
    private String role = "Instructor";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new SchoolAppDbHelper(this);

        mEmailView = (EditText) findViewById(R.id.register_email);
        mPasswordView = (EditText) findViewById(R.id.register_password);
        mConfirmPasswordView = (EditText) findViewById(R.id.register_confirm_password);
        mFullNameView = (EditText) findViewById(R.id.register_full_name);
        mGenderRadioGroupView = (RadioGroup) findViewById(R.id.gender_radio_group) ;
        mRoleRadioGroupView = (RadioGroup) findViewById(R.id.role_radio_group) ;

        mGenderRadioGroupView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                gender = ((RadioButton) findViewById(checkedId)).getText().toString();
            }
        });

        mRoleRadioGroupView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                role = ((RadioButton) findViewById(checkedId)).getText().toString();
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }
        });

        Button mEmailRegisterButton = (Button) findViewById(R.id.email_register_button);
        mEmailRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(SchoolAppContract.UserEntry.COLUMN_FULL_NAME, String.valueOf(mFullNameView.getText()));
                values.put(SchoolAppContract.UserEntry.COLUMN_EMAIL, String.valueOf(mEmailView.getText()));
                values.put(SchoolAppContract.UserEntry.COLUMN_PASSWORD, String.valueOf(mPasswordView.getText()));
                values.put(SchoolAppContract.UserEntry.COLUMN_ROLE, role);
                values.put(SchoolAppContract.UserEntry.COLUMN_GENDER, gender);

                if (!String.valueOf(mPasswordView.getText()).equals(String.valueOf(mConfirmPasswordView.getText()))) {

                    Toast.makeText(getApplicationContext(), "Your password didn't matched", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(SchoolAppContract.UserEntry.TABLE_NAME, null, values);

                if (newRowId == -1) {
                    Toast.makeText(getApplicationContext(), "Unable to register new user", Toast.LENGTH_SHORT).show();
                    return;
                }

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));


            }
        });
    }
}
