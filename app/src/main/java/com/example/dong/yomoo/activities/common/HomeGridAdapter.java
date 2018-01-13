package com.example.dong.yomoo.activities.common;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.farmer.CommonItemViewHolder;
import com.example.dong.yomoo.utils.CommonItemModel;

import java.util.List;

/**
 * Created by dong on 22/12/2017.
 */
public class HomeGridAdapter extends RecyclerView.Adapter<CommonItemViewHolder>  {

    private Context context;
    private List<CommonItemModel> modelList;

    public HomeGridAdapter(Context context, List<CommonItemModel> modelList) {
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
        final CommonItemModel model = modelList.get(position);
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
