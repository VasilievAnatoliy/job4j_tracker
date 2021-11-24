package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель данных пользователя.
 * @author VASILIEV ANATOLIY
 * @version 1.0
 */
public class User {

    /**
     * Поля модели даных содержат:
     * паспорт и имя пользователя.
     */
    private String passport;
    private String username;

    /**
     * Конструктор класса ввод данных:
     * @param passport паспорт пользователя.
     * @param username имя пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределяем номер паспорта для возможности поиска по нему.
     * @param o номер паспорта.
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
        User user = (User) o;
        return Objects.equals(getPassport(), user.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassport());
    }
}

