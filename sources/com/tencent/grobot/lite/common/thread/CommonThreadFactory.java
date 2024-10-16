package com.tencent.grobot.lite.common.thread;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class CommonThreadFactory implements ThreadFactory {
    public static final AtomicInteger poolNumber = new AtomicInteger(1);
    public final ThreadGroup group;
    public final String namePrefix;
    public final AtomicInteger threadNumber = new AtomicInteger(1);

    public CommonThreadFactory(String str) {
        String str2;
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        StringBuilder sb = new StringBuilder();
        sb.append("pool-");
        sb.append(poolNumber.getAndIncrement());
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "-" + str;
        }
        sb.append(str2);
        sb.append("-thread-");
        this.namePrefix = sb.toString();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 1) {
            thread.setPriority(1);
        }
        return thread;
    }
}
