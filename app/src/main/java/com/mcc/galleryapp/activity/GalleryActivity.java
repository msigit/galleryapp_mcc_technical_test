package com.mcc.galleryapp.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.mcc.galleryapp.R;
import com.mcc.galleryapp.adapter.recycleradapters.GalleryRecyclerAdapter;
import com.mcc.galleryapp.broadcastreceiver.InternetConnectivityReceiver;
import com.mcc.galleryapp.databinding.PrimaryListLayoutBinding;
import com.mcc.galleryapp.listener.ItemClickListener;
import com.mcc.galleryapp.model.datamodel.GalleryDataModel;
import com.mcc.galleryapp.model.responsemodel.GalleryResponseModel;
import com.mcc.galleryapp.network.ApiClient;
import com.mcc.galleryapp.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity extends BaseActivity implements ItemClickListener {

    PrimaryListLayoutBinding binding;
    GalleryRecyclerAdapter galleryAdapter;

    List<GalleryDataModel> modelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.primary_list_layout);
        initLayout();
    }

    /* callback of gallery item click*/
    @Override
    public void onClickGetPosition(int position) {
        startActivity(new Intent(GalleryActivity.this, GalleryDetailActivity.class)
                .putExtra("title", modelList.get(position).getTitle())
                .putExtra("image", modelList.get(position).getIMG()));
    }

    /* Initializing view Layout*/
    private void initLayout() {
        setDefaultToolbar(binding.primaryToolbar, getResources().getString(R.string.app_name));

        modelList = new ArrayList<>();
        galleryAdapter = new GalleryRecyclerAdapter(this, modelList);
        binding.primaryRecycler.setLayoutManager(new GridLayoutManager(GalleryActivity.this, 2, Configuration.ORIENTATION_PORTRAIT, false));
        binding.primaryRecycler.setAdapter(galleryAdapter);
        galleryAdapter.setClickListener(this);

        loadGalleryList();
    }

    /* Getting  model data*/
    private void loadGalleryList() {
        if (!InternetConnectivityReceiver.isInternetConnected()) {
            showShortToast(GalleryActivity.this, getString(R.string.internet_connect_error));
        } else {
            progressDialog.show();
            Call<GalleryResponseModel> apiCall = getApiCallInstance.getGalleryData("9", "35");

            apiCall.enqueue(new Callback<GalleryResponseModel>() {
                @Override
                public void onResponse(@NonNull Call<GalleryResponseModel> call, @NonNull Response<GalleryResponseModel> response) {

                    if (response.isSuccessful()) {
                        modelList.addAll(Objects.requireNonNull(response.body()).getGalleryDataModel());
                        galleryAdapter.notifyDataSetChanged();
                    } else {
                        showShortToast(GalleryActivity.this, "Server error");
                    }
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(@NonNull Call<GalleryResponseModel> call, @NonNull Throwable t) {
                    // Log.e("BPTokenData Fail: ", t.toString());
                    progressDialog.dismiss();
                    showShortToast(GalleryActivity.this, "Network error");
                }
            });
        }
    }
}
