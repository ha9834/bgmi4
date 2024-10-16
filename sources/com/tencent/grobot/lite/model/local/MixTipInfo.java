package com.tencent.grobot.lite.model.local;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class MixTipInfo {
    public static final int POSITION_CENTER = 1;
    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 2;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_TEXT = 1;
    public int format;
    public String resourceId;
    public String title;
    public int views;
    public String thumbImageUrl = "";
    public List<Item> items = new ArrayList();

    /* loaded from: classes2.dex */
    public static final class Item {
        public int floatPosition;
        public String source;
        public int type;
    }
}
