package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseListAdapter;
import com.example.dong.yomoo.activities.farmer.services.tab3.BreedingInfoListAdapter;
import com.example.dong.yomoo.entitiy.BreedingInfo;
import com.example.dong.yomoo.entitiy.Purchase;

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
            holder.tvPurchaseNum = convertView.findViewById(R.id.tv_purchase_num);
            holder.tvDate = convertView.findViewById(R.id.tv_date);
            holder.tvTotalPrice = convertView.findViewById(R.id.tv_total_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvPurchaseNum.setText(purchase.getId() + "");
        holder.tvDate.setText(purchase.getCreatedAt());
        holder.tvTotalPrice.setText(String.format("%s", purchase.getTotalPrice()));
        return convertView;
    }

    private class ViewHolder {
        private TextView tvPurchaseNum, tvDate, tvTotalPrice;
    }
}
