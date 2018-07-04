package com.shifair.androidgsonparser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titipku on 04/07/18.
 */
public class Item {

    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<String>();
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("is_answered")
    @Expose
    private boolean isAnswered;
    @SerializedName("view_count")
    @Expose
    private int viewCount;
    @SerializedName("answer_count")
    @Expose
    private int answerCount;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("last_activity_date")
    @Expose
    private int lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private int creationDate;
    @SerializedName("question_id")
    @Expose
    private int questionId;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param tags
     * @param creationDate
     * @param title
     * @param answerCount
     * @param questionId
     * @param link
     * @param lastActivityDate
     * @param isAnswered
     * @param score
     * @param owner
     * @param viewCount
     */
    public Item(List<String> tags, Owner owner, boolean isAnswered, int viewCount, int answerCount, int score, int lastActivityDate, int creationDate, int questionId, String link, String title) {
        super();
        this.tags = tags;
        this.owner = owner;
        this.isAnswered = isAnswered;
        this.viewCount = viewCount;
        this.answerCount = answerCount;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        this.creationDate = creationDate;
        this.questionId = questionId;
        this.link = link;
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Item withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Item withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public boolean isIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public Item withIsAnswered(boolean isAnswered) {
        this.isAnswered = isAnswered;
        return this;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Item withViewCount(int viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public Item withAnswerCount(int answerCount) {
        this.answerCount = answerCount;
        return this;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Item withScore(int score) {
        this.score = score;
        return this;
    }

    public int getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(int lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Item withLastActivityDate(int lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
        return this;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public Item withCreationDate(int creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Item withQuestionId(int questionId) {
        this.questionId = questionId;
        return this;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Item withLink(String link) {
        this.link = link;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("tags", tags).append("owner", owner).append("isAnswered", isAnswered).append("viewCount", viewCount).append("answerCount", answerCount).append("score", score).append("lastActivityDate", lastActivityDate).append("creationDate", creationDate).append("questionId", questionId).append("link", link).append("title", title).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tags).append(creationDate).append(title).append(answerCount).append(questionId).append(link).append(lastActivityDate).append(isAnswered).append(score).append(owner).append(viewCount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(tags, rhs.tags).append(creationDate, rhs.creationDate).append(title, rhs.title).append(answerCount, rhs.answerCount).append(questionId, rhs.questionId).append(link, rhs.link).append(lastActivityDate, rhs.lastActivityDate).append(isAnswered, rhs.isAnswered).append(score, rhs.score).append(owner, rhs.owner).append(viewCount, rhs.viewCount).isEquals();
    }

}
