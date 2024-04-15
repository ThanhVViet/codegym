package FuramaManager_CS2.service;

import FuramaManager_CS2.model.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractServiceImpl implements ContractService{
    private List<Contract> contracts= new ArrayList<>();

    @Override
    public void create(Contract contract) {
        contracts.add(contract);
    }

    @Override
    public void update(Contract contract) {
        int index = contracts.indexOf(contract);
        contracts.set(index, contract);
    }

    @Override
    public List<Contract> findAll() {
        return contracts;
    }
}
