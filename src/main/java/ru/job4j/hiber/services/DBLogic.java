package ru.job4j.hiber.services;

import ru.job4j.hiber.models.Item;
import ru.job4j.hiber.persistence.DBStore;
import ru.job4j.hiber.persistence.IStore;

import java.util.List;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 18.02.2020
 */
public class DBLogic implements ILogic {

    private static final DBLogic INSTANCE = new DBLogic();

    private final IStore storage = DBStore.getInstance();

    private DBLogic() {
    }

    public static DBLogic getInstance() {
        return INSTANCE;
    }

    @Override
    public Item add(Item item) {
        return storage.add(item);
    }

    @Override
    public Item update(Item item) {
        Item updated = storage.get(item);
        boolean status = item.isDone();
        updated.setDone(status);
        return storage.update(updated);
    }

    @Override
    public void delete(Item item) {
        storage.delete(item);
    }

    @Override
    public Item get(Item item) {
        return storage.get(item);
    }

    @Override
    public List<Item> getAll() {
        return storage.getAll();
    }
}
