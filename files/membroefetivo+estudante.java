    public void criaMembroEfetivo() throws FileNotFoundException, IOException {

        try (FileReader fr = new FileReader("Investigadores-editado.txt")) {
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
    }

    public void criaEstudante() throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader("Investigadores-COPIA.txt")) {
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

    }
