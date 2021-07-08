package com.edts.tdlib.bean;



import java.util.List;

/**
 * @author rickychandra
 * @created 03/11/2020
 */
public final class PageWrapper<U, T> {
    private U additionalData;
    private List<T> content;
   // private Pageable pageable;
    private long totalElements;
    private int totalPages;
    private boolean last;
    //private Sort sort;
    private int numberOfElements;
    private boolean first;
    private int size;
    private int number;
    private boolean empty;

    /*public PageWrapper<U, T> create(U U, Page<T> page) {
        this.additionalData = U;
        this.content = page.getContent();
        this.pageable = page.getPageable();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.last = page.isLast();
        this.sort = page.getSort();
        this.numberOfElements = page.getNumberOfElements();
        this.first = page.isFirst();
        this.size = page.getSize();
        this.number = page.getNumber();
        this.empty = page.isEmpty();
        return this;
    }

    public U getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(U additionalData) {
        this.additionalData = additionalData;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public String toString() {
        return "PageWrapper{" +
                "additionalData=" + additionalData +
                ", content=" + content +
                ", pageable=" + pageable +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", last=" + last +
                ", sort=" + sort +
                ", numberOfElements=" + numberOfElements +
                ", first=" + first +
                ", size=" + size +
                ", number=" + number +
                ", empty=" + empty +
                '}';
    }*/
}
