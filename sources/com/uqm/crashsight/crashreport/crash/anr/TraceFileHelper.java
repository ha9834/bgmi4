package com.uqm.crashsight.crashreport.crash.anr;

import com.uqm.crashsight.proguard.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class TraceFileHelper {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f6583a;
        public String b;
        public long c;
        public Map<String, String[]> d;
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, String str);

        boolean a(String str, int i, String str2, String str3);
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str == null || str2 == null) {
            return null;
        }
        final a aVar = new a();
        readTraceFile(str2, new b() { // from class: com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.1
            @Override // com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str3, int i, String str4, String str5) {
                m.c("new thread %s", str3);
                if (a.this.f6583a <= 0 || a.this.c <= 0 || a.this.b == null) {
                    return true;
                }
                if (a.this.d == null) {
                    a.this.d = new HashMap();
                }
                Map<String, String[]> map = a.this.d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str3, new String[]{str4, str5, sb.toString()});
                return true;
            }

            @Override // com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j, long j2, String str3) {
                m.c("new process %s", str3);
                if (!str3.equals(str)) {
                    return true;
                }
                a aVar2 = a.this;
                aVar2.f6583a = j;
                aVar2.b = str3;
                aVar2.c = j2;
                return z;
            }

            @Override // com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j) {
                m.c("process end %d", Long.valueOf(j));
                return a.this.f6583a <= 0 || a.this.c <= 0 || a.this.b == null;
            }
        });
        if (aVar.f6583a <= 0 || aVar.c <= 0 || aVar.b == null) {
            return null;
        }
        return aVar;
    }

    public static a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            m.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i, String str3, String str4) {
                m.c("new thread %s", str2);
                if (a.this.d == null) {
                    a.this.d = new HashMap();
                }
                Map<String, String[]> map = a.this.d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str2, new String[]{str3, str4, sb.toString()});
                return true;
            }

            @Override // com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j, long j2, String str2) {
                m.c("new process %s", str2);
                a aVar2 = a.this;
                aVar2.f6583a = j;
                aVar2.b = str2;
                aVar2.c = j2;
                return z;
            }

            @Override // com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j) {
                m.c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (aVar.f6583a > 0 && aVar.c > 0 && aVar.b != null) {
            return aVar;
        }
        m.e("first dump error %s", aVar.f6583a + " " + aVar.c + " " + aVar.b);
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        BufferedReader bufferedReader;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader2;
        }
        try {
            Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
            Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
            Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
            Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            while (true) {
                Object[] a2 = a(bufferedReader, compile);
                if (a2 == null) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e2) {
                        if (m.a(e2)) {
                            return;
                        }
                        e2.printStackTrace();
                        return;
                    }
                }
                String[] split = a2[1].toString().split("\\s");
                long parseLong = Long.parseLong(split[2]);
                long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                Object[] a3 = a(bufferedReader, compile3);
                if (a3 == null) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e3) {
                        if (m.a(e3)) {
                            return;
                        }
                        e3.printStackTrace();
                        return;
                    }
                }
                Matcher matcher = compile3.matcher(a3[1].toString());
                matcher.find();
                matcher.group(1);
                if (!bVar.a(parseLong, time, matcher.group(1))) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e4) {
                        if (m.a(e4)) {
                            return;
                        }
                        e4.printStackTrace();
                        return;
                    }
                }
                while (true) {
                    Object[] a4 = a(bufferedReader, compile4, compile2);
                    if (a4 == null) {
                        break;
                    }
                    if (a4[0] == compile4) {
                        String obj = a4[1].toString();
                        Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                        matcher2.find();
                        String group = matcher2.group();
                        String substring = group.substring(1, group.length() - 1);
                        obj.contains("NATIVE");
                        Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                        matcher3.find();
                        String group2 = matcher3.group();
                        bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader), b(bufferedReader));
                    } else if (!bVar.a(Long.parseLong(a4[1].toString().split("\\s")[2]))) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e5) {
                            if (m.a(e5)) {
                                return;
                            }
                            e5.printStackTrace();
                            return;
                        }
                    }
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader2 = bufferedReader;
            if (!m.a(e)) {
                e.printStackTrace();
            }
            m.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e7) {
                    if (m.a(e7)) {
                        return;
                    }
                    e7.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader == null) {
                throw th;
            }
            try {
                bufferedReader.close();
                throw th;
            } catch (IOException e8) {
                if (m.a(e8)) {
                    throw th;
                }
                e8.printStackTrace();
                throw th;
            }
        }
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader == null || patternArr == null) {
            return null;
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
