package com.example.dong.yomoo.activities.farmer.services.tab1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.base.BaseListAdapter;
import com.example.dong.yomoo.entities.LivestockDemand;

import java.util.List;

/**
 * Created by I346748 on 1/4/2018.
 */

public class LiveStockDemandAdapter extends BaseListAdapter<LivestockDemand> {

    public LiveStockDemandAdapter(Context context, List<LivestockDemand> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LivestockDemand demand = mList.get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.livestock_demand_list_item, parent, false);
            holder = new ViewHolder();
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvPublisher = convertView.findViewById(R.id.tv_publisher_name);
            holder.tvCreatedAt = convertView.findViewById(R.id.tv_created_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(demand.getTitle());
        holder.tvPublisher.setText(demand.getPublisher().getName());
        holder.tvCreatedAt.setText(demand.getCreatedAt());
        return convertView;
    }

    private class ViewHolder {
        private TextView tvTitle, tvPublisher, tvCreatedAt;
    }
}
