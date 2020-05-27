package com.book.pay.app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.book.pay.app.R;
import com.book.pay.app.fragment.NavigationDrawerFragment;
import com.book.pay.app.fragment.TimePickerDialogFragment;
import com.book.pay.app.model.Esercente;
import com.book.pay.app.notification.BookBroadCastReceiver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DetailActivity extends AppCompatActivity {

    private  CalendarView calendarView;
    private int anno;
    private int mese = 1; // metto uno perchè il mese del calendar parte da 0;
    private int giorno;
    private int ora = 0;
    private int minuti = 0;

    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extra = getIntent().getExtras();
        Esercente esercente = extra.getParcelable("esercente");
        TextView nomeAtt = findViewById(R.id.detail_nome_att);
        TextView nomeEse = findViewById(R.id.detail_nome_ese);

        nomeAtt.setText(esercente.getListaNegozi().get(0).getNumeNegozio());
        nomeEse.setText(esercente.getNome());

        calendarView = findViewById(R.id.calendarEsercente);

    }

    @Override
    protected void onResume() {
        super.onResume();

        LinearLayout layout = findViewById(R.id.bottom_app_bar_content_container);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                navigationDrawerFragment.show(getSupportFragmentManager(),"TAG");
            }
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int giornoPrenotazione = calendar.get(Calendar.DAY_OF_MONTH);
                int giorniRimanenti = giorno - giornoPrenotazione;
                String giornoText = "giorno";
                if(giorniRimanenti > 1){
                    giornoText = "giorni";
                }
                Toast.makeText(getApplicationContext(),"Tra  "+giorniRimanenti+" "+giornoText+" sarà il tuo turno",Toast.LENGTH_LONG).show();
                scheduleNotification(getNotification( "Tra " +minuti+" è il tuo turno" ) , 10000 ) ;
            }
        });


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                anno = year;
                mese = mese+month;
                giorno = dayOfMonth;
                TimePickerDialogFragment timePicker = new TimePickerDialogFragment();
                timePicker.show(getSupportFragmentManager(), "timePicker");
                ora = timePicker.getOra();
                minuti = timePicker.getMinuti();
            }
        });

    }

    private void scheduleNotification (Notification notification , int delay) {
        Intent notificationIntent = new Intent( this, BookBroadCastReceiver. class ) ;
        notificationIntent.putExtra(BookBroadCastReceiver.NOTIFICATION_ID , 1 ) ;
        notificationIntent.putExtra(BookBroadCastReceiver.NOTIFICATION , notification) ;
        PendingIntent pendingIntent = PendingIntent.
                getBroadcast ( this, 0 , notificationIntent , PendingIntent.FLAG_UPDATE_CURRENT ) ;
        long futureInMillis = SystemClock. elapsedRealtime () + delay ;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE ) ;
        assert alarmManager != null;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP , futureInMillis , pendingIntent) ;
    }
    private Notification getNotification (String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this, default_notification_channel_id ) ;
        builder.setContentTitle( "Scheduled Notification" ) ;
        builder.setContentText(content) ;
        builder.setSmallIcon(R.drawable.ic_launcher_foreground ) ;
        builder.setAutoCancel( true ) ;
        //Vibration
        builder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

        //LED
        builder.setLights(Color.RED, 3000, 3000);
        builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        builder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
        return builder.build() ;
    }





}
