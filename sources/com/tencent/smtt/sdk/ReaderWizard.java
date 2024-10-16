package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.UselessClass;
import com.tencent.smtt.sdk.TbsReaderView;

/* loaded from: classes2.dex */
public class ReaderWizard {

    /* renamed from: a, reason: collision with root package name */
    private UselessClass f6439a;
    private TbsReaderView.ReaderCallback b;

    private static UselessClass a() {
        return null;
    }

    public static boolean isSupportCurrentPlatform(Context context) {
        UselessClass a2 = a();
        if (a2 == null) {
            return false;
        }
        Object returnNull = a2.returnNull("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
        if (returnNull instanceof Boolean) {
            return ((Boolean) returnNull).booleanValue();
        }
        return false;
    }

    public static boolean isSupportExt(String str) {
        UselessClass a2 = a();
        if (a2 == null) {
            return false;
        }
        Object returnNull = a2.returnNull("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
        if (returnNull instanceof Boolean) {
            return ((Boolean) returnNull).booleanValue();
        }
        return false;
    }

    public static Drawable getResDrawable(int i) {
        UselessClass a2 = a();
        if (a2 != null) {
            Object returnNull = a2.returnNull("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i));
            if (returnNull instanceof Drawable) {
                return (Drawable) returnNull;
            }
        }
        return null;
    }

    public static String getResString(int i) {
        UselessClass a2 = a();
        if (a2 == null) {
            return "";
        }
        Object returnNull = a2.returnNull("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i));
        return returnNull instanceof String ? (String) returnNull : "";
    }

    public ReaderWizard(TbsReaderView.ReaderCallback readerCallback) {
        this.f6439a = null;
        this.b = null;
        this.f6439a = a();
        this.b = readerCallback;
    }

    public Object getTbsReader() {
        return this.f6439a.doNothing("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    public boolean initTbsReader(Object obj, Context context) {
        UselessClass uselessClass = this.f6439a;
        if (uselessClass == null || obj == null) {
            Log.e("ReaderWizard", "initTbsReader:Unexpect null object!");
            return false;
        }
        Object returnNull = uselessClass.returnNull(obj, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, UselessClass.class, Object.class}, context, uselessClass, this);
        if (!(returnNull instanceof Boolean)) {
            Log.e("ReaderWizard", "Unexpect return value type of call initTbsReader!");
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean checkPlugin(Object obj, Context context, String str, boolean z) {
        UselessClass uselessClass = this.f6439a;
        if (uselessClass == null) {
            Log.e("ReaderWizard", "checkPlugin:Unexpect null object!");
            return false;
        }
        Object returnNull = uselessClass.returnNull(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
        if (!(returnNull instanceof Boolean)) {
            Log.e("ReaderWizard", "Unexpect return value type of call checkPlugin!");
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public boolean openFile(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        UselessClass uselessClass = this.f6439a;
        if (uselessClass == null) {
            Log.e("ReaderWizard", "openFile:Unexpect null object!");
            return false;
        }
        Object returnNull = uselessClass.returnNull(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        if (!(returnNull instanceof Boolean)) {
            Log.e("ReaderWizard", "Unexpect return value type of call openFile!");
            return false;
        }
        return ((Boolean) returnNull).booleanValue();
    }

    public void onSizeChanged(Object obj, int i, int i2) {
        UselessClass uselessClass = this.f6439a;
        if (uselessClass == null) {
            Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
        } else {
            uselessClass.returnNull(obj, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, new Integer(i), new Integer(i2));
        }
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        Log.d("ReaderWizard", "onCallBackAction actionType:" + num + " args" + obj + " result" + obj2);
        TbsReaderView.ReaderCallback readerCallback = this.b;
        if (readerCallback != null) {
            readerCallback.onCallBackAction(num, obj, obj2);
        }
    }

    public void doCommand(Object obj, Integer num, Object obj2, Object obj3) {
        Log.d("ReaderWizard", "doAction actionType:" + num + " args" + obj2 + " result" + obj3);
        UselessClass uselessClass = this.f6439a;
        if (uselessClass == null) {
            Log.e("ReaderWizard", "doCommand:Unexpect null object!");
        } else {
            uselessClass.returnNull(obj, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, new Integer(num.intValue()), obj2, obj3);
        }
    }

    public void destroy(Object obj) {
        Log.d("ReaderWizard", "call destroy ...");
        this.b = null;
        UselessClass uselessClass = this.f6439a;
        if (uselessClass == null || obj == null) {
            Log.e("ReaderWizard", "destroy:Unexpect null object!");
        } else {
            uselessClass.returnNull(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        }
    }

    public void userStatistics(Object obj, String str) {
        UselessClass uselessClass = this.f6439a;
        if (uselessClass == null) {
            Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
        } else {
            uselessClass.returnNull(obj, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
        }
    }
}
