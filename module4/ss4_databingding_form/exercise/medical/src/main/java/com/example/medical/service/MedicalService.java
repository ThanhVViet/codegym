package com.example.medical.service;

import com.example.medical.model.Medical;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalService {

    private static List<Medical> medicalList;

    static {
        medicalList = new ArrayList<>();
        medicalList.add(new Medical("Thanh Viet", 2003, "080484928"));
        medicalList.add(new Medical("Muichirou", 2007, "0983y4820"));
        medicalList.add(new Medical("Cong Viet", 2003, "0878374298"));
    }

    public List<Medical> findAll() {
        return medicalList;
    }

    public void save(Medical medical) {
        medicalList.add(medical);
    }

    public boolean update(Medical declarationToUpdate) {
        for (int i = 0; i < medicalList.size(); i++) {
            Medical currentDeclaration = medicalList.get(i);
            if (currentDeclaration.getId() == declarationToUpdate.getId()) {
                medicalList.set(i, declarationToUpdate);
                return true;
            }
        }
        return false;
    }


    public Optional<Medical> findById(int id) {
        return medicalList.stream().filter(e -> e.getId() == id).findFirst();
    }

    public Medical findById2(int id) {
        for (Medical s : medicalList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

}
