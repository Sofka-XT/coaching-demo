package org.example.domain.coaching.reto.values;

import co.com.sofka.domain.generic.Identity;

public class CoachId extends Identity {
    public CoachId(){

    }
    private CoachId(String id) {
        super(id);
    }

    public static CoachId of(String id) {
        return new CoachId(id);
    }
}
