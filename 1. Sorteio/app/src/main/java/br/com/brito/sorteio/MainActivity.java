package br.com.brito.sorteio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultado = findViewById( R.id.tvResultado );
    }

    public void sortearNumero(View view){
        int x = new Random(  ).nextInt(11);
        tvResultado.setText( "Número selecionado é: "+ x );
    }
}
