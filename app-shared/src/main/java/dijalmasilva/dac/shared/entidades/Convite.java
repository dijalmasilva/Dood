/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.shared.entidades;

import dijalmasilva.dac.shared.enums.TypeUser;
import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
public class Convite implements Serializable{

    private static final long serialVersionUID = 9125243018717732648L;
    
    @Id
    @Column(length = 100)
    private String email;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(length = 80)
    private String link;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private TypeUser tipo;

    public Convite() {
    }

    public Convite(String email, String descricao, TypeUser tipo) {
        this.email = email;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public void notify(String mensagem) {
        String titulo = "Resposta para ingressar na Rede Dood";
        ThreadEmail emailThread = new ThreadEmail();
        emailThread.setEmail(email, titulo, mensagem);
        emailThread.start();
    }

    public void gerarLink() {

        String linkGerado = "";

        for (int i = 0; i < 30; i++) {
            int t = new Random().nextInt(2);
            if (t == 1) {
                int caractere = new Random().nextInt(25) + 65;
                linkGerado += (char) caractere;
            } else {
                int caractere = new Random().nextInt(25) + 97;
                linkGerado += (char) caractere;
            }
        }
        this.link = "http://localhost:8080/index/" + tipo.name().toLowerCase() + "?hashCode=" + linkGerado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
