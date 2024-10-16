package com.tencent.grobot.lite.model.local;

import com.tencent.grobot.lite.model.local.RecommendsInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class NavigationInfo implements Serializable {
    public List<RecommendsInfo.Item> items = new ArrayList();
    public List<TagInfo> tags = new ArrayList();
}
