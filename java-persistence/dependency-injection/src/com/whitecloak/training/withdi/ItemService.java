package com.whitecloak.training.withdi;

public class ItemService {

    private final ItemGateway itemGateway;

    public ItemService(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public void createItem(String name, int quantity, String description) {
        Item item = new Item();
        item.setName(name);
        item.setQuantity(quantity);
        item.setDescription(description);

        itemGateway.save(item);
    }
}
