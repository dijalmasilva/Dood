package dijalmasilva.dac.shared.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dijalmasilva.dac.shared.entidades.Usuario;
import javax.ejb.Remote;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Remote
public interface UserService {
    
    public boolean save(Usuario u);
    
    public boolean update(Usuario u);
    
    public Usuario find(String email);
    
    public boolean delete(Usuario u);
    
    public boolean updateStatus(String email, String senha);
    
    public Usuario login(String email, String senha);
}
