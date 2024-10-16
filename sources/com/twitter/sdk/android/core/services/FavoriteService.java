package com.twitter.sdk.android.core.services;

import a.b;
import a.b.c;
import a.b.e;
import a.b.f;
import a.b.o;
import a.b.t;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

/* loaded from: classes.dex */
public interface FavoriteService {
    @o(a = "/1.1/favorites/create.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    @e
    b<Tweet> create(@c(a = "id") Long l, @c(a = "include_entities") Boolean bool);

    @o(a = "/1.1/favorites/destroy.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    @e
    b<Tweet> destroy(@c(a = "id") Long l, @c(a = "include_entities") Boolean bool);

    @f(a = "/1.1/favorites/list.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    b<List<Tweet>> list(@t(a = "user_id") Long l, @t(a = "screen_name") String str, @t(a = "count") Integer num, @t(a = "since_id") String str2, @t(a = "max_id") String str3, @t(a = "include_entities") Boolean bool);
}
