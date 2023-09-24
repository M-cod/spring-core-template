package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.ColorFactory;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		ItemValidator itemValidator = context.getBean(ItemValidator.class);
		SimpleItemService itemServiceConstructor = (SimpleItemService) context.getBean("itemServiceConstructor");
		SimpleItemService itemServiceSetter = (SimpleItemService) context.getBean("itemServiceSetter");

		LinkedListItemRepository linkedListItemRepository = context.getBean(LinkedListItemRepository.class);
		ArrayListItemRepository arrayListItemRepository = context.getBean(ArrayListItemRepository.class);

		ColorFactory colorFactory = context.getBean(ColorFactory.class);
	}

}
