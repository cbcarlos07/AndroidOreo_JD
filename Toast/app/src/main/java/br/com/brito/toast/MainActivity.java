package br.com.brito.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void abrirToast( View view){
        /*
            Criação do toast
        */
        //Toast.makeText(this, "Botão pressionado", Toast.LENGTH_SHORT).show();
        ImageView imageView = new ImageView( getApplicationContext() );
        imageView.setImageResource( android.R.drawable.star_big_off );
        Toast toast = new Toast( getApplicationContext() );
        toast.setDuration( Toast.LENGTH_SHORT );
        toast.setView( imageView );
        toast.show();
    }
}
