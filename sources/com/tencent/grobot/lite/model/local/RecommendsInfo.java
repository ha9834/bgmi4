package com.tencent.grobot.lite.model.local;

import com.tencent.grobot.lite.model.local.MixTipInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class RecommendsInfo implements Serializable {
    public static final int ICON_HOT = 0;
    public static final int ICON_NEW = 1;
    public static final int ICON_NONE = -1;
    public static final int TYPE_A = 0;
    public static final int TYPE_B = 1;
    public static final int TYPE_C = 2;
    public static final int TYPE_QUESTION = 12;
    public static final int TYPE_TIP = 11;
    public static final int TYPE_VIDEO = 10;
    public String id;
    public final List<Item> items = new ArrayList();
    public String name;
    public int type;

    /* loaded from: classes2.dex */
    public static final class Item {
        public String contentFormat;
        public int icon;
        public String image;
        public String name;
        public String question;
        public String recommendTitle;
        public String resourceId;
        public int type;
        public long updateTime;
        public String url;
        public String videoId;
        public long views;
        public int vszie;
        public int vt;
        public List<MixTipInfo.Item> tips = new ArrayList();
        public List<String> subtitle = new ArrayList();
        public boolean selected = false;
    }
}
