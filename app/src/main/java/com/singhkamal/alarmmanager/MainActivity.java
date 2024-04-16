package com.singhkamal.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_CODE=100;
    EditText editTime;
    Button btnAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_main );



        AlarmManager alarmManager=(AlarmManager) getSystemService( ALARM_SERVICE );

        findViewById( R.id.btnAlarm ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time=Integer.parseInt( ((EditText)(findViewById( R.id.editTime ))).getText().toString());
                long triggerTime=System.currentTimeMillis()+(time * 1000);

                Intent iBroadCast = new Intent(MainActivity.this, myReceiver.class);

                PendingIntent pendingIntent=PendingIntent.getBroadcast( MainActivity.this, ALARM_REQ_CODE , iBroadCast,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set( AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
            }
        } );





    }
}