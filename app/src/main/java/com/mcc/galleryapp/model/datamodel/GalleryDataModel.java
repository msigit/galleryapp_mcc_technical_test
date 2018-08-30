
package com.mcc.galleryapp.model.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryDataModel {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("IMG")
    @Expose
    private String iMG;

    /**
     * No args constructor for use in serialization
     *
     */
    public GalleryDataModel() {
    }

    /**
     *
     * @param iMG
     * @param id
     * @param title
     * @param details
     */
    public GalleryDataModel(String id, String title, String details, String iMG) {
        super();
        this.id = id;
        this.title = title;
        this.details = details;
        this.iMG = iMG;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIMG() {
        return iMG;
    }

    public void setIMG(String iMG) {
        this.iMG = iMG;
    }
}