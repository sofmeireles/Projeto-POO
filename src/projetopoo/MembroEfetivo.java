/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;


public class MembroEfetivo extends Investigadores implements Serializable{
    
    protected int numeroGabinete;
    protected int numeroTelefoneDEI;

    public MembroEfetivo() {
      
    }

    public MembroEfetivo(String nome, String email, String grupoDeInvestigacao,int numeroGabinete, int numeroTelefoneDEI) {
        super(nome, email, grupoDeInvestigacao);
        this.numeroGabinete = numeroGabinete;
        this.numeroTelefoneDEI = numeroTelefoneDEI;
    }

    public int getNumeroGabinete() {
        return numeroGabinete;
    }

    public void setNumeroGabinete(int numeroGabinete) {
        this.numeroGabinete = numeroGabinete;
    }

    public int getNumeroTelefoneDEI() {
        return numeroTelefoneDEI;
    }

    public void setNumeroTelefoneDEI(int numeroTelefoneDEI) {
        this.numeroTelefoneDEI = numeroTelefoneDEI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrupoDeInvestigacao() {
        return grupoDeInvestigacao;
    }

    public void setGrupoDeInvestigacao(String grupoDeInvestigacao) {
        this.grupoDeInvestigacao = grupoDeInvestigacao;
    }

    @Override
    public String toString() {
        return super.toString() + "numeroGabinete=" + numeroGabinete + ", numeroTelefoneDEI=" + numeroTelefoneDEI + '}';
    }
    
    
}
