package com.example.mymall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.mymall.MainActivity.showCart;

public class ProductDetailsActivity extends AppCompatActivity {
    private ViewPager productImagesViewPager;
    private TabLayout viewpagerIndicator;
    private Button coupenRedeemBtn;

    /////coupendialog
    public static TextView coupenTitle;
    public static TextView coupenExpiryDate;
    public static TextView coupenBody;
    private static RecyclerView coupensRecyclerView;
    private static LinearLayout selectedCoupen;
    /////coupendialog

    /////////layou3
    private ViewPager productDtailsViewPager;
    private TabLayout productDeatailsTablayout;
    /////////layout3

    //////////rating Layout
private LinearLayout rateNowContainer;
    //////////rating Layout

    private Button buyNowBtn;

    private static boolean ALLREADY_ADD_TO_WISHLIST=false;
    private FloatingActionButton addToWishlistBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        productImagesViewPager=findViewById(R.id.product_images_viewpager);
        viewpagerIndicator=findViewById(R.id.viewpager_indicator);
        addToWishlistBtn =findViewById(R.id.add_to_wishlist_btn);
        /////////layout3#
        productDtailsViewPager=findViewById(R.id.product_details_viewpager);
        productDeatailsTablayout=findViewById(R.id.product_details_tablayout);
        /////////layout3
        buyNowBtn=findViewById(R.id.buy_now_btn);
        coupenRedeemBtn = findViewById(R.id.coupen_redemtion_btn);

        List<Integer>productImages=new ArrayList<>();
        productImages.add(R.drawable.product);
        productImages.add(R.drawable.bannere);
        productImages.add(R.drawable.banner);
        productImages.add(R.drawable.product);

        ProductImagesAdapter productImagesAdapter=new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);
       viewpagerIndicator.setupWithViewPager(productImagesViewPager,true);
       addToWishlistBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (ALLREADY_ADD_TO_WISHLIST){
                   ALLREADY_ADD_TO_WISHLIST=false;
                   addToWishlistBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
               }else {
                   ALLREADY_ADD_TO_WISHLIST=true;
                   addToWishlistBtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));
               }
           }
       });
        /////////layout3#
        productDtailsViewPager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDeatailsTablayout.getTabCount()));
        productDtailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDeatailsTablayout));
        productDeatailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDtailsViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        /////////layout3


        //////////////rating layout
        rateNowContainer=findViewById(R.id.rate_now_container);
        for (int x = 0;x < rateNowContainer.getChildCount();x++){
            final int starPosition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setRating(starPosition);
                }
            });

        }
        //////////rating Layout
        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deliveryIntent = new Intent(ProductDetailsActivity.this,DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });

        ////////coupen dialog
        final Dialog checkCoupenPriceDialog =new Dialog(ProductDetailsActivity.this);
        checkCoupenPriceDialog.setContentView(R.layout.coupen_redeem_dialog);
        checkCoupenPriceDialog.setCancelable(true);
        checkCoupenPriceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView toggleRecyclerView = checkCoupenPriceDialog.findViewById(R.id.toggle_recyclerview);
        coupensRecyclerView =checkCoupenPriceDialog.findViewById(R.id.coupens_recyclerview);
        selectedCoupen = checkCoupenPriceDialog.findViewById(R.id.selected_coupen);
        coupenTitle = checkCoupenPriceDialog.findViewById(R.id.coupen_title);
        coupenExpiryDate = checkCoupenPriceDialog.findViewById(R.id.coupen_validity);
        coupenBody = checkCoupenPriceDialog.findViewById(R.id.coupen_body);

        TextView originalPrice = checkCoupenPriceDialog.findViewById(R.id.original_price);
        TextView discountedPrice = checkCoupenPriceDialog.findViewById(R.id.discounted_price);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ProductDetailsActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        coupensRecyclerView.setLayoutManager(layoutManager);
        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Discount","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Buy 1 get 1 free","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Cashback","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Discount","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Buy 1 get 1 free","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Cashback","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Discount","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Buy 1 get 1 free","till 2nd,Jun 2020","GET 20% OFF on any product above Rs.200/- and below Rs.3000/-."));

        MyRewardAdaapter myRewardAdaapter= new MyRewardAdaapter(rewardModelList,true);
        coupensRecyclerView.setAdapter(myRewardAdaapter);
        myRewardAdaapter.notifyDataSetChanged();

        toggleRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogRecyclerView();
            }
        });
        ///////coupen dialog


        coupenRedeemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCoupenPriceDialog.show();
            }
        });
    }
    public static void showDialogRecyclerView(){
        if (coupensRecyclerView.getVisibility() == View.GONE){
            coupensRecyclerView.setVisibility(View.VISIBLE);
            selectedCoupen.setVisibility(View.GONE);
        }else {
            coupensRecyclerView.setVisibility(View.GONE);
            selectedCoupen.setVisibility(View.VISIBLE);
        }
    }
    private void setRating(int starPosition) {
        for (int x = 0;x < rateNowContainer.getChildCount(); x++){
            ImageView starBtn = (ImageView)rateNowContainer.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (x <= starPosition){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            //todo:search
            finish();
            return true;
        }else if (id == R.id.main_search_icon){
            //             todo:notification
            return true;
        } else if (id == R.id.main_cart_icon) {
//            todo:cart
            Intent cartIntent = new Intent(ProductDetailsActivity.this,MainActivity.class);
            showCart = true;
            startActivity(cartIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}