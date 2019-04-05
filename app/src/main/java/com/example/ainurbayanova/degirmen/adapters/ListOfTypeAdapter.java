package com.example.ainurbayanova.degirmen.adapters;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.ainurbayanova.degirmen.R;
import com.example.ainurbayanova.degirmen.models.Meals;
import com.example.ainurbayanova.degirmen.views.interfaces.ClickItemInterface;

import java.util.ArrayList;

public class ListOfTypeAdapter extends RecyclerView.Adapter<ListOfTypeAdapter.EmployeeViewHolder> {
    ClickItemInterface clickItemInterface;
    ArrayList<String> dataList;

    public ListOfTypeAdapter(ArrayList<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design_menu_categories, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        String product = dataList.get(position);
        holder.title.setText(product);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        CheckBox title;
        LinearLayout linearLayout;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.checkBox);
            linearLayout = itemView.findViewById(R.id.container);
            title.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        clickItemInterface.addCheckBoxTitle(getAdapterPosition());
                    } else {
                        clickItemInterface.deleteCheckBoxTitle(getAdapterPosition());
                    }
                }
            });
        }
    }

    public void setClickListener(ClickItemInterface clickItemInterface) {
        this.clickItemInterface = clickItemInterface;
    }
}