package com.example.dong.yomoo.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

/**
 * Created by dong on 17/12/2017.
 */

public class BaseFragment extends Fragment {
    protected Context context;
    protected View contentView;
//    protected RequestUtils requestUtils;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
//        requestUtils = new RequestUtils();
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
