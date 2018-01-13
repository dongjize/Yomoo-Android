package com.example.dong.yomoo.activities.farmer.services.tab2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseListAdapter;
import com.example.dong.yomoo.entitiy.users.User;

import java.util.List;

/**
 * Created by dong on 30/12/2017.
 */

public class VendorListAdapter extends BaseListAdapter<User> {

    public VendorListAdapter(Context context, List<User> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = mList.get(position);
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
