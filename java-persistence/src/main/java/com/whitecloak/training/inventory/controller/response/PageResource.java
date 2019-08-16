package com.whitecloak.training.inventory.controller.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public class PageResource<T> {

    private final List<T> content;
    private final int page;
    private final int size;
    private final int numOfPages;

    public PageResource(List<T> content, int page, int size, int numOfPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.numOfPages = numOfPages;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

}
