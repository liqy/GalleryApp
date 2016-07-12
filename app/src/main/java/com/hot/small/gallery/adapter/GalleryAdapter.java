package com.hot.small.gallery.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hot.small.gallery.R;
import com.hot.small.gallery.model.Photo;

import java.util.ArrayList;

/**
 * Created by liqingyi on 16/7/12.
 */
public class GalleryAdapter extends BaseQuickAdapter<Photo> {

    public GalleryAdapter() {
        super(R.layout.item_grid_gallery, new ArrayList<Photo>());
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Photo photo) {

    }
}
