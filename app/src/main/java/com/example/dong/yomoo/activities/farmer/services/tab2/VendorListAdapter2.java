package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.entities.users.User;

import java.util.List;

/**
 * Created by dong on 30/12/2017.
 */

public class VendorListAdapter2 extends BaseAdapter {

    private List<User> vendorList;
    private Context context;
    private LayoutInflater mInflater;

    public VendorListAdapter2(Context context, List<User> vendorList) {
        this.vendorList = vendorList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (vendorList == null) {
            return 0;
        }
        return vendorList.size();
    }

    @Override
    public Object getItem(int position) {
        if (vendorList == null) {
            return null;
        }
        return vendorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = vendorList.get(position);
        VendorListViewHolder holder;
        if (convertView == null) {
            holder = new VendorListViewHolder();
            convertView = mInflater.inflate(R.layout.vendor_list_item, parent, false);
            holder.tvName = convertView.findViewById(R.id.tv_name);
            holder.tvIntro = convertView.findViewById(R.id.tv_intro);
            convertView.setTag(holder);
        } else {
            holder = (VendorListViewHolder) convertView.getTag();
        }
        holder.tvName.setText(user.getName());
        holder.tvIntro.setText(user.getIntro());
        return convertView;
    }

    class VendorListViewHolder {
        private ImageView ivAvatar;
        private TextView tvName, tvIntro;

    }
}
