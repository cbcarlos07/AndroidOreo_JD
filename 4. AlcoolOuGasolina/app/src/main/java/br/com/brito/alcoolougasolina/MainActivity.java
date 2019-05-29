package br.com.brito.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private EditText editPrecoAlcool;
     private EditText editPrecoGasolina;
     private TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool = findViewById( R.id.editPrecoAlcool );
        editPrecoGasolina = findViewById( R.id.editPrecoGasolina );
        textResultado = findViewById( R.id.textResultado );
    }

    public void calcularPreco(View view){
        //recuperar os valores digitados
        String precoAlcool   = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        boolean camposValidados = this.validarCampos( precoAlcool, precoGasolina );
        if( camposValidados ){
            calcularMelhorPreco(precoAlcool, precoGasolina);
        }else{
            textResultado.setText( "Preencha os campos primeiros" );
        }
    }
    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        //Convertendo os valores string para numeros
        double precoAlcool   = Double.parseDouble( pAlcool );
        double precoGasolina = Double.parseDouble( pGasolina );
        double resultado     = precoAlcool / precoGasolina;
        if( resultado > 0.7 ){
            textResultado.setText("Melhor utilizar Gasolina");
        }else {
            textResultado.setText( "Melhor utilizar Álcool" );
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina){
        boolean camposValidads = true;

        //Validar campos
        if( pAlcool ==  null || pAlcool.equals( "" ) ){
            camposValidads = false;
        }else if( pGasolina == null || pGasolina.equals( "" ) ){
            camposValidads = false;
        }
        return camposValidads;
    }
}
