package com.example.notificacionwearos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotification();

        Button buttonShowNotification = findViewById(R.id.button1);

        NotificationCompat.Builder builder = new NotificationCompat.Builder( this, "01")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Notificacion Prueba")
                .setContentText("Contenido de la notificación")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        buttonShowNotification.setOnClickListener(v -> {
            notificationManager.notify( 100, builder.build());
        });
    }

    private void createNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "canalEstudiante";
            String description = "canal para canalEstudiante";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("01", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}