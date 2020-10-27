package com.example.mymall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        /////Banner Slider

        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_control_point_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_person_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.emailsuccess, "#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.email, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.bannere, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_shopping_cart_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_control_point_24, "#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_person_24, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.emailsuccess, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.email, "#077AE4"));


        //////Banner Slider
        /////////// Horizontal Product layout
        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_person_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_error_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_home_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_share_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_notifications_none_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_shopping_cart_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_send_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_home_24, "Redmi 5A", "SD 625 Processor", "Rs 5999/-"));

        /////////// Horizontal Product layout

        ////////////////////////////////////
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.stripad, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Deals of the Day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the Day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.stripad, "#ff0000"));
        homePageModelList.add(new HomePageModel(3, "Deals of the Day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2, "Deals of the Day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.banner, "#ffff00"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        }else if (id== android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}