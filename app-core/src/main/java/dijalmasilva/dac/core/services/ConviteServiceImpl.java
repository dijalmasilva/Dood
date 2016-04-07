/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.core.services;

import dijalmasilva.dac.core.jpa.ConviteDao;
import dijalmasilva.dac.shared.entidades.Administrador;
import dijalmasilva.dac.shared.entidades.Convite;
import dijalmasilva.dac.shared.interfaces.ConviteService;
import javax.ejb.EJB;
import javax.ejb.Remote;

import javax.ejb.Stateless;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Stateless
@Remote(ConviteService.class)
public class ConviteServiceImpl implements ConviteService {

    @EJB
    private ConviteDao dao;
    
    @Override
    public boolean solicitaConvite(Convite convite) {
        return dao.solicita(convite);
    }

    @Override
    public boolean aceitaConvite(Convite convite, Administrador admin) {
        admin.aceitaSolicitacao(convite);
        return apagaConvite(convite);
    }

    @Override
    public boolean recusaConvite(Convite convite, Administrador admin) {
        admin.recusaSolicitacao(convite);
        return apagaConvite(convite);
    }

    @Override
    public boolean apagaConvite(Convite convite) {
        return dao.apagaConvite(convite);
    }

}
