package com.example.ej7.crud.Controllers;

import com.example.ej7.crud.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/persona")
public class ControllerDelete {

    @Autowired
    private PersonaService personaService;

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable("id") Long id) {
        personaService.deletePersona(id);
    }
}
