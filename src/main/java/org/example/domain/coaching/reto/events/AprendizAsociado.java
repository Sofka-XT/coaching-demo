package org.example.domain.coaching.reto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.coaching.aprendiz.values.AprendizId;
import org.example.domain.coaching.reto.values.CoachId;

public class AprendizAsociado extends DomainEvent {
    private final AprendizId aprendizId;
    private final CoachId coachId;

    public AprendizAsociado(AprendizId aprendizId, CoachId coachId) {
        super("coaching.reto.aprendizasociado");
        this.aprendizId = aprendizId;
        this.coachId = coachId;
    }

    public AprendizId getAprendizId() {
        return aprendizId;
    }

    public CoachId getCoachId() {
        return coachId;
    }
}
