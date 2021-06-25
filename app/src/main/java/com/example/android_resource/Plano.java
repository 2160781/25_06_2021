package com.example.android_resource;

import java.util.ArrayList;
import java.util.List;

public class Plano {
    private String texto;
    private List<Tarefas> tarefas;



    Plano(String texto, ArrayList<Tarefas> tarefas) {
        this.texto = texto;
        this.tarefas = tarefas;

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(){
        this.texto = null;
    }

    public List<Tarefas> gettarefas(){
        return tarefas;
    }
}
