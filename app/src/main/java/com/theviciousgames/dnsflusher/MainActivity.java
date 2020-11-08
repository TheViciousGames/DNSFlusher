package com.theviciousgames.dnsflusher;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button flushDNSButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareObjects();
        buttonFunctions();
    }

    protected void declareObjects() {
        flushDNSButton = findViewById(R.id.flushDNSButton);
    }

    protected void buttonFunctions() {
        flushDNSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Running...Please wait").setPositiveButton("Close", dialogClickListener);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        FlushTools.flushDNS();
                        alertDialog.dismiss();
                    }
                }, 1000);
            }
        });
    }

}