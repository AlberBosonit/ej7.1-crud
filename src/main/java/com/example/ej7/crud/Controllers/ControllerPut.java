package com.example.ej7.crud.Controllers;

import com.example.ej7.crud.Entities.Persona;
import com.example.ej7.crud.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.function.BiConsumer;

@RestController
@RequestMapping(value = "/persona")
public class ControllerPut {

    @Autowired
    private PersonaService personaService;

    @PutMapping("/{id}")
    public void actualizaPersona(@Valid @RequestBody Persona persona, @PathVariable("id") Long id) {

        BiConsumer<Persona, Long> actualizarPersona = (person, ident) -> {
            try {
                personaService.getPersonaById(ident); //Si la persona no existe se lanza excepcion
                personaService.modifyPersona(person); //Si existe, se actualiza. Nota que aquí solo se llega si no ha saltado la excepción
            } catch (FileNotFoundException personaNoEncontrada) {
                System.out.println("No se ha encontrado la persona con este id: " + ident + " y por tanto no se ha podido actualizar");
            }
        };
        actualizarPersona.accept(persona,id);
    }
}
