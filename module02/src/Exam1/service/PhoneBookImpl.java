package Exam1.service;


import Exam1.model.PhoneBook;
import Exam1.utils.ConstantUtil;
import Exam1.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookImpl implements IPhoneBook {
    private static List<PhoneBook> phoneBooks = new ArrayList<>();

    private static final String PATH = "/Users/thanhviet/Documents/codegym/module2/src/Exam1/data/contacts.csv";

    private static ReadAndWrite<PhoneBook> file = new ReadAndWrite<>();

    static {
        phoneBooks = list();
    }

    @Override
    public void create(PhoneBook phoneBook) {
        phoneBooks.add(phoneBook);
        file.write(PATH, phoneBooks, false);

    }

    @Override
    public void edit(PhoneBook phoneBook) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhone().equals(phoneBook.getPhone())) {
                phoneBooks.set(i, phoneBook);
                break;
            }
        }
        file.write(PATH, phoneBooks, false);
    }

    @Override
    public List<PhoneBook> findAll() {
        return phoneBooks;
    }

    @Override
    public void find(String phoneBook) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhone().equals(phoneBook)) {
                System.out.println(phoneBooks.get(i));
                break;
            }
        }
    }

    @Override
    public void findByName(String t) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().equals(t)) {
                System.out.println(phoneBooks.get(i));
                break;
            }
        }
    }

    @Override
    public void delete(String phoneNumber) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhone().equals(phoneNumber)) {
                phoneBooks.remove(i);
                break;
            }
        }
        file.write(PATH, phoneBooks, false);
    }

    private static List<PhoneBook> list() {
        List<PhoneBook> result = new ArrayList<>();
        List<String> lines = file.readFile(PATH);

        for (String line : lines) {
            String[] tmp = line.split(",");
            String name = tmp[0];
            String birthday = tmp[1];
            String contactGroup = tmp[2];

            String phone = tmp[3];

            String address = tmp[4];
            String email = tmp[5];
            ConstantUtil.Gender gender = ConstantUtil.Gender.valueOf(tmp[6]);


            PhoneBook phoneBook = new PhoneBook(name, birthday, contactGroup, phone, address, email, gender);
            result.add(phoneBook);
        }

        return result;
    }


}
