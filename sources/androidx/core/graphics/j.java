package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.c.b;
import androidx.core.content.a.c;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class j extends k {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.graphics.k
    public b.C0043b a(b.C0043b[] c0043bArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.graphics.k
    public Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0043b[] c0043bArr, int i) {
        int i2;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        int length = c0043bArr.length;
        FontFamily.Builder builder = null;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                if (builder == null) {
                    return null;
                }
                return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
            }
            b.C0043b c0043b = c0043bArr[i2];
            try {
                openFileDescriptor = contentResolver.openFileDescriptor(c0043b.a(), AnalyticsEventKey.SMART_INTENT_SEARCH_RANK, cancellationSignal);
            } catch (IOException unused) {
                continue;
            }
            if (openFileDescriptor != null) {
                try {
                    Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(c0043b.c());
                    if (!c0043b.d()) {
                        i3 = 0;
                    }
                    Font build = weight.setSlant(i3).setTtcIndex(c0043b.b()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                    if (openFileDescriptor == null) {
                    }
                } catch (Throwable th) {
                    if (openFileDescriptor != null) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                    break;
                }
            } else {
                i2 = openFileDescriptor == null ? i2 + 1 : 0;
            }
            openFileDescriptor.close();
        }
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0044c[] a2 = bVar.a();
        int length = a2.length;
        FontFamily.Builder builder = null;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                break;
            }
            c.C0044c c0044c = a2[i2];
            try {
                Font.Builder weight = new Font.Builder(resources, c0044c.f()).setWeight(c0044c.b());
                if (!c0044c.c()) {
                    i3 = 0;
                }
                Font build = weight.setSlant(i3).setTtcIndex(c0044c.e()).setFontVariationSettings(c0044c.d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i2++;
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.k
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (IOException unused) {
            return null;
        }
    }
}
