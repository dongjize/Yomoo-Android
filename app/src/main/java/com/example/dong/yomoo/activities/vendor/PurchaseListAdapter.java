package com.example.dong.yomoo.activities.vendor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.yomoo.activities.common.BaseListAdapter;
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
        return null;
    }
}
