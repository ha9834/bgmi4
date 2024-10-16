package com.tencent.grobot.lite.search;

import com.tencent.grobot.lite.model.local.RecommendsInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface ISearchView {
    void onGetHotKeyword(String str, ArrayList<String> arrayList);

    void onSearchResult(String str, RecommendsInfo recommendsInfo);
}
