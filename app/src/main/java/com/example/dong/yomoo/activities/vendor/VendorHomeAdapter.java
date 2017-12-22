package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dong.yomoo.R;

import java.util.List;

/**
 * Created by dong on 17/12/2017.
 */

public class VendorHomeAdapter extends RecyclerView.Adapter<VendorHomeAdapter.VendorHomeViewHolder> {

    private Context context;
    private List<VendorHomeModel> modelList;

    public VendorHomeAdapter(Context context, List<VendorHomeModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public VendorHomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.vendor_home_activity_item, null);
        return new VendorHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VendorHomeViewHolder holder, int position) {
        final VendorHomeModel model = modelList.get(position);
        holder.tvTitle.setText(model.getTitle());
        holder.tvSubTitle.setText(model.getSubtitle());
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

    class VendorHomeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubTitle;

        public VendorHomeViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubTitle = itemView.findViewById(R.id.tv_subtitle);
        }
    }
}