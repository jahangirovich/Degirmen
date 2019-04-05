package com.example.ainurbayanova.degirmen.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.example.ainurbayanova.degirmen.R;
import com.example.ainurbayanova.degirmen.di.scopes.ActivityScope;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DrawerModule {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Context context;
    int open;
    int close;

    public DrawerModule(DrawerLayout drawerLayout,Toolbar toolbar,Context context,int open,int close){
        this.drawerLayout = drawerLayout;
        this.toolbar = toolbar;
        this.context = context;
        this.close = close;
        this.open = open;
    }

    @Provides
    @ActivityScope
    ActionBarDrawerToggle toggle(){
        return new ActionBarDrawerToggle((Activity) context,drawerLayout,toolbar,open,close);
    }

}
