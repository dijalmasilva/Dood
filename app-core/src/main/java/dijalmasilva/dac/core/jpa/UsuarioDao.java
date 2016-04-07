/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.core.jpa;

import dijalmasilva.dac.shared.entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Stateless
public class UsuarioDao {

    @PersistenceContext(unitName = "Rede_Dood")
    private EntityManager em;

    public boolean save(Usuario u) {
        try {
            em.persist(u);
            System.out.println("Usuario persistido!");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Usuario não persistido!");
            return false;
        }
    }

    public Usuario login(String email, String senha) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
            Root<Usuario> from = criteria.from(Usuario.class);
            Predicate equalEmail = builder.equal(from.get("email"), email);
            Predicate equalSenha = builder.equal(from.get("senha"), senha);
            CriteriaQuery<Usuario> consulta = criteria.select(from).where(equalEmail, equalSenha);
            TypedQuery<Usuario> query = em.createQuery(consulta);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
            System.out.println("Não achou nenhum!");
            return null;
        }
    }

    public boolean update(Usuario u) {
        try {
            em.merge(u);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Usuario find(String email) {
        try {
            return em.find(Usuario.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
