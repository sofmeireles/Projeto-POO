/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.util.ArrayList;


public class Livro extends Publicacao {
    protected String editora;
    protected String ISBN;

    public Livro() {}

    public Livro(String tipoPublicacao, ArrayList<Investigadores> listaAutores, String titulo,String palavrasChave, String resumo, int anoPublicacao, int dimensaoAudiencia,String editora, String ISBN) {
        super(tipoPublicacao, listaAutores, titulo, palavrasChave, resumo, anoPublicacao, dimensaoAudiencia);
        this.editora = editora;
        this.ISBN = ISBN;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + editora + ", " + ISBN;
    }

    @Override
    public String setFatorDeImpacto(String dimensao) {
        int tipo = Integer.parseInt(dimensao);
        String fator = "";
        if(tipo>=10000){
            fator.equals("A");
        }
        if(5000<=tipo && tipo<10000){
            fator.equals("B");}
        
        if(5000>tipo){
            fator.equals("C");}
        return fator;
    }
    
    
    
}
