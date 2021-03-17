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
import android.widget.Toast;

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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    public HomeFragment() {

    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private HomeViewModel homeViewModel;
    private RecyclerView homePageRecyclerView;
    private HomePageAdapter adapter;
    private List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<CategoryModel>();

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoryName").toString()));
                            }
                            categoryAdapter.notifyDataSetChanged();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                        }
                    }
                });

//        categoryModelList.add(new CategoryModel("link","Home"));
//        categoryModelList.add(new CategoryModel("link","Electronics"));
//        categoryModelList.add(new CategoryModel("link","Appliances"));
//        categoryModelList.add(new CategoryModel("link","furniture"));
//        categoryModelList.add(new CategoryModel("link","Fashion"));
//        categoryModelList.add(new CategoryModel("link","Toyes"));
//        categoryModelList.add(new CategoryModel("link","Sports"));
//        categoryModelList.add(new CategoryModel("link","Wall Arts"));
//        categoryModelList.add(new CategoryModel("link","Books"));
//        categoryModelList.add(new CategoryModel("link","Shoes"));

        /////Banner Slider


        //////Banner Slider
        /////////// Horizontal Product layout
//        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_person_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_error_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_home_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_share_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_notifications_none_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_shopping_cart_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_send_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_baseline_home_24,"Redmi 5A","SD 625 Processor","Rs 5999/-"));

        /////////// Horizontal Product layout

        ////////////////////////////////////
        homePageRecyclerView = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);
        final List<HomePageModel> homePageModelList = new ArrayList<>();
        adapter = new HomePageAdapter(homePageModelList);
        homePageRecyclerView.setAdapter(adapter);

        firebaseFirestore.collection("CATEGORIES")
                .document("HOME")
                .collection("TOP_DEALS").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                if ((long) documentSnapshot.get("view_type")==0){
                                    List<SliderModel> sliderModelList = new ArrayList<>();
                                    long no_of_banners = (long) documentSnapshot.get("no_of_banners");
                                    for (long x = 1; x < no_of_banners+1; x++) {
                                        sliderModelList.add(new SliderModel(documentSnapshot.get("banner_" + x).toString(), documentSnapshot.get("banner_" + x + "_background").toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(0, sliderModelList));
                                }else if ((long) documentSnapshot.get("view_type")==1){
                                    homePageModelList.add(new HomePageModel(1, documentSnapshot.get("strip_ad_banner").toString(), documentSnapshot.get("background").toString()));
                                }else if ((long) documentSnapshot.get("view_type")==2){

                                }else if ((long) documentSnapshot.get("view_type")==3){
                                }
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                        }
                    }
                });


        //////////////////////////////////////
        return view;
    }
}
