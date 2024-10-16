package MTT;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class EFvrFvrType implements Serializable {
    private String __T;
    private int __value;
    static final /* synthetic */ boolean i = !EFvrFvrType.class.desiredAssertionStatus();
    private static EFvrFvrType[] j = new EFvrFvrType[8];

    /* renamed from: a, reason: collision with root package name */
    public static final EFvrFvrType f5a = new EFvrFvrType(0, 0, "EFVRFVR_UNKNOW");
    public static final EFvrFvrType b = new EFvrFvrType(1, 1, "EFVRFVR_PAGE");
    public static final EFvrFvrType c = new EFvrFvrType(2, 2, "EFVRFVR_IMG");
    public static final EFvrFvrType d = new EFvrFvrType(3, 3, "EFVRFVR_TEXT");
    public static final EFvrFvrType e = new EFvrFvrType(4, 4, "EFVRFVR_VIDEO");
    public static final EFvrFvrType f = new EFvrFvrType(5, 5, "EFVRFVR_TFETCH");
    public static final EFvrFvrType g = new EFvrFvrType(6, 6, "EFVRFVR_RAWDATA");
    public static final EFvrFvrType h = new EFvrFvrType(7, 7, "EFVRFVR_MHT");

    public int a() {
        return this.__value;
    }

    public String toString() {
        return this.__T;
    }

    private EFvrFvrType(int i2, int i3, String str) {
        this.__T = new String();
        this.__T = str;
        this.__value = i3;
        j[i2] = this;
    }
}
