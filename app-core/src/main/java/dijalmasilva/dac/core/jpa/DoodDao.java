/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.core.jpa;

import dijalmasilva.dac.shared.entidades.Dood;
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
public class DoodDao {

    @PersistenceContext(unitName = "Rede_Dood")
    private EntityManager em;

    public boolean save(Dood dood) {
        try {
            em.persist(dood);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Dood find(String nome) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Dood> criteria = builder.createQuery(Dood.class);
            Root<Dood> from = criteria.from(Dood.class);
            builder.equal(from.get("nome"), nome);
            CriteriaQuery<Dood> consulta = criteria.select(from);
            TypedQuery<Dood> query = em.createQuery(consulta);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Dood dood) {
        try {
            em.merge(dood);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
