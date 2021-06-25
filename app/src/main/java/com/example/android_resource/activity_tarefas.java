package com.example.android_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_tarefas extends AppCompatActivity {

    boolean estadoBoton;
    Button boton;
    TextView textV;
    ImageView ver_imagen;
    int numeroTarefa = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);

        estadoBoton=true;
        boton=findViewById(R.id.Button);
        ver_imagen=findViewById(R.id.imageView3);
        textV= findViewById(R.id.textView);

        numeroTarefa = getIntent().getIntExtra("NumeroTarefa",0);
        textV.setText(PlayActivity.Main.dadosApp.getTextoPassoReceita(numeroTarefa));

        if(PlayActivity.Main.dadosApp.getFeito() == false){
            ver_imagen.setImageResource(R.drawable.errado);
        }else{
            ver_imagen.setImageResource(R.drawable.certo);
        }


    }

    //Metodos
    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        int PassosFeitos1 = PlayActivity.Main.dadosApp.getPassosFeitos();
        switch (keyCode) {
            //Seguinte
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(PlayActivity.Main.dadosApp.getPosicao()<PlayActivity.Main.dadosApp.getSizeListaPassos()-1){
                        PlayActivity.Main.dadosApp.avancar();
                        textV.setText(PlayActivity.Main.dadosApp.getTextoPassoReceita(numeroTarefa)+":");
                        PlayActivity.Main.dadosApp.incrementarPassosFeitos();

                        if(PlayActivity.Main.dadosApp.getFeito() == false){
                            ver_imagen.setImageResource(R.drawable.errado);
                        }else{
                            ver_imagen.setImageResource(R.drawable.certo);
                        }
                        estadoBoton= false;
                    }


                }
                return true;
            //Anterior
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(PlayActivity.Main.dadosApp.getPosicao()>0) {
                        PlayActivity.Main.dadosApp.retroceder();
                        textV.setText(PlayActivity.Main.dadosApp.getTextoPassoReceita(numeroTarefa) + ":" +
                                PlayActivity.Main.dadosApp.getFeito());
                        PlayActivity.Main.dadosApp.decrementarPassosFeitos();
                        estadoBoton = false;
                        if (PlayActivity.Main.dadosApp.getFeito() == false) {
                            ver_imagen.setImageResource(R.drawable.errado);
                        } else {
                            ver_imagen.setImageResource(R.drawable.certo);
                        }
                    }


                }

                return true;
            //Marcar passo como "Feito"
            case KeyEvent.KEYCODE_DPAD_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    //Colocar a posição da tarefa "Feito"

                    int position = PlayActivity.Main.dadosApp.getPosicao();
                    if(PlayActivity.Main.dadosApp.getFeito(position) == false){
                        PlayActivity.Main.dadosApp.marcarFeito(PlayActivity.Main.dadosApp.getPassosFeitos());
                        ver_imagen.setImageResource(R.drawable.certo);

                    }


                }

                return true;

            //Marcar passo como "Por fazer"
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {

                    int position = PlayActivity.Main.dadosApp.getPosicao();
                    if(PlayActivity.Main.dadosApp.getFeito(position) == true){
                        PlayActivity.Main.dadosApp.marcarErrado(
                                PlayActivity.Main.dadosApp.getPassosFeitos());
                        ver_imagen.setImageResource(R.drawable.errado);
                    }
                }

                return true;
            case KeyEvent.KEYCODE_ENTER:
                if (action == KeyEvent.ACTION_DOWN) {

                    Intent inicio = new Intent(this,
                            MainActivity.class);
                    startActivity(inicio);
                }

                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }




}