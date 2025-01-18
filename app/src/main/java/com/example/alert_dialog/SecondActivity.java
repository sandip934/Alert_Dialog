package com.example.alert_dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.Buffer;

public class SecondActivity extends AppCompatActivity {

    Button btnLogoutDialog1,btnLogoutDialog2,btnLogoutDialog3,btnYes,btnNo;
    TextView txtView1,textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        initListeners();
    }


    private void initViews(){
        btnLogoutDialog1 = findViewById(R.id.btnLogoutDialog1);
        btnLogoutDialog2 = findViewById(R.id.btnLogoutDialog2);
        btnLogoutDialog3 = findViewById(R.id.btnLogoutDialog3);
    }

// way 1-- this dialog is designed inside the activity itself
    private void initListeners() {

// way 3

        btnLogoutDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutDialog logoutDialog1 = new LogoutDialog(SecondActivity.this);
                logoutDialog1.setOnLogoutDialogClickListener(new MyLogoutDialogClickListener());
                logoutDialog1.show();
            }
        });

// way 2 - Logout Dialog object created

        btnLogoutDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutDialog logoutDialog = new LogoutDialog(SecondActivity.this);
                logoutDialog.show();
            }
        });

        btnLogoutDialog1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Dialog logoutDialog = new Dialog(SecondActivity.this);
                logoutDialog.setTitle("Logout Dialog");
                logoutDialog.setContentView(R.layout.logout_dialog);
                txtView1 = findViewById(R.id.textView1);
                textView2 = findViewById(R.id.textView2);
                btnYes = findViewById(R.id.btnYes);
                btnNo = findViewById(R.id.btnNo);
                logoutDialog.show();
            }
        });

    }


        class MyLogoutDialogClickListener implements LogoutDialog.OnLogoutDialogClickListener{
            @Override
            public void onSuccess() {
                Toast.makeText(SecondActivity.this, "on success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(SecondActivity.this,"on Failure",Toast.LENGTH_SHORT).show();
            }
        }
    }
