package com.whitecloak.training.withoutdi;

public class ItemService {

    public void createItem(String name, int quantity, String description) {
        Item item = new Item();
        item.setName(name);
        item.setQuantity(quantity);
        item.setDescription(description);

        item.save();
    }
}
