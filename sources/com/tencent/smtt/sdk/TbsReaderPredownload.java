package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;
    static final String[] b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};
    ReaderPreDownloadCallback i;

    /* renamed from: a, reason: collision with root package name */
    Handler f6472a = null;
    LinkedList<String> c = new LinkedList<>();
    boolean d = false;
    ReaderWizard e = null;
    TbsReaderView.ReaderCallback f = null;
    Object g = null;
    Context h = null;
    String j = "";

    /* loaded from: classes2.dex */
    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i, boolean z);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        this.i = null;
        this.i = readerPreDownloadCallback;
        for (String str : b) {
            this.c.add(str);
        }
        a();
    }

    public boolean init(Context context) {
        if (context == null) {
            return false;
        }
        this.h = context.getApplicationContext();
        boolean a2 = TbsReaderView.a(context.getApplicationContext());
        this.f = new TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                int intValue;
                if (num.intValue() == 5012 && 5014 != (intValue = ((Integer) obj).intValue())) {
                    if (5013 == intValue) {
                        TbsReaderPredownload.this.a(0);
                    } else if (intValue == 0) {
                        TbsReaderPredownload.this.a(0);
                    } else {
                        TbsReaderPredownload.this.a(-1);
                    }
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    tbsReaderPredownload.j = "";
                    tbsReaderPredownload.a(3, 100);
                }
            }
        };
        try {
            if (this.e == null) {
                this.e = new ReaderWizard(this.f);
            }
            if (this.g == null) {
                this.g = this.e.getTbsReader();
            }
            return this.g != null ? this.e.initTbsReader(this.g, context.getApplicationContext()) : a2;
        } catch (NullPointerException unused) {
            Log.e("TbsReaderPredownload", "Unexpect null object!");
            return false;
        }
    }

    public void startAll() {
        Log.d("TbsReaderPredownload", "start");
        this.d = false;
        if (!false && !c(3)) {
            a(3, 100);
        }
    }

    public void start(String str) {
        this.d = false;
        b(3);
        this.c.add(str);
        a(3, 100);
    }

    public void pause() {
        Log.d("TbsReaderPredownload", "pause");
        this.d = true;
    }

    public void shutdown() {
        Log.d("TbsReaderPredownload", "shutdown");
        this.i = null;
        this.d = false;
        this.c.clear();
        b();
        ReaderWizard readerWizard = this.e;
        if (readerWizard != null) {
            readerWizard.destroy(this.g);
            this.g = null;
        }
        this.h = null;
    }

    private void b() {
        b(3);
    }

    boolean a(String str) {
        if (this.g == null || this.e == null || !ReaderWizard.isSupportExt(str)) {
            return false;
        }
        return this.e.checkPlugin(this.g, this.h, str, true);
    }

    void a(int i) {
        if (this.i != null) {
            this.i.onEvent(this.j, i, this.c.isEmpty());
        }
    }

    void a() {
        this.f6472a = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 3 || TbsReaderPredownload.this.c.isEmpty() || TbsReaderPredownload.this.d) {
                    return;
                }
                String removeFirst = TbsReaderPredownload.this.c.removeFirst();
                TbsReaderPredownload.this.j = removeFirst;
                Log.d("TbsReaderPredownload", "READER_WAIT_IN_QUEUE,ext=" + removeFirst);
                if (TbsReaderPredownload.this.a(removeFirst)) {
                    return;
                }
                TbsReaderPredownload.this.a(-1);
            }
        };
    }

    void b(int i) {
        this.f6472a.removeMessages(i);
    }

    boolean c(int i) {
        return this.f6472a.hasMessages(i);
    }

    void a(int i, int i2) {
        this.f6472a.sendMessageDelayed(this.f6472a.obtainMessage(i), i2);
    }
}
