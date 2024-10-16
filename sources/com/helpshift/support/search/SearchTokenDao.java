package com.helpshift.support.search;

import java.util.List;

/* loaded from: classes2.dex */
public interface SearchTokenDao {
    void clear();

    SearchTokenDto get(String str);

    void save(List<SearchTokenDto> list);
}
