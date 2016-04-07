/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.shared.entidades;

import dijalmasilva.dac.shared.enums.ContaStatus;
import dijalmasilva.dac.shared.enums.TypeSexo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value = "Usuario")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 9125277018717732648L;

    @Id
    @Column(length = 100)
    private String email;
    @Column(length = 30)
    private String nome;
    @Column(length = 30)
    private String sobrenome;
    @Column(length = 30)
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TypeSexo sexo;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private ContaStatus status;
    @ManyToMany
    private List<Usuario> seguindo;
    @ManyToMany
    private List<Dood> doods;

    public Usuario() {
        this.seguindo = new ArrayList<Usuario>();
        this.doods = new ArrayList<Dood>();
    }

    public Usuario(String email, String nome, String sobrenome, String senha, TypeSexo sexo, LocalDate dataNascimento) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.seguindo = new ArrayList<Usuario>();
        this.doods = new ArrayList<Dood>();
        this.status = ContaStatus.ATIVADA;
    }

    public Usuario(String email, String nome, String sobrenome, String senha, TypeSexo sexo, LocalDate dataNascimento, ContaStatus status, List<Usuario> seguindo, List<Dood> doods) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.seguindo = seguindo;
        this.doods = doods;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TypeSexo getSexo() {
        return sexo;
    }

    public void setSexo(TypeSexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ContaStatus getStatus() {
        return status;
    }

    public void setStatus(ContaStatus status) {
        this.status = status;
    }

    public void seguir(Usuario u) {
        this.seguindo.add(u);
    }

    public void deixarDeSeguir(Usuario u) {
        this.seguindo.remove(u);
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(List<Usuario> seguindo) {
        this.seguindo = seguindo;
    }

    public void seguirDood(Dood dood) {
        this.doods.add(dood);
    }

    public void deixarDeSeguir(Dood dood) {
        this.doods.remove(dood);
    }

    public List<Dood> getDoods() {
        return doods;
    }

    public void setDoods(List<Dood> doods) {
        this.doods = doods;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", senha=" + senha + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", status=" + status + '}';
    }
}
