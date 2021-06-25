package com.example.android_resource;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean estadoBotao;
    TextView CaixadeTexto;
    Button botao;

    private List<Tarefas> listaPassos;
    private List<Plano> listaPlano;

    private int Passosfeitos1 = 0;
    private int Passosfeitos2 = 0;
    private int Passosfeitos1Total = 4;
    private int Passosfeitos2ToTal = 4;
//    private int PlanoEfetuar = 0;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Passosfeitos1 = PlayActivity.Main.dadosApp.getNumeroPassosFeitos();
        listview();
    }



    public boolean listview(){

        listView = findViewById(R.id.listview);

        String[] values = new String[] {
                "1. Qr CODE", "2. Microfone", "3. Tarefas"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent passo1 = new Intent(view.getContext(),Q_R_CODE.class);
                    startActivity(passo1);

                }
                if(position == 1){
                    Intent passo2 = new Intent(view.getContext(),AtivaRechonecimentoVoz.class);
                    startActivity(passo2);
                }
                if(position == 2){
                listviewTarefas();
                }
            }
        });
        return true;
    }

    public boolean listviewTarefas(){

        eliminaraPassosPlanos();

        setContentView(R.layout.activity_listview);
        
        listView = findViewById(R.id.listview);

        String[] values = new String[] {
                "1. Receita de bolo -" + PlayActivity.Main.dadosApp_corrigido.getNumeroPassosFeitos(0) + " de " + PlayActivity.Main.dadosApp_corrigido.getSizeListPassos(0)
                , "2. Plantação de trigo - " + PlayActivity.Main.dadosApp_corrigido.getNumeroPassosFeitos(4) + " de "
                + PlayActivity.Main.dadosApp_corrigido.getSizeListPassos(1),
                "3. Voltar para a Main"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,values);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                PlanoEfetuar = position;

                if(position == 0){
                    Passosfeitos1 = PlayActivity.Main.dadosApp.getPassosFeitos();
                    Intent Tarefa1 = new Intent(view.getContext(),
                            activity_tarefas.class);
                    Tarefa1.putExtra("NumeroTarefa",position);
                    startActivity(Tarefa1);
                }

                if (position == 1) {

                    Passosfeitos2 = PlayActivity.Main.dadosApp.getPassosFeitos();
                    Intent Tarefa2 = new Intent(view.getContext(),
                            activity_tarefas.class);
                    Tarefa2.putExtra("NumeroTarefa",position);
                    startActivity(Tarefa2);
                }

                if(position == 2){
                    Intent inicio = new Intent(view.getContext(),MainActivity.class);
                    startActivity(inicio);
                }
            }
        });
        return true;
    }


    public void Anterior( View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

    ///mudar
    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    listview();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO

                    Intent anterior = new Intent(this, MainActivity.class);
                    startActivity(anterior);

                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    private void siguiente( Intent siguiente ) {

        startActivity( siguiente );

    }
    private void anterior( Intent anterior ) {

        startActivity( anterior );
    }

    private void eliminaraPassosPlanos(){

        if (listaPassos != null){
            if(listaPassos.size() >= 4){
                for(int Pp = 0; Pp < listaPassos.size(); Pp ++){
                    listaPassos.remove(Pp);
                }
            }
            if(listaPlano.size() >= 1){
                for(int PP = 0; PP < listaPlano.size(); PP ++){
                    listaPlano.remove(PP);
                }
            }
        }
    }

  /*  public int getPlanoEfetuar() {
        return PlanoEfetuar;
    }
*/
}

