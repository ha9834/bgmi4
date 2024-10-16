package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.abase.utils.ConstantUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f559a;
    Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g;
    PorterDuff.Mode i;
    public String j;

    private static String a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return ConstantUtils.NET_UNKNOWN;
        }
    }

    public static IconCompat a(Resources resources, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.e = i;
        if (resources != null) {
            try {
                iconCompat.b = resources.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.b = str;
        }
        return iconCompat;
    }

    public IconCompat() {
        this.f559a = -1;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.i = h;
        this.j = null;
    }

    private IconCompat(int i) {
        this.f559a = -1;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.i = h;
        this.j = null;
        this.f559a = i;
    }

    public int a() {
        if (this.f559a == -1 && Build.VERSION.SDK_INT >= 23) {
            return a((Icon) this.b);
        }
        return this.f559a;
    }

    public String b() {
        if (this.f559a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.b);
        }
        if (this.f559a != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return ((String) this.b).split(CertificateUtil.DELIMITER, -1)[0];
    }

    public int c() {
        if (this.f559a == -1 && Build.VERSION.SDK_INT >= 23) {
            return c((Icon) this.b);
        }
        if (this.f559a != 2) {
            throw new IllegalStateException("called getResId() on " + this);
        }
        return this.e;
    }

    public Uri d() {
        if (this.f559a == -1 && Build.VERSION.SDK_INT >= 23) {
            return d((Icon) this.b);
        }
        int i = this.f559a;
        if (i != 4 && i != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.b);
    }

    @Deprecated
    public Icon e() {
        return a((Context) null);
    }

    public Icon a(Context context) {
        Icon createWithBitmap;
        int i = this.f559a;
        if (i == -1) {
            return (Icon) this.b;
        }
        switch (i) {
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.b);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(b(), this.e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.b, this.e, this.f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.b);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(a((Bitmap) this.b, false));
                    break;
                }
            case 6:
                if (context == null) {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + d());
                }
                InputStream b = b(context);
                if (b == null) {
                    throw new IllegalStateException("Cannot load adaptive icon from uri: " + d());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(b));
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(b), false));
                    break;
                }
            default:
                throw new IllegalArgumentException("Unknown type");
        }
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.i;
        if (mode != h) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    private InputStream b(Context context) {
        Uri d = d();
        String scheme = d.getScheme();
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme) || TransferTable.COLUMN_FILE.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(d);
            } catch (Exception e) {
                Log.w("IconCompat", "Unable to load image from URI: " + d, e);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.b));
        } catch (FileNotFoundException e2) {
            Log.w("IconCompat", "Unable to load image from path: " + d, e2);
            return null;
        }
    }

    public String toString() {
        if (this.f559a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(a(this.f559a));
        switch (this.f559a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(b());
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    sb.append(this.f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.i != h) {
            sb.append(" mode=");
            sb.append(this.i);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void a(boolean z) {
        this.j = this.i.name();
        int i = this.f559a;
        if (i == -1) {
            if (z) {
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            }
            this.d = (Parcelable) this.b;
            return;
        }
        switch (i) {
            case 1:
            case 5:
                if (z) {
                    Bitmap bitmap = (Bitmap) this.b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.d = (Parcelable) this.b;
                return;
            case 2:
                this.c = ((String) this.b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.c = (byte[]) this.b;
                return;
            case 4:
            case 6:
                this.c = this.b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void f() {
        this.i = PorterDuff.Mode.valueOf(this.j);
        int i = this.f559a;
        if (i == -1) {
            Parcelable parcelable = this.d;
            if (parcelable != null) {
                this.b = parcelable;
                return;
            }
            throw new IllegalArgumentException("Invalid icon");
        }
        switch (i) {
            case 1:
            case 5:
                Parcelable parcelable2 = this.d;
                if (parcelable2 != null) {
                    this.b = parcelable2;
                    return;
                }
                byte[] bArr = this.c;
                this.b = bArr;
                this.f559a = 3;
                this.e = 0;
                this.f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                this.b = new String(this.c, Charset.forName("UTF-16"));
                return;
            case 3:
                this.b = this.c;
                return;
            default:
                return;
        }
    }

    private static int a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e);
            return -1;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        }
    }

    private static String b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    private static int c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    private static Uri d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(WebView.NIGHT_MODE_COLOR);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
