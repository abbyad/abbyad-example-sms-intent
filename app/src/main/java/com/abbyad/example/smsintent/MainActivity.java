package com.abbyad.example.smsintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mPhone;
    EditText mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPhone = findViewById(R.id.editPhone);
        mMessage = findViewById(R.id.editMessage);
    }
    public void onClickSendSMS(View v) {
        // Using SENDTO instead of SEND to make sure default SMS app responds, not just any handler
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + mPhone.getText().toString()));
        intent.putExtra("sms_body", mMessage.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
