package org.example.domain.coaching.reto;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.coaching.aprendiz.values.AprendizId;
import org.example.domain.coaching.reto.events.AprendizAsociado;
import org.example.domain.coaching.reto.events.RetoCreado;
import org.example.domain.coaching.reto.values.*;

import java.util.List;
import java.util.Set;

public class Reto extends AggregateEvent<RetoId> {
    protected CoachId coachId;
    protected Descripcion descripcion;
    protected Contenido contenido;
    protected Set<AprendizId> aprendizIds;

    public Reto(RetoId id, Descripcion descripcion, Contenido contenido) {
        super(id);
        appendChange(new RetoCreado(descripcion, contenido)).apply();
    }

    public Reto(RetoId id) {
        super(id);
        subscribe(new RetoChange(this));
    }

    public static Reto from(RetoId id, List<DomainEvent> retrieveEvents) {
        var reto = new Reto(id);
        retrieveEvents.forEach(reto::applyEvent);
        return reto;
    }


    public void asociarAprendiz(AprendizId aprendizId){
        appendChange(new AprendizAsociado(aprendizId,coachId)).apply();
    }

    public int aprendicesCantidad() {
        return aprendizIds.size();
    }
}
