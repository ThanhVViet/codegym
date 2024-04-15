package FuramaManager_CS2.controller;

import FuramaManager_CS2.model.Facility;
import FuramaManager_CS2.service.FacilityService;
import FuramaManager_CS2.service.FacilityServiceImpl;

import java.util.List;
import java.util.Map;

public class FacilityController {
    private FacilityService facilityService = new FacilityServiceImpl();

    public List<Facility> findAll(){
        return facilityService.findAll();
    }

    public void create(Facility facility){
        facilityService.create(facility);
    }

    public Map<Facility, Integer> findAllMaintenance(){
        return facilityService.findAllMaintenance();
    }
}
