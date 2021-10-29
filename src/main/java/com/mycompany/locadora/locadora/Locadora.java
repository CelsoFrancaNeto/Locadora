package com.mycompany.locadora.locadora;

import com.mycompany.locadora.arquivos.ArquivoTexto;
import java.util.ArrayList;

/**
 *
 * @author Luan Felipe Santos Alves RA: 20203020891
 */
public class Locadora {

    private ArrayList<Filmes> catalogo;

    public Locadora() {
        this.catalogo = new ArrayList();
        initFilmeList();
    }

    public ArrayList<Filmes> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Filmes> catalogo) {
        this.catalogo = catalogo;
    }

    public void buscarFilme(String nome) {
        for (Filmes x : catalogo) {
            if (x.getNome().equals(nome)) {
                System.out.println("\nFilme: " + x.getNome() + "\nCategoria: " + x.getCategoria() + "\nAlugado: " + x.isEstado());
            } else {
                System.out.println("\nNão temos esse filme no catálogo.");
            }
        }
    }

    public void initFilmeList() {
        ArrayList<String> conteudo = ArquivoTexto.reader();

        for (int i = 0; i < conteudo.size(); i++) {
            Filmes filme = new Filmes(conteudo.get(i).split(";")[0], conteudo.get(i).split(";")[1], conteudo.get(i).split(";")[2],Boolean.valueOf(conteudo.get(i).split(";")[3]));
            inserirFilme(filme);
        }
    }

    /*
        Para alugar podemos receber o nome e o contato de quem alugou
        settar isso junto com o filme, mas nesse caso teriamos de ca-
        dastrar os clientes. 
     */
    public void alugarFilme(String nome) {
        for (Filmes x : catalogo) {
            if (x.getNome().equals(nome)) {
                if (x.isEstado() == true) {
                    System.out.println("\nFilme já alugado.");
                } else {
                    x.setEstado(true);
                    System.out.println("Filme alugado com sucesso.");
                }

            } else {
                System.out.println("\nNão temos esse filme no catálogo.");
            }
        }
    }

    /*
        De duas opções podemos fazer passando o filme como parâmetro,
        ou criando o filme através das informações separadas.
     */

    public void inserirFilme(Filmes filme) {
        Filmes aux = new Filmes(filme.getNome(),filme.getCategoria(),filme.getPreco(),filme.isEstado());
        catalogo.add(aux);
    }

    public void removerFilme(Filmes filme) {
        for (Filmes x : catalogo) {
            if (x.getNome().equals(filme.getNome())) {//caso o nome do objeto seja o msm do filme
                catalogo.remove(x);
                break; //sair do loop
            }
        }
    }
}
