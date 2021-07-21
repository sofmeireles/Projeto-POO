/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class InicilizarObjeto {

    // Estudante e = new Estudante();
    // MembroEfetivo m = new MembroEfetivo();
    CISUC c = new CISUC();
    ArrayList<Estudante> estudantes = new ArrayList<>();
    ArrayList<MembroEfetivo> efetivos = new ArrayList<>();
    ArrayList<Investigadores> investigadores = new ArrayList<>();
    ArrayList<GrupoInvestigacao> grupos = new ArrayList<>();
    ArrayList<Publicacao> publicacoes = new ArrayList<>();

    public void verificaObj() throws IOException, ClassNotFoundException {

        try {
            File f = new File("ficheiroInvestigadoresObj.obj");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if(f.exists() == true){
            ArrayList<Investigadores> investigadoresObj = (ArrayList<Investigadores>) ois.readObject();
            for (Investigadores i : investigadoresObj) {
                investigadores.add(i);
            }

            ois.close();}
            System.out.println("<O ficheiro de objetos já existe.>\n<A carregar os dados a partir do ficheiro...>");

        } catch (FileNotFoundException ex) {
            criaInvestigadores();
            criaInvestigadorObj();
            System.out.println("<O ficheiro de objetos Investigadores ainda não foi criado.\n<A carregar os dados a partir do ficheiro de texto...>");
        }

        try {
            File f = new File("ficheiroGruposObj.obj");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<GrupoInvestigacao> gruposObj = (ArrayList<GrupoInvestigacao>) ois.readObject();
            for (GrupoInvestigacao g : gruposObj) {
                grupos.add(g);
            }
            ois.close();
            System.out.println("<O ficheiro de objetos já existe.>\n<A carregar os dados a partir do ficheiro...>");

        } catch (FileNotFoundException ex) {
            criaGruposInvestigacao();
            criaGruposInvestigacaoObj();
            System.out.println("<O ficheiro de objetos Grupos ainda não foi criado.\n<A carregar os dados a partir do ficheiro de texto...>");
        }

        try {
            File f = new File("ficheiroPublicacoesObj.obj");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<GrupoInvestigacao> gruposObj = (ArrayList<GrupoInvestigacao>) ois.readObject();
            for (GrupoInvestigacao g : gruposObj) {
                grupos.add(g);
            }

            ois.close();
            System.out.println("<O ficheiro de objetos já existe.>\n<A carregar os dados a partir do ficheiro...>");

        } catch (FileNotFoundException ex) {
            criaPublicacoes();
            criaPublicacoesObj();
            System.out.println("<O ficheiro de objetos Publicacoes ainda não foi criado.\n<A carregar os dados a partir do ficheiro de texto...>");
        }

    }

    public void criaInvestigadores() throws FileNotFoundException, IOException {

        File f = new File("Investigadores-editado.txt");
        try (FileReader fr = new FileReader(f)) {
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] args = null;
            while ((line = br.readLine()) != null) {

                args = line.split(",");
                if (args[0].equals("ME")) {
                    int nGab = Integer.parseInt(args[4]);
                    int nTel = Integer.parseInt(args[5]);

                    efetivos.add(new MembroEfetivo(args[1], args[2], args[3], nGab, nTel));
                    investigadores.add(new MembroEfetivo(args[1], args[2], args[3], nGab, nTel));
                }

            }
            br.close();

        } catch (FileNotFoundException ex) {
            System.out.println("<Erro ao abrir o ficheiro>");
        } catch (IOException ex) {
            System.out.println("<Erro ao ler o ficheiro");
        }

        /*  for (MembroEfetivo m : efetivos) {
            System.out.println(m);
        }*/
        System.out.println(efetivos.size());

        try (FileReader fr = new FileReader(f)) {
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] args = null;
            while ((line = br.readLine()) != null) {

                args = line.split(",");

                if (args[0].equals("E")) {
                    String[] d = args[5].split("/");
                    Data data = new Data(d[0], d[1], d[2]);
                    MembroEfetivo m = new MembroEfetivo();

                    for (MembroEfetivo e : efetivos) {

                        if (e.nome.equals(args[6])) {
                            if (e.grupoDeInvestigacao.equals(args[3])) {
                                estudantes.add(new Estudante(args[1], args[2], args[3], args[4], data, e));
                                investigadores.add(new Estudante(args[1], args[2], args[3], args[4], data, e));
                            } else {
                                System.out.println("<Erro: O Investigador orientador não pertence ao mesmo grupo que o estudante>");
                                System.exit(1);
                            }
                        }
                    }

                }

            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("<Erro ao abrir o ficheiro>");
        } catch (IOException ex) {
            System.out.println("<Erro ao ler o ficheiro");
        }

        /* for (Estudante e : estudantes) {
            System.out.println(e);
        }*/
        System.out.println(estudantes.size());
        c.informacoes(investigadores);

    }

    public void criaGruposInvestigacao() throws FileNotFoundException, IOException {

        try (FileReader fr = new FileReader("Grupos-editado.txt")) {
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] args = null;
            while ((line = br.readLine()) != null) {
                ArrayList<Investigadores> investigadoresGrupo = new ArrayList<>();
                boolean confirma = false;
                String[] l = line.split(",");
                for (MembroEfetivo e : efetivos) {
                    String[] nomes = l[3].split("\\+");

                    if (e.getNome().equals(l[2])) {
                        confirma = true;
                        for (Investigadores i : investigadores) {
                            for (int j = 0; j < nomes.length; j++) {
                                if (i.getNome().equals(nomes[j])) {

                                    investigadoresGrupo.add(i);
                                }
                            }
                        }
                        GrupoInvestigacao g = new GrupoInvestigacao(l[0], l[1], e, investigadoresGrupo);

                        grupos.add(g);
                    }
                }
                if (confirma == false) {
                    System.out.println("ERRO");
                    System.exit(1);
                }
            }

            br.close();

        } catch (FileNotFoundException ex) {
            System.out.println("<Erro ao abrir o ficheiro>");
        } catch (IOException ex) {
            System.out.println("<Erro ao ler o ficheiro");
        }

        /*  for (GrupoInvestigacao g : grupos) {
            System.out.println(g);
            System.out.print("\n");
        }
        System.out.println(grupos.size());*/
    }

    public void criaPublicacoes() throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader("pubCop.txt")) {
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] args = null;
            while ((line = br.readLine()) != null) {

                args = line.split(",");
                if (args[0].equals("AC")) {
                    ArrayList<Investigadores> autoresArtigo = new ArrayList<Investigadores>();
                    String tipo = "Artigo de Conferência";
                    int ano = Integer.parseInt(args[5]);
                    int dimensao = Integer.parseInt(args[6]);
                    String[] d = args[8].split("/");
                    Data data = new Data(d[0], d[1], d[2]);
                    String palavras = args[3].replace("-", ", ");
                    String[] autores = args[1].split("\\+");
                    for (Investigadores i : investigadores) {
                        for (int j = 0; j < autores.length; j++) {
                            if (i.getNome().equals(autores[j])) {
                                autoresArtigo.add(i);

                            }
                        }
                    }
                    publicacoes.add(new ArtigoConferencia(tipo, autoresArtigo, args[2], palavras, args[4], ano, dimensao, args[7], data, args[9]));
                }
                if (args[0].equals("AR")) {
                    String tipo = "Artigo de revista";
                    ArrayList<Investigadores> autoresArtigo = new ArrayList<Investigadores>();

                    int ano = Integer.parseInt(args[6]);
                    int dimensao = Integer.parseInt(args[5]);
                    String[] d = args[8].split("/");
                    Data data = new Data(d[0], d[1], d[2]);
                    String palavras = args[3].replace("-", ", ");
                    String[] autores = args[1].split("\\+");
                    for (Investigadores i : investigadores) {
                        for (int j = 0; j < autores.length; j++) {
                            if (i.getNome().equals(autores[j])) {
                                autoresArtigo.add(i);

                            }
                        }
                    }
                    publicacoes.add(new ArtigoConferencia(tipo, autoresArtigo, args[2], palavras, args[4], dimensao, ano, args[7], data, args[9]));
                }

                if (args[0].equals("L")) {

                    ArrayList<Investigadores> autoresCap = new ArrayList<>();

                    String tipo = "Livro";
                    int ano = Integer.parseInt(args[5]);
                    int dimensao = Integer.parseInt(args[6]);

                    String palavras = args[3].replace("-", ", ");
                    String[] autores = args[1].split("\\+");
                    for (Investigadores i : investigadores) {

                        for (int j = 0; j < autores.length; j++) {

                            if (i.getNome().equals(autores[j])) {
                                autoresCap.add(i);

                            }

                        }
                    }
                    publicacoes.add(new Livro(tipo, autoresCap, args[2], palavras, args[4], ano, dimensao, args[7], args[8]));

                }

                if (args[0].equals("CAP")) {

                    ArrayList<Investigadores> autoresCap = new ArrayList<>();

                    String tipo = "Capítulo de Livro";
                    int ano = Integer.parseInt(args[5]);
                    int dimensao = Integer.parseInt(args[6]);
                    int pInicio = Integer.parseInt(args[10]);
                    int pFim = Integer.parseInt(args[11]);
                    String palavras = args[3].replace("-", ", ");
                    String[] autores = args[1].split("\\+");
                    for (Investigadores i : investigadores) {

                        for (int j = 0; j < autores.length; j++) {

                            if (i.getNome().equals(autores[j])) {
                                autoresCap.add(i);

                            }

                        }
                    }
                    publicacoes.add(new CapituloLivro(tipo, autoresCap, args[2], palavras, args[4], ano, dimensao, args[7], args[8], args[9], pInicio, pFim));
                }

                if (args[0].equals("LAC")) {

                    ArrayList<Investigadores> autoresCap = new ArrayList<>();

                    String tipo = "Livro de Artigos de Conferência";
                    int ano = Integer.parseInt(args[5]);
                    int dimensao = Integer.parseInt(args[6]);
                    int nArtigos = Integer.parseInt(args[10]);

                    String palavras = args[3].replace("-", ", ");
                    String[] autores = args[1].split("\\+");
                    for (Investigadores i : investigadores) {

                        for (int j = 0; j < autores.length; j++) {

                            if (i.getNome().equals(autores[j])) {
                                autoresCap.add(i);

                            }

                        }
                    }
                    publicacoes.add(new LivroArtigoConferencia(tipo, autoresCap, args[2], palavras, args[4], ano, dimensao, args[7], args[8], args[9], nArtigos));
                }

            }

            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("<Erro ao abrir o ficheiro>");
        } catch (IOException ex) {
            System.out.println("<Erro ao ler o ficheiro");
        }

        /*  for (Publicacao p : publicacoes) {
            System.out.println(p);

        }*/
        System.out.println(publicacoes.size());

    }

    public void criaInvestigadorObj() {
        File f = new File("ficheiroInvestigadoresObj.obj");
        try {
            FileOutputStream fos = new FileOutputStream(f); // writing data to a File
            ObjectOutputStream oos = new ObjectOutputStream(fos);//Permitir a conversão de um objeto para uma série de bytes
            for(Investigadores a : investigadores){
                System.out.println(a);
            }
            oos.writeObject(investigadores); //escreve o objeto
            System.out.println("DEUUUUU");
            oos.close(); //fecha

        } catch (FileNotFoundException ex) {
            System.out.println("<Erro a abrir o ficheiro " + f + ">");
        } catch (IOException ex) {
            System.out.println("<Erro>");
        }
    }

    public void criaGruposInvestigacaoObj() {

        File f = new File("ficheiroGruposObj.obj");
        try {

            FileOutputStream fos = new FileOutputStream(f); // writing data to a File
            ObjectOutputStream oos = new ObjectOutputStream(fos); //Permitir a conversão de um objeto para uma série de bytes

            oos.writeObject(grupos); //escreve o objeto

            oos.close(); //fecha

        } catch (FileNotFoundException ex) {
            System.out.println("<Erro a abrir o ficheiro " + f + ">");
        } catch (IOException ex) {
            System.out.println("<Erro>");
        }
    }

    public void criaPublicacoesObj() {

        File f = new File("ficheiroublicacoesPObj.obj");
        try {

            FileOutputStream fos = new FileOutputStream(f); // writing data to a File
            ObjectOutputStream oos = new ObjectOutputStream(fos); //Permitir a conversão de um objeto para uma série de bytes

            oos.writeObject(publicacoes); //escreve o objeto

            oos.close(); //fecha

        } catch (FileNotFoundException ex) {
            System.out.println("<Erro a abrir o ficheiro " + f + ">");
        } catch (IOException ex) {
            System.out.println("<Erro>");
        }
    }

}
