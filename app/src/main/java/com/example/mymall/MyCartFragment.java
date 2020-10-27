package com.example.mymall;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {


    public MyCartFragment() {

    }
    private RecyclerView cartItemsRecyclerView;
    private Button continueBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView=view.findViewById(R.id.cart_items_recyclerview);
        continueBtn = view.findViewById(R.id.cart_continue_btn);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);
        List<CartitemModel> cartitemModelList=new ArrayList<>();
        cartitemModelList.add(new CartitemModel(0,R.drawable.ic_baseline_home_24,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,0,0));
        cartitemModelList.add(new CartitemModel(0,R.drawable.ic_baseline_home_24,"Pixel 2",0,"Rs.49999/-","Rs.59999/-",1,1,0));
        cartitemModelList.add(new CartitemModel(0,R.drawable.ic_baseline_home_24,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,2,0)) ;
        cartitemModelList.add(new CartitemModel(1,"Price(3 items)","Rs.169999/-","Free","Rs.169999","Rs.5999"));

        CartAdapter cartAdapter=new CartAdapter(cartitemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deliveryIntent = new Intent(getContext(),AddAddressActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });
        return view;
    }

}