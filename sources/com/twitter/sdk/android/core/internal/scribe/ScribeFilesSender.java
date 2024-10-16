package com.twitter.sdk.android.core.internal.scribe;

import a.b;
import a.b.c;
import a.b.e;
import a.b.k;
import a.b.o;
import a.b.s;
import a.l;
import a.m;
import android.content.Context;
import android.text.TextUtils;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.CommonUtils;
import com.twitter.sdk.android.core.internal.IdManager;
import com.twitter.sdk.android.core.internal.network.GuestAuthInterceptor;
import com.twitter.sdk.android.core.internal.network.OAuth1aInterceptor;
import com.twitter.sdk.android.core.internal.network.OkHttpClientHelper;
import com.twitter.sdk.android.core.internal.scribe.QueueFile;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ScribeFilesSender implements FilesSender {
    private static final String SEND_FILE_FAILURE_ERROR = "Failed sending files";
    private final TwitterAuthConfig authConfig;
    private final Context context;
    private final ExecutorService executorService;
    private final GuestSessionProvider guestSessionProvider;
    private final IdManager idManager;
    private final long ownerId;
    private final ScribeConfig scribeConfig;
    private final AtomicReference<ScribeService> scribeService = new AtomicReference<>();
    private final SessionManager<? extends Session<TwitterAuthToken>> sessionManager;
    private static final byte[] START_JSON_ARRAY = {91};
    private static final byte[] COMMA = {44};
    private static final byte[] END_JSON_ARRAY = {93};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ScribeService {
        @k(a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @o(a = "/{version}/jot/{type}")
        @e
        b<ac> upload(@s(a = "version") String str, @s(a = "type") String str2, @c(a = "log[]") String str3);

        @k(a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @o(a = "/scribe/{sequence}")
        @e
        b<ac> uploadSequence(@s(a = "sequence") String str, @c(a = "log[]") String str2);
    }

    public ScribeFilesSender(Context context, ScribeConfig scribeConfig, long j, TwitterAuthConfig twitterAuthConfig, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, ExecutorService executorService, IdManager idManager) {
        this.context = context;
        this.scribeConfig = scribeConfig;
        this.ownerId = j;
        this.authConfig = twitterAuthConfig;
        this.sessionManager = sessionManager;
        this.guestSessionProvider = guestSessionProvider;
        this.executorService = executorService;
        this.idManager = idManager;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FilesSender
    public boolean send(List<File> list) {
        if (hasApiAdapter()) {
            try {
                String scribeEventsAsJsonArrayString = getScribeEventsAsJsonArrayString(list);
                CommonUtils.logControlled(this.context, scribeEventsAsJsonArrayString);
                l<ac> upload = upload(scribeEventsAsJsonArrayString);
                if (upload.a() == 200) {
                    return true;
                }
                CommonUtils.logControlledError(this.context, SEND_FILE_FAILURE_ERROR, null);
                if (upload.a() != 500) {
                    if (upload.a() != 400) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                CommonUtils.logControlledError(this.context, SEND_FILE_FAILURE_ERROR, e);
                return false;
            }
        }
        CommonUtils.logControlled(this.context, "Cannot attempt upload at this time");
        return false;
    }

    String getScribeEventsAsJsonArrayString(List<File> list) throws IOException {
        QueueFile queueFile;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        final boolean[] zArr = new boolean[1];
        byteArrayOutputStream.write(START_JSON_ARRAY);
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            try {
                queueFile = new QueueFile(it.next());
                try {
                    queueFile.forEach(new QueueFile.ElementReader() { // from class: com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender.1
                        @Override // com.twitter.sdk.android.core.internal.scribe.QueueFile.ElementReader
                        public void read(InputStream inputStream, int i) throws IOException {
                            byte[] bArr = new byte[i];
                            inputStream.read(bArr);
                            boolean[] zArr2 = zArr;
                            if (zArr2[0]) {
                                byteArrayOutputStream.write(ScribeFilesSender.COMMA);
                            } else {
                                zArr2[0] = true;
                            }
                            byteArrayOutputStream.write(bArr);
                        }
                    });
                    CommonUtils.closeQuietly(queueFile);
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeQuietly(queueFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                queueFile = null;
            }
        }
        byteArrayOutputStream.write(END_JSON_ARRAY);
        return byteArrayOutputStream.toString("UTF-8");
    }

    private boolean hasApiAdapter() {
        return getScribeService() != null;
    }

    void setScribeService(ScribeService scribeService) {
        this.scribeService.set(scribeService);
    }

    /* JADX WARN: Multi-variable type inference failed */
    synchronized ScribeService getScribeService() {
        x a2;
        if (this.scribeService.get() == null) {
            Session session = getSession(this.ownerId);
            if (isValidSession(session)) {
                a2 = new x.a().a(OkHttpClientHelper.getCertificatePinner()).a(new ConfigRequestInterceptor(this.scribeConfig, this.idManager)).a(new OAuth1aInterceptor(session, this.authConfig)).a();
            } else {
                a2 = new x.a().a(OkHttpClientHelper.getCertificatePinner()).a(new ConfigRequestInterceptor(this.scribeConfig, this.idManager)).a(new GuestAuthInterceptor(this.guestSessionProvider)).a();
            }
            this.scribeService.compareAndSet(null, new m.a().a(this.scribeConfig.baseUrl).a(a2).a().a(ScribeService.class));
        }
        return this.scribeService.get();
    }

    private Session getSession(long j) {
        return this.sessionManager.getSession(j);
    }

    private boolean isValidSession(Session session) {
        return (session == null || session.getAuthToken() == null) ? false : true;
    }

    l<ac> upload(String str) throws IOException {
        ScribeService scribeService = getScribeService();
        if (!TextUtils.isEmpty(this.scribeConfig.sequence)) {
            return scribeService.uploadSequence(this.scribeConfig.sequence, str).a();
        }
        return scribeService.upload(this.scribeConfig.pathVersion, this.scribeConfig.pathType, str).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ConfigRequestInterceptor implements u {
        private static final String CLIENT_UUID_HEADER = "X-Client-UUID";
        private static final String POLLING_HEADER = "X-Twitter-Polling";
        private static final String POLLING_HEADER_VALUE = "true";
        private static final String USER_AGENT_HEADER = "User-Agent";
        private final IdManager idManager;
        private final ScribeConfig scribeConfig;

        ConfigRequestInterceptor(ScribeConfig scribeConfig, IdManager idManager) {
            this.scribeConfig = scribeConfig;
            this.idManager = idManager;
        }

        @Override // okhttp3.u
        public ab intercept(u.a aVar) throws IOException {
            z.a e = aVar.a().e();
            if (!TextUtils.isEmpty(this.scribeConfig.userAgent)) {
                e.a("User-Agent", this.scribeConfig.userAgent);
            }
            if (!TextUtils.isEmpty(this.idManager.getDeviceUUID())) {
                e.a(CLIENT_UUID_HEADER, this.idManager.getDeviceUUID());
            }
            e.a(POLLING_HEADER, "true");
            return aVar.a(e.b());
        }
    }
}
