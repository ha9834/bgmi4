package com.tencent.abase;

import android.content.Context;
import com.tencent.abase.log.XLog;
import com.tencent.abase.utils.PatternUtils;
import com.tencent.abase.utils.ThreadPoolUtils;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class NetworkTool {
    private static final String TAG = "NetworkStateChecker";

    private String getPublicIP() {
        return null;
    }

    public void getPingMessage(final String str, final int i, final long j, final byte b, final byte b2) {
        if (str == null || 0 == j || (b & DeviceInfos.NETWORK_TYPE_UNCONNECTED) == 0 || (b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED) == 0) {
            XLog.e("NetTool::Ping", "Ping with error param");
        } else {
            ThreadPoolUtils.getThreadPoolSingleton().execute(new Runnable() { // from class: com.tencent.abase.NetworkTool.1
                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    int i3 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                    String exec = NetworkTool.exec("/system/bin/ping -c " + (b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + " -w " + i3 + " " + str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append("#");
                    List<String> matchGroup = PatternUtils.getMatchGroup("(?i)PING(.*?\\))", exec, 1);
                    if (matchGroup.get(0).equals(PatternUtils.NO_MATCH)) {
                        sb.append(str);
                        sb.append("(ERROR IP)");
                        sb.append("#");
                        i2 = 1;
                    } else {
                        sb.append(matchGroup.get(0));
                        sb.append("#");
                        i2 = 0;
                    }
                    sb.append((int) b2);
                    sb.append("#");
                    List<String> matchGroup2 = PatternUtils.getMatchGroup(",.*?(\\d+).*?received", exec, 1);
                    if (matchGroup2.get(0).equals("0")) {
                        i2 = 1;
                    }
                    sb.append(matchGroup2.get(0));
                    sb.append("#");
                    sb.append(PatternUtils.getMatchGroup("time.*?(\\d+)ms", exec, 1).get(0));
                    sb.append("#");
                    List<String> matchGroup3 = PatternUtils.getMatchGroup("(\\d+\\.\\d+)/", exec, 1);
                    if (matchGroup3.get(0).equals(PatternUtils.NO_MATCH)) {
                        sb.append(0);
                        sb.append("#");
                        sb.append(0);
                        sb.append("#");
                        sb.append(0);
                        sb.append("#");
                    } else {
                        Iterator<String> it = matchGroup3.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next());
                            sb.append("#");
                        }
                    }
                    sb.append(i2);
                    sb.append("#");
                    TX.Instance.pingFinishNotify(sb.toString(), j);
                }
            });
        }
    }

    private void getTraceRoute(final String str, final int i, final long j, final byte b) {
        if (str == null || 0 == j || (b & DeviceInfos.NETWORK_TYPE_UNCONNECTED) == 0) {
            XLog.e("NetTool::TraceRoute", "TraceRoute with error param");
        } else {
            ThreadPoolUtils.getThreadPoolSingleton().execute(new Runnable() { // from class: com.tencent.abase.NetworkTool.2
                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    int i3 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    sb.append(i);
                    sb.append("#");
                    sb.append(str);
                    sb.append("#");
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= i3) {
                            break;
                        }
                        int i6 = i5 + 1;
                        String str2 = null;
                        String str3 = null;
                        int i7 = 0;
                        int i8 = 0;
                        int i9 = 0;
                        while (i7 < 3) {
                            Date date = new Date();
                            String exec = NetworkTool.exec("ping -t " + i6 + " -c 1 -w 1 " + str);
                            Date date2 = new Date();
                            String str4 = PatternUtils.getMatchGroup("((?i)F)rom (.*?):", exec, 2).get(i4);
                            if (str4.equals(PatternUtils.NO_MATCH)) {
                                i2 = i6;
                                i8--;
                            } else {
                                i2 = i6;
                                i9 = (int) (i9 + (date2.getTime() - date.getTime()));
                                str2 = str4;
                            }
                            i7++;
                            str3 = exec;
                            i6 = i2;
                            i4 = 0;
                        }
                        int i10 = i6;
                        if (str2 != null) {
                            sb2.append(str2);
                            sb2.append("#");
                        } else {
                            sb2.append("TimeOut");
                            sb2.append("#");
                        }
                        if (i8 == 0) {
                            sb2.append(i9 / 3);
                            sb2.append("#");
                        } else {
                            sb2.append(i8);
                            sb2.append("#");
                        }
                        if (!PatternUtils.getMatchGroup("rtt min/avg/max/mdev = (.*?) ms", str3, 1).get(0).equals(PatternUtils.NO_MATCH)) {
                            i5 = i10;
                            break;
                        } else {
                            i5 = i10;
                            i4 = 0;
                        }
                    }
                    sb.append(i5);
                    sb.append("#");
                    sb.append(sb2.toString());
                    if (i5 >= i3) {
                        sb.append("1#");
                    } else {
                        sb.append("0#");
                    }
                    TX.Instance.traceRouteFinishNotify(sb.toString(), j);
                }
            });
        }
    }

    private void NSLookup(Context context, final String str, final int i, final long j) {
        if (context == null || str == null || 0 == j) {
            XLog.e("NetTool::NSLookup", "NSLookup with error param");
        } else {
            ThreadPoolUtils.getThreadPoolSingleton().execute(new Runnable() { // from class: com.tencent.abase.NetworkTool.3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append("#");
                    sb.append(str);
                    sb.append("#");
                    int i2 = 0;
                    try {
                        for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                            String[] split = inetAddress.toString().split("/");
                            if (split.length == 2) {
                                sb.append(split[1]);
                                sb.append("#");
                            }
                        }
                        sb.append(0);
                    } catch (UnknownHostException e) {
                        try {
                            e.printStackTrace();
                            sb.append(1);
                        } catch (Throwable th) {
                            th = th;
                            i2 = 1;
                            sb.append(i2);
                            sb.append("#");
                            TX.Instance.nsLookupFinishNotify(sb.toString(), j);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sb.append(i2);
                        sb.append("#");
                        TX.Instance.nsLookupFinishNotify(sb.toString(), j);
                        throw th;
                    }
                    sb.append("#");
                    TX.Instance.nsLookupFinishNotify(sb.toString(), j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String exec(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
