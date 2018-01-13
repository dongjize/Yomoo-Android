package com.example.dong.yomoo.activities.farmer.services.tab3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseListAdapter;
import com.example.dong.yomoo.entitiy.BreedingInfo;

import java.util.List;

/**
 * Created by I346748 on 1/5/2018.
 */

public class BreedingInfoListAdapter extends BaseListAdapter<BreedingInfo> {

    public BreedingInfoListAdapter(Context context, List<BreedingInfo> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BreedingInfo breedingInfo = mList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.breeding_info_list_item, parent, false);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvPublisher = convertView.findViewById(R.id.tv_publisher_name);
            holder.tvPublishDate = convertView.findViewById(R.id.tv_publish_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(breedingInfo.getTitle());
        holder.tvPublisher.setText(breedingInfo.getPublisher().getName());
        holder.tvPublishDate.setText(breedingInfo.getCreatedAt());
        return convertView;
    }

    private class ViewHolder {
        private TextView tvTitle, tvPublisher, tvPublishDate;
    }
}
