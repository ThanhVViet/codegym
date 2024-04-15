package Case_Study.services;

import Case_Study.models.Contract;
import Case_Study.utils.PATH;
import Case_Study.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private static List<Contract> contracts = new ArrayList<>();

    private static ReadAndWrite<Contract> file = new ReadAndWrite<>();

    @Override
    public void create(Contract contract) {
        contracts.add(contract);
        file.write(PATH.StringPath.CONTRACT, contracts, false);
    }

    @Override
    public void edit(Contract contract) {
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getCode().equals(contract.getCode())) {
                contracts.set(i, contract);
                break;
            }
        }
        file.write(PATH.StringPath.CONTRACT, contracts, false);
    }

    @Override
    public List<Contract> findAll() {
        return contracts;
    }
}
