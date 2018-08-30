package com.mcc.galleryapp.adapter.recycleradapters;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mcc.galleryapp.R;
import com.mcc.galleryapp.databinding.GalleryListLayoutBinding;
import com.mcc.galleryapp.listener.ItemClickListener;
import com.mcc.galleryapp.model.datamodel.GalleryDataModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class GalleryRecyclerAdapter extends RecyclerView.Adapter<GalleryRecyclerAdapter.GalleryViewHolder> {

    private Context context;
    private List<GalleryDataModel> modelList;

    private ItemClickListener clickListener;

    public GalleryRecyclerAdapter(Context context) {
        this.context = context;
    }

    public GalleryRecyclerAdapter(Context context, List<GalleryDataModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public GalleryRecyclerAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder((GalleryListLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.gallery_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryRecyclerAdapter.GalleryViewHolder holder, int position) {
        if (modelList.get(position).getIMG() != null && !modelList.get(position).getIMG().isEmpty())
            Picasso.with(context).load(modelList.get(position).getIMG())
                    .placeholder(context.getResources().getDrawable(R.drawable.cover_image_default))
                    .error(context.getResources().getDrawable(R.drawable.cover_image_default))
                    .into(holder.binding.galleryImage);

        holder.binding.galleryTitle.setText(modelList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        GalleryListLayoutBinding binding;

        GalleryViewHolder(GalleryListLayoutBinding listLayoutBinding) {
            super(listLayoutBinding.getRoot());
            binding = listLayoutBinding;

            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClickGetPosition(getAdapterPosition());
        }
    }
}
