package net.almaak.cms.migration.utils;

/**
 * Created by leiferksn on 8/25/16.
 */

public enum ImageRole {

    INTRO("Intro", "The thumbnail that appears in teasers"),
    FULLTEXT("Fulltext", "The picture that appears in the head of an article");

    private String role;
    private String comment;

    ImageRole(String role, String comment) {
        this.role = role;
        this.comment = comment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
