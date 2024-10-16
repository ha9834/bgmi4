package com.tencent.midas.oversea.newnetwork.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.amazonaws.event.ProgressEvent;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.midas.comm.APLog;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APIPDetectTools {
    private static final short DNS_TYPE_CNAME = 5;
    private static final short DNS_TYPE_IP = 1;
    private static final String TAG = "APIPDetectTools";
    private static final String pingSuccPrefix = "64 bytes from ";
    int DNS_SERVER_PORT = 53;

    public static String socketConn(String str, String str2, int i, String str3, String str4, int i2) {
        return socketConnImpl(1, str, str2, i, str3, str4, i2);
    }

    private static Map<String, String> dnsSocket(String str, String str2, long j) {
        HashMap hashMap = new HashMap();
        if (j <= 0) {
            try {
                j = System.currentTimeMillis();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InetAddress byName = InetAddress.getByName(str2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(4661);
        dataOutputStream.writeShort(256);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeShort(0);
        dataOutputStream.writeShort(0);
        dataOutputStream.writeShort(0);
        String[] split = str.split("\\.");
        System.out.println(str + " has " + split.length + " parts");
        for (int i = 0; i < split.length; i++) {
            System.out.println("Writing: " + split[i]);
            byte[] bytes = split[i].getBytes("UTF-8");
            dataOutputStream.writeByte(bytes.length);
            dataOutputStream.write(bytes);
        }
        dataOutputStream.writeByte(0);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeShort(1);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        System.out.println("Sending: " + byteArray.length + " bytes");
        for (byte b : byteArray) {
            System.out.print("0x" + String.format("%x", Byte.valueOf(b)) + " ");
        }
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(new DatagramPacket(byteArray, byteArray.length, byName, 53));
        byte[] bArr = new byte[ProgressEvent.PART_COMPLETED_EVENT_CODE];
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        datagramSocket.receive(datagramPacket);
        System.out.println("\n\nReceived: " + datagramPacket.getLength() + " bytes");
        for (int i2 = 0; i2 < datagramPacket.getLength(); i2++) {
            System.out.print(" 0x" + String.format("%x", Byte.valueOf(bArr[i2])) + " ");
        }
        System.out.println("\n");
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        System.out.println("Transaction ID: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        System.out.println("Flags: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        System.out.println("Questions: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        System.out.println("Answers RRs: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        System.out.println("Authority RRs: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        System.out.println("Additional RRs: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        while (true) {
            int readByte = dataInputStream.readByte();
            if (readByte <= 0) {
                break;
            }
            byte[] bArr2 = new byte[readByte];
            for (int i3 = 0; i3 < readByte; i3++) {
                bArr2[i3] = dataInputStream.readByte();
            }
            System.out.println("Record: " + new String(bArr2, "UTF-8"));
        }
        System.out.println("Record Type: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        System.out.println("Class: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        System.out.println("Field: 0x" + String.format("%x", Short.valueOf(dataInputStream.readShort())));
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        if (1 != readShort || 1 != readShort2) {
            APLog.d("Dns tools", "type=" + ((int) readShort) + ";class=" + ((int) readShort2));
        }
        System.out.println("TTL: 0x" + String.format("%x", Integer.valueOf(dataInputStream.readInt())));
        short readShort3 = dataInputStream.readShort();
        System.out.println("Len: 0x" + String.format("%x", Short.valueOf(readShort3)));
        String str3 = "";
        if (readShort == 5) {
            for (int i4 = 0; i4 < readShort3; i4++) {
                int readByte2 = dataInputStream.readByte() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                char c = '.';
                if (readByte2 >= 65 && readByte2 <= 122) {
                    c = (char) readByte2;
                }
                str3 = str3 + c;
                System.out.print("" + c + ".");
            }
            while (str3.length() > 0 && str3.endsWith(".")) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            while (str3.length() > 0 && str3.startsWith(".")) {
                str3 = str3.substring(1, str3.length());
            }
            if (!str3.endsWith(".com")) {
                str3 = str3 + ".com";
            }
            return dnsSocket(str3, str2, j);
        }
        if (readShort == 1) {
            for (int i5 = 0; i5 < readShort3; i5++) {
                int readByte3 = dataInputStream.readByte() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                str3 = str3 + readByte3 + ".";
                System.out.print("" + String.format("%d", Integer.valueOf(readByte3)) + ".");
            }
            String substring = str3.substring(0, str3.length() - 1);
            APLog.d("DNSParse", "addRess:" + substring + "& dnssvr=" + str2);
            long currentTimeMillis = System.currentTimeMillis() - j;
            hashMap.put("result", "succ");
            hashMap.put("dnssvr", str2);
            hashMap.put("host", str);
            hashMap.put("time", "" + currentTimeMillis);
            hashMap.put("ip", substring);
            return hashMap;
        }
        APLog.w("DetectService", "unsupport detect type : " + ((int) readShort));
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0187 A[Catch: JSONException -> 0x0267, IOException -> 0x026c, TryCatch #2 {IOException -> 0x026c, JSONException -> 0x0267, blocks: (B:3:0x0012, B:9:0x0024, B:11:0x0094, B:14:0x00a2, B:15:0x0171, B:17:0x0187, B:20:0x0193, B:22:0x019b, B:24:0x019f, B:25:0x01a1, B:27:0x01a9, B:29:0x01b3, B:31:0x01c3, B:33:0x01cd, B:35:0x01dd, B:37:0x0201, B:38:0x0215, B:39:0x025d, B:45:0x0207, B:48:0x0212, B:49:0x023d, B:50:0x012d), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0193 A[Catch: JSONException -> 0x0267, IOException -> 0x026c, TryCatch #2 {IOException -> 0x026c, JSONException -> 0x0267, blocks: (B:3:0x0012, B:9:0x0024, B:11:0x0094, B:14:0x00a2, B:15:0x0171, B:17:0x0187, B:20:0x0193, B:22:0x019b, B:24:0x019f, B:25:0x01a1, B:27:0x01a9, B:29:0x01b3, B:31:0x01c3, B:33:0x01cd, B:35:0x01dd, B:37:0x0201, B:38:0x0215, B:39:0x025d, B:45:0x0207, B:48:0x0212, B:49:0x023d, B:50:0x012d), top: B:2:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String socketConnImpl(int r15, java.lang.String r16, java.lang.String r17, int r18, java.lang.String r19, java.lang.String r20, int r21) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.newnetwork.service.APIPDetectTools.socketConnImpl(int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int):java.lang.String");
    }

    public static String ping(String str, int i, int i2, int i3) {
        String str2 = "ping -c " + i2 + " -t " + i3 + " " + str;
        String str3 = "";
        String str4 = "";
        JSONObject jSONObject = new JSONObject();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str2).getInputStream()));
            String str5 = "";
            String str6 = "";
            String str7 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str5 = str5 + readLine + "\n";
                if (readLine.contains("packet loss")) {
                    str3 = readLine.substring(readLine.indexOf("received") + 10, readLine.indexOf("%"));
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2.contains("avg")) {
                        int indexOf = readLine2.indexOf("/", 20);
                        str4 = readLine2.substring(indexOf + 1, readLine2.indexOf(".", indexOf));
                    }
                } else if (readLine.startsWith("From")) {
                    str6 = readLine.substring(5, readLine.indexOf(CertificateUtil.DELIMITER));
                } else if (readLine.startsWith(pingSuccPrefix)) {
                    str7 = readLine.substring(14, readLine.indexOf(CertificateUtil.DELIMITER));
                }
            }
            Log.d("Ping details", str5);
            jSONObject.put("ret", 0);
            jSONObject.put("loss_rate", str3);
            jSONObject.put("ip", str7);
            jSONObject.put("icmpIp", str6);
            jSONObject.put("delay", str4);
            Log.d("Ping result ", jSONObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String monitTraceRoute(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 20; i++) {
            try {
                JSONObject jSONObject = new JSONObject(ping(str, 0, 1, i));
                if (jSONObject.has("icmpIp") && !TextUtils.isEmpty(jSONObject.getString("icmpIp"))) {
                    arrayList.add(jSONObject.getString("icmpIp") + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + i);
                } else {
                    if (jSONObject.has("ip") && !TextUtils.isEmpty(jSONObject.getString("ip"))) {
                        arrayList.add(jSONObject.getString("ip") + "_succ");
                        break;
                    }
                    Log.d("ping details", jSONObject.toString());
                    arrayList.add("0.0.0.0");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.d("traceRoute", arrayList.toString());
        return arrayList.toString();
    }

    public static List<String> getDnsServer(Context context) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 26) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            List<InetAddress> dnsServers = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork()).getDnsServers();
            if (dnsServers == null) {
                return arrayList;
            }
            for (int i = 0; i < dnsServers.size(); i++) {
                arrayList.add(dnsServers.get(i).getHostAddress());
            }
        } else {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
                for (String str : new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"}) {
                    String str2 = (String) method.invoke(null, str);
                    if (str2 != null && !"".equals(str2) && !arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        APLog.d("gtDnsServer", "dns:" + arrayList.toString());
        return arrayList;
    }

    public static Map<String, String> dnsRequest(String str, String str2) {
        return dnsSocket(str, str2, 0L);
    }

    public static boolean isIp(String str) {
        return Pattern.compile("(2[0-4][0-9]|25[0-5]|[01]?\\d\\d?.){3}(2[0-4][0-9]|25[0-5]|[01]?\\d\\d?)").matcher(str).find();
    }

    public static String getSysDefaultLocale(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = context.getResources().getConfiguration().getLocales();
            Log.d("locale", locales.toString());
            return locales.toString();
        }
        APLog.d("locale", context.getResources().getConfiguration().locale.toString());
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String getInputMethodLocale(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        String str = "";
        Iterator<InputMethodInfo> it = inputMethodManager.getEnabledInputMethodList().iterator();
        while (it.hasNext()) {
            for (InputMethodSubtype inputMethodSubtype : inputMethodManager.getEnabledInputMethodSubtypeList(it.next(), true)) {
                if (inputMethodSubtype.getMode().equals("keyboard")) {
                    String locale = inputMethodSubtype.getLocale();
                    str = str + locale + "&";
                    Log.d(TAG, "Available input method locale: " + locale);
                }
            }
        }
        Log.d(TAG, "Available input method locale: " + str.substring(0, str.length() - 1));
        return str.substring(0, str.length() - 1);
    }
}
