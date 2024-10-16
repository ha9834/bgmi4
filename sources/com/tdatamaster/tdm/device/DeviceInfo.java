package com.tdatamaster.tdm.device;

/* loaded from: classes2.dex */
public class DeviceInfo<T> {
    public static final boolean DEFAULT_UNKNOWN_BOOL_VALUE = false;
    public static final long DEFAULT_UNKNOWN_LONG_VALUE = -1;
    public static final String DEFAULT_UNKNOWN_STRING_VALUE = "Unknown";
    public static final String[] DISABLE_CACHED_DEVICE_INFO_NAMES = new String[0];
    public String name;
    public int status;
    public T value;

    public DeviceInfo(String str, T t, int i) {
        this.name = str;
        this.value = t;
        this.status = i;
    }

    public DeviceInfo(T t, int i) {
        this.value = t;
        this.status = i;
    }

    public DeviceInfo(T t) {
        this.value = t;
        this.status = -1;
    }

    public static Class getValueTypeByDeviceInfoName(String str) {
        if (str == null) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1843425069:
                if (str.equals(DeviceInfoName.SCREEN_HEIGHT_LONG)) {
                    c = 20;
                    break;
                }
                break;
            case -1806168640:
                if (str.equals(DeviceInfoName.MAC_ADDR_STRING)) {
                    c = '\b';
                    break;
                }
                break;
            case -1645139641:
                if (str.equals(DeviceInfoName.CPU_CORE_LONG)) {
                    c = 18;
                    break;
                }
                break;
            case -1645047776:
                if (str.equals(DeviceInfoName.CPU_FREQ_LONG)) {
                    c = 19;
                    break;
                }
                break;
            case -1404677443:
                if (str.equals(DeviceInfoName.TURING_TICKET_STRING)) {
                    c = 17;
                    break;
                }
                break;
            case -1230011043:
                if (str.equals(DeviceInfoName.BUNDLE_ID_STRING)) {
                    c = 5;
                    break;
                }
                break;
            case -1159299158:
                if (str.equals(DeviceInfoName.ANDROID_ID_STRING)) {
                    c = 2;
                    break;
                }
                break;
            case -817389673:
                if (str.equals(DeviceInfoName.APP_VERSION_STRING)) {
                    c = 3;
                    break;
                }
                break;
            case -785268719:
                if (str.equals(DeviceInfoName.TOTAL_MEM_LONG)) {
                    c = 22;
                    break;
                }
                break;
            case 65921:
                if (str.equals(DeviceInfoName.ALL_DEVICE_INFO_STRING)) {
                    c = 0;
                    break;
                }
                break;
            case 118675:
                if (str.equals(DeviceInfoName.XID_STRING)) {
                    c = 16;
                    break;
                }
                break;
            case 2242326:
                if (str.equals(DeviceInfoName.IDFA_STRING)) {
                    c = 14;
                    break;
                }
                break;
            case 2418285:
                if (str.equals(DeviceInfoName.OAID_STRING)) {
                    c = 15;
                    break;
                }
                break;
            case 2616251:
                if (str.equals(DeviceInfoName.UUID_STRING)) {
                    c = 11;
                    break;
                }
                break;
            case 64445287:
                if (str.equals(DeviceInfoName.BRAND_STRING)) {
                    c = 4;
                    break;
                }
                break;
            case 74517257:
                if (str.equals(DeviceInfoName.MODEL_STRING)) {
                    c = '\t';
                    break;
                }
                break;
            case 77056153:
                if (str.equals(DeviceInfoName.QIMEI_STRING)) {
                    c = '\f';
                    break;
                }
                break;
            case 1036520636:
                if (str.equals(DeviceInfoName.QIMEI36_STRING)) {
                    c = '\r';
                    break;
                }
                break;
            case 1173835281:
                if (str.equals(DeviceInfoName.DEVICE_ID_STRING)) {
                    c = 7;
                    break;
                }
                break;
            case 1276865602:
                if (str.equals(DeviceInfoName.TOTAL_SPACE_LONG)) {
                    c = 23;
                    break;
                }
                break;
            case 1617070234:
                if (str.equals(DeviceInfoName.SCREEN_WIDTH_LONG)) {
                    c = 21;
                    break;
                }
                break;
            case 1704456243:
                if (str.equals(DeviceInfoName.CPU_NAME_STRING)) {
                    c = 6;
                    break;
                }
                break;
            case 1786577259:
                if (str.equals(DeviceInfoName.SYS_VERSION_STRING)) {
                    c = '\n';
                    break;
                }
                break;
            case 1963936135:
                if (str.equals(DeviceInfoName.ALL_SYN_DEVICE_INFO_STRING)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
                return String.class;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return Long.class;
            default:
                return null;
        }
    }
}
