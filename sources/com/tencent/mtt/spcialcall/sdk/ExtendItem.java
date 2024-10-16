package com.tencent.mtt.spcialcall.sdk;

import android.content.ComponentName;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.InputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ExtendItem implements Serializable {
    private static final long serialVersionUID = 5231345272635295955L;
    private String CallBackClassName;
    private String CallBackPackgeName;
    private String DesUrl;
    private String DrawableName;
    private int ID;
    private byte[] Image;
    private byte[] ImageNinePatchChunk;
    private byte[] ImagePressed;
    private CharSequence Label;
    private String ThemePackage;
    private String Type = "drawable";
    private int TextColor = 0;
    private int TextSize = 0;
    private boolean NeedSnapshot = false;

    public ExtendItem(int i) {
        this.ID = i;
    }

    public ExtendItem(int i, Drawable drawable, CharSequence charSequence) {
        if (drawable != null) {
            this.Image = BitmapTools.Drawable2Bytes(drawable);
        }
        this.Label = charSequence;
        this.ID = i;
    }

    public ExtendItem(int i, CharSequence charSequence) {
        this.Label = charSequence;
        this.ID = i;
    }

    public ExtendItem(int i, String str, CharSequence charSequence) {
        this.DrawableName = str;
        this.Label = charSequence;
        this.ID = i;
    }

    public ExtendItem(int i, Bitmap bitmap, Bitmap bitmap2, byte[] bArr, CharSequence charSequence) {
        try {
            if (bitmap.getNinePatchChunk() != null) {
                setImageNinePatchChunk(bitmap.getNinePatchChunk());
            }
            this.Image = BitmapTools.Bitmap2Bytes(bitmap);
            if (bitmap2 != null) {
                this.ImagePressed = BitmapTools.Bitmap2Bytes(bitmap2);
            }
        } catch (Exception unused) {
        }
        this.Label = charSequence;
        this.ID = i;
    }

    public ExtendItem(int i, boolean z, InputStream inputStream, InputStream inputStream2, CharSequence charSequence) {
        Bitmap decodeStream;
        Bitmap decodeStream2;
        try {
            if (z) {
                decodeStream = NinePatchUtils.decodeFromStream(inputStream);
                setImageNinePatchChunk(decodeStream.getNinePatchChunk());
            } else {
                decodeStream = BitmapFactory.decodeStream(inputStream);
            }
            this.Image = BitmapTools.Bitmap2Bytes(decodeStream);
            if (inputStream2 != null) {
                if (z) {
                    decodeStream2 = NinePatchUtils.decodeFromStream(inputStream2);
                } else {
                    decodeStream2 = BitmapFactory.decodeStream(inputStream2);
                }
                this.ImagePressed = BitmapTools.Bitmap2Bytes(decodeStream2);
            }
        } catch (Exception unused) {
        }
        this.Label = charSequence;
        this.ID = i;
    }

    public ExtendItem(int i, int i2, int i3, InputStream inputStream, InputStream inputStream2, CharSequence charSequence) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (inputStream != null) {
            try {
                options.inScaled = true;
                options.inDensity = i2;
                options.inTargetDensity = i3;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, new Rect(), options);
                setImageNinePatchChunk(decodeStream.getNinePatchChunk());
                this.Image = BitmapTools.Bitmap2Bytes(decodeStream);
            } catch (Exception unused) {
            }
        }
        if (inputStream2 != null) {
            this.ImagePressed = BitmapTools.Bitmap2Bytes(BitmapFactory.decodeStream(inputStream2, new Rect(), options));
        }
        this.Label = charSequence;
        this.ID = i;
    }

    public Bitmap getImage() {
        return BitmapTools.Bytes2Bimap(this.Image);
    }

    public void setImage(Drawable drawable) {
        this.Image = BitmapTools.Drawable2Bytes(drawable);
    }

    public CharSequence getLabel() {
        return this.Label;
    }

    public void setLabel(CharSequence charSequence) {
        this.Label = charSequence;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int i) {
        this.ID = i;
    }

    public ComponentName getComponentName() {
        if (TextUtils.isEmpty(this.CallBackPackgeName) || TextUtils.isEmpty(this.CallBackClassName)) {
            return null;
        }
        return new ComponentName(this.CallBackPackgeName, this.CallBackClassName);
    }

    public void setComponentName(ComponentName componentName) {
        this.CallBackPackgeName = componentName.getPackageName();
        this.CallBackClassName = componentName.getClassName();
    }

    public String getThemePackage() {
        return this.ThemePackage;
    }

    public void setThemePackage(String str, String str2) {
        this.ThemePackage = str;
        this.Type = str2;
    }

    public String getDrawableName() {
        return this.DrawableName;
    }

    public void setDrawableName(String str) {
        this.DrawableName = str;
    }

    public byte[] getImageNinePatchChunk() {
        return this.ImageNinePatchChunk;
    }

    private void setImageNinePatchChunk(byte[] bArr) {
        this.ImageNinePatchChunk = bArr;
    }

    public Bitmap getImagePressed() {
        return BitmapTools.Bytes2Bimap(this.ImagePressed);
    }

    public void setImagePressed(byte[] bArr) {
        this.ImagePressed = bArr;
    }

    public String getType() {
        return this.Type;
    }

    public boolean isNeedSnapshot() {
        return this.NeedSnapshot;
    }

    public void setNeedSnapshot(boolean z) {
        this.NeedSnapshot = z;
    }

    public int getTextColor() {
        return this.TextColor;
    }

    public void setTextColor(int i) {
        this.TextColor = i;
    }

    public String getDesUrl() {
        return this.DesUrl;
    }

    public void setDesUrl(String str) {
        this.DesUrl = str;
    }

    public void setJsFuncOnclick(String str, String... strArr) {
        String str2 = "";
        for (String str3 : strArr) {
            str2 = String.valueOf(str2) + ",'" + str3 + "'";
        }
        this.DesUrl = "javascript:" + str + "(" + str2.substring(1) + ")";
    }

    public int getTextSize() {
        return this.TextSize;
    }

    public void setTextSize(int i) {
        this.TextSize = i;
    }
}
