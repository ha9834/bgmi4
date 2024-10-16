package com.tencent.mtt.spcialcall.sdk;

import android.graphics.Bitmap;
import java.io.Serializable;

/* loaded from: classes.dex */
public class RspContent implements Serializable {
    private static final long serialVersionUID = -6589091102292710140L;
    private String Content;
    private int ID;
    private byte[] Image;
    private String ImagePath;
    private String Title;
    private DownLoadInfo WebViewDownloadInfo;

    public RspContent(int i, Bitmap bitmap, String str) {
        this.ID = i;
        if (bitmap != null) {
            this.Image = BitmapTools.Bitmap2Bytes(bitmap);
        }
        this.Content = str;
    }

    public RspContent(int i, String str, String str2) {
        this.ID = i;
        setTitle(str);
        this.Content = str2;
    }

    public Bitmap getImage() {
        byte[] bArr = this.Image;
        if (bArr != null) {
            return BitmapTools.Bytes2Bimap(bArr);
        }
        return null;
    }

    public String getContent() {
        return this.Content;
    }

    public int getID() {
        return this.ID;
    }

    public String getImagePath() {
        return this.ImagePath;
    }

    public void setImagePath(String str) {
        this.ImagePath = str;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String str) {
        this.Title = str;
    }

    public void setDownloadInfo(String str, String str2, String str3, String str4, long j, String str5) {
        this.WebViewDownloadInfo = new DownLoadInfo(str, str2, str3, str4, j, str5);
    }

    public DownLoadInfo getDownloadInfo() {
        return this.WebViewDownloadInfo;
    }

    /* loaded from: classes.dex */
    public class DownLoadInfo implements Serializable {
        private static final long serialVersionUID = 3759841938734585077L;
        private String ContentDisposition;
        private long ContentLength;
        private String DownLoadUrl;
        private String Mimetype;
        private String ReferUrl;
        private String UserAgent;

        public DownLoadInfo(String str, String str2, String str3, String str4, long j, String str5) {
            this.DownLoadUrl = str;
            this.UserAgent = str2;
            this.ContentDisposition = str3;
            this.Mimetype = str4;
            this.ContentLength = j;
            this.ReferUrl = str5;
        }

        public String getDownLoadUrl() {
            return this.DownLoadUrl;
        }

        public void setDownLoadUrl(String str) {
            this.DownLoadUrl = str;
        }

        public String getUserAgent() {
            return this.UserAgent;
        }

        public void setUserAgent(String str) {
            this.UserAgent = str;
        }

        public String getContentDisposition() {
            return this.ContentDisposition;
        }

        public void setContentDisposition(String str) {
            this.ContentDisposition = str;
        }

        public String getMimetype() {
            return this.Mimetype;
        }

        public void setMimetype(String str) {
            this.Mimetype = str;
        }

        public long getContentLength() {
            return this.ContentLength;
        }

        public void setContentLength(long j) {
            this.ContentLength = j;
        }

        public String getReferUrl() {
            return this.ReferUrl;
        }

        public void setReferUrl(String str) {
            this.ReferUrl = str;
        }
    }
}
