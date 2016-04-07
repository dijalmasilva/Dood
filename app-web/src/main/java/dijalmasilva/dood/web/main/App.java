/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.dood.web.main;

import dijalmasilva.dac.shared.entidades.Usuario;
import dijalmasilva.dac.shared.interfaces.ConviteService;
import dijalmasilva.dac.shared.interfaces.DoodService;
import dijalmasilva.dac.shared.interfaces.UserService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@SpringBootApplication
@Controller
public class App {

    @Inject
    private UserService userService;
    
    @Inject
    private DoodService doodService;
    
    @Inject
    private ConviteService conviteService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("")
    public String index(HttpServletRequest req) {
        Usuario usuario = userService.find("dijalma");
        req.setAttribute("usuario", usuario);
        return "index";
    }
}
