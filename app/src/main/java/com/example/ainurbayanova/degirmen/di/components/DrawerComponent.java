package com.example.ainurbayanova.degirmen.di.components;

import com.example.ainurbayanova.degirmen.MainActivity;
import com.example.ainurbayanova.degirmen.di.modules.DrawerModule;
import com.example.ainurbayanova.degirmen.di.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {DrawerModule.class})
public interface DrawerComponent {
    void inject(MainActivity mainActivity);
}
