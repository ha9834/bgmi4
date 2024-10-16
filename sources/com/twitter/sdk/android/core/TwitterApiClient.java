package com.twitter.sdk.android.core;

import a.a.a.a;
import a.m;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.OkHttpClientHelper;
import com.twitter.sdk.android.core.models.BindingValues;
import com.twitter.sdk.android.core.models.BindingValuesAdapter;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.services.CollectionService;
import com.twitter.sdk.android.core.services.ConfigurationService;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.core.services.ListService;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.services.SearchService;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.x;

/* loaded from: classes.dex */
public class TwitterApiClient {
    final m retrofit;
    final ConcurrentHashMap<Class, Object> services;

    public TwitterApiClient() {
        this(OkHttpClientHelper.getOkHttpClient(TwitterCore.getInstance().getGuestSessionProvider()), new TwitterApi());
    }

    public TwitterApiClient(x xVar) {
        this(OkHttpClientHelper.getCustomOkHttpClient(xVar, TwitterCore.getInstance().getGuestSessionProvider()), new TwitterApi());
    }

    public TwitterApiClient(TwitterSession twitterSession) {
        this(OkHttpClientHelper.getOkHttpClient(twitterSession, TwitterCore.getInstance().getAuthConfig()), new TwitterApi());
    }

    public TwitterApiClient(TwitterSession twitterSession, x xVar) {
        this(OkHttpClientHelper.getCustomOkHttpClient(xVar, twitterSession, TwitterCore.getInstance().getAuthConfig()), new TwitterApi());
    }

    TwitterApiClient(x xVar, TwitterApi twitterApi) {
        this.services = buildConcurrentMap();
        this.retrofit = buildRetrofit(xVar, twitterApi);
    }

    private m buildRetrofit(x xVar, TwitterApi twitterApi) {
        return new m.a().a(xVar).a(twitterApi.getBaseHostUrl()).a(a.a(buildGson())).a();
    }

    private Gson buildGson() {
        return new GsonBuilder().registerTypeAdapterFactory(new SafeListAdapter()).registerTypeAdapterFactory(new SafeMapAdapter()).registerTypeAdapter(BindingValues.class, new BindingValuesAdapter()).create();
    }

    private ConcurrentHashMap buildConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public AccountService getAccountService() {
        return (AccountService) getService(AccountService.class);
    }

    public FavoriteService getFavoriteService() {
        return (FavoriteService) getService(FavoriteService.class);
    }

    public StatusesService getStatusesService() {
        return (StatusesService) getService(StatusesService.class);
    }

    public SearchService getSearchService() {
        return (SearchService) getService(SearchService.class);
    }

    public ListService getListService() {
        return (ListService) getService(ListService.class);
    }

    public CollectionService getCollectionService() {
        return (CollectionService) getService(CollectionService.class);
    }

    public ConfigurationService getConfigurationService() {
        return (ConfigurationService) getService(ConfigurationService.class);
    }

    public MediaService getMediaService() {
        return (MediaService) getService(MediaService.class);
    }

    protected <T> T getService(Class<T> cls) {
        if (!this.services.contains(cls)) {
            this.services.putIfAbsent(cls, this.retrofit.a(cls));
        }
        return (T) this.services.get(cls);
    }
}
