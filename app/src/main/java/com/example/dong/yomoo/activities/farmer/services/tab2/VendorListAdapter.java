package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.User;

import java.util.List;

/**
 * 销售商列表adapter
 */
public class VendorListAdapter extends RecyclerView.Adapter<VendorListAdapter.VendorListViewHolder> {

    private Context context;
    private List<User> vendorList;

    public VendorListAdapter(Context context, List<User> vendorList) {
        this.context = context;
        this.vendorList = vendorList;
    }

    @Override
    public VendorListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.vendor_list_item, null);
        return new VendorListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VendorListViewHolder holder, int position) {
        final User user = vendorList.get(position);
        holder.tvName.setText(user.getName());
        holder.tvIntro.setText(user.getIntro());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VendorInfoDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("vendor_id", user.getId());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (vendorList != null) {
            return vendorList.size();
        }
        return 0;
    }

    class VendorListViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAvatar;
        private TextView tvName, tvIntro;

        public VendorListViewHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvIntro = itemView.findViewById(R.id.tv_intro);
        }
    }

}
