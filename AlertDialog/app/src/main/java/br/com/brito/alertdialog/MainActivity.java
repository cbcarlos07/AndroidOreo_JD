package br.com.brito.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlerta(View view){

        AlertDialog.Builder dialog = new AlertDialog.Builder( this );

        //Configura titulo e mensagem
        dialog.setTitle( "Título" );
        dialog.setMessage( "Mensagem" );

        //Configura o cancelamento
        dialog.setCancelable( false );

        //Configura ícone
        dialog.setIcon( android.R.drawable.ic_btn_speak_now );

        //configura ações para o botao sim ou nao
        dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Sim foi pressionado", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Não foi pressionado", Toast.LENGTH_SHORT).show();
            }
        });

        //Cria e exibir AlertDialog
        dialog.create();
        dialog.show();
    }
}
