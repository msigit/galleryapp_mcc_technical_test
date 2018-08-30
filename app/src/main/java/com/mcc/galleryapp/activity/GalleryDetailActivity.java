package com.mcc.galleryapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mcc.galleryapp.R;
import com.mcc.galleryapp.databinding.GalleryDetailLayoutBinding;
import com.squareup.picasso.Picasso;

public class GalleryDetailActivity extends BaseActivity {

    String galleryTitle, galleryImage;

    GalleryDetailLayoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            galleryTitle = bundle.getString("title");
            galleryImage = bundle.getString("image");
        }

        binding = DataBindingUtil.setContentView(this, R.layout.gallery_detail_layout);
        initLayout();
    }

    /* Initializing view Layout*/
    private void initLayout(){
        setExitToolbar(binding.galleryDetailToolbar, galleryTitle);

        if (galleryImage != null && !galleryImage.isEmpty())
            Picasso.with(this).load(galleryImage)
                    .placeholder(getResources().getDrawable(R.drawable.cover_image_default))
                    .error(getResources().getDrawable(R.drawable.cover_image_default))
                    .into(binding.galleryDetailImage);
    }
}
