package com.helpshift.migration.legacyUser;

import com.helpshift.account.dao.ProfileDTO;
import java.util.List;

/* loaded from: classes2.dex */
public interface LegacyProfileDAO {
    void deleteProfiles();

    List<ProfileDTO> fetchProfiles();
}
