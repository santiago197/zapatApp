package com.zapateria.zapatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zapateria.zapatapp.Modelo.Sneaker;

public class SneakerDetailActivity extends AppCompatActivity {
    private Sneaker detailedSneaker;
    private ImageView sneakerImg;
    private TextView sneakerTitle;
    private TextView sneakerDescription;

    private Button btnComprar;
    private Button btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_home);

        int id = getIntent().getExtras().getInt("sneaker_id");

        int sneaker_drawable  = getIntent().getExtras().getInt("sneaker_img");

        String sneaker_title = getIntent().getExtras().getString("sneaker_title");

        String sneaker_description = getIntent().getExtras().getString("sneaker_description");


        sneakerImg = (ImageView) findViewById(R.id.sneakerDetailedImage);
        sneakerTitle = (TextView) findViewById(R.id.sneakerTitle);
        sneakerDescription = (TextView) findViewById(R.id.sneakerDescription);

        sneakerImg.setImageResource(sneaker_drawable);
        sneakerTitle.setText(sneaker_title);
        sneakerDescription.setText(sneaker_description);

        btnComprar = (Button) findViewById(R.id.btnComprar);
        btnVolver  = (Button) findViewById(R.id.btnVolver);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Producto agregado al carrito", Toast.LENGTH_SHORT).show();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
