package com.example.android_resource;

import java.util.ArrayList;
import java.util.List;

public class DadosApp_Corrigido extends MainActivity{

    private List<Tarefas> listaPassos;
    private List<Plano> listaPlanos;

    private int posicao;
    private int PassosFeitos = 0;

    int posicaoPlano;

    public DadosApp_Corrigido(ArrayList<Tarefas> listaPassos, List<Plano> listaPlanos, int posicao, int passosFeitos, int posicaoPlano) {
        this.listaPassos = listaPassos;
        this.listaPlanos = listaPlanos;
        this.posicao = posicao;
        PassosFeitos = passosFeitos;
        this.posicaoPlano = posicaoPlano;
    }

    public DadosApp_Corrigido() {
        listaPassos = new ArrayList<>();
    }

    public void adicionarPlano(String name, List<Tarefas> lista){
        if (lista != null && name != null){
            listaPlanos.add(new Plano(""+name, (ArrayList<Tarefas>) lista));

        }

        /*
        if(numero == 0){

            listaPassos.add(new Tarefas("1. Passo --> Preparação de ingredientes",
                    false));
            listaPassos.add(new Tarefas("2. Passo --> Mistura de ingredientes",
                    false));

            listaPassos.add(new Tarefas("3. Passo --> Coloque o bolo no forno",
                    false));
            listaPassos.add(new Tarefas("4. Passo --> Finalizar o bolo",
                    false));
        }else {
            if(planoPosicao == 1){
                listaPassos.add(new Tarefas("1. Passo --> Compra de terreno",
                        false));

                listaPassos.add(new Tarefas("2. Passo --> Preparação de terreno",
                        false));

                listaPassos.add(new Tarefas("3. Passo --> Plantar trigo",
                        false));

                listaPassos.add(new Tarefas("4. Passo --> Obter colheita",
                        false));

            }
        */

    }

    public String getTextReceita(int posicao){
        return listaPlanos.get(posicao).getTexto();
    }

    public List<Tarefas> getListaTarefas(int posicao) {
        return listaPlanos.get(posicao).gettarefas();
    }

    public boolean getFeito(int posicao,int posicaoPasso){
        return listaPlanos.get(posicao).gettarefas().get(posicaoPasso).getFeito();
    }

    public int getSizeListPassos(int posicao) {
        return listaPlanos.get(posicao).gettarefas().size();
    }


    public void marcarFeito(int position,int posicaoPasso) {
        listaPlanos.get(position).gettarefas().get(posicaoPasso).setFeito(true);
    }

    public void marcarErrado(int position,int posicaoPasso) {
        listaPlanos.get(position).gettarefas().get(posicaoPasso).setFeito(false);
    }

    public int getNumeroPassosFeitos(int posicao) {
        int count = 0;

        List<Tarefas> tarefas = listaPlanos.get(posicao).gettarefas();

        if (tarefas != null) {
            for (Tarefas t : tarefas) {
                if (t.feito) {
                    count++;
                }
            }
        }
        return count;
    }
}
