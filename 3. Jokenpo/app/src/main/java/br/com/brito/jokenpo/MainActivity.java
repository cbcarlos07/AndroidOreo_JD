package br.com.brito.jokenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private String escolhaUsuario;
    private TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultado   = findViewById( R.id.tvResultado );
    }

    public void selecionarPedra( View view ){
        escolhaUsuario = "pedra";
        executarImagem();
    }

    public void selecionarPapel( View view ){
        escolhaUsuario =  "papel" ;
        executarImagem();
    }

    public void selecionarTesoura( View view ){
        escolhaUsuario = "tesoura";
        executarImagem();
    }

    public void opcaoSelecionada( ){
        ImageView imgResultado = findViewById( R.id.imgResultado );

        //gerar número aleatório para escolha do app
        String[] opcoes = { "pedra", "papel", "tesoura" };
        int numero = new Random().nextInt( 3 );
        String escolhaApp = opcoes[ numero ];
        switch ( escolhaApp ){
            case "pedra":
                    imgResultado.setImageResource( R.drawable.pedra );
                break;
            case "papel":
                    imgResultado.setImageResource( R.drawable.papel );
                break;
            case "tesoura":
                    imgResultado.setImageResource( R.drawable.tesoura );
                break;
        }

        if( ( escolhaApp == "pedra"  && escolhaUsuario == "tesoura" ) ||
            ( escolhaApp == "papel"  && escolhaUsuario == "pedra" ) ||
            ( escolhaApp == "tesoura" && escolhaUsuario == "papel")
           ) {
            tvResultado.setText( "Você perdeu! :(" );
          }
        else if(
                ( escolhaUsuario == "pedra"  && escolhaApp == "tesoura" ) ||
                ( escolhaUsuario == "papel"  && escolhaApp == "pedra" ) ||
                ( escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){
            tvResultado.setText( "Você ganhou \\o/" );
        }else {
            tvResultado.setText( "Empatamos ;)" );
        }

    }

    private void executarImagem(  ){
        tvResultado.setText( "..." );
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                imageView = findViewById(R.id.imgResultado);
                int m = 0;
                int n = 0;
                List<Integer> op = new ArrayList<Integer>();
                op.add(R.drawable.pedra);
                op.add(R.drawable.papel);
                op.add(R.drawable.tesoura);

                Collections.shuffle( op );

                Iterator iterator = op.iterator();
                for (int i = 0; i < 6; i++){
                    n++;

                    while (iterator.hasNext()){
                        m = (int) iterator.next();

                        imageView.setImageResource( m );
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Collections.shuffle( op );
                    iterator = op.iterator();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        opcaoSelecionada();
                    }
                });

            }
        });
        t.start();








    }
}
