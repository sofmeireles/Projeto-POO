/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LivroArtigoConferencia extends Livro implements Serializable{
    private String nomeConferencia;
    private int numeroArtigos;

    public LivroArtigoConferencia(String tipoPublicacao, ArrayList<Investigadores> listaAutores, String titulo, String palavrasChave, String resumo, int anoPublicacao, int dimensaoAudiencia, String editora, String ISBN,String nomeConferencia, int numeroArtigos) {
        super(tipoPublicacao, listaAutores, titulo, palavrasChave, resumo, anoPublicacao, dimensaoAudiencia, editora, ISBN);
        this.nomeConferencia = nomeConferencia;
        this.numeroArtigos = numeroArtigos;
    }
 
    public LivroArtigoConferencia() {
    }

    public String getNomeConferencia() {
        return nomeConferencia;
    }

    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }

    public int getNumeroArtigos() {
        return numeroArtigos;
    }

    public void setNumeroArtigos(int numeroArtigos) {
        this.numeroArtigos = numeroArtigos;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + nomeConferencia + ", " + numeroArtigos;
    }
    
    @Override
      public String setFatorDeImpacto(String dimensao) {
        int tipo = Integer.parseInt(dimensao);
        String fator = "";
        if(tipo>=2500){
            fator.equals("A");
        }
        if(2500<=tipo && tipo<7500){
            fator.equals("B");}
        
        if(2500>tipo){
            fator.equals("C");}
        return fator;
    }
    
}
