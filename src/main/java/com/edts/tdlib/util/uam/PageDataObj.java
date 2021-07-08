package com.edts.tdlib.util.uam;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Data with page information
 * 
 * @author danielset
 *
 * @param <E> Element type of data
 */
public final class PageDataObj<E> implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6612484245510524311L;
    private List<E> data;
    private boolean nextAvailable;
    private String nextLink;
    private boolean prevAvailable;
    private String prevLink;
    private boolean firstAvailable;
    private String firstLink;
    private boolean lastAvailable;
    private String lastLink;
    
    public PageDataObj() {
        data = Collections.<E>emptyList();
    }
    
    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public boolean isNextAvailable() {
        return nextAvailable;
    }

    public void setNextAvailable(boolean nextAvailable) {
        this.nextAvailable = nextAvailable;
    }

    public String getNextLink() {
        return nextLink;
    }

    public void setNextLink(String nextLink) {
        this.nextLink = nextLink;
    }

    public boolean isPrevAvailable() {
        return prevAvailable;
    }

    public void setPrevAvailable(boolean prevAvailable) {
        this.prevAvailable = prevAvailable;
    }

    public String getPrevLink() {
        return prevLink;
    }

    public void setPrevLink(String prevLink) {
        this.prevLink = prevLink;
    }

    public boolean isFirstAvailable() {
        return firstAvailable;
    }

    public void setFirstAvailable(boolean firstAvailable) {
        this.firstAvailable = firstAvailable;
    }

    public String getFirstLink() {
        return firstLink;
    }

    public void setFirstLink(String firstLink) {
        this.firstLink = firstLink;
    }

    public boolean isLastAvailable() {
        return lastAvailable;
    }

    public void setLastAvailable(boolean lastAvailable) {
        this.lastAvailable = lastAvailable;
    }

    public String getLastLink() {
        return lastLink;
    }

    public void setLastLink(String lastLink) {
        this.lastLink = lastLink;
    }
    
    public PageDataObj<E> data(List<E> data) {
        setData(data);
        return this;
    }
    
    public PageDataObj<E> next(boolean nextAvailable, String nextLink) {
        setNextAvailable(nextAvailable);
        setNextLink(nextLink);
        return this;
    }
    
    public PageDataObj<E> prev(boolean prevAvailable, String prevLink) {
        setPrevAvailable(prevAvailable);
        setPrevLink(prevLink);
        return this;
    }
    
    public PageDataObj<E> first(boolean firstAvailable, String firstLink) {
        setFirstAvailable(firstAvailable);
        setFirstLink(firstLink);
        return this;
    }
    
    public PageDataObj<E> last(boolean lastAvailable, String lastLink) {
        setLastAvailable(lastAvailable);
        setLastLink(lastLink);
        return this;
    }
    
    @Override
    public String toString() {
        return "PageData{" +
            "data=" + getData() +
            ", nextAvailable=" + isNextAvailable() +
            ", nextLink=" + getNextLink() +
            ", prevAvailable=" + isPrevAvailable() +
            ", prevLink=" + getPrevLink() +
            ", firstAvailable=" + isFirstAvailable() +
            ", firstLink=" + getFirstLink() +
            ", lastAvailable=" + isLastAvailable() +
            ", lastLink=" + getLastLink() +
            "}";
    }
}
