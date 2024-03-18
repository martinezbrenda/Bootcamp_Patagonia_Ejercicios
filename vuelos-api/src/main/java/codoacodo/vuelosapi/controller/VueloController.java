package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.model.Vuelo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    
    @GetMapping
    String HolaMundo(){
        return "Hola Mundo!";
    }
}
