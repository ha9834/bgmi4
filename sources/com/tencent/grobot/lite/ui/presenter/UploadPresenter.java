package com.tencent.grobot.lite.ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.image.ImagePresenter;
import com.tencent.grobot.lite.image.model.ImageItemInfo;
import com.tencent.grobot.lite.image.upload.UploadManager;
import com.tencent.grobot.lite.model.local.UploadImageInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class UploadPresenter implements ImagePresenter.ImageListener, UploadManager.OnUploadListener {
    public static final int CODE_SYSTEM_GALLERY = 4096;
    private static final String TAG = "UploadPresenter";
    private IUploadView uploadView;
    private HashMap<String, String> uploadPhotoResultMap = new HashMap<>();
    private ArrayList<ImageItemInfo> mSelectedList = new ArrayList<>();

    public UploadPresenter(IUploadView iUploadView) {
        this.uploadView = iUploadView;
        UploadManager.getInstance(GRobotApplication.self()).setOnUploadListener(this);
        ImagePresenter.getInstance().setImageListener(this);
    }

    public void addPic(Context context, int i) {
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 4096);
        }
    }

    public void onAddPicCallBack(Context context, Intent intent) {
        if (intent == null) {
            TLog.d(TAG, "onAddPicCallBack, data is null.");
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            TLog.d(TAG, "onAddPicCallBack, selectedImage is null.");
            return;
        }
        String[] strArr = {"_data"};
        Cursor query = context.getContentResolver().query(data, strArr, null, null, null);
        if (query == null) {
            TLog.d(TAG, "onAddPicCallBack, cursor is null.");
            return;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex(strArr[0]));
        query.close();
        File file = new File(string);
        if (file.exists() && file.isFile()) {
            UploadManager.getInstance(GRobotApplication.self()).uploadPhoto(file.getAbsolutePath());
            ArrayList<UploadImageInfo> arrayList = new ArrayList<>();
            UploadImageInfo uploadImageInfo = new UploadImageInfo();
            String absolutePath = file.getAbsolutePath();
            uploadImageInfo.imagePath = absolutePath;
            if (this.uploadPhotoResultMap.containsKey(absolutePath)) {
                uploadImageInfo.cosName = this.uploadPhotoResultMap.get(absolutePath);
                uploadImageInfo.progress = 100;
            }
            arrayList.add(uploadImageInfo);
            IUploadView iUploadView = this.uploadView;
            if (iUploadView != null) {
                iUploadView.onPhotoSelected(arrayList);
            }
        }
    }

    @Override // com.tencent.grobot.lite.image.upload.UploadManager.OnUploadListener
    public void onUploadProgress(String str, long j, long j2, String str2) {
        IUploadView iUploadView = this.uploadView;
        if (iUploadView != null) {
            iUploadView.updateUploadImageProgress(str, (int) ((j * 100) / j2), "", str2);
        }
    }

    @Override // com.tencent.grobot.lite.image.upload.UploadManager.OnUploadListener
    public void onUploadSucceed(String str, String str2, String str3) {
        this.uploadPhotoResultMap.put(str2, str3);
        IUploadView iUploadView = this.uploadView;
        if (iUploadView != null) {
            iUploadView.updateUploadImageProgress(str2, 100, str, str3);
        }
    }

    @Override // com.tencent.grobot.lite.image.upload.UploadManager.OnUploadListener
    public void onUploadFailed(String str, String str2, String str3) {
        IUploadView iUploadView = this.uploadView;
        if (iUploadView != null) {
            iUploadView.updateUploadImageProgress(str2, 0, "", str3);
        }
    }

    @Override // com.tencent.grobot.lite.image.ImagePresenter.ImageListener
    public void onPhotoSelected(ArrayList<ImageItemInfo> arrayList) {
        this.mSelectedList.clear();
        this.mSelectedList.addAll(arrayList);
        ArrayList<UploadImageInfo> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return;
        }
        Iterator<ImageItemInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            ImageItemInfo next = it.next();
            UploadImageInfo uploadImageInfo = new UploadImageInfo();
            String str = next.path;
            uploadImageInfo.imagePath = str;
            if (this.uploadPhotoResultMap.containsKey(str)) {
                uploadImageInfo.cosName = this.uploadPhotoResultMap.get(str);
                uploadImageInfo.progress = 100;
            }
            arrayList2.add(uploadImageInfo);
        }
        IUploadView iUploadView = this.uploadView;
        if (iUploadView != null) {
            iUploadView.onPhotoSelected(arrayList2);
        }
    }
}
