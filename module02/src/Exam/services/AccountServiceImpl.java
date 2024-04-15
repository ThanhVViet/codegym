package Exam.services;

import Exam.models.AccountBank;
import Exam.models.PaymentAccount;
import Exam.models.SavingAccount;
import Exam.utils.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private static List<AccountBank> accountBanks = new ArrayList<>();

    private static ReadAndWriteFile<AccountBank> file = new ReadAndWriteFile<>();

    private static final String PATH = "/Users/thanhviet/Documents/codegym/module2/src/Exam/data/bank_account.csv";

    static {
        accountBanks = listAccount();
    }


    @Override
    public void create(AccountBank accountBank) {
        accountBanks.add(accountBank);
        file.write(PATH, accountBanks, false);
    }

    @Override
    public void delete(int code) {
        for (int i = 0; i < accountBanks.size(); i++) {
            if (accountBanks.get(i).getId() == code) {
                accountBanks.remove(i);
                break;
            }
        }
        file.write(PATH, accountBanks, false);

    }

    @Override
    public void search(int code) {
        for (int i = 0; i < accountBanks.size(); i++) {
            if (accountBanks.get(i).getId() == code) {
                System.out.println(accountBanks.get(i));
                break;
            }
        }
       file.readFile(PATH);
    }


    @Override
    public List<AccountBank> findAll() {
        return accountBanks;
    }

//    private static List<AccountBank> listAccount1() {
//        List<AccountBank> result = new ArrayList<>();
//        List<SavingAccount> savingAccounts = new ArrayList<>();
//        List<PaymentAccount> paymentAccounts = new ArrayList<>();
//        List<String> lines = file.readFile(PATH);
//
//        if (result instanceof SavingAccount) {
//
//            for (String line : lines) {
//                String[] tmp = line.split(",");
//                int id = Integer.parseInt(tmp[0]);
//                String code = tmp[1];
//                String fullName = tmp[2];
//                String birthday = tmp[3];
//                double money = Double.parseDouble(tmp[4]);
//                String dayOfSaving = tmp[5];
//                double salary = Double.parseDouble(tmp[6]);
//                int tenor = Integer.parseInt(tmp[7]);
//
//                AccountBank accountBank = new SavingAccount(id, code, fullName, birthday, money, dayOfSaving, salary, tenor);
//                result.add(accountBank);
//            }
//        } else if (result instanceof PaymentAccount) {
//
//            for (String line : lines) {
//                String[] tmp = line.split(",");
//
//                int id = Integer.parseInt(tmp[0]);
//                String code = tmp[1];
//                String fullName = tmp[2];
//                String birthday = tmp[3];
//                String cardNumber = tmp[4];
//                double moneyInAccount = Double.parseDouble(tmp[5]);
//
//                AccountBank paymentAccount = new PaymentAccount(id, code, fullName, birthday, cardNumber, moneyInAccount);
//                result.add(paymentAccount);
//
//            }
//        }
//
//        return result;
//    }

    private static List<AccountBank> listAccount() {
        List<AccountBank> result = new ArrayList<>();
        List<String> lines = file.readFile(PATH);

        for (String line : lines) {
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String fullName = tmp[2];
            String birthday = tmp[3];

            if (tmp.length == 6) {
                // PaymentAccount
                String cardNumber = tmp[4];
                double moneyInAccount = Double.parseDouble(tmp[5]);
                AccountBank paymentAccount = new PaymentAccount(id, code, fullName, birthday, cardNumber, moneyInAccount);
                result.add(paymentAccount);
            } else if (tmp.length == 8) {
                // SavingAccount
                double money = Double.parseDouble(tmp[4]);
                String dayOfSaving = tmp[5];
                double salary = Double.parseDouble(tmp[6]);
                int tenor = Integer.parseInt(tmp[7]);
                AccountBank savingAccount = new SavingAccount(id, code, fullName, birthday, money, dayOfSaving, salary, tenor);
                result.add(savingAccount);
            } else {
                // Invalid data format
                System.out.println("Invalid data format: " + line);
            }
        }

        return result;
    }

}
