/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.shared.entidades;

import dijalmasilva.dac.shared.enums.ContaStatus;
import dijalmasilva.dac.shared.enums.TypeSexo;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
public class Administrador extends Professor {

    public Administrador(String email, String nome, String sobrenome, String senha, TypeSexo sexo, LocalDate dataNascimento) {
        super(email, nome, sobrenome, senha, sexo, dataNascimento);
    }

    public Administrador(String email, String nome, String sobrenome, String senha, TypeSexo sexo, LocalDate dataNascimento, ContaStatus status, List<Usuario> seguindo, List<Dood> doods) {
        super(email, nome, sobrenome, senha, sexo, dataNascimento, status, seguindo, doods);
    }

    public Administrador() {
    }

    public void aceitaSolicitacao(Convite convite) {
        convite.gerarLink();
        String mensagem = "<h2>Parabéns!</h2>"
                + "<h4>Sua solicitação para ingressar na mais nova rede social acadêmica, Dood, foi aceita.</h4>"
                + "<h4>Para fazer parte agora basta realizar seu cadastro clicando <a href='" + convite.getLink() + "'>aqui</a> .</h4>";
        convite.notify(mensagem);
    }

    public void recusaSolicitacao(Convite convite) {
        String mensagem = "<h2>Que pena!</h2>"
                + "<h4>Sua solicitação para ingressar na mais nova rede social acadêmica, Dood, foi recusada.</h4>"
                + "<h4>Nossa equipe verificou seu convite e constou algo errado.</h4>"
                + "<h4>Mas não fique triste, envie-nos novamente uma solicitação clicando <a href='http://localhost:8080/index'>aqui</a> e"
                + " verifique se a opção de usuário realmente"
                + " condiz com o seu papel na área acadêmica.</h4>";
        convite.notify(mensagem);
    }
}
