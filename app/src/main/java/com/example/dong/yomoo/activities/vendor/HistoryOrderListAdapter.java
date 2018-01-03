package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.Order;

import java.util.List;

/**
 * Created by dong on 02/01/2018.
 */

public class HistoryOrderListAdapter extends BaseAdapter {

    private Context context;
    private List<Order> orderList;
    private LayoutInflater mInflater;

    public HistoryOrderListAdapter(Context context, List<Order> orderList) {
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
            holder.tvBuyer = convertView.findViewById(R.id.tv_fodder_buyer);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvOrderNumber.setText(order.getId() + "");
        holder.tvOrderDate.setText(order.getCreatedAt());
        holder.tvTotalPrice.setText(order.getOrderEntries().get(position).getSellPrice() + "");
        holder.tvBuyer.setText(order.getBuyer().getName());
        return convertView;
    }

    class ViewHolder {
        private TextView tvOrderNumber, tvOrderDate, tvTotalPrice, tvBuyer;
    }
}
