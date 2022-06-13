package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс описывает работу возможности взаимодействия юзеров и их аккаунтов для проведения банковских переводов
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
     * Метод добавляет новый уникальный счёт пользователя
     * @param passport паспорт - уникальное поле каждого пользователя, поиск происходит через метод findByPassport
     * @param account банковский счет добавляется в том случае, если такого счета у пользователя еще нет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> addAccount = findByPassport(passport);
        if (addAccount.isPresent()) {
            List<Account> allUsers = users.get(addAccount.get());
            if (!allUsers.contains(account)) {
                allUsers.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * Метод перебирает всех пользователей через цикл for-each и метод и метод Map.keySet и сравнивает паспорт,
     * указанный в аргументах со всеми имеющимися паспортами
     * Если ничего не найдено - метод должен вернуть null
     * @param passport паспорт - который нужно найти
     * @return результат поиска: либо нужный паспорт, либо пусто
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * Первым делом ищет пользователя по паспорту с помощью метода findByPassport
     * Если паспорт есть, ищет в списке счетов нужный счет
     * @param passport - уникальное поле пользователя, чей счет требуется найти
     * @param requisite счет, который требуется найти
     * @return возвращает аккаунт пользователя
     */
    public  Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> one = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> two = findByRequisite(destPassport, destRequisite);
        if (one.isPresent() && two.isPresent() && one.get().getBalance() >= amount) {
            one.get().setBalance(one.get().getBalance() - amount);
            two.get().setBalance(two.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
