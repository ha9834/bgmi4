package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    private static Boolean f1594a = null;

    @GuardedBy("DynamiteModule.class")
    private static zzi b = null;

    @GuardedBy("DynamiteModule.class")
    private static zzk c = null;

    @GuardedBy("DynamiteModule.class")
    private static String d = null;

    @GuardedBy("DynamiteModule.class")
    private static int e = -1;
    private final Context i;
    private static final ThreadLocal<a> f = new ThreadLocal<>();
    private static final VersionPolicy.zza g = new com.google.android.gms.dynamite.a();

    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new com.google.android.gms.dynamite.b();

    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new c();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new d();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new e();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new f();
    private static final VersionPolicy h = new g();

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public interface VersionPolicy {

        /* loaded from: classes.dex */
        public interface zza {
            int getLocalVersion(Context context, String str);

            int zza(Context context, String str, boolean z) throws LoadingException;
        }

        /* loaded from: classes.dex */
        public static class zzb {
            public int zzir = 0;
            public int zzis = 0;
            public int zzit = 0;
        }

        zzb zza(Context context, String str, zza zzaVar) throws LoadingException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Cursor f1595a;

        private a() {
        }

        /* synthetic */ a(com.google.android.gms.dynamite.a aVar) {
            this();
        }
    }

    @KeepForSdk
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        a aVar = f.get();
        com.google.android.gms.dynamite.a aVar2 = null;
        a aVar3 = new a(aVar2);
        f.set(aVar3);
        try {
            VersionPolicy.zzb zza = versionPolicy.zza(context, str, g);
            int i = zza.zzir;
            int i2 = zza.zzis;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            if (zza.zzit == 0 || ((zza.zzit == -1 && zza.zzir == 0) || (zza.zzit == 1 && zza.zzis == 0))) {
                int i3 = zza.zzir;
                int i4 = zza.zzis;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i3);
                sb2.append(" and remote version is ");
                sb2.append(i4);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), aVar2);
            }
            if (zza.zzit == -1) {
                DynamiteModule a2 = a(context, str);
                if (aVar3.f1595a != null) {
                    aVar3.f1595a.close();
                }
                f.set(aVar);
                return a2;
            }
            if (zza.zzit == 1) {
                try {
                    DynamiteModule a3 = a(context, str, zza.zzis);
                    if (aVar3.f1595a != null) {
                        aVar3.f1595a.close();
                    }
                    f.set(aVar);
                    return a3;
                } catch (LoadingException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    if (zza.zzir != 0 && versionPolicy.zza(context, str, new b(zza.zzir, 0)).zzit == -1) {
                        DynamiteModule a4 = a(context, str);
                        if (aVar3.f1595a != null) {
                            aVar3.f1595a.close();
                        }
                        f.set(aVar);
                        return a4;
                    }
                    throw new LoadingException("Remote load failed. No local fallback found.", e2, aVar2);
                }
            }
            int i5 = zza.zzit;
            StringBuilder sb3 = new StringBuilder(47);
            sb3.append("VersionPolicy returned invalid code:");
            sb3.append(i5);
            throw new LoadingException(sb3.toString(), aVar2);
        } catch (Throwable th) {
            if (aVar3.f1595a != null) {
                aVar3.f1595a.close();
            }
            f.set(aVar);
            throw th;
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.a aVar) {
            this(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements VersionPolicy.zza {

        /* renamed from: a, reason: collision with root package name */
        private final int f1596a;
        private final int b = 0;

        public b(int i, int i2) {
            this.f1596a = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
        public final int zza(Context context, String str, boolean z) {
            return 0;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
        public final int getLocalVersion(Context context, String str) {
            return this.f1596a;
        }
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zza(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = f1594a;
                if (bool2 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    a(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int b2 = b(context, str, z);
                                if (d != null && !d.isEmpty()) {
                                    h hVar = new h(d, ClassLoader.getSystemClassLoader());
                                    a(hVar);
                                    declaredField.set(null, hVar);
                                    f1594a = Boolean.TRUE;
                                    return b2;
                                }
                                return b2;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        bool2 = bool;
                        f1594a = bool2;
                    }
                }
                if (bool2.booleanValue()) {
                    try {
                        return b(context, str, z);
                    } catch (LoadingException e3) {
                        String valueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return a(context, str, z);
            }
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw th;
        }
    }

    private static int a(Context context, String str, boolean z) {
        zzi a2 = a(context);
        if (a2 == null) {
            return 0;
        }
        try {
            if (a2.zzak() >= 2) {
                return a2.zzb(ObjectWrapper.wrap(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return a2.zza(ObjectWrapper.wrap(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int b(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r10 = r10.length()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r2.append(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r2.append(r9)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r8 == 0) goto L87
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            if (r9 == 0) goto L87
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            if (r9 <= 0) goto L81
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.dynamite.DynamiteModule.d = r1     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7e
            if (r1 < 0) goto L6b
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.dynamite.DynamiteModule.e = r1     // Catch: java.lang.Throwable -> L7e
        L6b:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7e
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$a> r10 = com.google.android.gms.dynamite.DynamiteModule.f     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            com.google.android.gms.dynamite.DynamiteModule$a r10 = (com.google.android.gms.dynamite.DynamiteModule.a) r10     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            if (r10 == 0) goto L81
            android.database.Cursor r1 = r10.f1595a     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            if (r1 != 0) goto L81
            r10.f1595a = r8     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            r8 = r0
            goto L81
        L7e:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7e
            throw r9     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
        L81:
            if (r8 == 0) goto L86
            r8.close()
        L86:
            return r9
        L87:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
            throw r9     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9a
        L96:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lb2
        L9a:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto La3
        L9f:
            r8 = move-exception
            goto Lb2
        La1:
            r8 = move-exception
            r9 = r0
        La3:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> Lb0
            if (r10 == 0) goto La8
            throw r8     // Catch: java.lang.Throwable -> Lb0
        La8:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lb0
            throw r10     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r8 = move-exception
            r0 = r9
        Lb2:
            if (r0 == 0) goto Lb7
            r0.close()
        Lb7:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.b(android.content.Context, java.lang.String, boolean):int");
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    private static DynamiteModule a(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule a(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        IObjectWrapper zza;
        com.google.android.gms.dynamite.a aVar = null;
        try {
            synchronized (DynamiteModule.class) {
                bool = f1594a;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", aVar);
            }
            if (bool.booleanValue()) {
                return b(context, str, i);
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
            sb.append("Selected remote version of ");
            sb.append(str);
            sb.append(", version >= ");
            sb.append(i);
            Log.i("DynamiteModule", sb.toString());
            zzi a2 = a(context);
            if (a2 == null) {
                throw new LoadingException("Failed to create IDynamiteLoader.", aVar);
            }
            if (a2.zzak() >= 2) {
                zza = a2.zzb(ObjectWrapper.wrap(context), str, i);
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                zza = a2.zza(ObjectWrapper.wrap(context), str, i);
            }
            if (ObjectWrapper.unwrap(zza) == null) {
                throw new LoadingException("Failed to load remote module.", aVar);
            }
            return new DynamiteModule((Context) ObjectWrapper.unwrap(zza));
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, aVar);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new LoadingException("Failed to load remote module.", th, aVar);
        }
    }

    private static zzi a(Context context) {
        zzi zzjVar;
        synchronized (DynamiteModule.class) {
            if (b != null) {
                return b;
            }
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzjVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzi) {
                        zzjVar = (zzi) queryLocalInterface;
                    } else {
                        zzjVar = new zzj(iBinder);
                    }
                }
                if (zzjVar != null) {
                    b = zzjVar;
                    return zzjVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    @KeepForSdk
    public final Context getModuleContext() {
        return this.i;
    }

    private static DynamiteModule b(Context context, String str, int i) throws LoadingException, RemoteException {
        zzk zzkVar;
        IObjectWrapper zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzkVar = c;
        }
        com.google.android.gms.dynamite.a aVar = null;
        if (zzkVar == null) {
            throw new LoadingException("DynamiteLoaderV2 was not cached.", aVar);
        }
        a aVar2 = f.get();
        if (aVar2 == null || aVar2.f1595a == null) {
            throw new LoadingException("No result cursor", aVar);
        }
        Context applicationContext = context.getApplicationContext();
        Cursor cursor = aVar2.f1595a;
        ObjectWrapper.wrap(null);
        if (a().booleanValue()) {
            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
            zza = zzkVar.zzb(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
        } else {
            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
            zza = zzkVar.zza(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
        }
        Context context2 = (Context) ObjectWrapper.unwrap(zza);
        if (context2 == null) {
            throw new LoadingException("Failed to get module context", aVar);
        }
        return new DynamiteModule(context2);
    }

    private static Boolean a() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(e >= 2);
        }
        return valueOf;
    }

    @GuardedBy("DynamiteModule.class")
    private static void a(ClassLoader classLoader) throws LoadingException {
        zzk zzlVar;
        com.google.android.gms.dynamite.a aVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzlVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzk) {
                    zzlVar = (zzk) queryLocalInterface;
                } else {
                    zzlVar = new zzl(iBinder);
                }
            }
            c = zzlVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, aVar);
        }
    }

    @KeepForSdk
    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.i.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }

    private DynamiteModule(Context context) {
        this.i = (Context) Preconditions.checkNotNull(context);
    }
}
