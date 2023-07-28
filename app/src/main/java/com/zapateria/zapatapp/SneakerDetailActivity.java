package com.zapateria.zapatapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zapateria.zapatapp.Modelo.Sneaker;
import com.zapateria.zapatapp.db.DbCarrito;

public class SneakerDetailActivity extends AppCompatActivity {
    private Sneaker detailedSneaker;
    private ImageView sneakerImg;
    private TextView sneakerTitle;
    private TextView sneakerDescription;
    private TextView sneakerPrice;

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
        String sneaker_price= getIntent().getExtras().getString("sneaker_price");


        sneakerImg = (ImageView) findViewById(R.id.sneakerDetailedImage);
        sneakerTitle = (TextView) findViewById(R.id.sneakerTitle);
        sneakerDescription = (TextView) findViewById(R.id.sneakerDescription);
        sneakerPrice = (TextView) findViewById(R.id.sneakerPrice);

        sneakerImg.setImageResource(sneaker_drawable);
        sneakerTitle.setText(sneaker_title);
        sneakerDescription.setText(sneaker_description);
        sneakerPrice.setText(sneaker_price);

        btnComprar = (Button) findViewById(R.id.btnComprar);
        btnVolver  = (Button) findViewById(R.id.btnVolver);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbCarrito dbCarrito = new DbCarrito(SneakerDetailActivity.this);
                long idSneaker = dbCarrito.agregarProductoCarrito(sneakerTitle.toString(),sneakerDescription.toString(),sneakerPrice.toString());
                if(idSneaker>0){
                    Toast.makeText(getApplicationContext(),"Producto agregado al carrito", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SneakerDetailActivity.this,"Ocurrio un error al agregar el producto",Toast.LENGTH_LONG).show();
                }

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
