package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User addAccount = findByPassport(passport);
        if (addAccount != null) {
            List<Account> allUsers = users.get(addAccount);
            if (!allUsers.contains(account)) {
                allUsers.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User forFind = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                forFind = user;
                break;
            }
        }
        return forFind;
    }

    public  Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account a : users.get(user)) {
                if (a.getRequisite().equals(requisite)) {
                    account = a;
                    break;
                }
            }
        }
        return  account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account one = findByRequisite(srcPassport, srcRequisite);
        Account two = findByRequisite(destPassport, destRequisite);
        if (one != null && two != null && one.getBalance() >= amount) {
            one.setBalance(one.getBalance() - amount);
            two.setBalance(two.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
