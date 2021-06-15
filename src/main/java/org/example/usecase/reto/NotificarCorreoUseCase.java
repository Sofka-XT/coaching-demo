package org.example.usecase.reto;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.domain.coaching.reto.events.AprendizAsociado;

public class NotificarCorreoUseCase  extends UseCase<TriggeredEvent<AprendizAsociado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AprendizAsociado> aprendizAsociadoTriggeredEvent) {
        var event = aprendizAsociadoTriggeredEvent.getDomainEvent();
        var coachService = getService(CoachService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();

        var email = coachService.getEmailByCoachId(event.getCoachId());
        sender.sendEmail(email, "Content body");
    }
}
