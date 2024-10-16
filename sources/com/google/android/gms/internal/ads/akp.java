package com.google.android.gms.internal.ads;

import com.google.firebase.FirebaseError;
import com.intlgame.core.INTLMethodID;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;

/* loaded from: classes2.dex */
final class akp implements akm {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzjg f1936a;

    private akp(zzjg zzjgVar) {
        this.f1936a = zzjgVar;
    }

    @Override // com.google.android.gms.internal.ads.akm
    public final int a(int i) {
        switch (i) {
            case 131:
            case 159:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /* 176 */:
            case 179:
            case 186:
            case TbsListener.ErrorCode.COPY_EXCEPTION /* 215 */:
            case 231:
            case 241:
            case 251:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 20531:
            case 21420:
            case 22186:
            case 22203:
            case 2807729:
                return 2;
            case INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE /* 134 */:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                return 3;
            case TbsListener.ErrorCode.STARTDOWNLOAD_1 /* 160 */:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
            case 183:
            case 187:
            case TbsListener.ErrorCode.EXCEED_INCR_UPDATE /* 224 */:
            case TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR /* 225 */:
            case 18407:
            case 19899:
            case 20533:
            case 25152:
            case 28032:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case TbsListener.ErrorCode.STARTDOWNLOAD_2 /* 161 */:
            case TbsListener.ErrorCode.STARTDOWNLOAD_4 /* 163 */:
            case 18402:
            case 21419:
            case 25506:
                return 4;
            case 181:
            case 17545:
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.akm
    public final void a(int i, long j, long j2) throws zzhl {
        this.f1936a.a(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.akm
    public final void b(int i) throws zzhl {
        this.f1936a.a(i);
    }

    @Override // com.google.android.gms.internal.ads.akm
    public final void a(int i, long j) throws zzhl {
        this.f1936a.a(i, j);
    }

    @Override // com.google.android.gms.internal.ads.akm
    public final void a(int i, double d) {
        this.f1936a.a(i, d);
    }

    @Override // com.google.android.gms.internal.ads.akm
    public final void a(int i, String str) throws zzhl {
        this.f1936a.a(i, str);
    }

    @Override // com.google.android.gms.internal.ads.akm
    public final void a(int i, int i2, zzie zzieVar) throws IOException, InterruptedException {
        this.f1936a.a(i, i2, zzieVar);
    }
}
