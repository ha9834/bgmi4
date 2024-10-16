package com.google.android.gms.tagmanager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
final class dm implements dn {
    @Override // com.google.android.gms.tagmanager.dn
    public final HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
