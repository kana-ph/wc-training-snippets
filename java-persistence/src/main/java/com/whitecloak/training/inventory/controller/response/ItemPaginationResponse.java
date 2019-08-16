package com.whitecloak.training.inventory.controller.response;

import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class ItemPaginationResponse<ItemEntity> {

  private List<ItemEntity> items;
  private long totalPage;
  private long totalItem;



    public ItemPaginationResponse(List<ItemEntity> items, long totalPage, long totalItem) {
        this.items = items;
        this.totalPage = totalPage;
        this.totalItem = totalItem;
    }
//
//
//    public ItemPaginationResponse(ItemEntity list) {
//    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(long totalItem) {
        this.totalItem = totalItem;
    }
}
