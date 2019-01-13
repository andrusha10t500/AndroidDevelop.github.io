package com.example.user.a123;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText txt1 = (EditText)findViewById(R.id.editText3);
        EditText txt2 = (EditText)findViewById(R.id.editText4);

        String number = txt1.getText().toString();
        String text = txt2.getText().toString();
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(number,null,text,null,null);
            Toast.makeText(getApplicationContext(),"Сообщение ушло",Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Сообщение");
            builder.setMessage(e.getMessage());
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
    
}
