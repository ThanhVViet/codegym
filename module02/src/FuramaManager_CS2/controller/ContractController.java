package FuramaManager_CS2.controller;

import FuramaManager_CS2.model.Contract;
import FuramaManager_CS2.service.ContractService;
import FuramaManager_CS2.service.ContractServiceImpl;

import java.util.List;

public class ContractController {
    private ContractService contractService = new ContractServiceImpl();

    public void create(Contract contract) {
        contractService.create(contract);
    }

    public void update(Contract contract) {
        contractService.update(contract);
    }

    public List<Contract> findAll(){
        return contractService.findAll();
    }
}