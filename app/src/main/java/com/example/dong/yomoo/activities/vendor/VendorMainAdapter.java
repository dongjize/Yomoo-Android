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

public class VendorMainAdapter extends RecyclerView.Adapter<VendorMainAdapter.VendorMainViewHolder> {

    private Context context;
    private List<VendorMainModel> modelList;

    public VendorMainAdapter(Context context, List<VendorMainModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public VendorMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.vendor_main_activity_item, null);
        return new VendorMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VendorMainViewHolder holder, int position) {
        final VendorMainModel model = modelList.get(position);
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

    class VendorMainViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubTitle;

        public VendorMainViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvSubTitle = (TextView) itemView.findViewById(R.id.tv_subtitle);
        }
    }
}