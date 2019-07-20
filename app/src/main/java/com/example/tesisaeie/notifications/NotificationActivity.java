package com.example.tesisaeie.notifications;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tesisaeie.R;

public class NotificationActivity extends AppCompatActivity {
    private TextView title,body,dateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Intent intent = getIntent();
        Anuncio ad = (Anuncio) intent.getSerializableExtra("ad");
        title = findViewById(R.id.title);
        body= findViewById(R.id.body);
        dateTime = findViewById(R.id.datetime);
        title.setText(ad.getTitle());
        dateTime.setText(" Publicado: "+ad.getFormatedDate());
        body.setText(ad.getDescription());
    }
}
