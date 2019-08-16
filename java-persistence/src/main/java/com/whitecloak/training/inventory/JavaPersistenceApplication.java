package com.whitecloak.training.inventory;

import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaPersistenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPersistenceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(CategoryRepository categoryRepository,
                                          UserRepository userRepository,
                                          ItemRepository itemRepository) {
        return args -> {
            CategoryEntity c1 = categoryRepository.save(new CategoryEntity("monitors"));
            CategoryEntity c2 = categoryRepository.save(new CategoryEntity("processors"));
            CategoryEntity c3 = categoryRepository.save(new CategoryEntity("laptops"));
            CategoryEntity c4 = categoryRepository.save(new CategoryEntity("smartphones"));
            CategoryEntity c5 = categoryRepository.save(new CategoryEntity("featurephones"));

            UserEntity u1 = userRepository.save(new UserEntity("Jonathan Francisco"));
            UserEntity u2 = userRepository.save(new UserEntity("Albert Baliguas"));
            UserEntity u3 = userRepository.save(new UserEntity("Gab Estremos"));
            UserEntity u4 =userRepository.save(new UserEntity("Tan Lozendo"));

            itemRepository.save(new ItemEntity("Macbook Pro", c1, u1));
            itemRepository.save(new ItemEntity("Macbook Pro", c1, u2));
            itemRepository.save(new ItemEntity("Macbook Pro", c1, u3));
            itemRepository.save(new ItemEntity("Zenfone Max Pro M1", c4, u1));
            itemRepository.save(new ItemEntity("Samsung", c4, u3));
            itemRepository.save(new ItemEntity("iPhone 11", c4, u2));
            itemRepository.save(new ItemEntity("Razer Phone Bla bla", c4, u4));
            itemRepository.save(new ItemEntity("Nokia 3310", c5, u2));
            itemRepository.save(new ItemEntity("AMD Ryzen", c3, u4));
            itemRepository.save(new ItemEntity("Lenovo Thinkpad X1 Carbon", c1, u1));
            itemRepository.save(new ItemEntity("Asus VC239H", c2, u1));
        };
    }

}
