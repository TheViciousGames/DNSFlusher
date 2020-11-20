package com.theviciousgames.dnsflusher;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.theviciousgames.dnsflusher.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding layoutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(declareObjects());
    }
    protected View declareObjects() {
        layoutBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = layoutBinding.getRoot();
        buttonFunctions();
        return view;
    }
    protected void buttonFunctions() {
        layoutBinding.flushDNSButton.setOnClickListener(new View.OnClickListener() {
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
        layoutBinding.goToWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://theviciousgames.com"));
                startActivity(goToWebsiteIntent);
            }
        });
    }
}