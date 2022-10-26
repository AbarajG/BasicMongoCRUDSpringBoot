package com.MongoCrud.Main.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//Mediante la notacion Data, nos ahorramos escribir los getter, setter, toString
//y contructores
@Document(collection = "Usuarios")
//Con lla notacion Document asignamos la collection o base de datos de mongo
//para poder interactuar con ella
public class Usuarios {

    @Id
    //Mediante la notacion id, asignamos el valor como es en la base de datos
    private Long id;
    private String nombre;
    private String email;
    
}
