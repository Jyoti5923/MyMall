package com.example.mymall;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProductSpecificationFragment extends Fragment {


    public ProductSpecificationFragment() {
        // Required empty public constructor
    }
    private RecyclerView productSpecifictionRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_specification, container, false);
        productSpecifictionRecyclerView=view.findViewById(R.id.product_specifiction_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        productSpecifictionRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductSpecifictionModel> productSpecifictionModelList=new ArrayList<>();
        productSpecifictionModelList.add(new ProductSpecifictionModel(0,"General"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(0,"Display"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(0,"General"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(0,"Display"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));
        productSpecifictionModelList.add(new ProductSpecifictionModel(1,"RAM","4GB"));

        ProductSpecifictionAdapter productSpecifictionAdapter=new ProductSpecifictionAdapter(productSpecifictionModelList);
        productSpecifictionRecyclerView.setAdapter(productSpecifictionAdapter);
        productSpecifictionAdapter.notifyDataSetChanged();
        return view;
    }
}