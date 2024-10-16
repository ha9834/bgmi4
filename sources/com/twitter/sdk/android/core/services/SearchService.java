package com.twitter.sdk.android.core.services;

import a.b;
import a.b.f;
import a.b.t;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.services.params.Geocode;

/* loaded from: classes.dex */
public interface SearchService {
    @f(a = "/1.1/search/tweets.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    b<Search> tweets(@t(a = "q") String str, @t(a = "geocode", b = true) Geocode geocode, @t(a = "lang") String str2, @t(a = "locale") String str3, @t(a = "result_type") String str4, @t(a = "count") Integer num, @t(a = "until") String str5, @t(a = "since_id") Long l, @t(a = "max_id") Long l2, @t(a = "include_entities") Boolean bool);
}
