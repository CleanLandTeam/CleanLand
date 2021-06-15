package com.example.cleanland.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpacingRecyclerView extends RecyclerView.ItemDecoration {

    private  final int  bottomSpacing ;
    public SpacingRecyclerView(int bottomSpacing) {
        this.bottomSpacing= bottomSpacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
      outRect.bottom=this.bottomSpacing;
    }
}
