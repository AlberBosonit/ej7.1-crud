package com.example.ej7.crud.Services;

import com.example.ej7.crud.Entities.Persona;
import java.io.FileNotFoundException;
import java.util.List;

public interface PersonaService {
    void addPersona(Persona persona);
    Persona modifyPersona(Persona persona);
    void deletePersona(Long id);
    Persona getPersonaById(Long id) throws FileNotFoundException;
    List<Persona> getPersonaByName(String nombre) throws FileNotFoundException;
}
