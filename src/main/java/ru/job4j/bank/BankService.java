package ru.job4j.bank;

import java.util.*;

/**
 * Модель для банковской системы в которой можно:
 * регистрировать пользователя, удалять пользователя,
 * добавлять пользователю банковский счет(у пользователя могут быть несколько счетов),
 * Переводить деньги с одного банковского счета на другой счет.
 *
 * @author VASILIEV ANATOLIY
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение обьектов осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляем пользователя в систему, с проверкой что такого
     * пользователя еще нет в системе. Если он есть, то нового не добавляем.
     *
     * @param user пользователь которого добавляем.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавяем новый счет к пользователю, если такой
     * пользователь есть и такого счета у него нет.
     *
     * @param passport номер паспорта.
     * @param account  номер счета и баланс.
     */
    public void addAccount(String passport, Account account) {
        var user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accountList = users.get(user.get());
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     *
     * @param passport номер паспорта.
     * @return возвращает пользователя или null если он не найден.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * метод ищет счет пользователя по реквизитам.
     * Находит пользователя по паспорту.
     * Получает список счетов этого пользователя и в них находит нужный счет.
     *
     * @param passport  номер паспорта.
     * @param requisite номер счета.
     * @return возвращят аккаунт(номер счета и баланс) ползователя или
     * null если пользователь или счет не найдены.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        var user = findByPassport(passport);
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(e -> e.getRequisite().contains(requisite))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     *
     * @param srcPassport   номер паспорта пользователя который переводит.
     * @param srcRequisite  номер счёта с которого переводят.
     * @param destPassport  номер паспорта получателя.
     * @param destRequisite номер счёта получателя.
     * @param amount        сумма перевода.
     * @return Метод вернёт true если перевод прошёл успешно, если счёт не
     * найден или не хватает денег на счёте то метод вернет false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        var srcAccount = findByRequisite(srcPassport, srcRequisite);
        var destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
