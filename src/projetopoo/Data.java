/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.util.Scanner;


public class Data {
     Scanner sc = new Scanner(System.in);
    private String dia;
    private String mes;
    private String ano;

    public Data(String dia, String mes, String ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public String getDia() {
        return dia;
    }

    /*O metodo setDia verifica se o utilizador introduz apenas números num intervalo
     de 1 a 31 */
    
    public void setDia() {

        while (true) {
            System.out.print("Dia: ");
            String dia = sc.next();

        
            try {
                int i = Integer.parseInt(dia); 

                try {
                    if (i >= 1 && i <= 31) {
                        this.dia = dia;
                        break;

                    } else {
                        System.out.println("Erro: insira um dia entre 1 e 31");
                    }

                } catch (NumberFormatException ne) {

                }
            } catch (NumberFormatException ne) {
                System.out.println("Erro: insira um inteiro");
            }
        }
    }

    public String getMes() {
        return mes;
    }

    /*O metodo setMesverifica se o utilizador introduz apenas números num intervalo
     de 1 a 12 */
    public void setMes() {

        while (true) {
            System.out.print("Mês: ");
            String mes = sc.next();

            try {
                int i = Integer.parseInt(mes); //devolve um inteiro

                try {
                    if (i >= 1 && i <= 12) {
                        this.mes = mes;
                        break;

                    } else {
                        System.out.println("Erro: insira um mês entre 1 e 12");
                    }

                } catch (NumberFormatException ne) {

                }
            } catch (NumberFormatException ne) {
                System.out.println("Erro: insira um inteiro");
            }
        }
    }

    public String getAno() {
        return ano;
    }

    /*O metodo setAno verifica se o utilizador introduz apenas um ano válido
      neste caso, decidi ser um ano acima de 2000*/
    public void setAno() {

        while (true) {
            System.out.print("Ano: ");
            String ano = sc.next();

            try {
                int i = Integer.parseInt(ano); 

                try {
                    if (i >= 2000) {
                        this.ano = ano;
                        break;

                    } else {
                        System.out.println("Erro: insira um ano a partir de 2000");
                    }

                } catch (NumberFormatException ne) {

                }
            } catch (NumberFormatException ne) {
                System.out.println("Erro: insira um inteiro");
            }
        }
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
 
}
