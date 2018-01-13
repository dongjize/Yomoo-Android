package com.example.dong.yomoo.activities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseListAdapter;
import com.example.dong.yomoo.entitiy.users.Farmer;

import java.util.List;

/**
 * 养殖户列表Adapter
 */
public class FarmerListAdapter extends BaseListAdapter<Farmer> {

    public FarmerListAdapter(Context context, List<Farmer> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Farmer farmer = mList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.farmer_list_item, parent, false);
            holder.ivAvatar = convertView.findViewById(R.id.iv_avatar);
            holder.tvName = convertView.findViewById(R.id.tv_farmer_name);
            holder.tvPhone = convertView.findViewById(R.id.tv_phone_num);
            holder.tvAddress = convertView.findViewById(R.id.tv_address);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(farmer.getName());
        holder.tvPhone.setText(farmer.getPhone());
        holder.tvAddress.setText(farmer.getAddress());
        return convertView;
    }

    private class ViewHolder {
        private ImageView ivAvatar;
        private TextView tvName, tvPhone, tvAddress;
    }
}
