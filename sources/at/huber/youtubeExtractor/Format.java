package at.huber.youtubeExtractor;

/* loaded from: classes.dex */
public class Format {

    /* renamed from: a, reason: collision with root package name */
    private int f928a;
    private String b;
    private int c;
    private int d;
    private VCodec e;
    private ACodec f;
    private int g;
    private boolean h;
    private boolean i;

    /* loaded from: classes.dex */
    public enum ACodec {
        MP3,
        AAC,
        VORBIS,
        OPUS,
        NONE
    }

    /* loaded from: classes.dex */
    public enum VCodec {
        H263,
        H264,
        MPEG4,
        VP8,
        VP9,
        NONE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, ACodec aCodec, boolean z) {
        this.f928a = i;
        this.b = str;
        this.c = i2;
        this.d = 30;
        this.g = -1;
        this.h = z;
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, VCodec vCodec, ACodec aCodec, int i2, boolean z) {
        this.f928a = i;
        this.b = str;
        this.c = -1;
        this.d = 30;
        this.g = i2;
        this.h = z;
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, ACodec aCodec, int i3, boolean z) {
        this.f928a = i;
        this.b = str;
        this.c = i2;
        this.d = 30;
        this.g = i3;
        this.h = z;
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, ACodec aCodec, int i3, boolean z, boolean z2) {
        this.f928a = i;
        this.b = str;
        this.c = i2;
        this.d = 30;
        this.g = i3;
        this.h = z;
        this.i = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, int i3, ACodec aCodec, boolean z) {
        this.f928a = i;
        this.b = str;
        this.c = i2;
        this.g = -1;
        this.d = i3;
        this.h = z;
        this.i = false;
    }

    public int a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.f928a != format.f928a || this.c != format.c || this.d != format.d || this.g != format.g || this.h != format.h || this.i != format.i) {
            return false;
        }
        String str = this.b;
        if (str == null ? format.b == null : str.equals(format.b)) {
            return this.e == format.e && this.f == format.f;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f928a * 31;
        String str = this.b;
        int hashCode = (((((i + (str != null ? str.hashCode() : 0)) * 31) + this.c) * 31) + this.d) * 31;
        VCodec vCodec = this.e;
        int hashCode2 = (hashCode + (vCodec != null ? vCodec.hashCode() : 0)) * 31;
        ACodec aCodec = this.f;
        return ((((((hashCode2 + (aCodec != null ? aCodec.hashCode() : 0)) * 31) + this.g) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }

    public String toString() {
        return "Format{itag=" + this.f928a + ", ext='" + this.b + "', height=" + this.c + ", fps=" + this.d + ", vCodec=" + this.e + ", aCodec=" + this.f + ", audioBitrate=" + this.g + ", isDashContainer=" + this.h + ", isHlsContent=" + this.i + '}';
    }
}
