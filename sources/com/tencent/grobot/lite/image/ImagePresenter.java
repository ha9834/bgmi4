package com.tencent.grobot.lite.image;

import android.text.TextUtils;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.image.model.ImageItemInfo;
import com.tencent.grobot.lite.image.upload.UploadManager;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ImagePresenter {
    private static ImagePresenter instance;
    private static int mMaxNum;
    private static ArrayList<ImageItemInfo> mSelectedList = new ArrayList<>();
    private ImageListener listener;

    /* loaded from: classes2.dex */
    public interface ImageListener {
        void onPhotoSelected(ArrayList<ImageItemInfo> arrayList);
    }

    public static ImagePresenter getInstance() {
        if (instance == null) {
            synchronized (ImagePresenter.class) {
                if (instance == null) {
                    instance = new ImagePresenter();
                }
            }
        }
        return instance;
    }

    public static void onDestory() {
        if (instance != null) {
            synchronized (ImageListener.class) {
                if (instance != null) {
                    instance = null;
                }
            }
        }
    }

    public void setMaxNum(int i) {
        mMaxNum = i;
    }

    public boolean canAdd() {
        return mSelectedList.size() < mMaxNum;
    }

    public boolean selectePhoto(ImageItemInfo imageItemInfo) {
        if (imageItemInfo == null) {
            return false;
        }
        if (mSelectedList.contains(imageItemInfo)) {
            mSelectedList.remove(imageItemInfo);
            return false;
        }
        mSelectedList.add(imageItemInfo);
        return true;
    }

    public ArrayList<ImageItemInfo> getSelectedImageList() {
        return mSelectedList;
    }

    public boolean isSelected(ImageItemInfo imageItemInfo) {
        return mSelectedList.contains(imageItemInfo);
    }

    public void onSelectPhotoFinish(boolean z) {
        if (z) {
            return;
        }
        ImageListener imageListener = this.listener;
        if (imageListener != null) {
            imageListener.onPhotoSelected(mSelectedList);
        }
        ArrayList<ImageItemInfo> arrayList = mSelectedList;
        if (arrayList == null) {
            return;
        }
        Iterator<ImageItemInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            UploadManager.getInstance(GRobotApplication.self()).uploadPhoto(it.next().path);
        }
    }

    public void onCommitForm() {
        mSelectedList.clear();
    }

    public void deleteImage(String str) {
        ArrayList<ImageItemInfo> arrayList = mSelectedList;
        if (arrayList == null) {
            return;
        }
        Iterator<ImageItemInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            ImageItemInfo next = it.next();
            if (str != null && !TextUtils.isEmpty(str) && str.equals(next.path)) {
                mSelectedList.remove(next);
                return;
            }
        }
    }

    public void setImageListener(ImageListener imageListener) {
        this.listener = imageListener;
    }
}
