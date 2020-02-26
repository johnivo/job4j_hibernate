package ru.job4j.hiber.models;

import java.util.Calendar;
import java.util.Objects;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 14.02.2020
 */
public class Item {

    private int id;
    private String description;
    private Calendar created;
    private boolean done;

    public Item() {
    }

    public Item(int id, String description, Calendar created, boolean done) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && done == item.done
                && Objects.equals(description, item.description)
                && Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, created, done);
    }

    @Override
    public String toString() {
        return String.format("Item{ id=%d, description=%s, created=%s, done=%s }",
                id, description, created.getTime(), done);
    }

}
