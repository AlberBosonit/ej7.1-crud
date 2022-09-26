package com.example.ej7.crud.Controllers;

import com.example.ej7.crud.Entities.Persona;
import com.example.ej7.crud.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(value="/persona")
public class ControllerPost {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<String> insertPersona(@Valid @RequestBody Persona persona){
        personaService.addPersona(persona);
        return ResponseEntity.ok().body("Persona insertada correctamente.");
    }
    /*
    {
        "nombre":"Alberto",
        "edad":40,
        "poblacion":"Madrid"
     }
    * */
}
