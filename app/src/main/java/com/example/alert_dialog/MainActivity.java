package com.example.alert_dialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog,btnTimePickerDialog, btnDatePickerDialog, btnLogoutDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews(){
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDiaqlog);
        btnDatePickerDialog = findViewById(R.id.btnDataPickerDialog);
        btnLogoutDialog = findViewById(R.id.btnLogoutDialog);
    }

    private void initListeners(){
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exam Form Submission");
                builder.setMessage("Are you sure you want to submit?");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setPositiveButton("Yes",new AlertDialogButtonClickListener());
                builder.setNegativeButton("No",new AlertDialogButtonClickListener());

                //pass the object of anonymous class using dialog interface
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Neutral Button Clicked" + i , Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnTimePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialogButtonClickListener(),
                        11,
                        34,
                        true);
                timePickerDialog.show();
            }
        });


        btnDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialogButtonClickListener(),
                        2024,
                        02,
                        9);
                datePickerDialog.show();
            }
        });

        btnLogoutDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutDialog logoutDialog = new LogoutDialog(MainActivity.this);
                logoutDialog.setOnLogoutDialogClickListener(new LogoutDialogClickListener());
                logoutDialog.show();
            }
        });
    }

    class LogoutDialogClickListener implements LogoutDialog.OnLogoutDialogClickListener{
        @Override
        public void onSuccess() {
            Log.e("tag", "on Success");
        }

        @Override
        public void onFailure() {
            Log.e("tag", "on Failure");
        }
    }

    class TimePickerDialogButtonClickListener implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Log.e("tag", "time picker " + timePicker + "   " + i + "  " + i1);
        }
    }


    class DatePickerDialogButtonClickListener implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Log.e("tag","date picker " + datePicker + " " + i + " " + i1 + " " + i2);
        }
    }

    class AlertDialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if(which == -1){
                Toast.makeText(MainActivity.this,"Positive Button Clicked" + which,Toast.LENGTH_LONG).show();
            } else if (which == -2) {
                Toast.makeText(MainActivity.this,"Negative Button Clicked" + which, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,"Neutral Button Clicked" + which, Toast.LENGTH_LONG).show();
            }
        }
    }

    class PositiveButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            Toast.makeText(MainActivity.this, "Positive Btn Clicked  " + which, Toast.LENGTH_LONG).show();
        }
    }

    class NegativeButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            Toast.makeText(MainActivity.this,"Negative Btn Clicked  " + which, Toast.LENGTH_LONG).show();
        }
    }

    class NeutralButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            Toast.makeText(MainActivity.this,"Neutral Btn Clicked  " + which,Toast.LENGTH_LONG).show();
        }
    }
}