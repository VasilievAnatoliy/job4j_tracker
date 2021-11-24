package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель данных банковского счета
 * @author VASILIEV ANATOLIY
 * @version 1.0
 */
public class Account {

    /**
     * Поля модели даных содержат:
     * реквизиты(номер счёта) и баланс.
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор класса ввод данных:
     * @param requisite номер счёта
     * @param balance баланс счёта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределяем номер счёта для возможности поиска по нему.
     * @param o номер счёта.
     * @return возвращает true если сравнение прошло успешно.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(getRequisite(), account.getRequisite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequisite());
    }
}
