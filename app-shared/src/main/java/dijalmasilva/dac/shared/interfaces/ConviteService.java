package dijalmasilva.dac.shared.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dijalmasilva.dac.shared.entidades.Administrador;
import dijalmasilva.dac.shared.entidades.Convite;
import javax.ejb.Remote;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Remote
public interface ConviteService {

    public boolean solicitaConvite(Convite convite);
    
    public boolean aceitaConvite(Convite convite, Administrador admin);
    
    public boolean recusaConvite(Convite convite, Administrador admin);
    
    public boolean apagaConvite(Convite convite);
}
