package com.example.mymall;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductSpecifictionAdapter extends RecyclerView.Adapter<ProductSpecifictionAdapter.ViewHolder> {
    private List<ProductSpecifictionModel> productSpecifictionModelList;

    public ProductSpecifictionAdapter(List<ProductSpecifictionModel> productSpecifictionModelList) {
        this.productSpecifictionModelList = productSpecifictionModelList;
    }

    @NonNull
    @Override
    public ProductSpecifictionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {switch (viewType) {
        case ProductSpecifictionModel.SPECIFICATION_TITLE:
            TextView title=new TextView(viewGroup.getContext());
            title.setTypeface(null, Typeface.BOLD);
            title.setTextColor(Color.parseColor("#000000"));
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(setDp(16,viewGroup.getContext()),
                    setDp(16,viewGroup.getContext()),
                    setDp(16,viewGroup.getContext()),
                    setDp(8,viewGroup.getContext()));
            title.setLayoutParams(layoutParams);
            return new ViewHolder(title);
        case ProductSpecifictionModel.SPECIFICATION_BODY:
            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_specifiction_item_layout,viewGroup,false);
            return new ViewHolder(view);
        default:
            return null;
    }

    }
    @Override
    public int getItemViewType(int position) {
        switch (productSpecifictionModelList.get(position).getType()){
            case 0:
                return ProductSpecifictionModel.SPECIFICATION_TITLE;
            case 1:
                return ProductSpecifictionModel.SPECIFICATION_BODY;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecifictionAdapter.ViewHolder viewHolder, int position) {
        switch (productSpecifictionModelList.get(position).getType()){
            case ProductSpecifictionModel.SPECIFICATION_TITLE:
                viewHolder.setTitle(productSpecifictionModelList.get(position).getTitle());
                break;
            case ProductSpecifictionModel.SPECIFICATION_BODY:
                String featureTitle=productSpecifictionModelList.get(position).getFeatureName();
                String featureDetail=productSpecifictionModelList.get(position).getFratureValue();
                viewHolder.setFeature(featureTitle,featureDetail);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return productSpecifictionModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName;
        private TextView featureValue;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        private void setTitle(String titleText){
            title= (TextView) itemView;
            title.setText(titleText);
        }
        private void setFeature(String featureTitle,String featureDetail){
            featureName=itemView.findViewById(R.id.feature_name);
            featureValue=itemView.findViewById(R.id.feture_value);
            featureName.setText(featureTitle);
            featureValue.setText(featureDetail);
        }
    }
    private int setDp(int dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());

    }
}
