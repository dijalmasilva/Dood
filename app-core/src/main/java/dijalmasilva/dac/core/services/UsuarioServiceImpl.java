/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dac.core.services;

import dijalmasilva.dac.core.jpa.UsuarioDao;
import dijalmasilva.dac.shared.entidades.Usuario;
import dijalmasilva.dac.shared.interfaces.UserService;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Stateless
@Remote(UserService.class)
public class UsuarioServiceImpl implements UserService {

    @EJB
    private UsuarioDao dao;

    @Override
    public boolean save(Usuario u) {
        return dao.save(u);
    }

    @Override
    public boolean update(Usuario u) {
        return dao.update(u);
    }

    @Override
    public Usuario find(String email) {
        return dao.find(email);
    }

    @Override
    public boolean delete(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateStatus(String email, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario login(String email, String senha) {
        return dao.login(email, senha);
    }

}
