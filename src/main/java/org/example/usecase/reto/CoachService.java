package org.example.usecase.reto;

import org.example.domain.coaching.reto.values.CoachId;

public interface CoachService {
    String getEmailByCoachId(CoachId coachId);
}
