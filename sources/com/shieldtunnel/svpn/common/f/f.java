package com.shieldtunnel.svpn.common.f;

import android.os.Build;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Locale f5810a;
    public static final Locale b;
    public static final Charset c;
    public static final String[] d;

    static {
        Charset defaultCharset;
        Locale locale = Locale.US;
        f5810a = locale;
        b = locale;
        if (Build.VERSION.SDK_INT >= 19) {
            defaultCharset = StandardCharsets.UTF_8;
        } else {
            try {
                defaultCharset = Charset.forName("UTF-8");
            } catch (UnsupportedCharsetException e) {
                e.printStackTrace();
                defaultCharset = Charset.defaultCharset();
            }
        }
        c = defaultCharset;
        d = new String[]{"5EE72F98-D35F-45EF-9521-D450D4194F9F", "C47C8491-E00C-4BA1-AA2A-01ADCF0AFF67", "341290D6-C909-468F-BD8A-CFAA0216EBE6", "551CDC92-7935-4C1C-BD31-D8EBF3BFF09B"};
    }
}
