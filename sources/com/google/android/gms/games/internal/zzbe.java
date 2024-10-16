package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzbe {

    /* renamed from: a, reason: collision with root package name */
    private static final zzbn f1695a = ai.f1655a;

    public static <R, PendingR extends Result, ExceptionData> Task<R> zza(final PendingResult<PendingR> pendingResult, final zzbn zzbnVar, final PendingResultUtil.ResultConverter<PendingR, R> resultConverter, final PendingResultUtil.ResultConverter<PendingR, ExceptionData> resultConverter2, final zzbl<ExceptionData> zzblVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(pendingResult, zzbnVar, taskCompletionSource, resultConverter, resultConverter2, zzblVar) { // from class: com.google.android.gms.games.internal.ad

            /* renamed from: a, reason: collision with root package name */
            private final PendingResult f1650a;
            private final zzbn b;
            private final TaskCompletionSource c;
            private final PendingResultUtil.ResultConverter d;
            private final PendingResultUtil.ResultConverter e;
            private final zzbl f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1650a = pendingResult;
                this.b = zzbnVar;
                this.c = taskCompletionSource;
                this.d = resultConverter;
                this.e = resultConverter2;
                this.f = zzblVar;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbe.a(this.f1650a, this.b, this.c, this.d, this.e, this.f, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<R> toTask(final PendingResult<PendingR> pendingResult, final PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(pendingResult, taskCompletionSource, resultConverter) { // from class: com.google.android.gms.games.internal.ae

            /* renamed from: a, reason: collision with root package name */
            private final PendingResult f1651a;
            private final TaskCompletionSource b;
            private final PendingResultUtil.ResultConverter c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1651a = pendingResult;
                this.b = taskCompletionSource;
                this.c = resultConverter;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbe.a(this.f1651a, this.b, this.c, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(final PendingResult<PendingR> pendingResult, final PendingResultUtil.ResultConverter<PendingR, R> resultConverter, final zzbm<PendingR> zzbmVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(pendingResult, taskCompletionSource, resultConverter, zzbmVar) { // from class: com.google.android.gms.games.internal.af

            /* renamed from: a, reason: collision with root package name */
            private final PendingResult f1652a;
            private final TaskCompletionSource b;
            private final PendingResultUtil.ResultConverter c;
            private final zzbm d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1652a = pendingResult;
                this.b = taskCompletionSource;
                this.c = resultConverter;
                this.d = zzbmVar;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbe.a(this.f1652a, this.b, this.c, this.d, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        return zza(pendingResult, resultConverter, (zzbm) null);
    }

    public static <R extends Releasable, PendingR extends Result> Task<AnnotatedData<R>> zzb(final PendingResult<PendingR> pendingResult, final PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(resultConverter, pendingResult, taskCompletionSource) { // from class: com.google.android.gms.games.internal.ag

            /* renamed from: a, reason: collision with root package name */
            private final PendingResultUtil.ResultConverter f1653a;
            private final PendingResult b;
            private final TaskCompletionSource c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1653a = resultConverter;
                this.b = pendingResult;
                this.c = taskCompletionSource;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbe.a(this.f1653a, this.b, this.c, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<R> zza(final PendingResult<PendingR> pendingResult, final zzbn zzbnVar, final PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(zzbnVar, pendingResult, taskCompletionSource, resultConverter) { // from class: com.google.android.gms.games.internal.ah

            /* renamed from: a, reason: collision with root package name */
            private final zzbn f1654a;
            private final PendingResult b;
            private final TaskCompletionSource c;
            private final PendingResultUtil.ResultConverter d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1654a = zzbnVar;
                this.b = pendingResult;
                this.c = taskCompletionSource;
                this.d = resultConverter;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbe.a(this.f1654a, this.b, this.c, this.d, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbn zzbnVar, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, Status status) {
        if (zzbnVar.zza(status)) {
            taskCompletionSource.setResult(resultConverter.convert(pendingResult.await(0L, TimeUnit.MILLISECONDS)));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(PendingResultUtil.ResultConverter resultConverter, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, Status status) {
        boolean z = status.getStatusCode() == 3;
        Releasable releasable = (Releasable) resultConverter.convert(pendingResult.await(0L, TimeUnit.MILLISECONDS));
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(releasable, z));
            return;
        }
        if (releasable != null) {
            releasable.release();
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zzbm zzbmVar, Status status) {
        boolean z = status.getStatusCode() == 3;
        Result await = pendingResult.await(0L, TimeUnit.MILLISECONDS);
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(resultConverter.convert(await), z));
            return;
        }
        if (await != null && zzbmVar != null) {
            zzbmVar.release(await);
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, Status status) {
        Result await = pendingResult.await(0L, TimeUnit.MILLISECONDS);
        if (status.isSuccess()) {
            taskCompletionSource.setResult(resultConverter.convert(await));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(PendingResult pendingResult, zzbn zzbnVar, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.ResultConverter resultConverter2, zzbl zzblVar, Status status) {
        Result await = pendingResult.await(0L, TimeUnit.MILLISECONDS);
        if (zzbnVar.zza(status)) {
            taskCompletionSource.setResult(resultConverter.convert(await));
            return;
        }
        Object convert = resultConverter2.convert(await);
        if (convert != null) {
            taskCompletionSource.setException(zzblVar.zza(GamesClientStatusCodes.zzb(status), convert));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
        }
    }
}
