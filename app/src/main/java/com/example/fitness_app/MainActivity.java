package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar Pb;
    private Button Bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pb = (ProgressBar)findViewById(R.id.pb);
        Bt = (Button) findViewById(R.id.btn);
        Pb.setVisibility(View.INVISIBLE); //Mi progress bar se hace invisible.

        Bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                new Task().execute(); //Ejecuto mi tarea asincrona.
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>
    {
        //Configura el proceso inicial.
        @Override
        protected void onPreExecute() {
            Pb.setVisibility(View.VISIBLE);

        }

        //Emplea la tarea pesada.
        @Override
        protected String doInBackground(String... strings) {
            for(int i =1; i<=10; i++)
            {
                try {
                    Thread.sleep(1000);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //Finaliza mi tarea asincrona.
        @Override
        protected void onPostExecute(String s) {
            Pb.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);

        }


    }

    // Tarea Pesada
    public void Hilo(View v)
    {
        for(int i = 1; i<=10; i++)
        {
            try {

               Thread.sleep(2000);
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
        }
    }
}