package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
@Component
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        return holder.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean createItem(Item item) {
        item.setId(initialSequence);
        holder.add(item);
        initialSequence++;
        return true;
    }

    @RandomInitialSequence(min = 1, max = 100)
    void setInitialSequence(int val) {
        initialSequence = val;
    }

    void setHolder() {
        holder = new LinkedList<>();
    }
}
