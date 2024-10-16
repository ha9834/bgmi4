package com.tencent.grobot.lite.ui.presenter;

import com.tencent.grobot.lite.model.local.UploadImageInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface IUploadView {
    void onPhotoSelected(ArrayList<UploadImageInfo> arrayList);

    void updateUploadImageProgress(String str, int i, String str2, String str3);
}
