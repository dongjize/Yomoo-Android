package com.example.dong.yomoo.activities.farmer.profile.tab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.Order;

import java.util.List;

/**
 * Created by I346748 on 1/3/2018.
 */

public class FarmerAccountInfoAdapter extends BaseAdapter {
    private Context context;
    private List<Order> orderList;
    private LayoutInflater mInflater;

    public FarmerAccountInfoAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (orderList != null) {
            return orderList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (orderList != null) {
            return orderList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Order order = orderList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.history_order_list_item, parent, false);
            holder.tvOrderNumber = convertView.findViewById(R.id.tv_order_number);
            holder.tvOrderDate = convertView.findViewById(R.id.tv_created_date);
            holder.tvTotalPrice = convertView.findViewById(R.id.tv_total_price);
            holder.tvVendor = convertView.findViewById(R.id.tv_fodder_vendor);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvOrderNumber.setText(String.format("%d", order.getId()));
        holder.tvOrderDate.setText(order.getCreatedAt());
        holder.tvTotalPrice.setText(String.format("%s", order.getTotalPrice()));
        holder.tvVendor.setText(order.getVendor().getName());
        return convertView;
    }

    private class ViewHolder {
        private TextView tvOrderNumber, tvOrderDate, tvTotalPrice, tvVendor;
    }
}