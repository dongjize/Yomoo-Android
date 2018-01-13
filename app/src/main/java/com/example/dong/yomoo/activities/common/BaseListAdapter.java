package com.example.dong.yomoo.activities.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by I346748 on 1/4/2018.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> mList;
    protected LayoutInflater mInflater;

    public BaseListAdapter(Context context, List<T> list) {
        this.context = context;
        this.mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mList != null) {
            return mList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
