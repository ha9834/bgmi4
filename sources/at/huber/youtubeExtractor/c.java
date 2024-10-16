package at.huber.youtubeExtractor;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Format f934a;
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Format format, String str) {
        this.b = "";
        this.f934a = format;
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public Format b() {
        return this.f934a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        Format format = this.f934a;
        if (format == null ? cVar.f934a != null : !format.equals(cVar.f934a)) {
            return false;
        }
        String str = this.b;
        return str != null ? str.equals(cVar.b) : cVar.b == null;
    }

    public int hashCode() {
        Format format = this.f934a;
        int hashCode = (format != null ? format.hashCode() : 0) * 31;
        String str = this.b;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "YtFile{format=" + this.f934a + ", url='" + this.b + "'}";
    }
}
