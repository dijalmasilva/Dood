/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.dood.web.cdi;

import dijalmasilva.dac.shared.interfaces.ConviteService;
import dijalmasilva.dac.shared.interfaces.DoodService;
import dijalmasilva.dac.shared.interfaces.UserService;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@ApplicationScoped
public class ProducersResource {

    @Produces
    @Resource(lookup = "java:global/dood-core/UsuarioServiceImpl")
    private UserService userService;
    
    @Produces
    @Resource(lookup = "java:global/dood-core/DoodServiceImpl")
    private DoodService doodService;
    
    @Produces
    @Resource(lookup = "java:global/dood-core/ConviteServiceImpl")
    private ConviteService conviteService;
}
