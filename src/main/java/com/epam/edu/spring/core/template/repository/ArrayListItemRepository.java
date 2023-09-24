package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Component
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

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

    @Value("${initial.sequence}")
    void setInitialSequence(int val) {
        initialSequence = val;
    }

    void setHolder() {
        holder = new ArrayList<>();
    }
}
