package com.whitecloak.training.inventory.controller.response;

import java.util.List;

public class PaginateResource<ItemResource> {
    private List<ItemResource> items;
    private long totalItems;
    private long totalPages;

    public PaginateResource(List<ItemResource> items, long totalItems, long totalPages) {
        this.items = items;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }

    public List<ItemResource> getItems() {
        return items;
    }

    public void setItems(List<ItemResource> items) {
        this.items = items;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
