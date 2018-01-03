package com.example.dong.yomoo.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.Farmer;

import java.util.List;

/**
 * 养殖户列表Adapter
 */
public class FarmerListAdapter extends BaseAdapter {

    private Context context;
    private List<Farmer> farmerList;
    private LayoutInflater mInflater;

    public FarmerListAdapter(Context context, List<Farmer> farmerList) {
        this.context = context;
        this.farmerList = farmerList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (farmerList != null) {
            return farmerList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (farmerList != null) {
            return farmerList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Farmer farmer = farmerList.get(position);
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
