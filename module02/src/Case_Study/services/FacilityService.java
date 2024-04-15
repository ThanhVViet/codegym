package Case_Study.services;

import Case_Study.models.Facility;

import java.util.Map;
import java.util.Optional;

public interface FacilityService extends OriginalService<Facility>{
    Map<Facility, Integer> findAllMaintaince();
    Optional<Facility> find(String ID);
}
