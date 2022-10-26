package com.MongoCrud.Main.repository;

import com.MongoCrud.Main.documents.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

//Es necesario crear una interface y implementar mediante el metodo que se necesite
//utilizando aqui mongo debe se utiliza su libreria MongoRepository
//Importando la clase Usuarios y el tipo de dato que esta el id para
//utilizarlo en el controlador
public interface UsuariosRepo extends MongoRepository<Usuarios, Long>{

}
