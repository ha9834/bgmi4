package com.tencent.grobot.lite.model.local;

/* loaded from: classes2.dex */
public class ContainerInfo {
    public static final int CONTAINER_TYPE_PIC = 1;
    public static final int CONTAINER_TYPE_QUESTION = 4;
    public static final int CONTAINER_TYPE_TIP = 3;
    public static final int CONTAINER_TYPE_VIDEO = 2;
    public int itemType = 0;
    public PicItemInfo picInfo = null;
    public VideoItemInfo videoInfo = null;
    public MixTipInfo tipInfo = null;
    public QuestionInfo questionInfo = null;
}
