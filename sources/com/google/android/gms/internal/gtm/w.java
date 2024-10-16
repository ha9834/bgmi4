package com.google.android.gms.internal.gtm;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.internal.gtm.v;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class w<T extends v> extends zzam {

    /* renamed from: a, reason: collision with root package name */
    private zzbp<T> f4376a;

    public w(zzap zzapVar, zzbp<T> zzbpVar) {
        super(zzapVar);
        this.f4376a = zzbpVar;
    }

    public final T zzq(int i) {
        try {
            return a(zzcm().zzdc().getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }

    private final T a(XmlResourceParser xmlResourceParser) {
        int eventType;
        try {
            xmlResourceParser.next();
            eventType = xmlResourceParser.getEventType();
        } catch (IOException | XmlPullParserException e) {
            zze("Error parsing tracker configuration file", e);
        }
        while (eventType != 1) {
            if (xmlResourceParser.getEventType() == 2) {
                String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                if (lowerCase.equals(ViewHierarchyConstants.SCREEN_NAME_KEY)) {
                    String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                    String trim = xmlResourceParser.nextText().trim();
                    if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                        this.f4376a.zzb(attributeValue, trim);
                    }
                } else if (lowerCase.equals("string")) {
                    String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                    String trim2 = xmlResourceParser.nextText().trim();
                    if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                        this.f4376a.zzc(attributeValue2, trim2);
                    }
                } else {
                    if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.f4376a.zza(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e2) {
                                zzc("Error parsing bool configuration value", trim3, e2);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.f4376a.zzb(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e3) {
                                zzc("Error parsing int configuration value", trim4, e3);
                            }
                        }
                    }
                    zze("Error parsing tracker configuration file", e);
                    return this.f4376a.zzel();
                }
            }
            eventType = xmlResourceParser.next();
        }
        return this.f4376a.zzel();
    }
}
