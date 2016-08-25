package net.almaak.cms.migration.dao.entities.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by leiferksn on 8/24/16.
 */
public class ImageVO {

    /**

    {"image_intro":"",
    "float_intro":"",
    "image_intro_alt":"",
    "image_intro_caption":"",
    "image_fulltext":"",
    "float_fulltext":"",
    "image_fulltext_alt":"",
    "image_fulltext_caption":""}

     */

    @JsonProperty("image_intro")
    private String imageIntro;

    @JsonProperty("image_intro_alt")
    private String imageIntroAlt;

    @JsonProperty("image_intro_caption")
    private String imageIntroCaption;


    @JsonProperty("image_fulltext_alt")
    private String imageFulltextAlt;

    @JsonProperty("image_fulltext_caption")
    private String imageFulltextCaption;

    @JsonProperty("image_fulltext")
    private String imageFullText;

    /*  === just ignore the float settings for both types of images for now  === */

    @JsonProperty("float_intro")
    private String floatIntro;


    @JsonProperty("float_fulltext")
    private String floatFulltext;


    @JsonIgnore
    public String getFloatIntro() {
        return floatIntro;
    }

    public void setFloatIntro(String floatIntro) {
        this.floatIntro = floatIntro;
    }

    public String getImageIntroAlt() {
        return imageIntroAlt;
    }

    public void setImageIntroAlt(String imageIntroAlt) {
        this.imageIntroAlt = imageIntroAlt;
    }

    public String getImageIntroCaption() {
        return imageIntroCaption;
    }

    public void setImageIntroCaption(String imageIntroCaption) {
        this.imageIntroCaption = imageIntroCaption;
    }

    public String getImageFullText() {
        return imageFullText;
    }

    public void setImageFullText(String imageFullText) {
        this.imageFullText = imageFullText;
    }

    @JsonIgnore
    public String getFloatFulltext() {
        return floatFulltext;
    }

    public void setFloatFulltext(String floatFulltext) {
        this.floatFulltext = floatFulltext;
    }

    public String getImageFulltextAlt() {
        return imageFulltextAlt;
    }

    public void setImageFulltextAlt(String imageFulltextAlt) {
        this.imageFulltextAlt = imageFulltextAlt;
    }

    public String getImageFulltextCaption() {
        return imageFulltextCaption;
    }

    public void setImageFulltextCaption(String imageFulltextCaption) {
        this.imageFulltextCaption = imageFulltextCaption;
    }

    public String getImageIntro() {
        return imageIntro;
    }

    public void setImageIntro(String imageIntro) {
        this.imageIntro = imageIntro;
    }
}
