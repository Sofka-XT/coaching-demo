package org.example.usecase.reto;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.coaching.aprendiz.values.AprendizId;
import org.example.domain.coaching.reto.commands.AsociarAprendiz;
import org.example.domain.coaching.reto.events.AprendizAsociado;
import org.example.domain.coaching.reto.events.RetoCreado;
import org.example.domain.coaching.reto.values.CoachId;
import org.example.domain.coaching.reto.values.Contenido;
import org.example.domain.coaching.reto.values.Descripcion;
import org.example.domain.coaching.reto.values.RetoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AsociarAprendizUseCaseTest {

    private AsociarAprendizUseCase asociarAprendizUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asociarAprendizUseCase = new AsociarAprendizUseCase();
        repository = mock(DomainEventRepository.class);
        asociarAprendizUseCase.addRepository(repository);
    }

    @Test
    void asociarApredizHappyPath() {
        //arrange
        var command = new AsociarAprendiz(
                RetoId.of("aaaaa"),
                AprendizId.of("fffff")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                asociarAprendizUseCase, new RequestCommand<>(command))
                .orElseThrow();

        System.out.println(response);
        //TODO: assertions
    }

    @Test
    void asociarApredizSadPath(){
        //arrange
        var command = new AsociarAprendiz(
                RetoId.of("aaaaa"),
                AprendizId.of("fffff")
        );
        when(repository.getEventsBy(any())).thenReturn(eventsFullAprendiz());

        //act
        var response = Assertions.assertThrows(BusinessException.class, () ->{
           UseCaseHandler.getInstance()
                    .setIdentifyExecutor("aaaaa")
                    .syncExecutor(
                            asociarAprendizUseCase, new RequestCommand<>(command))
                    .orElseThrow();
        });

        Assertions.assertEquals("No se puede registrar otro aprendiz en este reto", response.getMessage());
    }

    private List<DomainEvent> events() {
        return List.of(new RetoCreado(
                new Descripcion("descripcion creada"),
                new Contenido("contenido creado", new Descripcion("descripcion del contenido"))
        ));
    }

    private List<DomainEvent> eventsFullAprendiz() {
        return List.of(new RetoCreado(
                new Descripcion("descripcion creada"),
                new Contenido("contenido creado",
                        new Descripcion("descripcion del contenido"))),

                new AprendizAsociado(AprendizId.of("1"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("2"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("3"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("4"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("5"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("6"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("7"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("8"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("9"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("10"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("11"), CoachId.of("1")),
                new AprendizAsociado(AprendizId.of("12"), CoachId.of("1"))
        );
    }


}