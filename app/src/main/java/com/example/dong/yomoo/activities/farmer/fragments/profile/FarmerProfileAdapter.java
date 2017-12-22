package com.example.dong.yomoo.activities.farmer.fragments.profile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dong.yomoo.R;

import java.util.List;

/**
 * Created by dong on 22/12/2017.
 */

public class FarmerProfileAdapter extends RecyclerView.Adapter<FarmerProfileAdapter.FarmerProfileViewHolder>  {

    private Context context;
    private List<FarmerProfileModel> modelList;

    public FarmerProfileAdapter(Context context, List<FarmerProfileModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public FarmerProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.farmer_profile_fragment_item, null);
        return new FarmerProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FarmerProfileViewHolder holder, int position) {
        final FarmerProfileModel model = modelList.get(position);
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

    class FarmerProfileViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public FarmerProfileViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
