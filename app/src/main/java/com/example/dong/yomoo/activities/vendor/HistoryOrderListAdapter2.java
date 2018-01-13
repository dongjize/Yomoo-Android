package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entitiy.Order;
import com.example.dong.yomoo.utils.BaseLoadMoreRecyclerAdapter;

import java.util.List;

/**
 * 历史订单列表Adapter
 */
public class HistoryOrderListAdapter2 extends BaseLoadMoreRecyclerAdapter<String, HistoryOrderListAdapter2.HistoryOrderListViewHolder> {

    private Context context;
    private List<Order> orderList;

    public HistoryOrderListAdapter2(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @Override
    public HistoryOrderListViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.history_order_list_item, null);
        return new HistoryOrderListViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(HistoryOrderListViewHolder holder, int position) {
        final Order order = orderList.get(position);
        holder.tvOrderNumber.setText(order.getId() + "");
        holder.tvSellPrice.setText(String.format("%s 元", order.getOrderEntries().get(0).getSellPrice()));
        holder.tvOrderDate.setText(String.format("%s", order.getCreatedAt()));
        holder.tvBuyer.setText(order.getBuyer().getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderEntryDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("order_id", order.getId());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }


    class HistoryOrderListViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderNumber, tvOrderDate, tvSellPrice, tvBuyer;

        public HistoryOrderListViewHolder(View itemView) {
            super(itemView);
            tvOrderNumber = itemView.findViewById(R.id.tv_order_number);
            tvOrderDate = itemView.findViewById(R.id.tv_created_date);
            tvSellPrice = itemView.findViewById(R.id.tv_sell_price);
            tvBuyer = itemView.findViewById(R.id.tv_fodder_buyer);
        }
    }
}
