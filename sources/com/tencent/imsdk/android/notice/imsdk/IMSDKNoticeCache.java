package com.tencent.imsdk.android.notice.imsdk;

import android.content.Context;
import android.webkit.URLUtil;
import com.adjust.sdk.Constants;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.notice.IMSDKNoticeInfo;
import com.tencent.imsdk.android.api.notice.IMSDKNoticePic;
import com.tencent.imsdk.android.api.notice.IMSDKNoticeResult;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.tools.FileUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.imsdk.android.tools.net.IMSDKHttpClient;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKNoticeCache {
    private static final String LOCAL_PIC_PREFIX = "Notice_";
    private static final String SECOND_DIRECTORY = File.separator + "images" + File.separator;
    public Context mContext;
    private ClearUnusedPics mClearUnusedPics = null;
    private IMSDKHttpClient mHttpClient = null;
    private int mSumOfPictures = 0;
    private boolean isAllPicturesCached = true;

    /* JADX INFO: Access modifiers changed from: private */
    public File getExternalDir() {
        Context context = this.mContext;
        if (context != null) {
            return context.getExternalCacheDir();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isAllPictureLoaded(IMSDKNoticeResult iMSDKNoticeResult, IMSDKListener<Boolean> iMSDKListener, List<IMSDKNoticeInfo> list) {
        int i = this.mSumOfPictures - 1;
        this.mSumOfPictures = i;
        if (i <= 0) {
            IMLogger.d("final step , isAllPicturesCached = " + this.isAllPicturesCached);
            if (this.isAllPicturesCached) {
                iMSDKNoticeResult.noticesList = list;
            } else {
                iMSDKNoticeResult.imsdkRetCode = 11;
                iMSDKNoticeResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(11);
                iMSDKListener.onNotify(true);
            }
            if (iMSDKListener != null) {
                iMSDKListener.onResult(iMSDKNoticeResult);
            }
        }
    }

    public IMSDKNoticeCache(Context context) {
        this.mContext = context;
    }

    public void saveAndClearExpiredNoticePicture(IMSDKNoticeResult iMSDKNoticeResult, IMSDKListener<Boolean> iMSDKListener) {
        if (iMSDKListener == null) {
            return;
        }
        if (iMSDKNoticeResult == null) {
            IMSDKNoticeResult iMSDKNoticeResult2 = new IMSDKNoticeResult();
            iMSDKNoticeResult2.imsdkRetCode = 5;
            iMSDKNoticeResult2.imsdkRetMsg = IMSDKErrCode.getMessageByCode(5);
            iMSDKNoticeResult2.thirdRetCode = -1;
            iMSDKNoticeResult2.thirdRetMsg = "picture download error";
            iMSDKListener.onResult(iMSDKNoticeResult2);
            return;
        }
        List<IMSDKNoticeInfo> list = iMSDKNoticeResult.noticesList;
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            if (list.get(i) != null) {
                strArr[i] = String.valueOf(list.get(i).noticeId);
            }
        }
        clearNoticePicOutOfDate(strArr);
        saveNoticePicture(iMSDKNoticeResult, iMSDKListener);
    }

    public void saveNoticePicture(final IMSDKNoticeResult iMSDKNoticeResult, final IMSDKListener<Boolean> iMSDKListener) {
        IMSDKNoticeCache iMSDKNoticeCache = this;
        IMSDKNoticeResult iMSDKNoticeResult2 = iMSDKNoticeResult;
        if (iMSDKListener == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList(iMSDKNoticeResult2.noticesList);
        for (IMSDKNoticeInfo iMSDKNoticeInfo : iMSDKNoticeResult2.noticesList) {
            if (iMSDKNoticeInfo.noticePics != null) {
                iMSDKNoticeCache.mSumOfPictures += iMSDKNoticeInfo.noticePics.size();
            }
        }
        IMLogger.d("sum of picture is  " + iMSDKNoticeCache.mSumOfPictures);
        if (iMSDKNoticeCache.mSumOfPictures == 0) {
            iMSDKListener.onResult(iMSDKNoticeResult2);
            return;
        }
        int i = 0;
        while (i < iMSDKNoticeResult2.noticesList.size()) {
            IMSDKNoticeInfo iMSDKNoticeInfo2 = iMSDKNoticeResult2.noticesList.get(i);
            if (iMSDKNoticeInfo2 != null && iMSDKNoticeInfo2.noticePics != null) {
                int i2 = 0;
                while (i2 < iMSDKNoticeInfo2.noticePics.size()) {
                    final IMSDKNoticePic iMSDKNoticePic = iMSDKNoticeInfo2.noticePics.get(i2);
                    if (iMSDKNoticePic != null) {
                        if (!URLUtil.isHttpUrl(iMSDKNoticePic.picUrl) && !URLUtil.isHttpsUrl(iMSDKNoticePic.picUrl)) {
                            iMSDKNoticeCache.isAllPictureLoaded(iMSDKNoticeResult2, iMSDKListener, arrayList);
                        } else if (iMSDKNoticeCache.isNoticePicUnmodified(iMSDKNoticePic)) {
                            IMLogger.d("cache found for " + iMSDKNoticePic.picUrl);
                            arrayList.get(i).noticePics.get(i2).picUrl = iMSDKNoticeCache.getNoticePicFilePath(iMSDKNoticePic);
                            iMSDKNoticeCache.isAllPictureLoaded(iMSDKNoticeResult2, iMSDKListener, arrayList);
                        } else {
                            if (iMSDKNoticeCache.mHttpClient == null) {
                                IMLogger.d("init network request async http client");
                                iMSDKNoticeCache.mHttpClient = new IMSDKHttpClient(iMSDKNoticeCache.mContext);
                            }
                            final int i3 = i;
                            final int i4 = i2;
                            iMSDKNoticeCache.mHttpClient.get(iMSDKNoticePic.picUrl, new IMSDKListener<byte[]>() { // from class: com.tencent.imsdk.android.notice.imsdk.IMSDKNoticeCache.1
                                @Override // com.tencent.imsdk.android.base.IMSDKListener
                                public void onNotify(byte[] bArr) {
                                    File file;
                                    FileOutputStream fileOutputStream;
                                    FileOutputStream fileOutputStream2 = null;
                                    try {
                                        try {
                                            file = new File(IMSDKNoticeCache.this.getNoticePicFilePath(iMSDKNoticePic));
                                            if (!file.getParentFile().exists()) {
                                                boolean mkdirs = file.getParentFile().mkdirs();
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(mkdirs ? "success" : "fail");
                                                sb.append(" to create direct of ");
                                                sb.append(file.getParentFile().toString());
                                                IMLogger.d(sb.toString());
                                            }
                                            fileOutputStream = new FileOutputStream(file);
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                    } catch (FileNotFoundException e) {
                                        e = e;
                                    } catch (IOException e2) {
                                        e = e2;
                                    }
                                    try {
                                        fileOutputStream.write(bArr);
                                        IMLogger.d("save picture successfully in " + file.toString());
                                        ((IMSDKNoticeInfo) arrayList.get(i3)).noticePics.get(i4).picUrl = file.toString();
                                        FileUtils.closeQuietly(fileOutputStream);
                                    } catch (FileNotFoundException e3) {
                                        e = e3;
                                        fileOutputStream2 = fileOutputStream;
                                        IMLogger.e(e.getMessage(), new Object[0]);
                                        IMSDKNoticeCache.this.isAllPicturesCached = false;
                                        FileUtils.closeQuietly(fileOutputStream2);
                                        IMSDKNoticeCache.this.isAllPictureLoaded(iMSDKNoticeResult, iMSDKListener, arrayList);
                                    } catch (IOException e4) {
                                        e = e4;
                                        fileOutputStream2 = fileOutputStream;
                                        IMLogger.e(e.getMessage(), new Object[0]);
                                        IMSDKNoticeCache.this.isAllPicturesCached = false;
                                        FileUtils.closeQuietly(fileOutputStream2);
                                        IMSDKNoticeCache.this.isAllPictureLoaded(iMSDKNoticeResult, iMSDKListener, arrayList);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream2 = fileOutputStream;
                                        FileUtils.closeQuietly(fileOutputStream2);
                                        IMSDKNoticeCache.this.isAllPictureLoaded(iMSDKNoticeResult, iMSDKListener, arrayList);
                                        throw th;
                                    }
                                    IMSDKNoticeCache.this.isAllPictureLoaded(iMSDKNoticeResult, iMSDKListener, arrayList);
                                }

                                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                                public void onResult(IMSDKResult iMSDKResult) {
                                    IMLogger.e("save picture fail : " + iMSDKResult.thirdRetMsg + " from " + iMSDKNoticePic.picUrl, new Object[0]);
                                    IMSDKNoticeCache.this.isAllPicturesCached = false;
                                    IMSDKNoticeCache.this.isAllPictureLoaded(iMSDKNoticeResult, iMSDKListener, arrayList);
                                }
                            });
                        }
                    }
                    i2++;
                    iMSDKNoticeCache = this;
                    iMSDKNoticeResult2 = iMSDKNoticeResult;
                }
            }
            i++;
            iMSDKNoticeCache = this;
            iMSDKNoticeResult2 = iMSDKNoticeResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ClearUnusedPics implements Runnable {
        private String[] mNoticeIds;

        ClearUnusedPics() {
        }

        public void setNoticeIds(String[] strArr) {
            this.mNoticeIds = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            File file = new File(IMSDKNoticeCache.this.getExternalDir(), IMSDKNoticeCache.SECOND_DIRECTORY);
            IMLogger.d(file.toString());
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            IMLogger.d("number of pics those already cached are " + listFiles.length);
            String[] strArr = this.mNoticeIds;
            if (strArr == null || strArr.length <= 0) {
                IMLogger.d("delete all cached ...");
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        IMLogger.d("delete file : " + file2.toString());
                        file2.delete();
                    }
                }
                return;
            }
            for (File file3 : listFiles) {
                String[] strArr2 = this.mNoticeIds;
                int length = strArr2.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    }
                    if (file3.toString().contains(IMSDKNoticeCache.LOCAL_PIC_PREFIX + strArr2[i] + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR)) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z && file3.exists()) {
                    IMLogger.d("delete file : " + file3.toString());
                    file3.delete();
                }
            }
        }
    }

    public void clearNoticePicOutOfDate(String[] strArr) {
        IMLogger.d("start clear pics out of date , and  " + strArr.length + " will be save");
        if (this.mClearUnusedPics == null) {
            this.mClearUnusedPics = new ClearUnusedPics();
        }
        this.mClearUnusedPics.setNoticeIds(strArr);
        new Thread(this.mClearUnusedPics).start();
    }

    public boolean isNoticePicExist(IMSDKNoticePic iMSDKNoticePic) {
        if (T.ckNonEmpty(String.valueOf(iMSDKNoticePic.noticeId), iMSDKNoticePic.picUrl, iMSDKNoticePic.picHash)) {
            return false;
        }
        return new File(getNoticePicFilePath(iMSDKNoticePic)).exists();
    }

    public void deleteNoticePic(IMSDKNoticePic iMSDKNoticePic) {
        if (isNoticePicExist(iMSDKNoticePic)) {
            new File(getNoticePicFilePath(iMSDKNoticePic)).delete();
        }
    }

    public String getNoticePicFilePath(IMSDKNoticePic iMSDKNoticePic) {
        if (this.mContext == null || T.ckNonEmpty(String.valueOf(iMSDKNoticePic.noticeId), iMSDKNoticePic.picUrl, iMSDKNoticePic.picHash)) {
            IMLogger.d("noticeId = " + iMSDKNoticePic.noticeId + " ,url = " + iMSDKNoticePic.picUrl + " ,hash = " + iMSDKNoticePic.picHash);
            return "";
        }
        return new File(getExternalDir(), SECOND_DIRECTORY + LOCAL_PIC_PREFIX + iMSDKNoticePic.noticeId + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + iMSDKNoticePic.picHash).toString();
    }

    public boolean isNoticePicUnmodified(IMSDKNoticePic iMSDKNoticePic) {
        FileInputStream fileInputStream;
        String lowerCase;
        if (T.ckNonEmpty(String.valueOf(iMSDKNoticePic.noticeId), iMSDKNoticePic.picUrl, iMSDKNoticePic.picHash)) {
            return false;
        }
        File file = new File(getNoticePicFilePath(iMSDKNoticePic));
        if (!file.exists()) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
        } catch (FileNotFoundException unused) {
        } catch (IOException e) {
            e = e;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
        }
        try {
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(map);
            lowerCase = T.toHexString(messageDigest.digest()).toLowerCase(Locale.CHINA);
            IMLogger.d("picture md5 :" + lowerCase + ", picture hash :" + iMSDKNoticePic.picHash);
        } catch (FileNotFoundException unused2) {
            fileInputStream2 = fileInputStream;
            IMLogger.e("picture not found", new Object[0]);
            FileUtils.closeQuietly(fileInputStream2);
            return false;
        } catch (IOException e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(fileInputStream2);
            return true;
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(fileInputStream2);
            return true;
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeQuietly(fileInputStream);
            throw th;
        }
        if (lowerCase.equalsIgnoreCase(iMSDKNoticePic.picHash)) {
            FileUtils.closeQuietly(fileInputStream);
            return true;
        }
        file.delete();
        FileUtils.closeQuietly(fileInputStream);
        return false;
    }
}
