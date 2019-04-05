package com.example.ainurbayanova.degirmen.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ainurbayanova.degirmen.R;
import com.example.ainurbayanova.degirmen.adapters.MealAdapter;
import com.example.ainurbayanova.degirmen.adapters.MealTypeAdapter;
import com.example.ainurbayanova.degirmen.models.Meals;
import com.example.ainurbayanova.degirmen.views.dialogs.TypesDialog;
import com.example.ainurbayanova.degirmen.views.interfaces.AnimationCallback;
import com.example.ainurbayanova.degirmen.views.interfaces.ClickItemInterface;
import com.example.ainurbayanova.degirmen.views.interfaces.TypesDataInterface;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MealsFragment extends Fragment implements View.OnClickListener{
    View view;

    @BindView(R.id.showType)
    ImageView showCategoriesFragment;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.typesRecyclerView)
    RecyclerView typeRecyclerView;
    Unbinder unbinder;

    MealAdapter productAdapter;
    MealTypeAdapter mealTypeAdapter;

    ArrayList<Meals> listOfProducts = new ArrayList<>();
    ArrayList<String> typesOfProducts = new ArrayList<>();

    TypesDialog typesDialog = new TypesDialog();

    ScaleAnimation fade_in;
    ScaleAnimation fade_out;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.meals_fragment,container,false);
        unbinder = ButterKnife.bind(this,view);
        initializeScaleAnimations();

        generateListOfProducts();

        integrateProductAdapter();
        intergrateTypeOfMealAdapter();
        clickListenerForAdapters();

        if (showCategoriesFragment != null) {
            showCategoriesFragment.setOnClickListener(this);
        }
        return view;
    }

    public void initializeScaleAnimations(){
        fade_in = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_out = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        fade_out.setDuration(1000);
        fade_out.setFillAfter(true);

        fade_in.setDuration(1000);
        fade_in.setFillAfter(true);
    }

    public void generateListOfProducts(){
        listOfProducts.add(new Meals("Салат","https://cdn.lifehacker.ru/wp-content/uploads/2018/08/2Cesar_1533672706-630x315.jpeg","Картошка с ново выпеченным",700,200,true));
        listOfProducts.add(new Meals("Манты","http://1cookit.com/uploads/posts/2013-05/1369083155_69910584_0_9ef0_1ecaede5_xl.jpg","Картошка с ново выпеченным",700,200,false));
        listOfProducts.add(new Meals("Котлеты","http://povarenysh.ru/upload/content/ochen-vkusnoe-blyudo.jpg","Картошка с ново выпеченным",700,200,true));
    }
    public void integrateProductAdapter(){
        productAdapter = new MealAdapter(listOfProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(productAdapter);
    }

    public void intergrateTypeOfMealAdapter(){
        mealTypeAdapter = new MealTypeAdapter(typesOfProducts);
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        typeRecyclerView.setAdapter(mealTypeAdapter);
    }

    public void clickListenerForAdapters(){
        productAdapter.setClickListener(new ClickItemInterface() {
            @Override
            public void clickItem(int position) {
                Toast.makeText(getActivity(),"Not bad",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void addCheckBoxTitle(int id) {

            }

            @Override
            public void deleteCheckBoxTitle(int id) {

            }
        });
        mealTypeAdapter.setClickListener(new ClickItemInterface() {
            @Override
            public void clickItem(int position) {
                Toast.makeText(getActivity(),"Not bad",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void addCheckBoxTitle(int id) {

            }

            @Override
            public void deleteCheckBoxTitle(int id) {

            }
        });
        typesDialog.setTypesDataInterface(new TypesDataInterface() {
            @Override
            public void listOfTypes(ArrayList<String> list) {
                typesOfProducts.clear();
                typesOfProducts.addAll(list);
                mealTypeAdapter.notifyDataSetChanged();
            }
        });
        mealTypeAdapter.initializeAnimationCallback(new AnimationCallback() {
            @Override
            public void callIt(View view) {
                view.startAnimation(fade_in);
            }

            @Override
            public void deleteIt(int position,View view) {
                view.startAnimation(fade_out);
                typesOfProducts.remove(position);
                mealTypeAdapter.notifyItemRemoved(position);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.showType){
            typesDialog.show(getActivity().getSupportFragmentManager(),"Title");
        }
    }

}
