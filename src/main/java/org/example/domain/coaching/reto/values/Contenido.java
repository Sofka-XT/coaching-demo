package org.example.domain.coaching.reto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Contenido implements ValueObject<Contenido.Props> {
    private final Date fecha;
    private final String cuerpoDeContenido;
    private final Descripcion descripcion;

    public Contenido(String cuerpoDeContenido, Descripcion descripcion) {
       this(new Date(), cuerpoDeContenido, descripcion);
    }


    public Contenido(Date fecha, String cuerpoDeContenido, Descripcion descripcion) {
        this.fecha =  Objects.requireNonNull(fecha, "La fecha es requerida");
        this.cuerpoDeContenido = Objects.requireNonNull(cuerpoDeContenido, "El cuerpo del contenido es requerido");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripcion es requerida");
        //TODO: agregar mas validaciones
    }


    public Contenido cambiarDescripcion(Descripcion descripcion){
        return new Contenido(this.fecha, this.cuerpoDeContenido, descripcion);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Date fecha() {
                return fecha;
            }

            @Override
            public String cuerpoDeContenido() {
                return cuerpoDeContenido;
            }

            @Override
            public Descripcion descripcion() {
                return descripcion;
            }
        };
    }

    public interface Props {
        Date fecha();
        String cuerpoDeContenido();
        Descripcion descripcion();
    }
}
