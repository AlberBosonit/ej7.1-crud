package com.example.ej7.crud.Services;

import com.example.ej7.crud.Entities.Persona;
import com.example.ej7.crud.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void addPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Persona modifyPersona(Persona persona) {
        //Optional<Persona> p = personaRepository.findById(persona.getId());
        personaRepository.save(persona);
        return persona;
    }

    @Override
    public void deletePersona(Long id) {
        try {
            personaRepository.deleteById(id);
        }catch (EmptyResultDataAccessException exc){
            System.out.println("No existe una persona con el id: "+id);
        }
    }

    @Override
    public Persona getPersonaById(Long id) throws FileNotFoundException {
        return personaRepository.findById(id).orElseThrow( () -> new FileNotFoundException("Persona no encontrada"));
    }

    @Override
    public List<Persona> getPersonaByName(String nombre) {
        List<Persona> personasRepository = (List<Persona>) personaRepository.findAll();
        if(personasRepository.isEmpty())
            return null;
        Stream<Persona> personaStream = personasRepository.stream();
        List<Persona> personasConEseNombre;
        personasConEseNombre = personaStream.filter(person -> person.getNombre().equals(nombre)).toList();

        return personasConEseNombre;
    }
}
