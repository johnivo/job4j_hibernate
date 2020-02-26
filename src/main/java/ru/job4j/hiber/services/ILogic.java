package ru.job4j.hiber.services;

import ru.job4j.hiber.models.Item;

import java.util.List;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 18.02.2020
 */
public interface ILogic {

    Item add(Item item);

    Item update(Item item);

    void delete(Item item);

    Item get(Item item);

    List<Item> getAll();

}
