package com.example.ej7.crud.Controllers;

import com.example.ej7.crud.Entities.Persona;
import com.example.ej7.crud.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/persona")
public class ControllerGet {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public Persona mostrarPersonaPorId(@PathVariable("id") Long id) {
        Persona persona = null;
            try {
                persona = personaService.getPersonaById(id); //Si la persona no existe se lanza excepcion
            } catch (FileNotFoundException personaNoEncontrada) {
                System.out.println("No se ha encontrado la persona con este id: " + id);
            }
        return persona;
    }
    @GetMapping("/nombre/{nombre}")
    public List<Persona> mostrarPersonaPorNombre(@PathVariable("nombre") String nombre) {
        List<Persona> listaPersonas = null;
        listaPersonas = personaService.getPersonaByName(nombre); //Si no hay personas con ese nombre, se lanza excepcion
        return listaPersonas;
    }
}

