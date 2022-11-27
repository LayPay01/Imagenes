package com.example.imagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView Foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Foto = findViewById(R.id.Foto);
    }

    public void TomarFoto(View view){
        abrirCam();

    }
    private void abrirCam(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(getIntent().resolveActivity(getPackageManager()) != null){
            startActivityForResult(i,1);
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap img = (Bitmap) extras.get("data");
            Foto.setImageBitmap(img);
        }
    }
}