package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.helpshift.common.domain.network.NetworkConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public final class zzd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f1266a = new Logger("RevokeAccessOperation", new String[0]);
    private final String b;
    private final StatusPendingResult c;

    private zzd(String str) {
        Preconditions.checkNotEmpty(str);
        this.b = str;
        this.c = new StatusPendingResult((GoogleApiClient) null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            String valueOf = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
            String valueOf2 = String.valueOf(this.b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", NetworkConstants.contentType);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                f1266a.e("Unable to revoke access!", new Object[0]);
            }
            Logger logger = f1266a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.d(sb.toString(), new Object[0]);
        } catch (IOException e) {
            Logger logger2 = f1266a;
            String valueOf3 = String.valueOf(e.toString());
            logger2.e(valueOf3.length() != 0 ? "IOException when revoking access: ".concat(valueOf3) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            Logger logger3 = f1266a;
            String valueOf4 = String.valueOf(e2.toString());
            logger3.e(valueOf4.length() != 0 ? "Exception when revoking access: ".concat(valueOf4) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.c.setResult(status);
    }

    public static PendingResult<Status> zzc(String str) {
        if (str == null) {
            return PendingResults.immediateFailedResult(new Status(4), null);
        }
        zzd zzdVar = new zzd(str);
        new Thread(zzdVar).start();
        return zzdVar.c;
    }
}
