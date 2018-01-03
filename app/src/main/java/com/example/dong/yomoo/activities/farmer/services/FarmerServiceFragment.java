package com.example.dong.yomoo.activities.farmer.services;

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
import com.example.dong.yomoo.activities.farmer.services.tab1.LivestockDemandListActivity;
import com.example.dong.yomoo.activities.farmer.services.tab2.VendorListActivity;
import com.example.dong.yomoo.activities.farmer.services.tab3.BreedingInfoListActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 养殖户主页tab2 服务
 * 包括3个Card：牲畜需求、饲料销售商、养殖技术
 * <p>
 * Created by dong on 22/12/2017.
 */
public class FarmerServiceFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<FarmerServiceModel> modelList;
    private FarmerServiceAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.farmer_service_fragment, container, false);
        return contentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        modelList = new ArrayList<>();
        FarmerServiceModel[] models = {
                new FarmerServiceModel("牲畜需求", LivestockDemandListActivity.class),
                new FarmerServiceModel("饲料销售商", VendorListActivity.class),
                new FarmerServiceModel("养殖技术", BreedingInfoListActivity.class)
        };
        modelList.addAll(Arrays.asList(models));

        recyclerView = contentView.findViewById(R.id.recycler_view);
        adapter = new FarmerServiceAdapter(context, modelList);
        RecyclerView.LayoutManager lm = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }
}
