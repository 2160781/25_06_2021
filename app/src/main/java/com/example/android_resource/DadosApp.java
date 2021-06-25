package com.example.android_resource;

import java.util.ArrayList;
import java.util.List;



public class DadosApp extends MainActivity {


    private List<Tarefas> listaPassos;
    private List<ArrayList<Tarefas>> listaListaPassos;
    private List<Plano> listaPlano;

    private int posicao;
    private int PassosFeitos = 0;

    int posicaoPlano;


    // singleton
    public DadosApp() {
        listaPassos = new ArrayList<>();

        for (int i = 0; i<2; i++){
            //uniaoTarefasPlano(i);


            if (i == posicaoPlano) {

                listaPlano = new ArrayList<>();
                listaPlano.add(new Plano("Receita de bolo",
                        (ArrayList<Tarefas>) listaListaPassos.get(i)));

            } else {

                if (i == posicaoPlano) {

                    listaPlano = new ArrayList<>();
                    listaPlano.add(new Plano("Preparação de terreno de trigo",
                            (ArrayList<Tarefas>) listaListaPassos.get(i)));

                }
            }
        }

        posicao = 0;
    }

    private void uniaoTarefasPlano(int planoPosicao){


        if(planoPosicao == 0){


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
        }



    }



    public String getTextoPassoReceita(int nrtarefa) {

        //return listaPassos.get(posicao - 1).getTexto();
        if (nrtarefa == 0)
            return listaListaPassos.get(0).get(posicao).getTexto();
        else
            return listaListaPassos.get(4).get(posicao).getTexto();
    }

    public void avancar() {
        if (posicao < listaPassos.size()){
            posicao++;
        }
    }


    public void retroceder() {
        if (posicao >=0)
            posicao--;
    }

    public List<Tarefas> getListaPassos() {
        return listaPassos;
    }

    public Tarefas getElement(int index){
        return listaPassos.get(index);
    }

    public boolean getFeito(int index){
        return listaPassos.get(index).getFeito();
    }

    public boolean getFeito(){
        //return listaPassos.get(posicao - 1).getFeito();
        return listaPassos.get(posicao).getFeito();
    }

    public int getTarefasSize(){
        return listaPassos.size();
    }


    public int getPosicao()  {
        return posicao;
    }

    public int getSizeListaPassos()  {
        return listaPassos.size();
    }

    public void marcarFeito(int position) {
        listaPassos.get(position).setFeito(true);
    }

    public void marcarErrado(int position) {
        listaPassos.get(position).setFeito(false);
    }

    public int getNumeroPassosFeitos(){
        int count = 0;

        if(listaPassos != null){
            for (Tarefas t: listaPassos) {
                if(t.feito){
                    count++;
                }
            }
        }
        return count;
    }


    public void incrementarPassosFeitos(){
        PassosFeitos++;
    }
    public void decrementarPassosFeitos(){
        PassosFeitos--;
    }


    public int getPassosFeitos()  {
        return PassosFeitos;
    }

}
