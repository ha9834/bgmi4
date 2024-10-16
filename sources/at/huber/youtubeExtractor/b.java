package at.huber.youtubeExtractor;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import at.huber.youtubeExtractor.Format;
import com.amazonaws.http.HttpHeader;
import com.intlgame.core.INTLMethodID;
import com.tencent.smtt.sdk.TbsListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class b extends AsyncTask<String, Void, SparseArray<c>> {
    private static final String CACHE_FILE_NAME = "decipher_js_funct";
    private static final boolean CACHING = true;
    static boolean LOGGING = false;
    private static final String LOG_TAG = "YouTubeExtractor";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36";
    private static String decipherFunctionName;
    private static String decipherFunctions;
    private static String decipherJsFileName;
    private String cacheDirPath;
    private volatile String decipheredSignature;
    private WeakReference<Context> refContext;
    private String videoID;
    private a videoMeta;
    private static final Pattern patYouTubePageLink = Pattern.compile("(http|https)://(www\\.|m.|)youtube\\.com/watch\\?v=(.+?)( |\\z|&)");
    private static final Pattern patYouTubeShortLink = Pattern.compile("(http|https)://(www\\.|)youtu.be/(.+?)( |\\z|&)");
    private static final Pattern patTitle = Pattern.compile("\"title\"\\s*:\\s*\"(.*?)\"");
    private static final Pattern patAuthor = Pattern.compile("\"author\"\\s*:\\s*\"(.+?)\"");
    private static final Pattern patChannelId = Pattern.compile("\"channelId\"\\s*:\\s*\"(.+?)\"");
    private static final Pattern patLength = Pattern.compile("\"lengthSeconds\"\\s*:\\s*\"(\\d+?)\"");
    private static final Pattern patViewCount = Pattern.compile("\"viewCount\"\\s*:\\s*\"(\\d+?)\"");
    private static final Pattern patShortDescript = Pattern.compile("\"shortDescription\"\\s*:\\s*\"(.+?)\"");
    private static final Pattern patStatusOk = Pattern.compile("status=ok(&|,|\\z)");
    private static final Pattern patHlsvp = Pattern.compile("hlsvp=(.+?)(&|\\z)");
    private static final Pattern patHlsItag = Pattern.compile("/itag/(\\d+?)/");
    private static final Pattern patItag = Pattern.compile("itag=([0-9]+?)(&|\\z)");
    private static final Pattern patEncSig = Pattern.compile("s=(.{10,}?)(\\\\\\\\u0026|\\z)");
    private static final Pattern patUrl = Pattern.compile("\"url\"\\s*:\\s*\"(.+?)\"");
    private static final Pattern patCipher = Pattern.compile("\"signatureCipher\"\\s*:\\s*\"(.+?)\"");
    private static final Pattern patCipherUrl = Pattern.compile("url=(.+?)(\\\\\\\\u0026|\\z)");
    private static final Pattern patVariableFunction = Pattern.compile("([{; =])([a-zA-Z$][a-zA-Z0-9$]{0,2})\\.([a-zA-Z$][a-zA-Z0-9$]{0,2})\\(");
    private static final Pattern patFunction = Pattern.compile("([{; =])([a-zA-Z$_][a-zA-Z0-9$]{0,2})\\(");
    private static final Pattern patDecryptionJsFile = Pattern.compile("\\\\/s\\\\/player\\\\/([^\"]+?)\\.js");
    private static final Pattern patSignatureDecFunction = Pattern.compile("\\b([\\w$]{2})\\s*=\\s*function\\((\\w+)\\)\\{\\s*\\2=\\s*\\2\\.split\\(\"\"\\)\\s*;");
    private static final SparseArray<Format> FORMAT_MAP = new SparseArray<>();
    private boolean includeWebM = true;
    private boolean useHttp = false;
    private final Lock lock = new ReentrantLock();
    private final Condition jsExecuting = this.lock.newCondition();

    protected abstract void onExtractionComplete(SparseArray<c> sparseArray, a aVar);

    public void setParseDashManifest(boolean z) {
    }

    static {
        FORMAT_MAP.put(17, new Format(17, "3gp", 144, Format.VCodec.MPEG4, Format.ACodec.AAC, 24, false));
        FORMAT_MAP.put(36, new Format(36, "3gp", 240, Format.VCodec.MPEG4, Format.ACodec.AAC, 32, false));
        FORMAT_MAP.put(5, new Format(5, "flv", 240, Format.VCodec.H263, Format.ACodec.MP3, 64, false));
        FORMAT_MAP.put(43, new Format(43, "webm", 360, Format.VCodec.VP8, Format.ACodec.VORBIS, 128, false));
        FORMAT_MAP.put(18, new Format(18, "mp4", 360, Format.VCodec.H264, Format.ACodec.AAC, 96, false));
        FORMAT_MAP.put(22, new Format(22, "mp4", 720, Format.VCodec.H264, Format.ACodec.AAC, 192, false));
        FORMAT_MAP.put(TbsListener.ErrorCode.STARTDOWNLOAD_1, new Format(TbsListener.ErrorCode.STARTDOWNLOAD_1, "mp4", 144, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_USERNAME_STATUS, new Format(INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_USERNAME_STATUS, "mp4", 240, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE, new Format(INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE, "mp4", 360, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(INTLMethodID.INTL_METHOD_ID_AUTH_MODIFY_DATA_PROTECTION_ACCEPTANCE, new Format(INTLMethodID.INTL_METHOD_ID_AUTH_MODIFY_DATA_PROTECTION_ACCEPTANCE, "mp4", 480, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(136, new Format(136, "mp4", 720, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(INTLMethodID.INTL_METHOD_ID_AUTH_LAUNCH_ACCOUNT_UI, new Format(INTLMethodID.INTL_METHOD_ID_AUTH_LAUNCH_ACCOUNT_UI, "mp4", 1080, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(264, new Format(264, "mp4", 1440, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(266, new Format(266, "mp4", 2160, Format.VCodec.H264, Format.ACodec.NONE, true));
        FORMAT_MAP.put(298, new Format(298, "mp4", 720, Format.VCodec.H264, 60, Format.ACodec.NONE, true));
        FORMAT_MAP.put(299, new Format(299, "mp4", 1080, Format.VCodec.H264, 60, Format.ACodec.NONE, true));
        FORMAT_MAP.put(140, new Format(140, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 128, true));
        FORMAT_MAP.put(TbsListener.ErrorCode.NEEDDOWNLOAD_2, new Format(TbsListener.ErrorCode.NEEDDOWNLOAD_2, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 256, true));
        FORMAT_MAP.put(256, new Format(256, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 192, true));
        FORMAT_MAP.put(258, new Format(258, "m4a", Format.VCodec.NONE, Format.ACodec.AAC, 384, true));
        FORMAT_MAP.put(278, new Format(278, "webm", 144, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(242, new Format(242, "webm", 240, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(243, new Format(243, "webm", 360, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(244, new Format(244, "webm", 480, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(247, new Format(247, "webm", 720, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(248, new Format(248, "webm", 1080, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(271, new Format(271, "webm", 1440, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(313, new Format(313, "webm", 2160, Format.VCodec.VP9, Format.ACodec.NONE, true));
        FORMAT_MAP.put(302, new Format(302, "webm", 720, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        FORMAT_MAP.put(308, new Format(308, "webm", 1440, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        FORMAT_MAP.put(INTLMethodID.INTL_METHOD_ID_WEBVIEW_JS_CALL, new Format(INTLMethodID.INTL_METHOD_ID_WEBVIEW_JS_CALL, "webm", 1080, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        FORMAT_MAP.put(315, new Format(315, "webm", 2160, Format.VCodec.VP9, 60, Format.ACodec.NONE, true));
        FORMAT_MAP.put(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, new Format(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, "webm", Format.VCodec.NONE, Format.ACodec.VORBIS, 128, true));
        FORMAT_MAP.put(249, new Format(249, "webm", Format.VCodec.NONE, Format.ACodec.OPUS, 48, true));
        FORMAT_MAP.put(250, new Format(250, "webm", Format.VCodec.NONE, Format.ACodec.OPUS, 64, true));
        FORMAT_MAP.put(251, new Format(251, "webm", Format.VCodec.NONE, Format.ACodec.OPUS, TbsListener.ErrorCode.STARTDOWNLOAD_1, true));
        FORMAT_MAP.put(91, new Format(91, "mp4", 144, Format.VCodec.H264, Format.ACodec.AAC, 48, false, true));
        FORMAT_MAP.put(92, new Format(92, "mp4", 240, Format.VCodec.H264, Format.ACodec.AAC, 48, false, true));
        FORMAT_MAP.put(93, new Format(93, "mp4", 360, Format.VCodec.H264, Format.ACodec.AAC, 128, false, true));
        FORMAT_MAP.put(94, new Format(94, "mp4", 480, Format.VCodec.H264, Format.ACodec.AAC, 128, false, true));
        FORMAT_MAP.put(95, new Format(95, "mp4", 720, Format.VCodec.H264, Format.ACodec.AAC, 256, false, true));
        FORMAT_MAP.put(96, new Format(96, "mp4", 1080, Format.VCodec.H264, Format.ACodec.AAC, 256, false, true));
    }

    public b(Context context) {
        this.refContext = new WeakReference<>(context);
        this.cacheDirPath = context.getCacheDir().getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(SparseArray<c> sparseArray) {
        onExtractionComplete(sparseArray, this.videoMeta);
    }

    public void extract(String str, boolean z, boolean z2) {
        this.includeWebM = z2;
        execute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public SparseArray<c> doInBackground(String... strArr) {
        this.videoID = null;
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        Matcher matcher = patYouTubePageLink.matcher(str);
        if (matcher.find()) {
            this.videoID = matcher.group(3);
        } else {
            Matcher matcher2 = patYouTubeShortLink.matcher(str);
            if (matcher2.find()) {
                this.videoID = matcher2.group(3);
            } else if (str.matches("\\p{Graph}+?")) {
                this.videoID = str;
            }
        }
        if (this.videoID != null) {
            try {
                return getStreamUrls();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e(LOG_TAG, "Wrong YouTube link format");
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SparseArray<c> getStreamUrls() throws IOException, InterruptedException {
        boolean z;
        boolean z2;
        BufferedReader bufferedReader;
        SparseArray<String> sparseArray;
        Matcher matcher;
        String group;
        String str;
        BufferedReader bufferedReader2;
        String str2 = this.useHttp ? "http://" : "https://";
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("www.youtube.com/get_video_info?video_id=");
        sb.append(this.videoID);
        sb.append("&eurl=");
        sb.append(URLEncoder.encode("https://youtube.googleapis.com/v/" + this.videoID, "UTF-8"));
        String sb2 = sb.toString();
        URL url = new URL(sb2);
        if (LOGGING) {
            Log.d(LOG_TAG, "infoUrl: " + sb2);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, USER_AGENT);
        BufferedReader bufferedReader3 = null;
        try {
            BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            try {
                String readLine = bufferedReader4.readLine();
                bufferedReader4.close();
                httpURLConnection.disconnect();
                String replace = URLDecoder.decode(readLine, "UTF-8").replace("\\u0026", "&");
                parseVideoMeta(replace);
                if (this.videoMeta.a()) {
                    Matcher matcher2 = patHlsvp.matcher(replace);
                    if (!matcher2.find()) {
                        return null;
                    }
                    String decode = URLDecoder.decode(matcher2.group(1), "UTF-8");
                    SparseArray<c> sparseArray2 = new SparseArray<>();
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(decode).openConnection();
                    httpURLConnection2.setRequestProperty(HttpHeader.USER_AGENT, USER_AGENT);
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                        while (true) {
                            try {
                                String readLine2 = bufferedReader2.readLine();
                                if (readLine2 == null) {
                                    break;
                                }
                                if (readLine2.startsWith("https://") || readLine2.startsWith("http://")) {
                                    Matcher matcher3 = patHlsItag.matcher(readLine2);
                                    if (matcher3.find()) {
                                        int parseInt = Integer.parseInt(matcher3.group(1));
                                        sparseArray2.put(parseInt, new c(FORMAT_MAP.get(parseInt), readLine2));
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2.close();
                                httpURLConnection2.disconnect();
                                throw th;
                            }
                        }
                        bufferedReader2.close();
                        httpURLConnection2.disconnect();
                        if (sparseArray2.size() != 0) {
                            return sparseArray2;
                        }
                        if (LOGGING) {
                            Log.d(LOG_TAG, replace);
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader4;
                    }
                } else {
                    if (patCipher.matcher(replace).find()) {
                        z = true;
                        z2 = false;
                    } else if (patStatusOk.matcher(replace).find()) {
                        z = false;
                        z2 = false;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    if (z || z2) {
                        if (decipherJsFileName == null || decipherFunctions == null || decipherFunctionName == null) {
                            readDecipherFunctFromCache();
                        }
                        if (LOGGING) {
                            Log.d(LOG_TAG, "Get from youtube page");
                        }
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL("https://youtube.com/watch?v=" + this.videoID).openConnection();
                        httpURLConnection3.setRequestProperty(HttpHeader.USER_AGENT, USER_AGENT);
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection3.getInputStream()));
                            try {
                                StringBuilder sb3 = new StringBuilder();
                                while (true) {
                                    String readLine3 = bufferedReader.readLine();
                                    if (readLine3 == null) {
                                        break;
                                    }
                                    sb3.append(readLine3.replace("\\\"", "\""));
                                }
                                String sb4 = sb3.toString();
                                bufferedReader.close();
                                httpURLConnection3.disconnect();
                                SparseArray<String> sparseArray3 = new SparseArray<>();
                                Matcher matcher4 = patDecryptionJsFile.matcher(sb4);
                                if (matcher4.find()) {
                                    String replace2 = matcher4.group(0).replace("\\/", "/");
                                    String str3 = decipherJsFileName;
                                    if (str3 == null || !str3.equals(replace2)) {
                                        decipherFunctions = null;
                                        decipherFunctionName = null;
                                    }
                                    decipherJsFileName = replace2;
                                }
                                sparseArray = sparseArray3;
                                replace = sb4;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader.close();
                                httpURLConnection3.disconnect();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = bufferedReader4;
                        }
                    } else {
                        sparseArray = null;
                    }
                    SparseArray<c> sparseArray4 = new SparseArray<>();
                    if (z) {
                        matcher = patCipher.matcher(replace);
                    } else {
                        matcher = patUrl.matcher(replace);
                    }
                    while (matcher.find()) {
                        if (z) {
                            String group2 = matcher.group(1);
                            Matcher matcher5 = patCipherUrl.matcher(group2);
                            if (matcher5.find()) {
                                group = URLDecoder.decode(matcher5.group(1), "UTF-8");
                                Matcher matcher6 = patEncSig.matcher(group2);
                                if (matcher6.find()) {
                                    str = URLDecoder.decode(matcher6.group(1), "UTF-8");
                                }
                            }
                        } else {
                            group = matcher.group(1);
                            str = null;
                        }
                        Matcher matcher7 = patItag.matcher(group);
                        if (matcher7.find()) {
                            int parseInt2 = Integer.parseInt(matcher7.group(1));
                            if (FORMAT_MAP.get(parseInt2) == null) {
                                if (LOGGING) {
                                    Log.d(LOG_TAG, "Itag not in list:" + parseInt2);
                                }
                            } else if (this.includeWebM || !FORMAT_MAP.get(parseInt2).b().equals("webm")) {
                                if (!group.contains("&source=yt_otf&")) {
                                    if (LOGGING) {
                                        Log.d(LOG_TAG, "Itag found:" + parseInt2);
                                    }
                                    if (str != null) {
                                        sparseArray.append(parseInt2, str);
                                    }
                                    sparseArray4.put(parseInt2, new c(FORMAT_MAP.get(parseInt2), group));
                                }
                            }
                        }
                    }
                    if (sparseArray != null) {
                        if (LOGGING) {
                            Log.d(LOG_TAG, "Decipher signatures: " + sparseArray.size() + ", videos: " + sparseArray4.size());
                        }
                        this.decipheredSignature = null;
                        if (decipherSignature(sparseArray)) {
                            this.lock.lock();
                            try {
                                this.jsExecuting.await(7L, TimeUnit.SECONDS);
                            } finally {
                                this.lock.unlock();
                            }
                        }
                        String str4 = this.decipheredSignature;
                        if (str4 == null) {
                            return null;
                        }
                        String[] split = str4.split("\n");
                        for (int i = 0; i < sparseArray.size() && i < split.length; i++) {
                            int keyAt = sparseArray.keyAt(i);
                            sparseArray4.put(keyAt, new c(FORMAT_MAP.get(keyAt), sparseArray4.get(keyAt).a() + "&sig=" + split[i]));
                        }
                    }
                    if (sparseArray4.size() != 0) {
                        return sparseArray4;
                    }
                    if (LOGGING) {
                        Log.d(LOG_TAG, replace);
                    }
                    return null;
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader3 = bufferedReader4;
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean decipherSignature(SparseArray<String> sparseArray) throws IOException {
        BufferedReader bufferedReader;
        String str;
        if (decipherFunctionName == null || decipherFunctions == null) {
            String str2 = "https://youtube.com" + decipherJsFileName;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setRequestProperty(HttpHeader.USER_AGENT, USER_AGENT);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    StringBuilder sb = new StringBuilder("");
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(" ");
                    }
                    String sb2 = sb.toString();
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    if (LOGGING) {
                        Log.d(LOG_TAG, "Decipher FunctURL: " + str2);
                    }
                    Matcher matcher = patSignatureDecFunction.matcher(sb2);
                    if (!matcher.find()) {
                        return false;
                    }
                    decipherFunctionName = matcher.group(1);
                    if (LOGGING) {
                        Log.d(LOG_TAG, "Decipher Functname: " + decipherFunctionName);
                    }
                    Matcher matcher2 = Pattern.compile("(var |\\s|,|;)" + decipherFunctionName.replace("$", "\\$") + "(=function\\((.{1,3})\\)\\{)").matcher(sb2);
                    if (matcher2.find()) {
                        str = "var " + decipherFunctionName + matcher2.group(2);
                    } else {
                        matcher2 = Pattern.compile("function " + decipherFunctionName.replace("$", "\\$") + "(\\((.{1,3})\\)\\{)").matcher(sb2);
                        if (!matcher2.find()) {
                            return false;
                        }
                        str = "function " + decipherFunctionName + matcher2.group(2);
                    }
                    int end = matcher2.end();
                    int i = end;
                    int i2 = 1;
                    while (true) {
                        if (i < sb2.length()) {
                            if (i2 == 0 && end + 5 < i) {
                                str = str + sb2.substring(end, i) + ";";
                                break;
                            }
                            if (sb2.charAt(i) == '{') {
                                i2++;
                            } else if (sb2.charAt(i) == '}') {
                                i2--;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    decipherFunctions = str;
                    Matcher matcher3 = patVariableFunction.matcher(str);
                    while (matcher3.find()) {
                        String str3 = "var " + matcher3.group(2) + "={";
                        if (!decipherFunctions.contains(str3)) {
                            int indexOf = sb2.indexOf(str3) + str3.length();
                            int i3 = indexOf;
                            int i4 = 1;
                            while (true) {
                                if (i3 >= sb2.length()) {
                                    break;
                                }
                                if (i4 == 0) {
                                    decipherFunctions += str3 + sb2.substring(indexOf, i3) + ";";
                                    break;
                                }
                                if (sb2.charAt(i3) == '{') {
                                    i4++;
                                } else if (sb2.charAt(i3) == '}') {
                                    i4--;
                                }
                                i3++;
                            }
                        }
                    }
                    Matcher matcher4 = patFunction.matcher(str);
                    while (matcher4.find()) {
                        String str4 = "function " + matcher4.group(2) + "(";
                        if (!decipherFunctions.contains(str4)) {
                            int indexOf2 = sb2.indexOf(str4) + str4.length();
                            int i5 = indexOf2;
                            int i6 = 0;
                            while (true) {
                                if (i5 < sb2.length()) {
                                    if (i6 == 0 && indexOf2 + 5 < i5) {
                                        decipherFunctions += str4 + sb2.substring(indexOf2, i5) + ";";
                                        break;
                                    }
                                    if (sb2.charAt(i5) == '{') {
                                        i6++;
                                    } else if (sb2.charAt(i5) == '}') {
                                        i6--;
                                    }
                                    i5++;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    if (LOGGING) {
                        Log.d(LOG_TAG, "Decipher Function: " + decipherFunctions);
                    }
                    decipherViaWebView(sparseArray);
                    writeDeciperFunctToChache();
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } else {
            decipherViaWebView(sparseArray);
        }
        return true;
    }

    private void parseVideoMeta(String str) {
        Matcher matcher = patTitle.matcher(str);
        String group = matcher.find() ? matcher.group(1) : null;
        boolean find = patHlsvp.matcher(str).find();
        Matcher matcher2 = patAuthor.matcher(str);
        String group2 = matcher2.find() ? matcher2.group(1) : null;
        Matcher matcher3 = patChannelId.matcher(str);
        String group3 = matcher3.find() ? matcher3.group(1) : null;
        Matcher matcher4 = patShortDescript.matcher(str);
        String group4 = matcher4.find() ? matcher4.group(1) : null;
        Matcher matcher5 = patLength.matcher(str);
        long parseLong = matcher5.find() ? Long.parseLong(matcher5.group(1)) : 0L;
        Matcher matcher6 = patViewCount.matcher(str);
        this.videoMeta = new a(this.videoID, group, group2, group3, parseLong, matcher6.find() ? Long.parseLong(matcher6.group(1)) : 0L, find, group4);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x006e -> B:13:0x007d). Please report as a decompilation issue!!! */
    private void readDecipherFunctFromCache() {
        BufferedReader bufferedReader;
        File file = new File(this.cacheDirPath + "/" + CACHE_FILE_NAME);
        if (!file.exists() || System.currentTimeMillis() - file.lastModified() >= 1209600000) {
            return;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            decipherJsFileName = bufferedReader.readLine();
            decipherFunctionName = bufferedReader.readLine();
            decipherFunctions = bufferedReader.readLine();
            bufferedReader.close();
        } catch (Exception e3) {
            e = e3;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public void setIncludeWebM(boolean z) {
        this.includeWebM = z;
    }

    public void setDefaultHttpProtocol(boolean z) {
        this.useHttp = z;
    }

    private void writeDeciperFunctToChache() {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(this.cacheDirPath + "/" + CACHE_FILE_NAME)), "UTF-8"));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
            }
            try {
                bufferedWriter.write(decipherJsFileName + "\n");
                bufferedWriter.write(decipherFunctionName + "\n");
                bufferedWriter.write(decipherFunctions);
                bufferedWriter.close();
            } catch (Exception e2) {
                e = e2;
                bufferedWriter2 = bufferedWriter;
                e.printStackTrace();
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private void decipherViaWebView(SparseArray<String> sparseArray) {
        final Context context = this.refContext.get();
        if (context == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder(decipherFunctions + " function decipher(");
        sb.append("){return ");
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (i < sparseArray.size() - 1) {
                sb.append(decipherFunctionName);
                sb.append("('");
                sb.append(sparseArray.get(keyAt));
                sb.append("')+\"\\n\"+");
            } else {
                sb.append(decipherFunctionName);
                sb.append("('");
                sb.append(sparseArray.get(keyAt));
                sb.append("')");
            }
        }
        sb.append("};decipher();");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: at.huber.youtubeExtractor.b.1
            @Override // java.lang.Runnable
            public void run() {
                new com.a.a.c(context).a(sb.toString(), new com.a.a.a.c() { // from class: at.huber.youtubeExtractor.b.1.1
                    @Override // com.a.a.a.c
                    public void a(String str) {
                        b.this.lock.lock();
                        try {
                            b.this.decipheredSignature = str;
                            b.this.jsExecuting.signal();
                        } finally {
                            b.this.lock.unlock();
                        }
                    }

                    @Override // com.a.a.a.c
                    public void b(String str) {
                        b.this.lock.lock();
                        try {
                            if (b.LOGGING) {
                                Log.e(b.LOG_TAG, str);
                            }
                            b.this.jsExecuting.signal();
                        } finally {
                            b.this.lock.unlock();
                        }
                    }
                });
            }
        });
    }
}
