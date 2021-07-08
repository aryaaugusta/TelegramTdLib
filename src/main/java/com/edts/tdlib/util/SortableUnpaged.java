package com.edts.tdlib.util;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Unpaged pageable with sort capability.
 */
@JsonSerialize(using = SortableUnpagedSerializer.class)
public class SortableUnpaged implements Pageable {
    private final Sort sort;

    public SortableUnpaged(Sort sort) {
        this.sort = sort;
    }

    /**
     * Returns whether the current {@link Pageable} contains pagination information.
     *
     * @return true = contains pagination information, false = doesn't contains pagination information
     */
    @Override
    public boolean isPaged() {
        return false;
    }

    /**
     * Returns the previous {@link Pageable} or the first {@link Pageable} if the current one already is the first one.
     *
     * @return pageable
     */
    @Override
    public Pageable previousOrFirst() {
        return this;
    }

    /**
     * Returns the {@link Pageable} requesting the next {@link Page}.
     *
     * @return pageable
     */
    @Override
    public Pageable next() {
        return this;
    }

    /**
     * Returns whether there's a previous {@link Pageable} we can access from the current one. Will return
     * {@literal false} in case the current {@link Pageable} already refers to the first page.
     *
     * @return true = has previous page, false = doesn't have previous page
     */
    @Override
    public boolean hasPrevious() {
        return false;
    }

    /**
     * Returns the sorting parameters.
     *
     * @return sort
     */
    @Override
    public Sort getSort() {
        return sort;
    }

    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page
     */
    @Override
    public int getPageSize() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    @Override
    public int getPageNumber() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the offset to be taken according to the underlying page and page size.
     *
     * @return the offset to be taken
     */
    @Override
    public long getOffset() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the {@link Pageable} requesting the first page.
     *
     * @return pageable
     */
    @Override
    public Pageable first() {
        return this;
    }
}
