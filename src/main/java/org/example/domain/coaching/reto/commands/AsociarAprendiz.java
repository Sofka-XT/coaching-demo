package org.example.domain.coaching.reto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.coaching.aprendiz.values.AprendizId;
import org.example.domain.coaching.reto.values.RetoId;

public class AsociarAprendiz implements Command {
    private final RetoId id;
    private final AprendizId aprendizId;

    public AsociarAprendiz(RetoId id, AprendizId aprendizId) {
        this.id = id;
        this.aprendizId = aprendizId;
    }

    public RetoId getId() {
        return id;
    }

    public AprendizId getAprendizId() {
        return aprendizId;
    }
}
