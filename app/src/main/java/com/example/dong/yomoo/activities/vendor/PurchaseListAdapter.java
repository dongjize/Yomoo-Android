package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseListAdapter;
import com.example.dong.yomoo.activities.farmer.services.tab3.BreedingInfoListAdapter;
import com.example.dong.yomoo.entitiy.BreedingInfo;
import com.example.dong.yomoo.entitiy.Purchase;
import com.example.dong.yomoo.entitiy.PurchaseEntry;

import java.util.List;

/**
 * Created by I346748 on 1/5/2018.
 */

public class PurchaseListAdapter extends BaseListAdapter<Purchase> {

    public PurchaseListAdapter(Context context, List<Purchase> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Purchase purchase = mList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.purchase_list_item, parent, false);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvDate = convertView.findViewById(R.id.tv_date);
            holder.entriesLayout = convertView.findViewById(R.id.entries_layout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(String.format("订单id：%d", purchase.getId()));
        holder.tvDate.setText(purchase.getCreatedAt());
        if (purchase.getPurchaseEntries() != null) {
            for (int i = 0; i < purchase.getPurchaseEntries().size(); i++) {
                PurchaseEntry entry = purchase.getPurchaseEntries().get(i);
                View layout = mInflater.inflate(R.layout.purchase_list_item_entry, parent, false);
                TextView tvFodder = layout.findViewById(R.id.tv_fodder);
                TextView tvQuantity = layout.findViewById(R.id.tv_quantity);
                TextView tvPrice = layout.findViewById(R.id.tv_purchase_price);
                tvFodder.setText(String.format("%s %s", entry.getFodder().getName(), entry.getFodder().getFodderSpec()));
                tvQuantity.setText("数量：" + entry.getQuantity() + "");
                tvPrice.setText("进价：" + entry.getPurchasePrice() + "元");
                holder.entriesLayout.addView(layout);
            }
        }
        return convertView;
    }

    private class ViewHolder {
        private TextView tvTitle, tvDate;
        private LinearLayout entriesLayout;
    }
}
