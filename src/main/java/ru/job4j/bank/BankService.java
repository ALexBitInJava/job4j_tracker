package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в систему пользователя
     * @param user пользователь, которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый уникальный счёт польщоваотеля
     * @param passport паспорт - уникальное поле каждого пользователя, поиск происходит через метод findByPassport
     * @param account банковский счет добавляется в том случае, если такого счета у пользователя еще нет
     */
    public void addAccount(String passport, Account account) {
        User addAccount = findByPassport(passport);
        if (addAccount != null) {
            List<Account> allUsers = users.get(addAccount);
            if (!allUsers.contains(account)) {
                allUsers.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * Метод перебирает всех пользователей через цикл for-each и метод и метод Map.keySet и сравнивает паспорт,
     * указанный в аргементе со всеми имеющимися паспортами
     * Если ничего не найдено - метод должен вернуть null
     * @param passport паспорт - который нужно найти
     * @return результат поиска: либо нужный паспорт, либо пусто
     */
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

    /**
     * Метод ищет счет пользователя по реквизитам
     * Первым делом ищет пользователя по паспорту с помощью метода findByPassport
     * Если паспорт есть, ищет в списке счетов нужный счет
     * @param passport - уникальное поле пользователя, чей счет требуется найти
     * @param requisite счет, который требуется найти
     * @return возвращает аккаунт пользователя
     */
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

    /**
     * Метод предназначен для перечисления денег с одного счета на другой
     * @param srcPassport паспорт пользователя, с чьего счёта будет производиться перевод
     * @param srcRequisite счет пользователя, с которого будет производиться перевод
     * @param destPassport паспорт пользователя, с чьего счёта будет производиться перевод
     * @param destRequisite счет пользователя, с которого будет производиться перевод
     * @param amount сумма перевода
     * @return Если счет не найден или не хватает денег на счете, с которого переводят, то метод возвращает false
     */
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
