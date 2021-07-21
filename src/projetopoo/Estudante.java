/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;

public class Estudante extends Investigadores implements Serializable {

    private String tituloTese;
    private Data data; //Sq mudar a classe p uma Data
    private MembroEfetivo investigadorOrientador; //classe membroEfetivo!!!
    // tem de pertencer ao mm grupo de investigacao!!!

    public Estudante() {
    }

    public Estudante(String nome, String email, String grupoDeInvestigacao,String tituloTese, Data data, MembroEfetivo investigadorOrientador) {
        super(nome, email, grupoDeInvestigacao);
        this.tituloTese = tituloTese;
        this.data = data;
        this.investigadorOrientador = investigadorOrientador;
    }

    public String getTituloTese() {
        return tituloTese;
    }

    public void setTituloTese(String tituloTese) {
        this.tituloTese = tituloTese;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public MembroEfetivo getInvestigadorOrientador() {
        return investigadorOrientador;
    }

    public void setInvestigadorOrientador(MembroEfetivo investigadorOrientador) {
        this.investigadorOrientador = investigadorOrientador;
    }

    @Override
    public String toString() {
        return super.toString() + ", \"" + tituloTese + "\", " + data + ", " + investigadorOrientador;
    }
    
}
