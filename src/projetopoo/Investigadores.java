/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;

public class Investigadores implements Serializable{
    protected String nome;
    protected String email;
    protected String grupoDeInvestigacao;

    public Investigadores() {
    }

    public Investigadores(String nome, String email, String grupoDeInvestigacao) {
        this.nome = nome;
        this.email = email;
        this.grupoDeInvestigacao = grupoDeInvestigacao;
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
        return "Investigadores{" + "nome=" + nome + ", email=" + email + ", grupoDeInvestigaca=" + grupoDeInvestigacao + '}';
    }
   
    
    
}
