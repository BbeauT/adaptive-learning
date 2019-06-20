package com.example.btarekegn.schoolapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btarekegn.schoolapp.repository.SchoolAppContract;
import com.example.btarekegn.schoolapp.repository.SchoolAppDbHelper;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {



    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    SchoolAppDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new SchoolAppDbHelper(this);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));


//                SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//
//                String selection = SchoolAppContract.UserEntry.COLUMN_EMAIL + " = ?1 AND " + SchoolAppContract.UserEntry.COLUMN_PASSWORD + " = ?2 ";
//                String[] selectionArgs = { String.valueOf(mEmailView.getText()), String.valueOf(mPasswordView.getText()) };
//
//                Cursor cursor = db.query(
//                        SchoolAppContract.UserEntry.TABLE_NAME,   // The table to query
//                        null,             // The array of columns to return (pass null to get all)
//                        selection,              // The columns for the WHERE clause
//                        selectionArgs,          // The values for the WHERE clause
//                        null,                   // don't group the rows
//                        null,                   // don't filter by row groups
//                        null               // The sort order
//                );
//
//                List itemIds = new ArrayList<>();
//                while(cursor.moveToNext()) {
//                    long itemId = cursor.getLong(
//                            cursor.getColumnIndexOrThrow(SchoolAppContract.UserEntry._ID));
//
//                    if (itemId != -1)
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//
//                    else
//                        Toast.makeText(getApplicationContext(), getString(R.string.invalid_user_name_or_password), Toast.LENGTH_LONG).show();
//                }
//                cursor.close();
            }
        });


    }


    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

}

