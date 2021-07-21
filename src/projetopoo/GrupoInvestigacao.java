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

public class GrupoInvestigacao implements Serializable {
    private String nome;
    private String acronimo;
    private MembroEfetivo membroEfetivo;
    private ArrayList<Investigadores> listaInvestigadores = new ArrayList<>();

    public GrupoInvestigacao() {
    }

    
    public GrupoInvestigacao(String nome, String acronimo, MembroEfetivo membroEfetivo,ArrayList<Investigadores> listaInvestigadores) {
        this.nome = nome;
        this.acronimo = acronimo;
        this.membroEfetivo = membroEfetivo;
        this.listaInvestigadores = listaInvestigadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public MembroEfetivo getMembroEfetivo() {
        return membroEfetivo;
    }

    public void setMembroEfetivo(MembroEfetivo membroEfetivo) {
        this.membroEfetivo = membroEfetivo;
    }

    public ArrayList<Investigadores> getListaInvestigadores() {
        return listaInvestigadores;
    }

    public void setListaInvestigadores(ArrayList<Investigadores> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }
    
    public String displayLista(){
        String nomes = "";
        for(Investigadores i : listaInvestigadores){
            nomes += "\n" + i.nome;}
    return nomes;}
    
    @Override
    public String toString() {
        return nome + ", " + acronimo + ", " + membroEfetivo.nome + displayLista();
    }


}

