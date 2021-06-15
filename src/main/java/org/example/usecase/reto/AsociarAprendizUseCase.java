package org.example.usecase.reto;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.coaching.reto.Reto;
import org.example.domain.coaching.reto.commands.AsociarAprendiz;

public class AsociarAprendizUseCase extends UseCase<RequestCommand<AsociarAprendiz>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarAprendiz> asociarAprendizRequestCommand) {
        var command = asociarAprendizRequestCommand.getCommand();
        var reto = Reto.from(command.getId(), retrieveEvents(command.getId().value()));

        if(reto.aprendicesCantidad() >= 12){
            throw new BusinessException(
                    command.getId().value(),
                    "No se puede registrar otro aprendiz en este reto"
            );
        }
        reto.asociarAprendiz(command.getAprendizId());
        emit().onResponse(new ResponseEvents(reto.getUncommittedChanges()));
    }
}
