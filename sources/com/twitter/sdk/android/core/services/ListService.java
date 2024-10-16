package com.twitter.sdk.android.core.services;

import a.b;
import a.b.f;
import a.b.t;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

/* loaded from: classes.dex */
public interface ListService {
    @f(a = "/1.1/lists/statuses.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    b<List<Tweet>> statuses(@t(a = "list_id") Long l, @t(a = "slug") String str, @t(a = "owner_screen_name") String str2, @t(a = "owner_id") Long l2, @t(a = "since_id") Long l3, @t(a = "max_id") Long l4, @t(a = "count") Integer num, @t(a = "include_entities") Boolean bool, @t(a = "include_rts") Boolean bool2);
}
