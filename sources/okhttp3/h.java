package okhttp3;

import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.intlgame.core.INTLMethodID;
import com.tencent.smtt.sdk.TbsListener;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h {
    final String bq;

    /* renamed from: a, reason: collision with root package name */
    static final Comparator<String> f7059a = new Comparator<String>() { // from class: okhttp3.h.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i2 = 4; i2 < min; i2++) {
                char charAt = str.charAt(i2);
                char charAt2 = str2.charAt(i2);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    };
    private static final Map<String, h> br = new LinkedHashMap();
    public static final h b = a("SSL_RSA_WITH_NULL_MD5", 1);
    public static final h c = a("SSL_RSA_WITH_NULL_SHA", 2);
    public static final h d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final h e = a("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final h f = a("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final h g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final h h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final h i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final h j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final h k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final h l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final h m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final h n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final h o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final h p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final h q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final h r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final h s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final h t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final h u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final h v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final h w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final h x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final h y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final h z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final h A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final h B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final h C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final h D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final h E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final h F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final h G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final h H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final h I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final h J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final h K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final h L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final h M = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final h N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final h O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final h P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final h Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final h R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final h S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final h T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final h U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final h V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final h W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final h X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final h Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", INTLMethodID.INTL_METHOD_ID_AUTH_UNBIND);
    public static final h Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", INTLMethodID.INTL_METHOD_ID_AUTH_MODIFY_DATA_PROTECTION_ACCEPTANCE);
    public static final h aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final h ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final h ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", TwitterApiConstants.Errors.ALREADY_FAVORITED);
    public static final h ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final h ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", TbsListener.ErrorCode.NEEDDOWNLOAD_2);
    public static final h af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final h ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final h ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final h ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final h aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final h ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", TbsListener.ErrorCode.STARTDOWNLOAD_3);
    public static final h al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", TbsListener.ErrorCode.STARTDOWNLOAD_4);
    public static final h am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", TbsListener.ErrorCode.STARTDOWNLOAD_7);
    public static final h an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", TbsListener.ErrorCode.STARTDOWNLOAD_8);
    public static final h ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final h ap = a("TLS_FALLBACK_SCSV", 22016);
    public static final h aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_TRANSLATE_SUCC);
    public static final h ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_TRANSLATE_SERVER_ERR);
    public static final h as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: at, reason: collision with root package name */
    public static final h f7060at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final h au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final h av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final h aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final h ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final h ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final h az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final h aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final h aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final h aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final h aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final h aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final h aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final h aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final h aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final h aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final h aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final h aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final h aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final h aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final h aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final h aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final h aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final h aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final h aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final h aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final h aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final h aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final h aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final h aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final h aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final h aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final h aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final h ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final h bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final h bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final h bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final h be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final h bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final h bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final h bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final h bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final h bj = a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final h bk = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final h bl = a("TLS_AES_128_GCM_SHA256", 4865);
    public static final h bm = a("TLS_AES_256_GCM_SHA384", 4866);
    public static final h bn = a("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final h bo = a("TLS_AES_128_CCM_SHA256", 4868);
    public static final h bp = a("TLS_AES_256_CCM_8_SHA256", 4869);

    public static synchronized h a(String str) {
        h hVar;
        synchronized (h.class) {
            hVar = br.get(str);
            if (hVar == null) {
                hVar = br.get(b(str));
                if (hVar == null) {
                    hVar = new h(str);
                }
                br.put(str, hVar);
            }
        }
        return hVar;
    }

    private static String b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<h> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private h(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bq = str;
    }

    private static h a(String str, int i2) {
        h hVar = new h(str);
        br.put(str, hVar);
        return hVar;
    }

    public String toString() {
        return this.bq;
    }
}
