package com.tencent.imsdk.android.api.relation;

/* loaded from: classes.dex */
public class IMSDKFriendReqInfo {
    public static final int TYPE_DIALOG_LINK = 3;
    public static final int TYPE_DIALOG_PICTURE = 5;
    public static final int TYPE_DIALOG_TEXT = 1;
    public static final int TYPE_SILENT_LINK = 2;
    public static final int TYPE_SILENT_PICTURE = 4;
    public static final int TYPE_SILENT_TEXT = 0;
    public String content;
    public String extraJson;
    public String imagePath;
    public String link;
    public String thumbPath;
    public String title;
    public int type;
    public String user;

    public String toString() {
        return "IMSDKFriendReqInfo{type=" + this.type + ", user='" + this.user + "', title='" + this.title + "', content='" + this.content + "', link='" + this.link + "', thumbPath='" + this.thumbPath + "', imagePath='" + this.imagePath + "', extraJson='" + this.extraJson + "'}";
    }
}
