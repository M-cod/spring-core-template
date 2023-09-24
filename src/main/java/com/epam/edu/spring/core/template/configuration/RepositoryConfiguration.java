package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.epam.edu.spring.core.template")
public class RepositoryConfiguration {

    private ItemRepository itemRepository;
    private final LinkedListItemRepository linkedListItemRepository;
    private final ArrayListItemRepository arrayListItemRepository;

    @Autowired
    public RepositoryConfiguration(LinkedListItemRepository linkedListItemRepository, ArrayListItemRepository arrayListItemRepository) {
        this.linkedListItemRepository = linkedListItemRepository;
        this.arrayListItemRepository = arrayListItemRepository;
    }

    @Value("${item.repository.implementation}")
    private void initConfiguration (String implementation) {
        if (implementation.equals("linked")) {
            itemRepository = linkedListItemRepository;
        } else {
            itemRepository = arrayListItemRepository;
        }
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }
}
