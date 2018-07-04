package com.shifair.androidgsonparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by titipku on 04/07/18.
 */
public class Owner {

    @SerializedName("reputation")
    @Expose
    private int reputation;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     * No args constructor for use in serialization
     */
    public Owner() {
    }

    /**
     * @param profileImage
     * @param link
     * @param userId
     * @param reputation
     * @param displayName
     * @param userType
     */
    public Owner(int reputation, int userId, String userType, String profileImage, String displayName, String link) {
        super();
        this.reputation = reputation;
        this.userId = userId;
        this.userType = userType;
        this.profileImage = profileImage;
        this.displayName = displayName;
        this.link = link;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public Owner withReputation(int reputation) {
        this.reputation = reputation;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Owner withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Owner withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Owner withProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Owner withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Owner withLink(String link) {
        this.link = link;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("reputation", reputation).append("userId", userId).append("userType", userType).append("profileImage", profileImage).append("displayName", displayName).append("link", link).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(profileImage).append(link).append(userId).append(reputation).append(displayName).append(userType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Owner) == false) {
            return false;
        }
        Owner rhs = ((Owner) other);
        return new EqualsBuilder().append(profileImage, rhs.profileImage).append(link, rhs.link).append(userId, rhs.userId).append(reputation, rhs.reputation).append(displayName, rhs.displayName).append(userType, rhs.userType).isEquals();
    }

}
