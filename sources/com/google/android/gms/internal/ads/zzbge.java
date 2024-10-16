package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzbge extends zzbft {
    private static final Set<String> d = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat e = new DecimalFormat("#,###");
    private File f;
    private boolean g;

    public zzbge(zzbdf zzbdfVar) {
        super(zzbdfVar);
        File cacheDir = this.f2870a.getCacheDir();
        if (cacheDir == null) {
            zzawz.zzep("Context.getCacheDir() returned null");
            return;
        }
        this.f = new File(cacheDir, "admobVideoStreams");
        if (!this.f.isDirectory() && !this.f.mkdirs()) {
            String valueOf = String.valueOf(this.f.getAbsolutePath());
            zzawz.zzep(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.f = null;
        } else {
            if (this.f.setReadable(true, false) && this.f.setExecutable(true, false)) {
                return;
            }
            String valueOf2 = String.valueOf(this.f.getAbsolutePath());
            zzawz.zzep(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x01f2, code lost:
    
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01f4, code lost:
    
        r1 = r5.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01fd, code lost:
    
        if (r1 < 400) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01ff, code lost:
    
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x020f, code lost:
    
        if (r2.length() == 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0211, code lost:
    
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x021c, code lost:
    
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0244, code lost:
    
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0247, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0245, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0217, code lost:
    
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0249, code lost:
    
        r7 = r5.getContentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x024d, code lost:
    
        if (r7 >= 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x024f, code lost:
    
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0259, code lost:
    
        if (r1.length() == 0) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x025b, code lost:
    
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0266, code lost:
    
        com.google.android.gms.internal.ads.zzawz.zzep(r0);
        zza(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzbge.d.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0277, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0260, code lost:
    
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0278, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzbge.e.format(r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzyt.zzpe().zzd(com.google.android.gms.internal.ads.zzacu.zzclv)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x028f, code lost:
    
        if (r7 <= r3) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0291, code lost:
    
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.internal.ads.zzawz.zzep(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02ca, code lost:
    
        if (r1.length() == 0) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02cc, code lost:
    
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02d7, code lost:
    
        zza(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.zzbge.d.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02e5, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02d1, code lost:
    
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02e6, code lost:
    
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.internal.ads.zzawz.zzdp(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0321, code lost:
    
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(com.amazonaws.services.s3.internal.Constants.MB);
        r16 = com.google.android.gms.ads.internal.zzk.zzln();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x033f, code lost:
    
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0340, code lost:
    
        r6 = new com.google.android.gms.internal.ads.zzazj(((java.lang.Long) com.google.android.gms.internal.ads.zzyt.zzpe().zzd(com.google.android.gms.internal.ads.zzacu.zzcly)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzyt.zzpe().zzd(com.google.android.gms.internal.ads.zzacu.zzclx)).longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0359, code lost:
    
        r20 = r5.read(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x035d, code lost:
    
        if (r20 < 0) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x035f, code lost:
    
        r11 = r11 + r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0361, code lost:
    
        if (r11 <= r3) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0396, code lost:
    
        r1.flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x039d, code lost:
    
        if (r2.write(r1) > 0) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x039f, code lost:
    
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03ae, code lost:
    
        if (r24 > 0) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03b0, code lost:
    
        r20 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03b4, code lost:
    
        if (r30.g != false) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03ba, code lost:
    
        if (r6.tryAcquire() == false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03c2, code lost:
    
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03c6, code lost:
    
        r24 = r10;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03e4, code lost:
    
        com.google.android.gms.internal.ads.zzazt.zzyr.post(new com.google.android.gms.internal.ads.ki(r30, r31, r12.getAbsolutePath(), r11, r7, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0405, code lost:
    
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04c5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x04c6, code lost:
    
        r15 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04c8, code lost:
    
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04c3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x03ed, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x03ee, code lost:
    
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03eb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03f3, code lost:
    
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0428, code lost:
    
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0429, code lost:
    
        r27 = r4;
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x042f, code lost:
    
        r15 = "downloadTimeout";
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0431, code lost:
    
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r10 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x045c, code lost:
    
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x045d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0460, code lost:
    
        r2 = r10;
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0469, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0467, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0471, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0472, code lost:
    
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0363, code lost:
    
        r15 = "sizeExceeded";
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0373, code lost:
    
        if (r1.length() == 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0375, code lost:
    
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0387, code lost:
    
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x038a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x038b, code lost:
    
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0393, code lost:
    
        r10 = r4;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x037b, code lost:
    
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x038e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0391, code lost:
    
        r1 = r10;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0479, code lost:
    
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0481, code lost:
    
        r27.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0488, code lost:
    
        if (com.google.android.gms.internal.ads.zzawz.isLoggable(3) == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x048a, code lost:
    
        r1 = com.google.android.gms.internal.ads.zzbge.e.format(r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.ads.zzawz.zzdp(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04c0, code lost:
    
        r1 = false;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x04cd, code lost:
    
        r12.setReadable(r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x04d4, code lost:
    
        if (r0.isFile() == false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04d6, code lost:
    
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x04de, code lost:
    
        r0.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x04cb, code lost:
    
        r1 = false;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x04f7, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x04f8, code lost:
    
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x04ff, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0500, code lost:
    
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x050a, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0506, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0507, code lost:
    
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0529: MOVE (r15 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:285:0x0529 */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x056c  */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.net.URLConnection] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzbft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzex(java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 1483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbge.zzex(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void abort() {
        this.g = true;
    }

    private final File a(File file) {
        return new File(this.f, String.valueOf(file.getName()).concat(".done"));
    }
}
