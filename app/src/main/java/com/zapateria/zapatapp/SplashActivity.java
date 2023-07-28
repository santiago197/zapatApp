package com.zapateria.zapatapp;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.os.AsyncTask;
import android.os.Handler;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class SplashActivity extends Activity {
    private ProgressBar pb;
    private ImageView logo;
    private static int SPLASH_DURATION = 6000;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ImageView logo = findViewById(R.id.logo);

        pb = (ProgressBar)findViewById(R.id.progressBar);
        new LoadDataAsyncTask().execute();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, SPLASH_DURATION);
    }
    private void startMainActivity() {
        pb.setVisibility(View.INVISIBLE);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Cierra esta actividad para que el usuario no pueda volver al splash screen presionando el botón "Atrás"
    }

    private class LoadDataAsyncTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute(){
            pb.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(SPLASH_DURATION);
                ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            // Aquí puedes realizar acciones después de cargar los datos, si es necesario.
        }
    }
}
