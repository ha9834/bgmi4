package MTT;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class EFvrChannel implements Serializable {
    private String __T;
    private int __value;
    static final /* synthetic */ boolean G = !EFvrChannel.class.desiredAssertionStatus();
    private static EFvrChannel[] H = new EFvrChannel[32];

    /* renamed from: a, reason: collision with root package name */
    public static final EFvrChannel f4a = new EFvrChannel(0, 0, "EFVRCHN_UNKNOW");
    public static final EFvrChannel b = new EFvrChannel(1, 1, "EFVRCHN_HOME");
    public static final EFvrChannel c = new EFvrChannel(2, 2, "EFVRCHN_BOOK");
    public static final EFvrChannel d = new EFvrChannel(3, 3, "EFVRCHN_LINK");
    public static final EFvrChannel e = new EFvrChannel(4, 4, "EFVRCHN_PAGE");
    public static final EFvrChannel f = new EFvrChannel(5, 5, "EFVRCHN_SIDE");
    public static final EFvrChannel g = new EFvrChannel(6, 6, "EFVRCHN_PC");
    public static final EFvrChannel h = new EFvrChannel(7, 7, "EFVRCHN_READ");
    public static final EFvrChannel i = new EFvrChannel(8, 8, "EFVRCHN_MODEL");
    public static final EFvrChannel j = new EFvrChannel(9, 9, "EFVRCHN_FETCH");
    public static final EFvrChannel k = new EFvrChannel(10, 10, "EFVRCHN_IPHHOME");
    public static final EFvrChannel l = new EFvrChannel(11, 11, "EFVRCHN_PCBOOK");
    public static final EFvrChannel m = new EFvrChannel(12, 12, "EFVRCHN_PIC");
    public static final EFvrChannel n = new EFvrChannel(13, 13, "EFVRCHN_DRAW");
    public static final EFvrChannel o = new EFvrChannel(14, 14, "EFVRCHN_DRAWWORD");
    public static final EFvrChannel p = new EFvrChannel(15, 15, "EFVRCHN_EDIT");
    public static final EFvrChannel q = new EFvrChannel(16, 16, "EFVRCHN_COPY");
    public static final EFvrChannel r = new EFvrChannel(17, 17, "EFVRCHN_SCREEN");
    public static final EFvrChannel s = new EFvrChannel(18, 18, "EFVRCHN_PCQBTOOLBAR");
    public static final EFvrChannel t = new EFvrChannel(19, 19, "EFVRCHN_IPQBTOOLBAR");
    public static final EFvrChannel u = new EFvrChannel(20, 20, "EFVRCHN_UPPERRIGHT");
    public static final EFvrChannel v = new EFvrChannel(21, 21, "EFVRCHN_PICVIEWER");
    public static final EFvrChannel w = new EFvrChannel(22, 22, "EFVRCHN_IPQBLIGHT");
    public static final EFvrChannel x = new EFvrChannel(23, 100, "EFVRCHN_SHARE");
    public static final EFvrChannel y = new EFvrChannel(24, 101, "EFVRCHN_IMG");
    public static final EFvrChannel z = new EFvrChannel(25, 102, "EFVRCHN_NETDISK");
    public static final EFvrChannel A = new EFvrChannel(26, 103, "EFVRCHN_WECHAT");
    public static final EFvrChannel B = new EFvrChannel(27, 104, "EFVRCHN_TENCENTNEWS");
    public static final EFvrChannel C = new EFvrChannel(28, 105, "EFVRCHN_FENXIANG");
    public static final EFvrChannel D = new EFvrChannel(29, 106, "EFVRCHN_3GTENCENT");
    public static final EFvrChannel E = new EFvrChannel(30, 107, "EFVRCHN_NATIVE_CENTER");
    public static final EFvrChannel F = new EFvrChannel(31, 108, "EFVRCHN_NATIVE_LINK");

    public int a() {
        return this.__value;
    }

    public String toString() {
        return this.__T;
    }

    private EFvrChannel(int i2, int i3, String str) {
        this.__T = new String();
        this.__T = str;
        this.__value = i3;
        H[i2] = this;
    }
}
