/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.util.ArrayList;

/*As publicações
de um grupo de investigação são as publicações em que pelo menos um dos autores é
membro do grupo de investigação. Uma publicação pode conter autores de vários grupos
de investigação.*/
abstract class Publicacao {

    private String resumo;
    protected String tipoPublicacao;
    protected ArrayList<Investigadores> listaAutores = new ArrayList<>(); //ArrayList de autores
    protected String titulo;
    protected String palavrasChave;
    protected int anoPublicacao;
    protected int dimensaoAudiencia; //numero de pessoas que assistiram OU compraram a publicacao

    public Publicacao() {
    }

    public Publicacao(String tipoPublicacao, ArrayList<Investigadores> listaAutores, String titulo, String palavrasChave, String resumo, int anoPublicacao, int dimensaoAudiencia) {
        this.tipoPublicacao = tipoPublicacao;
        this.listaAutores = listaAutores;
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.anoPublicacao = anoPublicacao;
        this.dimensaoAudiencia = dimensaoAudiencia;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(String tipoPublicacao) {

        this.tipoPublicacao = tipoPublicacao;
    }

    public ArrayList<Investigadores> getListaAutores() {
        return listaAutores;
    }

    /**
     *
     * @param tipoPublicacao
     * @return
     */
    public abstract String setFatorDeImpacto(String dimensao);

    public void setListaAutores(ArrayList<Investigadores> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getDimensaoAudiencia() {
        return dimensaoAudiencia;
    }

    public void setDimensaoAudiencia(int dimensaoAudiencia) {
        this.dimensaoAudiencia = dimensaoAudiencia;
    }

    public String displayLista() {
        String nomes = "";
        for (Investigadores i : listaAutores) {
            nomes += i.nome + ", ";
        }
        return nomes;
    }

    @Override
    public String toString() {
        return tipoPublicacao + ", Autores:" + displayLista() + titulo + ", Palavras chave:" + palavrasChave + ", " + resumo + ", " + anoPublicacao + ", " + dimensaoAudiencia;
    }

}
