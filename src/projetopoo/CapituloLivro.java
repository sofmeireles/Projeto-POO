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
public class CapituloLivro extends Livro implements Serializable {
    private String nomeCapitulo;
    private int paginaInicio;
    private int paginaFim;

    public CapituloLivro(String tipoPublicacao,ArrayList<Investigadores> listaAutores, String titulo, String palavrasChave, String resumo, int anoPublicacao, int dimensaoAudiencia, String editora, String ISBN,String nomeCapitulo, int paginaInicio, int paginaFim) {
        super(tipoPublicacao, listaAutores, titulo, palavrasChave, resumo, anoPublicacao, dimensaoAudiencia, editora, ISBN);
        this.nomeCapitulo = nomeCapitulo;
        this.paginaInicio = paginaInicio;
        this.paginaFim = paginaFim;
    }

    public CapituloLivro() {
    }

    public String getNomeCapitulo() {
        return nomeCapitulo;
    }

    public void setNomeCapitulo(String nomeCapitulo) {
        this.nomeCapitulo = nomeCapitulo;
    }

    public int getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(int paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public int getPaginaFim() {
        return paginaFim;
    }

    public void setPaginaFim(int paginaFim) {
        this.paginaFim = paginaFim;
    }

    @Override
    public String toString() {
        return super.toString()+", " + nomeCapitulo + ", " + paginaInicio + ", " + paginaFim;
    }

    
    @Override
      public String setFatorDeImpacto(String dimensao) {
        return super.setFatorDeImpacto(dimensao);
    }

}
