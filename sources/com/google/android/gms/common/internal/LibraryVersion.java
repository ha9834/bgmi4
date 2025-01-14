package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.abase.utils.ConstantUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
/* loaded from: classes.dex */
public class LibraryVersion {

    /* renamed from: a, reason: collision with root package name */
    private static final GmsLogger f1456a = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion b = new LibraryVersion();
    private ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();

    @KeepForSdk
    public static LibraryVersion getInstance() {
        return b;
    }

    @VisibleForTesting
    protected LibraryVersion() {
    }

    @KeepForSdk
    public String getVersion(String str) {
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty("version", null);
                GmsLogger gmsLogger = f1456a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                gmsLogger.v("LibraryVersion", sb.toString());
            } else {
                GmsLogger gmsLogger2 = f1456a;
                String valueOf = String.valueOf(str);
                gmsLogger2.e("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e) {
            GmsLogger gmsLogger3 = f1456a;
            String valueOf2 = String.valueOf(str);
            gmsLogger3.e("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e);
        }
        if (str2 == null) {
            str2 = ConstantUtils.NET_UNKNOWN;
            f1456a.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
        }
        this.c.put(str, str2);
        return str2;
    }
}
