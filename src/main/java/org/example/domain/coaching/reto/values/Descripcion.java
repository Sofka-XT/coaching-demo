package org.example.domain.coaching.reto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.length() > 200){
            throw new IllegalArgumentException("No puede superar la descripcion mas de 200 caracteres");
        }

        if(value.length() < 5){
            throw new IllegalArgumentException("Debe ingresar mas caracteres a la descripcion");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
