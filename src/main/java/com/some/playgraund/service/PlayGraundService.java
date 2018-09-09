package com.some.playgraund.service;

import com.some.playgraund.model.SnapShot;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PlayGraundService {

    Boolean addPlayerToPlaySite(long playerId, boolean waitIsOK, boolean isVip);

    Boolean removePlayerFormPlaySite(long playerId, String playSiteName);

    void setSnapShotPeriod(long ms);

    List<SnapShot> getSnapHost(Date day);

    void startPlayGraund(long ms);

    Map<Long, Long> getVisitorRecordReportForDay(Date date);

    Map<Long, Long> getUtilisationReportForDay(Date date);
}
