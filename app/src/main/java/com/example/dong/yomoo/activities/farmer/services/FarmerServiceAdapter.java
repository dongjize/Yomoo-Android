package com.example.dong.yomoo.activities.farmer.services;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.farmer.CommonItemViewHolder;

import java.util.List;

/**
 * Created by dong on 23/12/2017.
 */

public class FarmerServiceAdapter extends RecyclerView.Adapter<CommonItemViewHolder> {

    private Context context;
    private List<FarmerServiceModel> modelList;

    public FarmerServiceAdapter(Context context, List<FarmerServiceModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public CommonItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.common_recycler_grid_item, null);
        return new CommonItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommonItemViewHolder holder, int position) {
        final FarmerServiceModel model = modelList.get(position);
        holder.tvTitle.setText(model.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, model.getCls());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (modelList != null) {
            return modelList.size();
        }
        return 0;
    }
}
