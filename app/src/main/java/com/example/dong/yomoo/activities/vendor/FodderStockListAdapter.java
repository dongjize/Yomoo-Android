package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseListAdapter;
import com.example.dong.yomoo.entities.FodderOfVendor;

import java.util.List;

/**
 * Created by I346748 on 1/4/2018.
 */

public class FodderStockListAdapter extends BaseListAdapter<FodderOfVendor> {

    public FodderStockListAdapter(Context context, List<FodderOfVendor> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FodderOfVendor fv = mList.get(position);
        ViewHolder holder;
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
        holder.tvSellPrice.setText(String.format("%s", fv.getSellPrice()));
        holder.tvStock.setText(fv.getStock());
        return convertView;
    }

    private class ViewHolder {
        private ImageView ivAvatar;
        private TextView tvTitle, tvSellPrice, tvStock;
    }
}
