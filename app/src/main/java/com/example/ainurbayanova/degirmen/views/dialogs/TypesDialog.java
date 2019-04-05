package com.example.ainurbayanova.degirmen.views.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.ainurbayanova.degirmen.R;
import com.example.ainurbayanova.degirmen.adapters.ListOfTypeAdapter;
import com.example.ainurbayanova.degirmen.views.interfaces.ClickItemInterface;
import com.example.ainurbayanova.degirmen.views.interfaces.TypesDataInterface;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypesDialog extends DialogFragment{
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<String> listOfDoneTypes = new ArrayList<>();
    ListOfTypeAdapter listOfTypeAdapter;
    TypesDataInterface typesDataInterface;
    View view;
    @BindView(R.id.button)
    Button button;
    AlertDialog alertDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.design_types_for_dialog,null);
        alertDialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
        ButterKnife.bind(this,view);

        generateListOfStrings();
        integrateAdapters();

        clickListeners();

        return alertDialog;
    }

    private void clickListeners() {
        listOfDoneTypes.clear();
        listOfTypeAdapter.setClickListener(new ClickItemInterface() {
            @Override
            public void clickItem(int position) {

            }

            @Override
            public void addCheckBoxTitle(int id) {
                listOfDoneTypes.add(strings.get(id));
            }

            @Override
            public void deleteCheckBoxTitle(int id) {
                listOfDoneTypes.remove(strings.get(id));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typesDataInterface.listOfTypes(listOfDoneTypes);
                alertDialog.dismiss();
            }
        });
    }

    private void integrateAdapters() {
        listOfTypeAdapter = new ListOfTypeAdapter(strings);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(listOfTypeAdapter);
    }

    private void generateListOfStrings() {
        strings.clear();
        strings.add("Soups");
        strings.add("Chocolates");
        strings.add("Kotleti");
    }

    public void setTypesDataInterface(TypesDataInterface typesDataInterface){
        this.typesDataInterface = typesDataInterface;
    }
}
