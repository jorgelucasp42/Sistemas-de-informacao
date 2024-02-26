/*
 Implementação da Classe Cliente com seus repectivos atributos e métodos construtos e toString. 
 */
package questao03;

/**
 *
 * @author jorge
 */
public class Cliente {

    int id;
    private final String nome;
    private final String email;
    private final String cidade;

    public Cliente(int id, String nome, String email, String cidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
    }

   
    @Override
    public String toString() {
        return "Cliente ( " +
               "ID: " + id +
               ", Nome: " + nome +
               ", Email: " + email +
               ", Cidade: " + cidade + 
               " )";
    }


}
