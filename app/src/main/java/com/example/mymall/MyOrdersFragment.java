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


public class MyOrdersFragment extends Fragment {



    public MyOrdersFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrdersRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrdersRecyclerView=view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrdersRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.productcart,2,"Pixel 2XL (BLACK)","Deliverd on Mon,15th Jan 2013"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.poopmobile,1,"Pixel 2XL (BLACK)","Deliverd on Mon,15th Jan 2013"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.productcart,0,"Pixel 2XL (BLACK)","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.poopmobile,4,"Pixel 2XL (BLACK)","Deliverd on Mon,15th Jan 2013"));

        MyOrderAdapter myOrderAdapter = new  MyOrderAdapter(myOrderItemModelList);
        myOrdersRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;
    }
}