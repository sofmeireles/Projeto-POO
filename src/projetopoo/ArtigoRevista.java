/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;
import java.util.ArrayList;

public class ArtigoRevista extends Publicacao implements Serializable{
   
    private String nomeRevista;
    private int numeroRevista;
    private Data dataRevista;

    public ArtigoRevista() {
    }

    public ArtigoRevista( String tipoPublicacao, ArrayList<Investigadores> listaAutores, String titulo, String palavrasChave, String resumo,int dimensaoAudiencia, int anoPublicacao,String nomeRevista, int numeroRevista, Data dataRevista) {
        super(tipoPublicacao, listaAutores, titulo, palavrasChave, resumo, anoPublicacao, dimensaoAudiencia);
        this.nomeRevista = nomeRevista;
        this.numeroRevista = numeroRevista;
        this.dataRevista = dataRevista;
    }

    public String getNomeRevista() {
        return nomeRevista;
    }

    public void setNomeRevista(String nomeRevista) {
        this.nomeRevista = nomeRevista;
    }

    public int getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(int numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    public Data getDataRevista() {
        return dataRevista;
    }

    public void setDataRevista(Data dataRevista) {
        this.dataRevista = dataRevista;
    }

    @Override
    public String toString() {
        return "ArtigoRevista{" + "nomeRevista=" + nomeRevista + ", numeroRevista=" + numeroRevista + ", dataRevista=" + dataRevista + '}';
    }

    @Override
    public String setFatorDeImpacto(String dimensao) {
        int tipo = Integer.parseInt(dimensao);
        String fator = "";
        if(tipo>=1000){
            fator.equals("A");
        }
        if(500<=tipo && tipo<1000){
            fator.equals("B");}
        
        if(500>tipo){
            fator.equals("C");}
        return fator;
    }

    


}
