package com.tencent.hawk.bridge;

import java.util.Locale;

/* loaded from: classes2.dex */
public class ActionCtrl {
    private boolean checkIpPattern(String str) {
        return true;
    }

    public static boolean isVersionBlkTp(String str, int i) {
        String[] split;
        if (str == null || str.length() == 0 || (split = str.split(",")) == null || split.length == 0) {
            return false;
        }
        String valueOf = String.valueOf(i);
        for (String str2 : split) {
            if (valueOf.equals(str2.trim())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isApmVersionBlk(String str, int i) {
        return isVersionBlkTp(str, i);
    }

    public static boolean isGameVersionBlk(String str, int i) {
        return isVersionBlkTp(str, i);
    }

    public static boolean isOSVersionBlk(String str, int i) {
        return isVersionBlkTp(str, i);
    }

    public static boolean isManuBlk(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        if (str.indexOf(44) == -1) {
            return (str.indexOf(42) != -1 && WildMatch.isMatch(str2, str)) || str.equals(str2);
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return false;
        }
        for (String str3 : split) {
            String trim = str3.trim();
            if ((trim.indexOf(42) != -1 && WildMatch.isMatch(str2, trim)) || trim.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGrayManu(String str, String str2) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.indexOf(44) == -1) {
            return (str.indexOf(42) != -1 && WildMatch.isMatch(str2, str)) || str.equals(str2);
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return false;
        }
        for (String str3 : split) {
            String trim = str3.trim();
            if ((trim.indexOf(42) != -1 && WildMatch.isMatch(str2, trim)) || trim.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isModelBlk(String str, String str2) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.indexOf(44) == -1) {
            return (str.indexOf(42) != -1 && WildMatch.isMatch(str2, str)) || str.equals(str2);
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return false;
        }
        for (String str3 : split) {
            String trim = str3.trim();
            if ((trim.indexOf(42) != -1 && WildMatch.isMatch(str2, trim)) || trim.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGrayModel(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null) {
            return false;
        }
        if (str.indexOf(44) == -1) {
            return (str.indexOf(42) != -1 && WildMatch.isMatch(str2, str)) || str.equals(str2);
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return false;
        }
        for (String str3 : split) {
            String trim = str3.trim();
            if ((trim.indexOf(42) != -1 && WildMatch.isMatch(str2, trim)) || trim.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArchBlk(String str, String str2) {
        return str2 == null || str == null || str.toLowerCase(Locale.getDefault()).contains(str2.toLowerCase());
    }

    public static long hton(String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length != 4) {
            return -1L;
        }
        try {
            return ((Integer.parseInt(split[0].trim()) & 255) << 24) | ((Integer.parseInt(split[1].trim()) & 255) << 16) | ((Integer.parseInt(split[2].trim()) & 255) << 8) | (Integer.parseInt(split[3].trim()) & 255);
        } catch (Exception unused) {
            HawkLogger.e("parse error");
            return -1L;
        }
    }

    private static Pair<Long, Long> htonRangeWild(String str) {
        long j;
        long parseLong;
        long parseLong2;
        long parseLong3;
        long j2 = 0;
        if (str == null || str.length() == 0) {
            return new Pair<>(0L, 0L);
        }
        String[] split = str.split("\\.");
        if (split == null || split.length != 4) {
            return new Pair<>(-1L, -1L);
        }
        if (str.indexOf(42) == -1) {
            return new Pair<>(-1L, -1L);
        }
        String trim = split[0].trim();
        String trim2 = split[1].trim();
        String trim3 = split[2].trim();
        String trim4 = split[3].trim();
        if (trim.indexOf(42) != -1) {
            j = 4278190080L;
        } else {
            j2 = (Long.parseLong(trim) & 255) << 24;
            j = j2;
        }
        if (trim2.indexOf(42) != -1) {
            parseLong = j | 16711680;
        } else {
            j2 |= (Long.parseLong(trim2) & 255) << 16;
            parseLong = j | ((Long.parseLong(trim2) & 255) << 16);
        }
        if (trim3.indexOf(42) != -1) {
            parseLong2 = 65280 | parseLong;
        } else {
            j2 |= (Long.parseLong(trim3) & 255) << 8;
            parseLong2 = ((Long.parseLong(trim3) & 255) << 8) | parseLong;
        }
        if (trim4.indexOf(42) != -1) {
            parseLong3 = parseLong2 | 255;
        } else {
            j2 |= Long.parseLong(trim4) & 255;
            parseLong3 = parseLong2 | (Long.parseLong(trim4) & 255);
        }
        return new Pair<>(Long.valueOf(j2), Long.valueOf(parseLong3));
    }

    public static boolean isGrayIp(String str, long j) {
        String[] split;
        if (str == null || str.length() == 0 || (split = str.split(",")) == null) {
            return false;
        }
        for (String str2 : split) {
            if (str2.indexOf(91) == -1 || str2.indexOf(93) == -1) {
                return false;
            }
            String trim = str2.substring(str2.indexOf(91) + 1, str2.lastIndexOf(93)).trim();
            int indexOf = trim.indexOf(46);
            int lastIndexOf = trim.lastIndexOf(46);
            int indexOf2 = trim.indexOf(45);
            int indexOf3 = trim.indexOf(42);
            if (indexOf3 == -1 && (indexOf == -1 || lastIndexOf == -1 || indexOf2 == -1)) {
                return false;
            }
            if (indexOf3 != -1 && indexOf2 != -1) {
                return false;
            }
            long j2 = Long.MIN_VALUE;
            long j3 = Long.MAX_VALUE;
            if (indexOf3 != -1) {
                Pair<Long, Long> htonRangeWild = htonRangeWild(trim);
                if (htonRangeWild.getLeft().longValue() == -1 || htonRangeWild.getRight().longValue() == -1) {
                    return false;
                }
                j2 = htonRangeWild.getLeft().longValue();
                j3 = htonRangeWild.getRight().longValue();
            } else {
                if (trim.indexOf(45) == -1) {
                    return false;
                }
                if (indexOf2 > indexOf && indexOf2 > lastIndexOf) {
                    j2 = hton(trim.substring(0, trim.indexOf(45)).trim());
                } else if (indexOf2 > indexOf && indexOf2 < lastIndexOf) {
                    String[] split2 = trim.split("-");
                    if (split2 == null || split2.length != 2) {
                        return false;
                    }
                    j2 = hton(split2[0]);
                    j3 = hton(split2[1]);
                } else if (indexOf2 < indexOf) {
                    j3 = hton(trim.substring(trim.indexOf(45) + 1).trim());
                }
            }
            if (j2 == -1 || j3 == -1) {
                return false;
            }
            if (j >= j2 && j <= j3) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGrayMac(String str, long j) {
        String[] split;
        String[] split2;
        if (str == null || (split = str.split(",")) == null) {
            return true;
        }
        for (String str2 : split) {
            int indexOf = str2.indexOf(35);
            int indexOf2 = str2.indexOf(45);
            if (indexOf == -1 || indexOf2 == -1 || (split2 = str2.split("#")) == null || split2.length != 2) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(split2[0]);
                if (parseInt < 1 || parseInt > 6) {
                    return false;
                }
                long j2 = (j >> ((6 - parseInt) * 8)) & 255;
                String trim = split2[1].trim();
                if (trim.indexOf(45) == 0) {
                    if (j2 > Long.parseLong(trim.substring(1).trim())) {
                        return false;
                    }
                } else if (trim.indexOf(45) != trim.length() - 1) {
                    String[] split3 = trim.split("-");
                    long parseLong = Long.parseLong(split3[0].trim());
                    long parseLong2 = Long.parseLong(split3[1].trim());
                    if (parseLong > j2 || parseLong2 < j2) {
                        return false;
                    }
                } else if (j2 < Long.parseLong(trim.substring(0, trim.length() - 2).trim())) {
                    return false;
                }
            } catch (Exception unused) {
                HawkLogger.e(str + "parse error");
                return false;
            }
        }
        return true;
    }
}
