package com.example.dong.yomoo.activities.farmer.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseFragment;
import com.example.dong.yomoo.activities.common.HomeGridAdapter;
import com.example.dong.yomoo.activities.farmer.profile.tab1.FarmerAccountInfoActivity;
import com.example.dong.yomoo.activities.farmer.profile.tab2.FarmerInfoActivity;
import com.example.dong.yomoo.activities.farmer.profile.tab3.BreedingInfoDemandPublishActivity;
import com.example.dong.yomoo.utils.CommonItemModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 养殖户主页tab1 我
 * 包括3个Card：账务信息、个人信息、发布服务需求
 * <p>
 * Created by dong on 17/12/2017.
 */

public class FarmerProfileFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private List<CommonItemModel> modelList;
    private HomeGridAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.farmer_profile_fragment, container, false);
        return contentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        modelList = new ArrayList<>();

        CommonItemModel[] models = {
                new CommonItemModel("账务信息", FarmerAccountInfoActivity.class),
                new CommonItemModel("个人信息", FarmerInfoActivity.class),
                new CommonItemModel("发布需求", BreedingInfoDemandPublishActivity.class)
        };
        modelList.addAll(Arrays.asList(models));
        recyclerView = contentView.findViewById(R.id.recycler_view);
        adapter = new HomeGridAdapter(context, modelList);
        RecyclerView.LayoutManager lm = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }
}
