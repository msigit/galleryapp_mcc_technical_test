package com.mcc.galleryapp.network;


import com.mcc.galleryapp.model.responsemodel.GalleryResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
 * Created by Sahidul Islam on 12/2/2018.
 */

public interface ApiInterface {


    @POST("ContentFile.php")
    @FormUrlEncoded
    Call<GalleryResponseModel> getGalleryData(@Field("AppId") String appId,
                                              @Field("MenuId") String menuId);
}
