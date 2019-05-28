package br.com.brito.comandosbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText campoProduto;
    private TextView resultado;
    private CheckBox cbBranco, cbVerde, cbVermelho;
    private List<String> check = new ArrayList<String>() ;
    private RadioGroup rgEstoque;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById( R.id.etNomeProduto );
        resultado = findViewById( R.id.tvResultado );
        cbBranco  = findViewById( R.id.cbBranco );
        cbVerde  = findViewById( R.id.cbVerde );
        cbVermelho  = findViewById( R.id.cbVermelho );
        rgEstoque = findViewById( R.id.rgEstoque );
        verificaRadioButton();
    }
    public void verificaCheck(){
        check.clear();
        if( cbBranco.isChecked() ){
            check.add( cbBranco.getText().toString() );
        }

        if( cbVerde.isChecked() ){
            check.add( cbVerde.getText().toString() );
        }

        if( cbVermelho.isChecked() ){
            check.add( cbVermelho.getText().toString() );
        }

        resultado.setText( check.toString() );
    }

    public void verificaRadioButton(){
        rgEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if( checkedId == R.id.rbSim ){
                    resultado.setText("Sim");
                }else{
                    resultado.setText("Não");
                }
            }
        });
    }
    public void btEnviar(View view){
        /*String nomeProduto = campoProduto.getText().toString() + ".";
        resultado.setText( nomeProduto );*/
        //verificaCheck();

    }
}
