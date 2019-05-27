package br.com.brito.comandosbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText campoProduto;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById( R.id.etNomeProduto );
        resultado = findViewById( R.id.tvResultado );
    }

    public void btEnviar(View view){
        String nomeProduto = campoProduto.getText().toString() + ".";
        resultado.setText( nomeProduto );

    }
}
