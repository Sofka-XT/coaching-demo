package org.example.usecase.reto;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.coaching.reto.Reto;
import org.example.domain.coaching.reto.commands.CrearReto;

public class CrearRetoUseCase extends UseCase<RequestCommand<CrearReto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearReto> crearRetoRequestCommand) {
        var command = crearRetoRequestCommand.getCommand();
        var reto = new Reto(command.getId(), command.getDescripcion(), command.getContenido());
        //aqui: reglas de negocio ...
        emit().onResponse(new ResponseEvents(reto.getUncommittedChanges()));
    }
}
