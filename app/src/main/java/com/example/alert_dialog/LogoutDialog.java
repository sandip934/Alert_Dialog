package com.example.alert_dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class LogoutDialog extends Dialog {

    interface OnLogoutDialogClickListener{
        void onSuccess();
        void onFailure();
    }

    private OnLogoutDialogClickListener onLogoutDialogClickListener;

    public void setOnLogoutDialogClickListener(OnLogoutDialogClickListener onLogoutDialogClickListener) {

        this.onLogoutDialogClickListener = onLogoutDialogClickListener;
    }

    TextView textView1,textView2;
    Button btnYes,btnNo;

    public LogoutDialog(@NonNull Context context){
        super(context);
        setContentView(R.layout.logout_dialog);
        initViews();
        initListeners();
    }

    private void initViews(){
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

    }

    private void initListeners(){
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutDialogClickListener.onSuccess();
   //             Log.e("tag","Yes click listener");
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutDialogClickListener.onFailure();
    //            Log.e("tag","No click listener");
            }
        });

    }
}
