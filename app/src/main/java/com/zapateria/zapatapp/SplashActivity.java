package com.zapateria.zapatapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.os.Handler;
import android.content.Intent;



public class SplashActivity extends Activity {
    private static int SPLASH_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Iniciar AsyncTask para cargar datos en segundo plano
        new LoadDataAsyncTask().execute();

        // Usar un Handler para redirigir al usuario a la actividad principal después del tiempo del splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, SPLASH_DURATION);
    }
    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Cierra esta actividad para que el usuario no pueda volver al splash screen presionando el botón "Atrás"
    }

    private class LoadDataAsyncTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
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
