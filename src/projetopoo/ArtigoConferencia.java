/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;
import java.util.ArrayList;

public class ArtigoConferencia extends Publicacao implements Serializable{
    private String nomeConferencia;
    private String localizacaoConferencia;
    private Data dataConferencia;

    public ArtigoConferencia(String tipoPublicacao,ArrayList<Investigadores> listaAutores, String titulo, String palavrasChave, String resumo, int anoPublicacao, int dimensaoAudiencia,String nomeConferencia,Data dataConferencia,String localizacaoConferencia) {
        super(tipoPublicacao, listaAutores, titulo, palavrasChave, resumo, anoPublicacao, dimensaoAudiencia);
        this.nomeConferencia = nomeConferencia;
        this.localizacaoConferencia = localizacaoConferencia;
        this.dataConferencia = dataConferencia;
    }

    
    public ArtigoConferencia() {
    }

    public String getNomeConferencia() {
        return nomeConferencia;
    }

    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }

    public String getLocalizacaoConferencia() {
        return localizacaoConferencia;
    }

    public void setLocalizacaoConferencia(String localizacaoConferencia) {
        this.localizacaoConferencia = localizacaoConferencia;
    }

    public Data getDataConferencia() {
        return dataConferencia;
    }

    public void setDataConferencia(Data dataConferencia) {
        this.dataConferencia = dataConferencia;
    }
    
    @Override
     public String setFatorDeImpacto(String dimensao) {
       
        int tipo = Integer.parseInt(dimensao);
        String fator = "";
        if(tipo>=500){
            fator.equals("A");
        }
        if(200<=tipo && tipo<500){
            fator.equals("B");}
        
        if(200>tipo){
            fator.equals("C");}
        return fator;
    }

    @Override
    public String toString() {
        return super.toString() +", " + nomeConferencia + ", " + localizacaoConferencia + ", " + dataConferencia;
    }

    



}
