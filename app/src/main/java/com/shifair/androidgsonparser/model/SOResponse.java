package com.shifair.androidgsonparser.model;

/**
 * Created by titipku on 04/07/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class SOResponse {

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<>();
    @SerializedName("has_more")
    @Expose
    private boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    private int quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private int quotaRemaining;

    /**
     * No args constructor for use in serialization
     */
    public SOResponse() {
    }

    /**
     * @param hasMore
     * @param quotaMax
     * @param items
     * @param quotaRemaining
     */
    public SOResponse(List<Item> items, boolean hasMore, int quotaMax, int quotaRemaining) {
        super();
        this.items = items;
        this.hasMore = hasMore;
        this.quotaMax = quotaMax;
        this.quotaRemaining = quotaRemaining;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public SOResponse withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public SOResponse withHasMore(boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(int quotaMax) {
        this.quotaMax = quotaMax;
    }

    public SOResponse withQuotaMax(int quotaMax) {
        this.quotaMax = quotaMax;
        return this;
    }

    public int getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(int quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public SOResponse withQuotaRemaining(int quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("items", items).append("hasMore", hasMore).append("quotaMax", quotaMax).append("quotaRemaining", quotaRemaining).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(hasMore)
                .append(quotaMax)
                .append(items)
                .append(quotaRemaining)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SOResponse)) {
            return false;
        }
        SOResponse rhs = ((SOResponse) other);
        return new EqualsBuilder()
                .append(hasMore, rhs.hasMore)
                .append(quotaMax, rhs.quotaMax)
                .append(items, rhs.items)
                .append(quotaRemaining, rhs.quotaRemaining)
                .isEquals();
    }

}

