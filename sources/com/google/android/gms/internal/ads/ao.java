package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes2.dex */
final class ao extends zzaj {

    /* renamed from: a, reason: collision with root package name */
    private final zzas f1996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(zzas zzasVar) {
        this.f1996a = zzasVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzaj
    public final zzar zza(zzr<?> zzrVar, Map<String, String> map) throws IOException, zza {
        try {
            HttpResponse zzb = this.f1996a.zzb(zzrVar, map);
            int statusCode = zzb.getStatusLine().getStatusCode();
            Header[] allHeaders = zzb.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (zzb.getEntity() == null) {
                return new zzar(statusCode, arrayList);
            }
            long contentLength = zzb.getEntity().getContentLength();
            if (((int) contentLength) != contentLength) {
                StringBuilder sb = new StringBuilder(40);
                sb.append("Response too large: ");
                sb.append(contentLength);
                throw new IOException(sb.toString());
            }
            return new zzar(statusCode, arrayList, (int) zzb.getEntity().getContentLength(), zzb.getEntity().getContent());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
