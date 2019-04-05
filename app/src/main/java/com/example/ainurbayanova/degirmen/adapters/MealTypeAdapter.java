package com.example.ainurbayanova.degirmen.adapters;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.ainurbayanova.degirmen.R;
import com.example.ainurbayanova.degirmen.models.Meals;
import com.example.ainurbayanova.degirmen.models.TypeOfMeals;
import com.example.ainurbayanova.degirmen.views.interfaces.AnimationCallback;
import com.example.ainurbayanova.degirmen.views.interfaces.ClickItemInterface;

import java.util.ArrayList;

public class MealTypeAdapter extends RecyclerView.Adapter<MealTypeAdapter.EmployeeViewHolder> {
    ClickItemInterface clickItemInterface;
    ArrayList<String> dataList;
    AnimationCallback animationCallback;

    public MealTypeAdapter(ArrayList<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design_types_of_meals, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        String product = dataList.get(position);
        holder.title.setText(product);
        animationCallback.callIt(holder.cardView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        CardView cardView;
        EmployeeViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.nameOfType);
            cardView = itemView.findViewById(R.id.linearLayout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItemInterface.clickItem(getAdapterPosition());

                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animationCallback.deleteIt(getPosition(),cardView);
                }
            });
        }
    }

    public void setClickListener(ClickItemInterface clickItemInterface){
        this.clickItemInterface = clickItemInterface;
    }

    public void initializeAnimationCallback(AnimationCallback animationCallback){
        this.animationCallback = animationCallback;
    }
}