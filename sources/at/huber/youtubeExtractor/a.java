package at.huber.youtubeExtractor;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f931a;
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private long g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, String str2, String str3, String str4, long j, long j2, boolean z, String str5) {
        this.f931a = str;
        this.b = str2;
        this.d = str3;
        this.e = str4;
        this.f = j;
        this.g = j2;
        this.h = z;
        this.c = str5;
    }

    public boolean a() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f != aVar.f || this.g != aVar.g || this.h != aVar.h) {
            return false;
        }
        String str = this.f931a;
        if (str == null ? aVar.f931a != null : !str.equals(aVar.f931a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? aVar.b != null : !str2.equals(aVar.b)) {
            return false;
        }
        String str3 = this.d;
        if (str3 == null ? aVar.d != null : !str3.equals(aVar.d)) {
            return false;
        }
        String str4 = this.e;
        return str4 != null ? str4.equals(aVar.e) : aVar.e == null;
    }

    public int hashCode() {
        String str = this.f931a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        long j = this.f;
        int i = (hashCode4 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.g;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.h ? 1 : 0);
    }

    public String toString() {
        return "VideoMeta{videoId='" + this.f931a + "', title='" + this.b + "', author='" + this.d + "', channelId='" + this.e + "', videoLength=" + this.f + ", viewCount=" + this.g + ", isLiveStream=" + this.h + '}';
    }
}
