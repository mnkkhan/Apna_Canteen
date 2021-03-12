package com.mnk.apnacanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText signupName, signupPassword;
    Button addAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        myDB = new DatabaseHelper(this);
        signupName = (EditText) findViewById(R.id.signup_id);
        signupPassword = (EditText) findViewById(R.id.signup_password);
        addAccount = (Button) findViewById(R.id.add_account);

        Add_User();

    }


    public void Add_User() {


        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if ((signupName.getText().toString().equals("")) && (signupPassword.getText().toString().equals("")))
                {

                    Toast.makeText(signUp.this, "Username and Password fields can't left blank", Toast.LENGTH_SHORT).show();

                }

                else if ((signupName.getText().toString().equals(""))) {
                    Toast.makeText(signUp.this, "Username field can't left blank", Toast.LENGTH_SHORT).show();

                }
                else if(signupPassword.getText().toString().equals(""))
                {    Toast.makeText(signUp.this, "Password field can't left blank", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    boolean isinserted = myDB.Add_Account(signupName.getText().toString(), signupPassword.getText().toString());

                    if (isinserted)
                    {
                        Toast.makeText(signUp.this, "User Added Successfully !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),signIn.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                        Toast.makeText(signUp.this, "Please, Try again", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}