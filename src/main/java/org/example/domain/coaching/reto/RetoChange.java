package org.example.domain.coaching.reto;

import co.com.sofka.domain.generic.EventChange;
import org.example.domain.coaching.reto.events.AprendizAsociado;
import org.example.domain.coaching.reto.events.RetoCreado;

import java.util.HashSet;
import java.util.Objects;

public class RetoChange extends EventChange {
    public RetoChange(Reto reto) {
        apply((RetoCreado event) ->{
            reto.aprendizIds = new HashSet<>();
            reto.coachId = null;
            reto.contenido = event.getContenido();
            reto.descripcion = event.getDescripcion();
        });

        apply((AprendizAsociado event) -> {
            if(Objects.isNull( reto.coachId)){
               // throw new IllegalArgumentException("No se puede asociar aprendiz si no se tiene un coach");
            }
            reto.aprendizIds.add(event.getAprendizId());
        });
    }
}
