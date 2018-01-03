package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.FodderOfVendor;
import com.example.dong.yomoo.entities.users.User;

import java.util.List;

/**
 * Created by dong on 30/12/2017.
 */

public class VendorInfoDetailAdapter extends BaseAdapter {

    private Context context;
    private List<FodderOfVendor> fvList;
    private LayoutInflater mInflater;

    public VendorInfoDetailAdapter(Context context, List<FodderOfVendor> fvList) {
        this.context = context;
        this.fvList = fvList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (fvList == null) {
            return 0;
        }
        return fvList.size();
    }

    @Override
    public Object getItem(int position) {
        if (fvList == null) {
            return null;
        }
        return fvList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        FodderOfVendor fv = fvList.get(position);
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

    class ViewHolder {
        private ImageView ivAvatar;
        private TextView tvTitle, tvSellPrice, tvStock;
    }
}
