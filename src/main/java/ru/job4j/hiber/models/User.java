package ru.job4j.hiber.models;

import java.util.Calendar;
import java.util.Objects;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 12.02.2020
 */
public class User {

    int id;
    String name;
    Calendar expired;

    public User() {
    }

    public User(int id, String name, Calendar expired) {
        this.id = id;
        this.name = name;
        this.expired = expired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpired() {
        return expired;
    }

    public void setExpired(Calendar expired) {
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(expired, user.expired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, expired);
    }

    @Override
    public String toString() {
        return String.format("User{ id=%d, name=%s, expired=%s }",
                id, name, expired.getTime());
    }

}
