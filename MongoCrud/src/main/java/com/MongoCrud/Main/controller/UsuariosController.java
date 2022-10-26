package com.MongoCrud.Main.controller;

import com.MongoCrud.Main.documents.Usuarios;
import com.MongoCrud.Main.repository.UsuariosRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/usuarios")
//Con la notacion RequestMapping asignamos la ruta principal para poder realizar
//las acciones del crud, post, put, get, delete
public class UsuariosController {

    @Autowired
    //Mediante el Autowired importaremos la interface UsuarioRepo instanciandola
    private UsuariosRepo usuarioRepo;

    @PostMapping
    //Con la notacion PostMapping nos encargaremos de pedir el usuario ya instanciado con un metodo
    //de almacenamiento   
    public ResponseEntity<?> saveUsuario(@RequestBody Usuarios usuario) {
        //Al asignale un ? al ResponseEntity le diremos que no sabemos que tipo de entidad
        //se obtendra
        try {
            Usuarios usuarioSave = usuarioRepo.save(usuario);
            return new ResponseEntity<Usuarios>(usuarioSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    //Con la notacion GetMapping traeremos una consulta con todos los datos del usuario
    public ResponseEntity<?> findAllUsuarios() {
        try {
            List<Usuarios> usuarioFind = usuarioRepo.findAll();
            return new ResponseEntity<List<Usuarios>>(usuarioFind, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    //Con la notacion PutMapping nos encargaremos de poder actualizar un usuario ya creado
    public ResponseEntity<?> updateUsuario(@RequestBody Usuarios usuario) {
        try {
            Usuarios usuarioSave = usuarioRepo.save(usuario);
            return new ResponseEntity<Usuarios>(usuarioSave, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    //Mediante el DeleteMapping se le asigna en el value el tipo de dato que buscara
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id) {
        //Con PathVariable le pedimos el dato que buscara con su tipo de dato que es
        try {

            usuarioRepo.deleteById(id);
            //Traeremos el objeto usuarioRepo con su metodo de eliminar por un id 
            return new ResponseEntity<String>("Usuario eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
