package com.ihoc.mgpa.e.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.ihoc.mgpa.e.a.d;
import com.ihoc.mgpa.n.m;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a extends d {
    private final Vibrator b;
    private final boolean c = true;
    private Class<?> d;

    @SuppressLint({"PrivateApi"})
    public a(Context context) {
        this.b = (Vibrator) context.getSystemService("vibrator");
        try {
            this.d = Class.forName("android.os.RichTapVibrationEffect");
        } catch (ClassNotFoundException unused) {
            m.c("TGPA_PatternHeImpl", "failed to reflect class: \"android.os.RichTapVibrationEffect\"!");
        }
        if (this.d == null) {
            try {
                this.d = Class.forName("android.os.VibrationEffect");
            } catch (ClassNotFoundException unused2) {
                m.c("TGPA_PatternHeImpl", "failed to reflect class: \"android.os.VibrationEffect\"!");
            }
        }
    }

    public static int a(int i, int i2) {
        if (i2 < 41 || i2 > 68) {
            if (i <= 0 || i >= 50) {
                return (i < 50 || i > 100) ? 0 : 15;
            }
            return 10;
        }
        if (i > 0 && i < 50) {
            return 15;
        }
        if (i < 50 || i >= 75) {
            return (i < 75 || i > 100) ? 0 : 30;
        }
        return 20;
    }

    private boolean b(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    @Override // com.ihoc.mgpa.e.a.d
    public int a(String str) {
        int a2;
        m.a("TGPA_PatternHeImpl", "getNonRichTapPatternDuration");
        int i = 0;
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("Pattern");
            int min = Math.min(jSONArray.length(), 16);
            long[] jArr = new long[min * 2];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 >= min) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2).getJSONObject("Event");
                String string = jSONObject.getString("Type");
                if (!TextUtils.equals("continuous", string)) {
                    if (!TextUtils.equals(FacebookRequestErrorClassification.KEY_TRANSIENT, string)) {
                        m.b("TGPA_PatternHeImpl", "haven't get type value");
                        break;
                    }
                    int i5 = i2 * 2;
                    jArr[i5] = (jSONObject.getInt("RelativeTime") - i3) - i4;
                    if (jArr[i5] < 0) {
                        jArr[i5] = 50;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("Parameters");
                    a2 = a(jSONObject2.getInt("Intensity"), jSONObject2.getInt("Frequency"));
                    jArr[i5 + 1] = a2;
                } else {
                    int i6 = i2 * 2;
                    jArr[i6] = (jSONObject.getInt("RelativeTime") - i3) - i4;
                    if (jArr[i6] < 0) {
                        jArr[i6] = 50;
                    }
                    a2 = jSONObject.getInt("Duration");
                    if (a2 > 50 && a2 < 100) {
                        a2 = 50;
                    } else if (a2 > 100) {
                        a2 -= 50;
                    }
                    jArr[i6 + 1] = a2;
                }
                i2++;
                i4 = a2;
                i3 = jSONObject.getInt("RelativeTime");
            }
            int i7 = 0;
            for (long j : jArr) {
                try {
                    i7 = (int) (i7 + j);
                } catch (Exception e) {
                    e = e;
                    i = i7;
                    e.printStackTrace();
                    return i;
                }
            }
            if (i7 <= 30000) {
                return i7;
            }
            m.b("TGPA_PatternHeImpl", "Pattern's duration is less than 30000");
            return 0;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.ihoc.mgpa.e.a.d
    public void a() {
        a(0, 0, 0);
    }

    @Override // com.ihoc.mgpa.e.a.d
    public void a(int i, int i2, int i3) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.b.vibrate((VibrationEffect) this.d.getMethod("createPatternHeParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
            } else {
                m.b("TGPA_PatternHeImpl", "The system apk is low than 26,does not support richTap!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            m.d("TGPA_PatternHeImpl", "The system doesn't integrate richTap software");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0117, code lost:
    
        com.ihoc.mgpa.n.m.b(r3, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x021f, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0211, code lost:
    
        r3 = "TGPA_PatternHeImpl";
        r7 = "intensity or frequency must between 0 and 100";
     */
    @Override // com.ihoc.mgpa.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.e.b.a.a(java.lang.String, int, int, int, int):void");
    }

    @Override // com.ihoc.mgpa.e.a.d
    public void b(String str, int i, int i2, int i3, int i4) {
        int i5;
        JSONArray jSONArray;
        int i6;
        String str2;
        String str3;
        String str4;
        if (this.b == null) {
            str3 = "TGPA_PatternHeImpl";
            str4 = "Please call the init method";
        } else {
            m.a("TGPA_PatternHeImpl", "play new he api");
            int i7 = 1;
            if (i >= 1) {
                try {
                    JSONArray jSONArray2 = new JSONObject(str).getJSONArray("Pattern");
                    int min = Math.min(jSONArray2.length(), 16);
                    int i8 = min * 2;
                    long[] jArr = new long[i8];
                    int[] iArr = new int[i8];
                    int i9 = 0;
                    Arrays.fill(iArr, 0);
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (i10 >= min) {
                            i5 = 0;
                            break;
                        }
                        JSONObject jSONObject = jSONArray2.getJSONObject(i10).getJSONObject("Event");
                        String string = jSONObject.getString("Type");
                        if (!TextUtils.equals("continuous", string)) {
                            jSONArray = jSONArray2;
                            i6 = i10;
                            if (!TextUtils.equals(FacebookRequestErrorClassification.KEY_TRANSIENT, string)) {
                                i5 = 0;
                                m.b("TGPA_PatternHeImpl", "haven't get type value");
                                break;
                            }
                            int i13 = i6 * 2;
                            jArr[i13] = (jSONObject.getInt("RelativeTime") - i11) - i12;
                            if (jArr[i13] < 0) {
                                jArr[i13] = 50;
                            }
                            iArr[i13] = 0;
                            JSONObject jSONObject2 = jSONObject.getJSONObject("Parameters");
                            int i14 = jSONObject2.getInt("Intensity");
                            int a2 = a(i14, jSONObject2.getInt("Frequency"));
                            int i15 = i13 + 1;
                            jArr[i15] = a2;
                            double d = i3;
                            Double.isNaN(d);
                            double d2 = i14;
                            Double.isNaN(d2);
                            iArr[i15] = Math.max(1, Math.min((int) (((d * 1.0d) * d2) / 100.0d), 255));
                            str2 = "RelativeTime";
                            i12 = a2;
                        } else {
                            int i16 = i10 * 2;
                            jArr[i16] = (jSONObject.getInt("RelativeTime") - i11) - i12;
                            if (jArr[i16] < 0) {
                                jArr[i16] = 50;
                            }
                            iArr[i16] = i9;
                            int i17 = jSONObject.getInt("Duration");
                            if (i17 > 50 && i17 < 100) {
                                i17 = 50;
                            } else if (i17 > 100) {
                                i17 -= 50;
                            }
                            int i18 = i16 + 1;
                            i6 = i10;
                            jArr[i18] = i17;
                            JSONObject jSONObject3 = jSONObject.getJSONObject("Parameters");
                            JSONArray jSONArray3 = jSONObject3.getJSONArray("Curve");
                            jSONArray = jSONArray2;
                            int max = Math.max(Math.min((int) (jSONArray3.getJSONObject(i7).getDouble("Intensity") * 255.0d), 255), Math.min((int) (jSONArray3.getJSONObject(2).getDouble("Intensity") * 255.0d), 255));
                            int i19 = jSONObject3.getInt("Intensity");
                            int i20 = jSONObject3.getInt("Frequency");
                            double d3 = i19;
                            Double.isNaN(d3);
                            double d4 = max;
                            Double.isNaN(d4);
                            double d5 = d4 * (d3 / 100.0d);
                            double d6 = i3;
                            Double.isNaN(d6);
                            int max2 = Math.max(1, (int) ((d5 * d6) / 255.0d));
                            if (i20 < 30) {
                                max2 = 0;
                            }
                            iArr[i18] = max2;
                            str2 = "RelativeTime";
                            i12 = i17;
                        }
                        i10 = i6 + 1;
                        i11 = jSONObject.getInt(str2);
                        jSONArray2 = jSONArray;
                        i7 = 1;
                        i9 = 0;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("times:");
                    sb.append(Arrays.toString(jArr));
                    m.a("TGPA_PatternHeImpl", sb.toString());
                    int length = jArr.length;
                    int i21 = 0;
                    while (i5 < length) {
                        i21 = (int) (i21 + jArr[i5]);
                        i5++;
                    }
                    if (i21 > 30000) {
                        m.b("TGPA_PatternHeImpl", "Pattern's duration is less than 30000");
                        return;
                    } else if (Build.VERSION.SDK_INT >= 26) {
                        this.b.vibrate(VibrationEffect.createWaveform(jArr, iArr, -1));
                        return;
                    } else {
                        this.b.vibrate(jArr, -1);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            str3 = "TGPA_PatternHeImpl";
            str4 = "The minimum count of loop pattern is 1";
        }
        m.b(str3, str4);
    }
}
