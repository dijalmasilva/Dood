/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.shared.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
public class Dood implements Serializable {

    private static final long serialVersionUID = 9125277018717732778L;
    
    @Id
    @Column(length = 60)
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @OneToOne
    @Basic(fetch = FetchType.LAZY)
    private Professor dono;

    public Dood() {
    }

    public Dood(String nome, String descricao, Professor dono) {
        this.nome = nome;
        this.descricao = descricao;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getDono() {
        return dono;
    }

    public void setDono(Professor dono) {
        this.dono = dono;
    }

}
