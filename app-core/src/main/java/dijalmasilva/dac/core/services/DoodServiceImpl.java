/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.core.services;

import dijalmasilva.dac.core.jpa.DoodDao;
import dijalmasilva.dac.shared.entidades.Dood;
import dijalmasilva.dac.shared.interfaces.DoodService;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Stateless
@Remote(DoodService.class)
public class DoodServiceImpl implements DoodService {

    @EJB
    private DoodDao dao;
    

    @Override
    public boolean save(Dood dood) {
        return dao.save(dood);
    }

    @Override
    public Dood find(String nome) {
        return dao.find(nome);
    }

    @Override
    public boolean update(Dood dood) {
        return dao.update(dood);
    }

}
