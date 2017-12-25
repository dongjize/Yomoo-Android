package com.example.dong.yomoo.activities.farmer.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.BreedingInfo;
import com.example.dong.yomoo.utils.BaseLoadMoreRecyclerAdapter;

import java.util.List;

/**
 * Created by dong on 25/12/2017.
 */

public class BreedingInfoAdapter extends BaseLoadMoreRecyclerAdapter<String, BreedingInfoAdapter.BreedingInfoViewHolder> {

    private Context context;
    private List<BreedingInfo> infoList;

    public BreedingInfoAdapter(Context context, List<BreedingInfo> infoList) {
        this.context = context;
        this.infoList = infoList;
    }

    @Override
    public BreedingInfoViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.breeding_info_list_item, null);
        return new BreedingInfoViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(BreedingInfoViewHolder holder, int position) {
        final BreedingInfo breedingInfo = infoList.get(position);
        holder.tvTitle.setText(breedingInfo.getTitle());
        holder.tvDate.setText(breedingInfo.getCreatedAt());
        holder.tvPublisher.setText(breedingInfo.getPublisher().getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BreedingInfoDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("id", breedingInfo.getId());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    class BreedingInfoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvPublisher, tvDate;

        public BreedingInfoViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPublisher = itemView.findViewById(R.id.tv_publisher_name);
            tvDate = itemView.findViewById(R.id.tv_publish_date);
        }
    }
}
