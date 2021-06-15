package org.example.domain.coaching.reto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.coaching.reto.values.Contenido;
import org.example.domain.coaching.reto.values.Descripcion;


public class RetoCreado extends DomainEvent {
    private final Descripcion descripcion;
    private final Contenido contenido;

    public RetoCreado(Descripcion descripcion, Contenido contenido) {
        super("coaching.reto.retocreado");
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Contenido getContenido() {
        return contenido;
    }
}
