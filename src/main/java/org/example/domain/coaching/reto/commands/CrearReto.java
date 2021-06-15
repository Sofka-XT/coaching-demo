package org.example.domain.coaching.reto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.coaching.reto.values.Contenido;
import org.example.domain.coaching.reto.values.Descripcion;
import org.example.domain.coaching.reto.values.RetoId;

public class CrearReto implements Command {
    private final RetoId id;
    private final Descripcion descripcion;
    private final Contenido contenido;

    public CrearReto(RetoId id, Descripcion descripcion, Contenido contenido){
        this.id = id;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public RetoId getId() {
        return id;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Contenido getContenido() {
        return contenido;
    }
}
