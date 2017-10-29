package com.example.jaka.toastsms_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private void sendSMS(String senderName, String message){
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(senderName,null, message,null,null);
        Log.e("Send back: ",message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText, String senderName) {
                Log.e("Message recieved: ",messageText);
                Toast.makeText(MainActivity.this,"Message: "+messageText,Toast.LENGTH_LONG).show();
                if (messageText.toLowerCase().contains("prevoz")) {
                    Log.d("STANJE: ", "prevoz");
                    if( messageText.toLowerCase().contains("stanje")) {
                        Log.d("STANJE: ", "stanje");
                        String response = "Stanje prevoza: \n Število prostih mest 5/5";
                        sendSMS(senderName, response);
                    }
                    else{
                        sendSMS(senderName, "Neznan ukaz");
                    }
                }
            }
        });
    }


}
