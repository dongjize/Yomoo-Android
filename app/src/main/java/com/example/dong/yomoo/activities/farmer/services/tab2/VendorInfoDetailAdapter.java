package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.content.Context;
import android.support.design.internal.BaselineLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseListAdapter;
import com.example.dong.yomoo.entitiy.FodderOfVendor;

import java.util.List;

/**
 * Created by dong on 30/12/2017.
 */

public class VendorInfoDetailAdapter extends BaseListAdapter<FodderOfVendor> {

    public VendorInfoDetailAdapter(Context context, List<FodderOfVendor> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        FodderOfVendor fv = mList.get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.vendor_info_detail_item, parent, false);
            holder = new ViewHolder();
            holder.ivAvatar = convertView.findViewById(R.id.iv_avatar);
            holder.tvTitle = convertView.findViewById(R.id.tv_fodder_title);
            holder.tvSellPrice = convertView.findViewById(R.id.tv_sell_price);
            holder.tvStock = convertView.findViewById(R.id.tv_fodder_stock);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(String.format("%s %s", fv.getFodder().getName(), fv.getFodder().getFodderSpec()));
        holder.tvSellPrice.setText(String.format("售价 %s", fv.getSellPrice()));
        holder.tvStock.setText(String.format("库存 %d", fv.getStock()));
        return convertView;
    }

    class ViewHolder {
        private ImageView ivAvatar;
        private TextView tvTitle, tvSellPrice, tvStock;
    }
}
