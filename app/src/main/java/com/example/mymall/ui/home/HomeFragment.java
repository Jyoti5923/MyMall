package com.example.mymall.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mymall.CategoryAdapter;
import com.example.mymall.CategoryModel;
import com.example.mymall.GridProductLayoutAdapter;
import com.example.mymall.HomePageAdapter;
import com.example.mymall.HomePageModel;
import com.example.mymall.HorizontalProductScrollAdapter;
import com.example.mymall.HorizontalProductScrollModel;
import com.example.mymall.R;
import com.example.mymall.SliderAdapter;
import com.example.mymall.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    public HomeFragment(){

    }
private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private HomeViewModel homeViewModel;
    private  RecyclerView testing;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
       categoryRecyclerView=view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel>categoryModelList=new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Appliances"));
        categoryModelList.add(new CategoryModel("link","furniture"));
        categoryModelList.add(new CategoryModel("link","Fashion"));
        categoryModelList.add(new CategoryModel("link","Toyes"));
        categoryModelList.add(new CategoryModel("link","Sports"));
        categoryModelList.add(new CategoryModel("link","Wall Arts"));
        categoryModelList.add(new CategoryModel("link","Books"));
        categoryModelList.add(new CategoryModel("link","Shoes"));
        categoryAdapter=new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        /////Banner Slider

      List<SliderModel> sliderModelList=new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.emailsuccess,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.bannere,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_shopping_cart_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_control_point_24,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_baseline_person_24,"#077AE4"));

        //////Banner Slider
        /////////// Horizontal Product layout
        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_person_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_error_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_home_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_share_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_notifications_none_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_shopping_cart_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_send_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_home_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));

        /////////// Horizontal Product layout

        ////////////////////////////////////
        testing=view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager=new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#ff0000"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad,"#ff0000"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        HomePageAdapter adapter =new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //////////////////////////////////////
        return view;
    }
}
