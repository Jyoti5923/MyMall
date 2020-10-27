package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.mymall.DeliveryActivity.SELECT_ADDRESS;

public class MyAddressesActivity extends AppCompatActivity {
Toolbar toolbar;
private RecyclerView myAddressesRecyclerView;
private Button deliverHereBtn;
private static AddressesAdapter addressesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myAddressesRecyclerView = findViewById(R.id.addresses_recyclerview);
        deliverHereBtn = findViewById(R.id.deliver_here_btn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myAddressesRecyclerView.setLayoutManager(layoutManager);

        List<AddressesModel>addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("John Doe","jdjfdkljdlkgjkdlgdlfg","488888",true));
        addressesModelList.add(new AddressesModel("John sbe","jdjfdkljdlkgjkdlgdlfg","675767",false));
        addressesModelList.add(new AddressesModel("John sas","jdjfdkljdlkgjkdlgdlfg","575777",false));
        addressesModelList.add(new AddressesModel("John ffv","jdjfdkljdlkgjkdlgdlfg","675757",false));
        addressesModelList.add(new AddressesModel("John rter","jdjfdkljdlkgjkdlgdlfg","567575",false));
        addressesModelList.add(new AddressesModel("John bnv","jdjfdkljdlkgjkdlgdlfg","567567",false));
        addressesModelList.add(new AddressesModel("John wee","jdjfdkljdlkgjkdlgdlfg","567576",false));
        addressesModelList.add(new AddressesModel("John sdsd","jdjfdkljdlkgjkdlgdlfg","57575",false));

        int mode = getIntent().getIntExtra("MODE",-1);
        if (mode == SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }else {
            deliverHereBtn.setVisibility(View.GONE);
        }

        addressesAdapter = new AddressesAdapter(addressesModelList,mode);
        myAddressesRecyclerView.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myAddressesRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();
    }
    public static void refreshItem(int deselected, int select){
        addressesAdapter.notifyItemChanged(deselected);
        addressesAdapter.notifyItemChanged(select);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}