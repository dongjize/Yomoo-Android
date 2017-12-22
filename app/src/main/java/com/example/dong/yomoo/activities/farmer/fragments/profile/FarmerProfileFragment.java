package com.example.dong.yomoo.activities.farmer.fragments.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseFragment;
import com.example.dong.yomoo.activities.butcher.LivestockDemandPublishActivity;
import com.example.dong.yomoo.activities.farmer.FarmerAccountInfoActivity;
import com.example.dong.yomoo.activities.farmer.FarmerInfoActivity;
import com.example.dong.yomoo.activities.farmer.BreedingInfoListActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 包括4个Card：账务信息、个人信息、发布服务需求、养殖方法列表
 * <p>
 * Created by dong on 17/12/2017.
 */

public class FarmerProfileFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private List<FarmerProfileModel> modelList;
    private FarmerProfileAdapter adapter;


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
        FarmerProfileModel[] models = {
                new FarmerProfileModel("账务信息", FarmerAccountInfoActivity.class),
                new FarmerProfileModel("个人信息", FarmerInfoActivity.class),
                new FarmerProfileModel("发布需求", LivestockDemandPublishActivity.class),
                new FarmerProfileModel("养殖方法", BreedingInfoListActivity.class)
        };
        modelList.addAll(Arrays.asList(models));

        recyclerView = contentView.findViewById(R.id.recycler_view);
        adapter = new FarmerProfileAdapter(context, modelList);
        RecyclerView.LayoutManager lm = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }
}
