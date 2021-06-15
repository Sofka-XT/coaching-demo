package org.example.usecase.reto;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.domain.coaching.reto.commands.CrearReto;
import org.example.domain.coaching.reto.events.RetoCreado;
import org.example.domain.coaching.reto.values.Contenido;
import org.example.domain.coaching.reto.values.Descripcion;
import org.example.domain.coaching.reto.values.RetoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearRetoUseCaseTest {

    private CrearRetoUseCase crearRetoUseCase;

    @BeforeEach
    public void setup(){
        crearRetoUseCase = new CrearRetoUseCase();
    }

    @Test
    void crearRetoHappyPath(){
        //arrange
        var command = new CrearReto(
                RetoId.of("xxx-xxxx"),
                new Descripcion("reto de DDD en 3 dias"),
                new Contenido("aplicar la parte tenica de DDD usando la libreria",
                        new Descripcion("aplicar ddd")
                )
        );

        //act
        var response = UseCaseHandler.getInstance().syncExecutor(
                crearRetoUseCase, new RequestCommand<>(command)
        ).orElseThrow();

       var events = response.getDomainEvents();


       //asserts
        RetoCreado retoCreado = (RetoCreado)events.get(0);
        Assertions.assertEquals("aplicar la parte tenica de DDD usando la libreria", retoCreado.getContenido().value().cuerpoDeContenido());
        Assertions.assertEquals("aplicar ddd", retoCreado.getContenido().value().descripcion().value());
        Assertions.assertEquals("reto de DDD en 3 dias", retoCreado.getDescripcion().value());
    }



}