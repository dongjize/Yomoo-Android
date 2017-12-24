package com.example.dong.yomoo.activities.farmer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dong.yomoo.R;

/**
 * Created by dong on 23/12/2017.
 */

public class CommonItemViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;

    public CommonItemViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }
}
