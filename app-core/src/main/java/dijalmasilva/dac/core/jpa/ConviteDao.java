/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.core.jpa;

import dijalmasilva.dac.shared.entidades.Convite;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Stateless
public class ConviteDao{

    @PersistenceContext(unitName = "Rede_Dood")
    private EntityManager em;

    public boolean solicita(Convite convite) {
        try {
            em.persist(convite);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean apagaConvite(Convite c) {
        try {
            em.remove(em.merge(c));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Convite find(String email) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Convite> criteria = builder.createQuery(Convite.class);
            Root<Convite> from = criteria.from(Convite.class);
            builder.equal(from.get("nome"), email);
            CriteriaQuery<Convite> consulta = criteria.select(from);
            TypedQuery<Convite> query = em.createQuery(consulta);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Convite c) {
        try {
            em.merge(c);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
