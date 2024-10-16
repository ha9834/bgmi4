package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.games.Notifications;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class akd {
    public static zzix a(zzir zzirVar, zzis zzisVar) {
        boolean z;
        boolean z2;
        long zzge;
        int i;
        int i2;
        int i3;
        String str;
        boolean z3;
        zzir zzw = zzirVar.zzw(akc.zzakr);
        zzkm zzkmVar = zzw.zzv(akc.zzala).zzamc;
        zzkmVar.setPosition(16);
        int readInt = zzkmVar.readInt();
        if (readInt != 1936684398 && readInt != 1986618469 && readInt != 1952807028 && readInt != 1953325924) {
            return null;
        }
        zzkm zzkmVar2 = zzirVar.zzv(akc.zzaky).zzamc;
        zzkmVar2.setPosition(8);
        int zzt = akc.zzt(zzkmVar2.readInt());
        zzkmVar2.zzac(zzt == 0 ? 8 : 16);
        int readInt2 = zzkmVar2.readInt();
        zzkmVar2.zzac(4);
        int position = zzkmVar2.getPosition();
        int i4 = zzt == 0 ? 4 : 8;
        int i5 = 0;
        while (true) {
            z = true;
            if (i5 >= i4) {
                z2 = true;
                break;
            }
            if (zzkmVar2.data[position + i5] != -1) {
                z2 = false;
                break;
            }
            i5++;
        }
        if (z2) {
            zzkmVar2.zzac(i4);
            zzge = -1;
        } else {
            zzge = zzt == 0 ? zzkmVar2.zzge() : zzkmVar2.zzgh();
        }
        Pair create = Pair.create(Integer.valueOf(readInt2), Long.valueOf(zzge));
        int intValue = ((Integer) create.first).intValue();
        long longValue = ((Long) create.second).longValue();
        zzkm zzkmVar3 = zzisVar.zzamc;
        zzkmVar3.setPosition(8);
        zzkmVar3.zzac(akc.zzt(zzkmVar3.readInt()) == 0 ? 8 : 16);
        long zza = longValue == -1 ? -1L : zzkq.zza(longValue, 1000000L, zzkmVar3.zzge());
        zzir zzw2 = zzw.zzw(akc.zzaks).zzw(akc.zzakt);
        zzkm zzkmVar4 = zzw.zzv(akc.zzakz).zzamc;
        zzkmVar4.setPosition(8);
        zzkmVar4.zzac(akc.zzt(zzkmVar4.readInt()) != 0 ? 16 : 8);
        long zzge2 = zzkmVar4.zzge();
        zzkm zzkmVar5 = zzw2.zzv(akc.zzalb).zzamc;
        zzkmVar5.setPosition(12);
        int readInt3 = zzkmVar5.readInt();
        ake akeVar = new ake(readInt3);
        int i6 = 0;
        while (i6 < readInt3) {
            int position2 = zzkmVar5.getPosition();
            int readInt4 = zzkmVar5.readInt();
            zzkh.checkArgument(readInt4 > 0, "childAtomSize should be positive");
            int readInt5 = zzkmVar5.readInt();
            if (readInt5 == akc.zzaka || readInt5 == akc.zzakb || readInt5 == akc.zzalh) {
                i = readInt3;
                i2 = readInt;
                i3 = readInt4;
                zzkmVar5.setPosition(position2 + 8);
                zzkmVar5.zzac(24);
                int readUnsignedShort = zzkmVar5.readUnsignedShort();
                int readUnsignedShort2 = zzkmVar5.readUnsignedShort();
                zzkmVar5.zzac(50);
                int position3 = zzkmVar5.getPosition();
                float f = 1.0f;
                List list = null;
                while (position3 - position2 < i3) {
                    zzkmVar5.setPosition(position3);
                    int position4 = zzkmVar5.getPosition();
                    int readInt6 = zzkmVar5.readInt();
                    if (readInt6 == 0 && zzkmVar5.getPosition() - position2 == i3) {
                        break;
                    }
                    zzkh.checkArgument(readInt6 > 0, "childAtomSize should be positive");
                    int readInt7 = zzkmVar5.readInt();
                    if (readInt7 == akc.zzaku) {
                        zzkmVar5.setPosition(position4 + 8 + 4);
                        int readUnsignedByte = (zzkmVar5.readUnsignedByte() & 3) + 1;
                        if (readUnsignedByte == 3) {
                            throw new IllegalStateException();
                        }
                        ArrayList arrayList = new ArrayList();
                        int readUnsignedByte2 = zzkmVar5.readUnsignedByte() & 31;
                        for (int i7 = 0; i7 < readUnsignedByte2; i7++) {
                            arrayList.add(zzkj.zzc(zzkmVar5));
                        }
                        int readUnsignedByte3 = zzkmVar5.readUnsignedByte();
                        for (int i8 = 0; i8 < readUnsignedByte3; i8++) {
                            arrayList.add(zzkj.zzc(zzkmVar5));
                        }
                        Pair create2 = Pair.create(arrayList, Integer.valueOf(readUnsignedByte));
                        List list2 = (List) create2.first;
                        akeVar.c = ((Integer) create2.second).intValue();
                        list = list2;
                    } else if (readInt7 == akc.zzald) {
                        akeVar.f1929a[i6] = a(zzkmVar5, position4, readInt6);
                    } else if (readInt7 == akc.zzaln) {
                        zzkmVar5.setPosition(position4 + 8);
                        f = zzkmVar5.zzgg() / zzkmVar5.zzgg();
                    }
                    position3 += readInt6;
                }
                akeVar.b = zzhj.zza("video/avc", -1, zza, readUnsignedShort, readUnsignedShort2, f, list);
            } else if (readInt5 == akc.zzake || readInt5 == akc.zzali || readInt5 == akc.zzakf) {
                i3 = readInt4;
                zzkmVar5.setPosition(position2 + 8);
                zzkmVar5.zzac(16);
                int readUnsignedShort3 = zzkmVar5.readUnsignedShort();
                int readUnsignedShort4 = zzkmVar5.readUnsignedShort();
                zzkmVar5.zzac(4);
                int zzgf = zzkmVar5.zzgf();
                int position5 = zzkmVar5.getPosition();
                int i9 = readUnsignedShort3;
                int i10 = zzgf;
                byte[] bArr = null;
                while (true) {
                    if (position5 - position2 < i3) {
                        zzkmVar5.setPosition(position5);
                        int position6 = zzkmVar5.getPosition();
                        int readInt8 = zzkmVar5.readInt();
                        if (readInt8 > 0) {
                            i = readInt3;
                            i2 = readInt;
                            z3 = true;
                        } else {
                            i = readInt3;
                            i2 = readInt;
                            z3 = false;
                        }
                        zzkh.checkArgument(z3, "childAtomSize should be positive");
                        int readInt9 = zzkmVar5.readInt();
                        if (readInt5 == akc.zzake || readInt5 == akc.zzali) {
                            if (readInt9 == akc.zzakc) {
                                byte[] a2 = a(zzkmVar5, position6);
                                Pair<Integer, Integer> zzd = zzki.zzd(a2);
                                i10 = ((Integer) zzd.first).intValue();
                                i9 = ((Integer) zzd.second).intValue();
                                bArr = a2;
                            } else if (readInt9 == akc.zzald) {
                                akeVar.f1929a[i6] = a(zzkmVar5, position6, readInt8);
                            }
                        } else {
                            if (readInt5 == akc.zzakf && readInt9 == akc.zzakg) {
                                zzkmVar5.setPosition(position6 + 8);
                                akeVar.b = zzkg.zza(zzkmVar5);
                                break;
                            }
                            if (readInt5 == akc.zzakh && readInt9 == akc.zzaki) {
                                zzkmVar5.setPosition(position6 + 8);
                                akeVar.b = zzkg.zzb(zzkmVar5);
                                break;
                            }
                        }
                        position5 += readInt8;
                        readInt3 = i;
                        readInt = i2;
                    } else {
                        i = readInt3;
                        i2 = readInt;
                        if (readInt5 == akc.zzakf) {
                            str = "audio/ac3";
                        } else {
                            str = readInt5 == akc.zzakh ? "audio/eac3" : "audio/mp4a-latm";
                        }
                        akeVar.b = zzhj.zzb(str, readUnsignedShort4, zza, i9, i10, bArr == null ? null : Collections.singletonList(bArr));
                    }
                }
            } else if (readInt5 == akc.zzalo) {
                akeVar.b = zzhj.zzem();
                i = readInt3;
                i2 = readInt;
                i3 = readInt4;
            } else if (readInt5 == akc.zzalr) {
                zzkmVar5.setPosition(position2 + 8);
                zzkmVar5.zzac(24);
                int readUnsignedShort5 = zzkmVar5.readUnsignedShort();
                int readUnsignedShort6 = zzkmVar5.readUnsignedShort();
                zzkmVar5.zzac(50);
                ArrayList arrayList2 = new ArrayList(z ? 1 : 0);
                int position7 = zzkmVar5.getPosition();
                while (position7 - position2 < readInt4) {
                    zzkmVar5.setPosition(position7);
                    int position8 = zzkmVar5.getPosition();
                    int readInt10 = zzkmVar5.readInt();
                    if (readInt10 <= 0) {
                        z = false;
                    }
                    zzkh.checkArgument(z, "childAtomSize should be positive");
                    if (zzkmVar5.readInt() == akc.zzakc) {
                        arrayList2.add(a(zzkmVar5, position8));
                    }
                    position7 += readInt10;
                    z = true;
                }
                i3 = readInt4;
                akeVar.b = zzhj.zza("video/mp4v-es", -1, zza, readUnsignedShort5, readUnsignedShort6, arrayList2);
                i = readInt3;
                i2 = readInt;
            } else {
                i3 = readInt4;
                i = readInt3;
                i2 = readInt;
            }
            zzkmVar5.setPosition(position2 + i3);
            i6++;
            readInt3 = i;
            readInt = i2;
            z = true;
        }
        return new zzix(intValue, readInt, zzge2, zza, akeVar.b, akeVar.f1929a, akeVar.c);
    }

    private static zziy a(zzkm zzkmVar, int i, int i2) {
        zziy zziyVar;
        int i3 = i + 8;
        zziy zziyVar2 = null;
        while (i3 - i < i2) {
            zzkmVar.setPosition(i3);
            int readInt = zzkmVar.readInt();
            int readInt2 = zzkmVar.readInt();
            if (readInt2 == akc.zzalj) {
                zzkmVar.readInt();
            } else if (readInt2 == akc.zzale) {
                zzkmVar.zzac(4);
                zzkmVar.readInt();
                zzkmVar.readInt();
            } else if (readInt2 == akc.zzalf) {
                int i4 = i3 + 8;
                while (true) {
                    if (i4 - i3 >= readInt) {
                        zziyVar = null;
                        break;
                    }
                    zzkmVar.setPosition(i4);
                    int readInt3 = zzkmVar.readInt();
                    if (zzkmVar.readInt() == akc.zzalg) {
                        zzkmVar.zzac(4);
                        int readInt4 = zzkmVar.readInt();
                        boolean z = (readInt4 >> 8) == 1;
                        byte[] bArr = new byte[16];
                        zzkmVar.zzb(bArr, 0, 16);
                        zziyVar = new zziy(z, readInt4 & 255, bArr);
                    } else {
                        i4 += readInt3;
                    }
                }
                zziyVar2 = zziyVar;
            }
            i3 += readInt;
        }
        return zziyVar2;
    }

    private static byte[] a(zzkm zzkmVar, int i) {
        zzkmVar.setPosition(i + 8 + 4);
        zzkmVar.zzac(1);
        int readUnsignedByte = zzkmVar.readUnsignedByte();
        while (readUnsignedByte > 127) {
            readUnsignedByte = zzkmVar.readUnsignedByte();
        }
        zzkmVar.zzac(2);
        int readUnsignedByte2 = zzkmVar.readUnsignedByte();
        if ((readUnsignedByte2 & 128) != 0) {
            zzkmVar.zzac(2);
        }
        if ((readUnsignedByte2 & 64) != 0) {
            zzkmVar.zzac(zzkmVar.readUnsignedShort());
        }
        if ((readUnsignedByte2 & 32) != 0) {
            zzkmVar.zzac(2);
        }
        zzkmVar.zzac(1);
        int readUnsignedByte3 = zzkmVar.readUnsignedByte();
        while (readUnsignedByte3 > 127) {
            readUnsignedByte3 = zzkmVar.readUnsignedByte();
        }
        zzkmVar.zzac(13);
        zzkmVar.zzac(1);
        int readUnsignedByte4 = zzkmVar.readUnsignedByte();
        int i2 = readUnsignedByte4 & Notifications.NOTIFICATION_TYPES_ALL;
        while (readUnsignedByte4 > 127) {
            readUnsignedByte4 = zzkmVar.readUnsignedByte();
            i2 = (i2 << 8) | (readUnsignedByte4 & Notifications.NOTIFICATION_TYPES_ALL);
        }
        byte[] bArr = new byte[i2];
        zzkmVar.zzb(bArr, 0, i2);
        return bArr;
    }
}
