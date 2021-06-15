package org.example.usecase.reto;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.domain.coaching.aprendiz.values.AprendizId;
import org.example.domain.coaching.reto.events.AprendizAsociado;
import org.example.domain.coaching.reto.values.CoachId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NotificarCorreoUseCaseTest {
    private NotificarCorreoUseCase notificarCorreoUseCase;

    private CoachService coachService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup() {
        notificarCorreoUseCase = new NotificarCorreoUseCase();
        coachService = mock(CoachService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder builder = new ServiceBuilder()
                .addService(coachService)
                .addService(senderEmailService);
        notificarCorreoUseCase.addServiceBuilder(builder);
    }

    @Test
    void sendEmailHappyPath(){
        //arrange
        var event = new AprendizAsociado(
                AprendizId.of("sssss"),
                CoachId.of("fffff")
        );

        when(coachService.getEmailByCoachId(any())).thenReturn("raul.alzate@sofka.com.co");
        doNothing().when(senderEmailService).sendEmail(anyString(), anyString());

        //act
        UseCaseHandler.getInstance()
                .syncExecutor(notificarCorreoUseCase, new TriggeredEvent<>(event));

        //assert
        verify(coachService).getEmailByCoachId(any());
        verify(senderEmailService).sendEmail(anyString(), anyString());

    }

}

