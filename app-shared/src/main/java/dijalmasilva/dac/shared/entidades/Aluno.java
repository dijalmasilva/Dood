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
public class Aluno extends Usuario{

    public Aluno() {
    }

    public Aluno(String email, String nome, String sobrenome, String senha, TypeSexo sexo, LocalDate dataNascimento) {
        super(email, nome, sobrenome, senha, sexo, dataNascimento);
    }

    public Aluno(String email, String nome, String sobrenome, String senha, TypeSexo sexo, LocalDate dataNascimento, ContaStatus status, List<Usuario> seguindo, List<Dood> doods) {
        super(email, nome, sobrenome, senha, sexo, dataNascimento, status, seguindo, doods);
    }

}
