package com.example.mymall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {
private Toolbar toolbar;
private RecyclerView deliveryRecyclerView;
private Button changeOrAddNewAddressBtn;
public static final int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryRecyclerView=findViewById(R.id.delivery_recyclerview);
        changeOrAddNewAddressBtn = findViewById(R.id.change_or_add_address_btn);


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);
        List<CartitemModel> cartitemModelList=new ArrayList<>();
        cartitemModelList.add(new CartitemModel(0,R.drawable.ic_baseline_home_24,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,0,0));
        cartitemModelList.add(new CartitemModel(0,R.drawable.ic_baseline_home_24,"Pixel 2",0,"Rs.49999/-","Rs.59999/-",1,1,0));
        cartitemModelList.add(new CartitemModel(0,R.drawable.ic_baseline_home_24,"Pixel 2",2,"Rs.49999/-","Rs.59999/-",1,2,0)) ;
        cartitemModelList.add(new CartitemModel(1,"Price(3 items)","Rs.169999/-","Free","Rs.169999","Rs.5999"));

        CartAdapter cartAdapter=new CartAdapter(cartitemModelList);
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        changeOrAddNewAddressBtn.setVisibility(View.VISIBLE);
        changeOrAddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myaddressesIntent = new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                myaddressesIntent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(myaddressesIntent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
       if (id == android.R.id.home){
           fileList();
           return true;
       }
        return super.onOptionsItemSelected(item);
    }
}