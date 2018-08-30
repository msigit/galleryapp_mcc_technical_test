
package com.mcc.galleryapp.model.responsemodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mcc.galleryapp.model.datamodel.GalleryDataModel;

public class GalleryResponseModel {

    @SerializedName("contentfilelist")
    @Expose
    private List<GalleryDataModel> galleryDataModel = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GalleryResponseModel() {
    }

    /**
     * 
     * @param galleryDataModel
     */
    public GalleryResponseModel(List<GalleryDataModel> galleryDataModel) {
        super();
        this.galleryDataModel = galleryDataModel;
    }

    public List<GalleryDataModel> getGalleryDataModel() {
        return galleryDataModel;
    }

    public void setGalleryDataModel(List<GalleryDataModel> galleryDataModel) {
        this.galleryDataModel = galleryDataModel;
    }

}
