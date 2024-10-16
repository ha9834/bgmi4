package com.helpshift.support.external;

import com.huawei.devices.a.a;
import java.util.Locale;

/* loaded from: classes2.dex */
public class DoubleMetaphone {
    private static final String VOWELS = "AEIOUY";
    int maxCodeLen = 4;
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", "T", "K", "S", "N", "M", "B", a.n};

    protected static boolean contains(String str, int i, int i2, String[] strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String str2 : strArr) {
            if (substring.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public String doubleMetaphone(String str, boolean z) {
        int i;
        boolean z2;
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        boolean z3;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        char c16;
        char c17;
        char c18;
        boolean z4;
        boolean z5;
        char c19;
        char c20;
        char c21;
        char c22;
        char c23;
        char c24;
        char c25;
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        String upperCase = trim.toUpperCase(Locale.ENGLISH);
        boolean z6 = upperCase.indexOf(87) > -1 || upperCase.indexOf(75) > -1 || upperCase.indexOf("CZ") > -1 || upperCase.indexOf("WITZ") > -1;
        String[] strArr = SILENT_START;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i = 0;
                break;
            }
            if (upperCase.startsWith(strArr[i2])) {
                i = 1;
                break;
            }
            i2++;
        }
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(this.maxCodeLen);
        while (true) {
            if ((doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength || doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) && i <= upperCase.length() - 1) {
                char charAt = upperCase.charAt(i);
                if (charAt == 199) {
                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                        doubleMetaphoneResult.primary.append('S');
                    }
                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                        doubleMetaphoneResult.alternate.append('S');
                    }
                    i++;
                } else if (charAt != 209) {
                    switch (charAt) {
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                        case 'Y':
                            if (i == 0) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('A');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('A');
                                }
                            }
                            i++;
                            break;
                        case 'B':
                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.primary.append('P');
                            }
                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.alternate.append('P');
                            }
                            int i3 = i + 1;
                            i = charAt(upperCase, i3) == 'B' ? i + 2 : i3;
                            break;
                        case 'C':
                            if (contains(upperCase, i, 4, new String[]{"CHIA"})) {
                                z2 = true;
                            } else if (i <= 1) {
                                z2 = false;
                            } else {
                                int i4 = i - 2;
                                if (VOWELS.indexOf(charAt(upperCase, i4)) != -1) {
                                    z2 = false;
                                } else if (contains(upperCase, i - 1, 3, new String[]{"ACH"})) {
                                    char charAt2 = charAt(upperCase, i + 2);
                                    z2 = !(charAt2 == 'I' || charAt2 == 'E') || contains(upperCase, i4, 6, new String[]{"BACHER", "MACHER"});
                                } else {
                                    z2 = false;
                                }
                            }
                            if (z2) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    c10 = 'K';
                                    doubleMetaphoneResult.primary.append('K');
                                } else {
                                    c10 = 'K';
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append(c10);
                                }
                                i += 2;
                            } else if (i == 0 && contains(upperCase, i, 6, new String[]{"CAESAR"})) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('S');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('S');
                                }
                                i += 2;
                            } else if (contains(upperCase, i, 2, new String[]{"CH"})) {
                                if (i != 0) {
                                    z3 = false;
                                } else {
                                    int i5 = i + 1;
                                    z3 = (contains(upperCase, i5, 5, new String[]{"HARAC", "HARIS"}) || contains(upperCase, i5, 3, new String[]{"HOR", "HYM", "HIA", "HEM"})) ? !contains(upperCase, 0, 5, new String[]{"CHORE"}) : false;
                                }
                                if (i > 0 && contains(upperCase, i, 4, new String[]{"CHAE"})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('K');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('X');
                                    }
                                    i += 2;
                                } else if (z3) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c9 = 'K';
                                        doubleMetaphoneResult.primary.append('K');
                                    } else {
                                        c9 = 'K';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c9);
                                    }
                                    i += 2;
                                } else {
                                    if (!contains(upperCase, 0, 4, new String[]{"VAN ", "VON "}) && !contains(upperCase, 0, 3, new String[]{"SCH"}) && !contains(upperCase, i - 2, 6, new String[]{"ORCHES", "ARCHIT", "ORCHID"})) {
                                        int i6 = i + 2;
                                        if (!contains(upperCase, i6, 1, new String[]{"T", "S"}) && ((!contains(upperCase, i - 1, 1, new String[]{"A", "O", "U", "E"}) && i != 0) || (!contains(upperCase, i6, 1, L_R_N_M_B_H_F_V_W_SPACE) && i + 1 != upperCase.length() - 1))) {
                                            if (i <= 0) {
                                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                    c7 = 'X';
                                                    doubleMetaphoneResult.primary.append('X');
                                                } else {
                                                    c7 = 'X';
                                                }
                                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.alternate.append(c7);
                                                }
                                            } else if (contains(upperCase, 0, 2, new String[]{"MC"})) {
                                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                    c8 = 'K';
                                                    doubleMetaphoneResult.primary.append('K');
                                                } else {
                                                    c8 = 'K';
                                                }
                                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.alternate.append(c8);
                                                }
                                            } else {
                                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.primary.append('X');
                                                }
                                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.alternate.append('K');
                                                }
                                            }
                                            i = i6;
                                        }
                                    }
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c6 = 'K';
                                        doubleMetaphoneResult.primary.append('K');
                                    } else {
                                        c6 = 'K';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c6);
                                    }
                                    i += 2;
                                }
                            } else if (!contains(upperCase, i, 2, new String[]{"CZ"}) || contains(upperCase, i - 2, 4, new String[]{"WICZ"})) {
                                int i7 = i + 1;
                                if (contains(upperCase, i7, 3, new String[]{"CIA"})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c5 = 'X';
                                        doubleMetaphoneResult.primary.append('X');
                                    } else {
                                        c5 = 'X';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c5);
                                    }
                                    i += 3;
                                } else if (contains(upperCase, i, 2, new String[]{"CC"}) && (i != 1 || charAt(upperCase, 0) != 'M')) {
                                    int i8 = i + 2;
                                    if (contains(upperCase, i8, 1, new String[]{"I", "E", "H"}) && !contains(upperCase, i8, 2, new String[]{"HU"})) {
                                        if ((i == 1 && charAt(upperCase, i - 1) == 'A') || contains(upperCase, i - 1, 5, new String[]{"UCCEE", "UCCES"})) {
                                            int length2 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                            if (2 <= length2) {
                                                doubleMetaphoneResult.primary.append("KS");
                                            } else {
                                                doubleMetaphoneResult.primary.append("KS".substring(0, length2));
                                            }
                                            int length3 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                            if (2 <= length3) {
                                                doubleMetaphoneResult.alternate.append("KS");
                                            } else {
                                                doubleMetaphoneResult.alternate.append("KS".substring(0, length3));
                                            }
                                        } else {
                                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                c4 = 'X';
                                                doubleMetaphoneResult.primary.append('X');
                                            } else {
                                                c4 = 'X';
                                            }
                                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.alternate.append(c4);
                                            }
                                        }
                                        i8 = i + 3;
                                    } else {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            c3 = 'K';
                                            doubleMetaphoneResult.primary.append('K');
                                        } else {
                                            c3 = 'K';
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append(c3);
                                        }
                                    }
                                    i = i8;
                                } else if (contains(upperCase, i, 2, new String[]{"CK", "CG", "CQ"})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c2 = 'K';
                                        doubleMetaphoneResult.primary.append('K');
                                    } else {
                                        c2 = 'K';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c2);
                                    }
                                    i += 2;
                                } else if (contains(upperCase, i, 2, new String[]{"CI", "CE", "CY"})) {
                                    if (contains(upperCase, i, 3, new String[]{"CIO", "CIE", "CIA"})) {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.primary.append('S');
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append('X');
                                        }
                                    } else {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.primary.append('S');
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append('S');
                                        }
                                    }
                                    i += 2;
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c = 'K';
                                        doubleMetaphoneResult.primary.append('K');
                                    } else {
                                        c = 'K';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c);
                                    }
                                    if (contains(upperCase, i7, 2, new String[]{" C", " Q", " G"})) {
                                        i7 = i + 3;
                                    } else if (contains(upperCase, i7, 1, new String[]{"C", "K", "Q"}) && !contains(upperCase, i7, 2, new String[]{"CE", "CI"})) {
                                        i7 = i + 2;
                                    }
                                    i = i7;
                                }
                            } else {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('S');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('X');
                                }
                                i += 2;
                            }
                            break;
                        case 'D':
                            if (contains(upperCase, i, 2, new String[]{"DG"})) {
                                int i9 = i + 2;
                                if (contains(upperCase, i9, 1, new String[]{"I", "E", "Y"})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('J');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('J');
                                    }
                                    i += 3;
                                } else {
                                    int length4 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                    if (2 <= length4) {
                                        doubleMetaphoneResult.primary.append("TK");
                                    } else {
                                        doubleMetaphoneResult.primary.append("TK".substring(0, length4));
                                    }
                                    int length5 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                    if (2 <= length5) {
                                        doubleMetaphoneResult.alternate.append("TK");
                                    } else {
                                        doubleMetaphoneResult.alternate.append("TK".substring(0, length5));
                                    }
                                    i = i9;
                                }
                            } else if (contains(upperCase, i, 2, new String[]{"DT", "DD"})) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('T');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('T');
                                }
                                i += 2;
                            } else {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('T');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('T');
                                }
                                i++;
                            }
                            break;
                        case 'F':
                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                c11 = 'F';
                                doubleMetaphoneResult.primary.append('F');
                            } else {
                                c11 = 'F';
                            }
                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.alternate.append(c11);
                            }
                            int i10 = i + 1;
                            i = charAt(upperCase, i10) == c11 ? i + 2 : i10;
                            break;
                        case 'G':
                            int i11 = i + 1;
                            if (charAt(upperCase, i11) == 'H') {
                                if (i > 0 && VOWELS.indexOf(charAt(upperCase, i - 1)) == -1) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c17 = 'K';
                                        doubleMetaphoneResult.primary.append('K');
                                    } else {
                                        c17 = 'K';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c17);
                                    }
                                    i += 2;
                                } else if (i == 0) {
                                    i += 2;
                                    if (charAt(upperCase, i) == 'I') {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.primary.append('J');
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append('J');
                                        }
                                    } else {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            c16 = 'K';
                                            doubleMetaphoneResult.primary.append('K');
                                        } else {
                                            c16 = 'K';
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append(c16);
                                        }
                                    }
                                } else if ((i <= 1 || !contains(upperCase, i - 2, 1, new String[]{"B", "H", "D"})) && ((i <= 2 || !contains(upperCase, i - 3, 1, new String[]{"B", "H", "D"})) && (i <= 3 || !contains(upperCase, i - 4, 1, new String[]{"B", "H"})))) {
                                    if (i > 2 && charAt(upperCase, i - 1) == 'U' && contains(upperCase, i - 3, 1, new String[]{"C", "G", "L", "R", "T"})) {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            c15 = 'F';
                                            doubleMetaphoneResult.primary.append('F');
                                        } else {
                                            c15 = 'F';
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append(c15);
                                        }
                                    } else if (i > 0 && charAt(upperCase, i - 1) != 'I') {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            c14 = 'K';
                                            doubleMetaphoneResult.primary.append('K');
                                        } else {
                                            c14 = 'K';
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append(c14);
                                        }
                                    }
                                    i += 2;
                                } else {
                                    i += 2;
                                }
                            } else if (charAt(upperCase, i11) == 'N') {
                                if (i == 1 && VOWELS.indexOf(charAt(upperCase, 0)) != -1 && !z6) {
                                    int length6 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                    if (2 <= length6) {
                                        doubleMetaphoneResult.primary.append("KN");
                                    } else {
                                        doubleMetaphoneResult.primary.append("KN".substring(0, length6));
                                    }
                                    int length7 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                    if (1 <= length7) {
                                        doubleMetaphoneResult.alternate.append("N");
                                    } else {
                                        doubleMetaphoneResult.alternate.append("N".substring(0, length7));
                                    }
                                } else if (!contains(upperCase, i + 2, 2, new String[]{"EY"}) && charAt(upperCase, i11) != 'Y' && !z6) {
                                    int length8 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                    if (1 <= length8) {
                                        doubleMetaphoneResult.primary.append("N");
                                    } else {
                                        doubleMetaphoneResult.primary.append("N".substring(0, length8));
                                    }
                                    int length9 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                    if (2 <= length9) {
                                        doubleMetaphoneResult.alternate.append("KN");
                                    } else {
                                        doubleMetaphoneResult.alternate.append("KN".substring(0, length9));
                                    }
                                } else {
                                    int length10 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                    if (2 <= length10) {
                                        doubleMetaphoneResult.primary.append("KN");
                                    } else {
                                        doubleMetaphoneResult.primary.append("KN".substring(0, length10));
                                    }
                                    int length11 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                    if (2 <= length11) {
                                        doubleMetaphoneResult.alternate.append("KN");
                                    } else {
                                        doubleMetaphoneResult.alternate.append("KN".substring(0, length11));
                                    }
                                }
                                i += 2;
                            } else if (contains(upperCase, i11, 2, new String[]{"LI"}) && !z6) {
                                int length12 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                if (2 <= length12) {
                                    doubleMetaphoneResult.primary.append("KL");
                                } else {
                                    doubleMetaphoneResult.primary.append("KL".substring(0, length12));
                                }
                                int length13 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                if (1 <= length13) {
                                    doubleMetaphoneResult.alternate.append("L");
                                } else {
                                    doubleMetaphoneResult.alternate.append("L".substring(0, length13));
                                }
                                i += 2;
                            } else if (i == 0 && (charAt(upperCase, i11) == 'Y' || contains(upperCase, i11, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('K');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('J');
                                }
                                i += 2;
                            } else {
                                if ((contains(upperCase, i11, 2, new String[]{"ER"}) || charAt(upperCase, i11) == 'Y') && !contains(upperCase, 0, 6, new String[]{"DANGER", "RANGER", "MANGER"})) {
                                    int i12 = i - 1;
                                    if (!contains(upperCase, i12, 1, new String[]{"E", "I"}) && !contains(upperCase, i12, 3, new String[]{"RGY", "OGY"})) {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.primary.append('K');
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append('J');
                                        }
                                        i += 2;
                                    }
                                }
                                if (contains(upperCase, i11, 1, new String[]{"E", "I", "Y"}) || contains(upperCase, i - 1, 4, new String[]{"AGGI", "OGGI"})) {
                                    if (contains(upperCase, 0, 4, new String[]{"VAN ", "VON "})) {
                                        c12 = 'K';
                                    } else if (contains(upperCase, 0, 3, new String[]{"SCH"})) {
                                        c12 = 'K';
                                    } else if (contains(upperCase, i11, 2, new String[]{"ET"})) {
                                        c12 = 'K';
                                    } else {
                                        if (contains(upperCase, i11, 3, new String[]{"IER"})) {
                                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.primary.append('J');
                                            }
                                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.alternate.append('J');
                                            }
                                        } else {
                                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.primary.append('J');
                                            }
                                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.alternate.append('K');
                                            }
                                        }
                                        i += 2;
                                    }
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append(c12);
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c12);
                                    }
                                    i += 2;
                                } else if (charAt(upperCase, i11) == 'G') {
                                    i += 2;
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c13 = 'K';
                                        doubleMetaphoneResult.primary.append('K');
                                    } else {
                                        c13 = 'K';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c13);
                                    }
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('K');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('K');
                                    }
                                    i = i11;
                                }
                            }
                            break;
                        case 'H':
                            if ((i == 0 || VOWELS.indexOf(charAt(upperCase, i - 1)) != -1) && VOWELS.indexOf(charAt(upperCase, i + 1)) != -1) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('H');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('H');
                                }
                                i += 2;
                            } else {
                                i++;
                            }
                            break;
                        case 'J':
                            if (contains(upperCase, i, 4, new String[]{"JOSE"}) || contains(upperCase, 0, 4, new String[]{"SAN "})) {
                                if ((i == 0 && charAt(upperCase, i + 4) == ' ') || upperCase.length() == 4 || contains(upperCase, 0, 4, new String[]{"SAN "})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('H');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('H');
                                    }
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('J');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('H');
                                    }
                                }
                                i++;
                            } else {
                                if (i == 0 && !contains(upperCase, i, 4, new String[]{"JOSE"})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('J');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('A');
                                    }
                                } else {
                                    int i13 = i - 1;
                                    if (VOWELS.indexOf(charAt(upperCase, i13)) != -1 && !z6) {
                                        int i14 = i + 1;
                                        if (charAt(upperCase, i14) == 'A' || charAt(upperCase, i14) == 'O') {
                                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.primary.append('J');
                                            }
                                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.alternate.append('H');
                                            }
                                        }
                                    }
                                    if (i == upperCase.length() - 1) {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.primary.append('J');
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append(' ');
                                        }
                                    } else if (!contains(upperCase, i + 1, 1, L_T_K_S_N_M_B_Z) && !contains(upperCase, i13, 1, new String[]{"S", "K", "L"})) {
                                        if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.primary.append('J');
                                        }
                                        if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                            doubleMetaphoneResult.alternate.append('J');
                                        }
                                    }
                                }
                                int i15 = i + 1;
                                i = charAt(upperCase, i15) == 'J' ? i + 2 : i15;
                            }
                            break;
                        case 'K':
                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                c18 = 'K';
                                doubleMetaphoneResult.primary.append('K');
                            } else {
                                c18 = 'K';
                            }
                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.alternate.append(c18);
                            }
                            int i16 = i + 1;
                            i = charAt(upperCase, i16) == c18 ? i + 2 : i16;
                            break;
                        case 'L':
                            int i17 = i + 1;
                            if (charAt(upperCase, i17) == 'L') {
                                if (i == upperCase.length() - 3 && contains(upperCase, i - 1, 4, new String[]{"ILLO", "ILLA", "ALLE"})) {
                                    z4 = true;
                                } else {
                                    z4 = (contains(upperCase, upperCase.length() - 2, 2, new String[]{"AS", "OS"}) || contains(upperCase, upperCase.length() - 1, 1, new String[]{"A", "O"})) && contains(upperCase, i + (-1), 4, new String[]{"ALLE"});
                                }
                                if (z4) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('L');
                                    }
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('L');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('L');
                                    }
                                }
                                i += 2;
                            } else {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('L');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('L');
                                }
                                i = i17;
                            }
                            break;
                        case 'M':
                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.primary.append('M');
                            }
                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.alternate.append('M');
                            }
                            int i18 = i + 1;
                            if (charAt(upperCase, i18) == 'M') {
                                z5 = true;
                            } else {
                                z5 = contains(upperCase, i + (-1), 3, new String[]{"UMB"}) && (i18 == upperCase.length() - 1 || contains(upperCase, i + 2, 2, new String[]{"ER"}));
                            }
                            i = z5 ? i + 2 : i18;
                            break;
                        case 'N':
                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.primary.append('N');
                            }
                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.alternate.append('N');
                            }
                            int i19 = i + 1;
                            i = charAt(upperCase, i19) == 'N' ? i + 2 : i19;
                            break;
                        case 'P':
                            int i20 = i + 1;
                            if (charAt(upperCase, i20) == 'H') {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    c19 = 'F';
                                    doubleMetaphoneResult.primary.append('F');
                                } else {
                                    c19 = 'F';
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append(c19);
                                }
                                i += 2;
                            } else {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('P');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('P');
                                }
                                if (contains(upperCase, i20, 1, new String[]{"P", "B"})) {
                                    i20 = i + 2;
                                }
                                i = i20;
                            }
                            break;
                        case 'Q':
                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                c20 = 'K';
                                doubleMetaphoneResult.primary.append('K');
                            } else {
                                c20 = 'K';
                            }
                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.alternate.append(c20);
                            }
                            int i21 = i + 1;
                            i = charAt(upperCase, i21) == 'Q' ? i + 2 : i21;
                            break;
                        case 'R':
                            if (i == upperCase.length() - 1 && !z6 && contains(upperCase, i - 2, 2, new String[]{"IE"}) && !contains(upperCase, i - 4, 2, new String[]{"ME", "MA"})) {
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('R');
                                }
                            } else {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('R');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('R');
                                }
                            }
                            int i22 = i + 1;
                            i = charAt(upperCase, i22) == 'R' ? i + 2 : i22;
                            break;
                        case 'S':
                            if (contains(upperCase, i - 1, 3, new String[]{"ISL", "YSL"})) {
                                i++;
                            } else if (i == 0 && contains(upperCase, i, 5, new String[]{"SUGAR"})) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('X');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('S');
                                }
                                i++;
                            } else if (contains(upperCase, i, 2, new String[]{"SH"})) {
                                if (contains(upperCase, i + 1, 4, new String[]{"HEIM", "HOEK", "HOLM", "HOLZ"})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('S');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('S');
                                    }
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        c22 = 'X';
                                        doubleMetaphoneResult.primary.append('X');
                                    } else {
                                        c22 = 'X';
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append(c22);
                                    }
                                }
                                i += 2;
                            } else if (contains(upperCase, i, 3, new String[]{"SIO", "SIA"}) || contains(upperCase, i, 4, new String[]{"SIAN"})) {
                                if (z6) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('S');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('S');
                                    }
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('S');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('X');
                                    }
                                }
                                i += 3;
                            } else {
                                if (i != 0 || !contains(upperCase, i + 1, 1, new String[]{"M", "N", "L", "W"})) {
                                    int i23 = i + 1;
                                    if (!contains(upperCase, i23, 1, new String[]{a.n})) {
                                        if (contains(upperCase, i, 2, new String[]{"SC"})) {
                                            int i24 = i + 2;
                                            if (charAt(upperCase, i24) == 'H') {
                                                int i25 = i + 3;
                                                if (contains(upperCase, i25, 2, new String[]{"OO", "ER", "EN", "UY", "ED", "EM"})) {
                                                    if (contains(upperCase, i25, 2, new String[]{"ER", "EN"})) {
                                                        int length14 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                                        if (1 <= length14) {
                                                            doubleMetaphoneResult.primary.append(a.m);
                                                        } else {
                                                            doubleMetaphoneResult.primary.append(a.m.substring(0, length14));
                                                        }
                                                        int length15 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                                        if (2 <= length15) {
                                                            doubleMetaphoneResult.alternate.append("SK");
                                                        } else {
                                                            doubleMetaphoneResult.alternate.append("SK".substring(0, length15));
                                                        }
                                                    } else {
                                                        int length16 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                                        if (2 <= length16) {
                                                            doubleMetaphoneResult.primary.append("SK");
                                                        } else {
                                                            doubleMetaphoneResult.primary.append("SK".substring(0, length16));
                                                        }
                                                        int length17 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                                        if (2 <= length17) {
                                                            doubleMetaphoneResult.alternate.append("SK");
                                                        } else {
                                                            doubleMetaphoneResult.alternate.append("SK".substring(0, length17));
                                                        }
                                                    }
                                                } else if (i == 0 && VOWELS.indexOf(charAt(upperCase, 3)) == -1 && charAt(upperCase, 3) != 'W') {
                                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                        doubleMetaphoneResult.primary.append('X');
                                                    }
                                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                        doubleMetaphoneResult.alternate.append('S');
                                                    }
                                                } else {
                                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                        c21 = 'X';
                                                        doubleMetaphoneResult.primary.append('X');
                                                    } else {
                                                        c21 = 'X';
                                                    }
                                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                        doubleMetaphoneResult.alternate.append(c21);
                                                    }
                                                }
                                            } else if (contains(upperCase, i24, 1, new String[]{"I", "E", "Y"})) {
                                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.primary.append('S');
                                                }
                                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.alternate.append('S');
                                                }
                                            } else {
                                                int length18 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                                if (2 <= length18) {
                                                    doubleMetaphoneResult.primary.append("SK");
                                                } else {
                                                    doubleMetaphoneResult.primary.append("SK".substring(0, length18));
                                                }
                                                int length19 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                                if (2 <= length19) {
                                                    doubleMetaphoneResult.alternate.append("SK");
                                                } else {
                                                    doubleMetaphoneResult.alternate.append("SK".substring(0, length19));
                                                }
                                            }
                                            i += 3;
                                        } else {
                                            if (i == upperCase.length() - 1 && contains(upperCase, i - 2, 2, new String[]{"AI", "OI"})) {
                                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.alternate.append('S');
                                                }
                                            } else {
                                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.primary.append('S');
                                                }
                                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                    doubleMetaphoneResult.alternate.append('S');
                                                }
                                            }
                                            if (contains(upperCase, i23, 1, new String[]{"S", a.n})) {
                                                i23 = i + 2;
                                            }
                                            i = i23;
                                        }
                                    }
                                }
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('S');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('X');
                                }
                                int i26 = i + 1;
                                if (contains(upperCase, i26, 1, new String[]{a.n})) {
                                    i26 = i + 2;
                                }
                                i = i26;
                            }
                            break;
                        case 'T':
                            if (contains(upperCase, i, 4, new String[]{"TION"})) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    c24 = 'X';
                                    doubleMetaphoneResult.primary.append('X');
                                } else {
                                    c24 = 'X';
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append(c24);
                                }
                                i += 3;
                            } else if (contains(upperCase, i, 3, new String[]{"TIA", "TCH"})) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    c23 = 'X';
                                    doubleMetaphoneResult.primary.append('X');
                                } else {
                                    c23 = 'X';
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append(c23);
                                }
                                i += 3;
                            } else if (contains(upperCase, i, 2, new String[]{"TH"}) || contains(upperCase, i, 3, new String[]{"TTH"})) {
                                i += 2;
                                if (contains(upperCase, i, 2, new String[]{"OM", "AM"}) || contains(upperCase, 0, 4, new String[]{"VAN ", "VON "}) || contains(upperCase, 0, 3, new String[]{"SCH"})) {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('T');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('T');
                                    }
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('0');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('T');
                                    }
                                }
                            } else {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('T');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('T');
                                }
                                int i27 = i + 1;
                                if (contains(upperCase, i27, 1, new String[]{"T", "D"})) {
                                    i27 = i + 2;
                                }
                                i = i27;
                            }
                            break;
                        case 'V':
                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                c25 = 'F';
                                doubleMetaphoneResult.primary.append('F');
                            } else {
                                c25 = 'F';
                            }
                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                doubleMetaphoneResult.alternate.append(c25);
                            }
                            int i28 = i + 1;
                            i = charAt(upperCase, i28) == 'V' ? i + 2 : i28;
                            break;
                        case 'W':
                            if (contains(upperCase, i, 2, new String[]{"WR"})) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('R');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('R');
                                }
                                i += 2;
                            } else {
                                if (i == 0) {
                                    int i29 = i + 1;
                                    if (VOWELS.indexOf(charAt(upperCase, i29)) != -1 || contains(upperCase, i, 2, new String[]{"WH"})) {
                                        if (VOWELS.indexOf(charAt(upperCase, i29)) != -1) {
                                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.primary.append('A');
                                            }
                                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.alternate.append('F');
                                            }
                                        } else {
                                            if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.primary.append('A');
                                            }
                                            if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                                doubleMetaphoneResult.alternate.append('A');
                                            }
                                        }
                                        i = i29;
                                    }
                                }
                                if ((i == upperCase.length() - 1 && VOWELS.indexOf(charAt(upperCase, i - 1)) != -1) || contains(upperCase, i - 1, 5, new String[]{"EWSKI", "EWSKY", "OWSKI", "OWSKY"}) || contains(upperCase, 0, 3, new String[]{"SCH"})) {
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('F');
                                    }
                                    i++;
                                } else if (contains(upperCase, i, 4, new String[]{"WICZ", "WITZ"})) {
                                    int length20 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                    if (2 <= length20) {
                                        doubleMetaphoneResult.primary.append("TS");
                                    } else {
                                        doubleMetaphoneResult.primary.append("TS".substring(0, length20));
                                    }
                                    int length21 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                    if (2 <= length21) {
                                        doubleMetaphoneResult.alternate.append("FX");
                                    } else {
                                        doubleMetaphoneResult.alternate.append("FX".substring(0, length21));
                                    }
                                    i += 4;
                                } else {
                                    i++;
                                }
                            }
                            break;
                        case 'X':
                            if (i == 0) {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('S');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('S');
                                }
                                i++;
                            } else {
                                if (i != upperCase.length() - 1 || (!contains(upperCase, i - 3, 3, new String[]{"IAU", "EAU"}) && !contains(upperCase, i - 2, 2, new String[]{"AU", "OU"}))) {
                                    int length22 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                    if (2 <= length22) {
                                        doubleMetaphoneResult.primary.append("KS");
                                    } else {
                                        doubleMetaphoneResult.primary.append("KS".substring(0, length22));
                                    }
                                    int length23 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                    if (2 <= length23) {
                                        doubleMetaphoneResult.alternate.append("KS");
                                    } else {
                                        doubleMetaphoneResult.alternate.append("KS".substring(0, length23));
                                    }
                                }
                                int i30 = i + 1;
                                if (contains(upperCase, i30, 1, new String[]{"C", a.m})) {
                                    i30 = i + 2;
                                }
                                i = i30;
                            }
                            break;
                        case 'Z':
                            int i31 = i + 1;
                            if (charAt(upperCase, i31) == 'H') {
                                if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.primary.append('J');
                                }
                                if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                    doubleMetaphoneResult.alternate.append('J');
                                }
                                i += 2;
                            } else {
                                if (contains(upperCase, i31, 2, new String[]{"ZO", "ZI", "ZA"}) || (z6 && i > 0 && charAt(upperCase, i - 1) != 'T')) {
                                    int length24 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.primary.length();
                                    if (1 <= length24) {
                                        doubleMetaphoneResult.primary.append("S");
                                    } else {
                                        doubleMetaphoneResult.primary.append("S".substring(0, length24));
                                    }
                                    int length25 = doubleMetaphoneResult.maxLength - doubleMetaphoneResult.alternate.length();
                                    if (2 <= length25) {
                                        doubleMetaphoneResult.alternate.append("TS");
                                    } else {
                                        doubleMetaphoneResult.alternate.append("TS".substring(0, length25));
                                    }
                                } else {
                                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.primary.append('S');
                                    }
                                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                                        doubleMetaphoneResult.alternate.append('S');
                                    }
                                }
                                if (charAt(upperCase, i31) == 'Z') {
                                    i31 = i + 2;
                                }
                                i = i31;
                            }
                            break;
                        default:
                            i++;
                            break;
                    }
                } else {
                    if (doubleMetaphoneResult.primary.length() < doubleMetaphoneResult.maxLength) {
                        doubleMetaphoneResult.primary.append('N');
                    }
                    if (doubleMetaphoneResult.alternate.length() < doubleMetaphoneResult.maxLength) {
                        doubleMetaphoneResult.alternate.append('N');
                    }
                    i++;
                }
            }
        }
        return (z ? doubleMetaphoneResult.alternate : doubleMetaphoneResult.primary).toString();
    }

    protected char charAt(String str, int i) {
        if (i < 0 || i >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i);
    }

    /* loaded from: classes2.dex */
    public class DoubleMetaphoneResult {
        final StringBuilder alternate;
        final int maxLength;
        final StringBuilder primary;

        public DoubleMetaphoneResult(int i) {
            this.primary = new StringBuilder(DoubleMetaphone.this.maxCodeLen);
            this.alternate = new StringBuilder(DoubleMetaphone.this.maxCodeLen);
            this.maxLength = i;
        }
    }
}
