package org.intermine.app.module;

/*
 * Copyright (C) 2015 InterMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.intermine.app.InterMineApplication;
import org.intermine.app.activity.GeneViewActivity;
import org.intermine.app.activity.GenesListActivity;
import org.intermine.app.activity.LoginActivity;
import org.intermine.app.activity.MainActivity;
import org.intermine.app.activity.MinesActivity;
import org.intermine.app.activity.SettingsActivity;
import org.intermine.app.activity.StartActivity;
import org.intermine.app.activity.TemplateActivity;
import org.intermine.app.activity.TemplateResultsActivity;
import org.intermine.app.activity.WebActivity;
import org.intermine.app.fragment.FavoritesListFragment;
import org.intermine.app.fragment.GeneViewFragment;
import org.intermine.app.fragment.GenesListFragment;
import org.intermine.app.fragment.ListsFragment;
import org.intermine.app.fragment.LogInFragment;
import org.intermine.app.fragment.PreferencesFragment;
import org.intermine.app.fragment.SearchFragment;
import org.intermine.app.fragment.TemplatesFragment;
import org.intermine.app.net.request.PostAuthRequest;
import org.intermine.app.net.request.get.GeneSearchRequest;
import org.intermine.app.net.request.get.GetListsRequest;
import org.intermine.app.net.request.get.GetModelRequest;
import org.intermine.app.net.request.get.GetTemplateResultsRequest;
import org.intermine.app.net.request.get.GetTemplatesRequest;
import org.intermine.app.net.request.get.GetTypeFieldsRequest;
import org.intermine.app.net.request.post.AppendGenesToListRequest;
import org.intermine.app.net.request.post.CreateGenesList;
import org.intermine.app.net.request.post.FetchListResultsRequest;
import org.intermine.app.net.request.post.GetUserTokenRequest;
import org.intermine.app.storage.MemoryStorage;
import org.intermine.app.storage.Storage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                StorageModule.class,
                SpiceModule.class
        },
        injects = {
                MemoryStorage.class,
                InterMineApplication.class,
                StartActivity.class,
                GenesListActivity.class,
                GeneViewActivity.class,
                SettingsActivity.class,
                TemplateActivity.class,
                TemplateResultsActivity.class,
                MainActivity.class,
                GenesListActivity.class,
                ListsFragment.class,
                SearchFragment.class,
                GenesListFragment.class,
                TemplatesFragment.class,
                LogInFragment.class,
                GeneViewFragment.class,
                PreferencesFragment.class,
                GetModelRequest.class,
                GeneSearchRequest.class,
                GetTemplateResultsRequest.class,
                GetTemplatesRequest.class,
                AppendGenesToListRequest.class,
                CreateGenesList.class,
                GetListsRequest.class,
                GetUserTokenRequest.class,
                PostAuthRequest.class,
                FetchListResultsRequest.class,
                Storage.class,
                MinesActivity.class,
                WebActivity.class,
                GetTypeFieldsRequest.class,
                FavoritesListFragment.class,
                LoginActivity.class
        }
)
public final class AppModule {
    /**
     * Application gene_view_menu.
     */
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
