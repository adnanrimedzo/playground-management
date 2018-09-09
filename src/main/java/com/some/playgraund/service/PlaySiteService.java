package com.some.playgraund.service;

import com.some.playgraund.model.PlaySite;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlaySiteService {

    PlaySite addPlaySite(PlaySite playSite);
    PlaySite updatePlaySite(PlaySite playSite);
    void deletePlaySite(long playSiteId);
    List<PlaySite> getPlaySiteByName(String playSiteName);
    List<PlaySite> listPlaySite();

}
