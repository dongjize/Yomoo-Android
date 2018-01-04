package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dong.yomoo.base.BaseListAdapter;
import com.example.dong.yomoo.entities.FodderOfVendor;

import java.util.List;

/**
 * Created by I346748 on 1/4/2018.
 */

public class FodderStockListAdapter extends BaseListAdapter<FodderOfVendor> {


    public FodderStockListAdapter(Context context, List<FodderOfVendor> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    private class ViewHolder {
        private TextView tvFodderName, tvFodderSpec, tvFodderStock;
    }
}
