package com.some.playgraund.service;

import com.some.playgraund.model.PlaySite;
import com.some.playgraund.repository.PlaySiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaySiteServiceImp implements PlaySiteService {

    @Autowired
    PlaySiteRepository playSiteRepository;

    @Override
    public PlaySite addPlaySite(PlaySite playSite) {
        return playSiteRepository.save(playSite);
    }

    @Override
    public PlaySite updatePlaySite(PlaySite playSite) {
        return playSiteRepository.save(playSite);
    }

    @Override
    public void deletePlaySite(long playSiteId) {
        playSiteRepository.deleteById(playSiteId);
    }

    @Override
    public List<PlaySite> getPlaySiteByName(String playSiteName) {
        return playSiteRepository.findByName(playSiteName);
    }

    @Override
    public List<PlaySite> listPlaySite() {
        return playSiteRepository.findAll();
    }
}
