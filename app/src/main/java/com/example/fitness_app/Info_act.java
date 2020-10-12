package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoview = (VideoView)findViewById(R.id.vd);  //LLamo el elemento videoview.

        // Asignar nuestro video mp4 al videoview a traves de su ruta.
        String ruta = "android.resource://" + getPackageName() +"/" + R.raw.video;  //Obtener la ruta.
        Uri uri = Uri.parse(ruta);
        videoview.setVideoURI(uri);

        // Controles del video.
        MediaController media = new MediaController(this);
        videoview.setMediaController(media);
    }
}