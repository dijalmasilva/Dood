package dijalmasilva.dac.shared.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dijalmasilva.dac.shared.entidades.Dood;
import javax.ejb.Remote;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Remote
public interface DoodService {

    public boolean save(Dood dood);

    public Dood find(String nome);

    public boolean update(Dood dood);
}
