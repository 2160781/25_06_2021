package com.example.android_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    public static class Main {
        public static DadosApp dadosApp;
        public static DadosApp_Corrigido dadosApp_corrigido;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Main.dadosApp = new DadosApp();

        Main.dadosApp_corrigido = new DadosApp_Corrigido();

        List<Tarefas> listaPassos = new ArrayList<>();
        listaPassos.add(new Tarefas("1. Passo --> Preparação de ingredientes",
                false));
        listaPassos.add(new Tarefas("2. Passo --> Mistura de ingredientes",
                false));

        listaPassos.add(new Tarefas("3. Passo --> Coloque o bolo no forno",
                false));
        listaPassos.add(new Tarefas("4. Passo --> Finalizar o bolo",
                false));

        //Main.dadosApp_corrigido.adicionarPlano("Receita de bolo",listaPassos);

        listaPassos.clear();
        listaPassos.add(new Tarefas("1. Passo --> Compra de terreno",
                false));

        listaPassos.add(new Tarefas("2. Passo --> Preparação de terreno",
                false));

        listaPassos.add(new Tarefas("3. Passo --> Plantar trigo",
                false));

        listaPassos.add(new Tarefas("4. Passo --> Obter colheita",
                false));

        //Main.dadosApp_corrigido.adicionarPlano("Preparação de terreno de trigo",listaPassos);

        Intent main = new Intent(this,MainActivity.class);
        startActivity(main);

    }
}