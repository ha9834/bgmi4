package com.tencent.grobot.lite.presenter.config;

import com.tencent.grobot.lite.BuildConfig;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.req.AskReqInfo;
import com.tencent.grobot.lite.model.req.ClearRedPointReqInfo;
import com.tencent.grobot.lite.model.req.CloseIMReqInfo;
import com.tencent.grobot.lite.model.req.CommonReportReqInfo;
import com.tencent.grobot.lite.model.req.CreateIMReqInfo;
import com.tencent.grobot.lite.model.req.DetailRecomendReqInfo;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.EventReportInfo;
import com.tencent.grobot.lite.model.req.FilterReqInfo;
import com.tencent.grobot.lite.model.req.FormTemplateDetailReqInfo;
import com.tencent.grobot.lite.model.req.GetCosFederationTokenReqInfo;
import com.tencent.grobot.lite.model.req.GetHotKeywordReqInfo;
import com.tencent.grobot.lite.model.req.GetPackageReqInfo;
import com.tencent.grobot.lite.model.req.HotReqInfo;
import com.tencent.grobot.lite.model.req.InitReqInfo;
import com.tencent.grobot.lite.model.req.LikeRecommendItemReqInfo;
import com.tencent.grobot.lite.model.req.NavigationIndexReqInfo;
import com.tencent.grobot.lite.model.req.NavigationReqInfo;
import com.tencent.grobot.lite.model.req.NewTicketReqInfo;
import com.tencent.grobot.lite.model.req.PullIMMsgReqInfo;
import com.tencent.grobot.lite.model.req.PushIMMsgReqInfo;
import com.tencent.grobot.lite.model.req.QueryGBotLogReqInfo;
import com.tencent.grobot.lite.model.req.QueryTicketDetailReqInfo;
import com.tencent.grobot.lite.model.req.QueryTicketListReqInfo;
import com.tencent.grobot.lite.model.req.RecommendDetailReqInfo;
import com.tencent.grobot.lite.model.req.RecommendNavigationSearchReqInfo;
import com.tencent.grobot.lite.model.req.RecommendsReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class ServerConfig {
    private static Map<Class<? extends ReqInfo>, String> cmdMap = new ConcurrentHashMap();

    static {
        cmdMap.put(InitReqInfo.class, "/xiaoyue.abroad.logic/Init");
        cmdMap.put(AskReqInfo.class, "/xiaoyue.abroad.logic/Ask");
        cmdMap.put(HotReqInfo.class, "/xiaoyue.abroad.logic/Hot");
        cmdMap.put(FilterReqInfo.class, "/xiaoyue.abroad.logic/api/xiaoyue/helper/filter");
        cmdMap.put(FormTemplateDetailReqInfo.class, "/xiaoyue.abroad.logic/FormTemplateDetail");
        cmdMap.put(NewTicketReqInfo.class, "/xiaoyue.abroad.logic/NewTicket");
        cmdMap.put(QueryTicketListReqInfo.class, "/xiaoyue.abroad.logic/QueryTicketList");
        cmdMap.put(QueryTicketDetailReqInfo.class, "/xiaoyue.abroad.logic/QueryTicketDetail");
        cmdMap.put(GetCosFederationTokenReqInfo.class, "/xiaoyue.abroad.logic/GetCosFederationToken");
        cmdMap.put(EvaluateReqInfo.class, "/xiaoyue.abroad.logic/AddEvaluate");
        cmdMap.put(QueryGBotLogReqInfo.class, "/xiaoyue.abroad.logic/QueryGBotLog");
        cmdMap.put(CreateIMReqInfo.class, "/xiaoyue.abroad.im/CreateIm");
        cmdMap.put(CloseIMReqInfo.class, "/xiaoyue.abroad.im/UserCloseIm");
        cmdMap.put(PushIMMsgReqInfo.class, "/xiaoyue.abroad.im/PushImMsg");
        cmdMap.put(PullIMMsgReqInfo.class, "/xiaoyue.abroad.im/PullImMsg");
        cmdMap.put(EventReportInfo.class, "/xiaoyue.abroad.logic/EventReport");
        cmdMap.put(CommonReportReqInfo.class, "/trpc.log.logproxy.LogProxy/SendLogs");
        cmdMap.put(RecommendsReqInfo.class, "/xiaoyue.abroad.logic/RecommendMain");
        cmdMap.put(NavigationReqInfo.class, "/xiaoyue.abroad.logic/RecommendNavigation");
        cmdMap.put(NavigationIndexReqInfo.class, "/xiaoyue.abroad.logic/RecommendNavigationIndex");
        cmdMap.put(DetailRecomendReqInfo.class, "/xiaoyue.abroad.logic/DetailRecommend");
        cmdMap.put(ClearRedPointReqInfo.class, "/xiaoyue.abroad.logic/ClearRedPoint");
        cmdMap.put(GetPackageReqInfo.class, "/xiaoyue.abroad.logic/GetPackage");
        cmdMap.put(RecommendDetailReqInfo.class, "/xiaoyue.abroad.logic/RecommendDetailInfo");
        cmdMap.put(LikeRecommendItemReqInfo.class, "/xiaoyue.abroad.logic/LikeRecommendItem");
        cmdMap.put(RecommendNavigationSearchReqInfo.class, "/xiaoyue.abroad.logic/RecommendNavigationSearch");
        cmdMap.put(GetHotKeywordReqInfo.class, "/xiaoyue.abroad.logic/GetHotKeyword");
    }

    public static String getServerInterface(Class<? extends ReqInfo> cls) {
        return cls != null ? cmdMap.get(cls) : "";
    }

    private static String getServerDomain() {
        return (GRobotApplication.getInstance().getServerKey() == 1 || TLog.isServerDebug()) ? BuildConfig.URL_SERVER_TEST : BuildConfig.URL_SERVER;
    }

    public static String getApiInterface(ReqInfo reqInfo) {
        Class apiInterfaceName = getApiInterfaceName(reqInfo);
        if (apiInterfaceName != null) {
            return getServerDomain() + getServerInterface(apiInterfaceName);
        }
        return getServerDomain();
    }

    public static Class getApiInterfaceName(ReqInfo reqInfo) {
        if (reqInfo != null) {
            return reqInfo.getClass();
        }
        return null;
    }
}
