package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.OrderEntry;
import com.example.dong.yomoo.utils.BaseLoadMoreRecyclerAdapter;

import java.util.List;

/**
 * 历史订单列表Adapter
 */
public class HistoryOrderListAdapter extends BaseLoadMoreRecyclerAdapter<String, HistoryOrderListAdapter.HistoryOrderListViewHolder> {

    private Context context;
    private List<OrderEntry> entryList;

    public HistoryOrderListAdapter(Context context, List<OrderEntry> orderList) {
        this.context = context;
        this.entryList = orderList;
    }

    @Override
    public HistoryOrderListViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.history_order_list_item, null);
        return new HistoryOrderListViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(HistoryOrderListViewHolder holder, int position) {
        OrderEntry orderEntry = entryList.get(position);

    }


    class HistoryOrderListViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameSpec, tvSellPrice, tvQuantity;

        public HistoryOrderListViewHolder(View itemView) {
            super(itemView);
            tvNameSpec = itemView.findViewById(R.id.tv_fodder_name);
            tvSellPrice = itemView.findViewById(R.id.tv_sell_price);
            tvQuantity = itemView.findViewById(R.id.tv_fodder_quantity);
        }
    }
}
