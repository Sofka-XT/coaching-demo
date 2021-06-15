package org.example.domain.coaching.reto.values;

import co.com.sofka.domain.generic.Identity;

public class RetoId extends Identity {
    public RetoId(){

    }

    private RetoId(String id){
        super(id);
    }

    public static RetoId of(String id){
        return new RetoId(id);
    }
}
