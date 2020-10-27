package com.example.mymall;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {
    List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public GridProductLayoutAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @Override
    public int getCount() {
        return horizontalProductScrollModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, final ViewGroup viewGroup) {
       View view;
       if (convertView ==null){
           view= LayoutInflater .from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
           view.setElevation(0);
           view.setBackgroundColor(Color.parseColor("#ffffff"));

           view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent productDetailsIntent=new Intent(viewGroup.getContext(),ProductDetailsActivity.class);
                   viewGroup.getContext().startActivity(productDetailsIntent);
               }
           });

           ImageView prouctImage=view.findViewById(R.id.h_s_product_image);
           TextView productTitle=view.findViewById(R.id.h_s_product_title);
           TextView productDescription=view.findViewById(R.id.h_s_product_description);
           TextView productPrice=view.findViewById(R.id.h_s_product_price);

           prouctImage.setImageResource(horizontalProductScrollModelList.get(i).getProductImage());
           productTitle.setText(horizontalProductScrollModelList.get(i).getProductTitle());
           productDescription.setText(horizontalProductScrollModelList.get(i).getProductDescription());
           productPrice.setText(horizontalProductScrollModelList.get(i).getProductPrice());

       }else {
           view=convertView;
       }
       return view;
    }
}
