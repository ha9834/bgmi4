package com.twitter.sdk.android.core.services;

import a.b;
import a.b.f;
import a.b.t;
import com.twitter.sdk.android.core.models.TwitterCollection;

/* loaded from: classes.dex */
public interface CollectionService {
    @f(a = "/1.1/collections/entries.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    b<TwitterCollection> collection(@t(a = "id") String str, @t(a = "count") Integer num, @t(a = "max_position") Long l, @t(a = "min_position") Long l2);
}
