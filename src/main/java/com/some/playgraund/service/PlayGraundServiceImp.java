package com.some.playgraund.service;

import com.some.playgraund.model.Play;
import com.some.playgraund.model.PlaySite;
import com.some.playgraund.model.Player;
import com.some.playgraund.model.SnapShot;
import com.some.playgraund.repository.PlayRepository;
import com.some.playgraund.repository.SnapShotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayGraundServiceImp implements PlayGraundService {

    @Autowired
    PlaySiteService playSiteService;

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayRepository playRepository;

    @Autowired
    SnapShotRepository snapShotRepository;

    @Override
    public Boolean addPlayerToPlaySite(long playerId, boolean waitIsOK, boolean isVip) {

        Player player = playerService.getPlayer(playerId);
        List<PlaySite> playSiteList = playSiteService.getPlaySiteByName(player.getTicketPlaySiteName());

        if (playSiteList == null)
            return false;

        PlaySite minQuePlaySite = playSiteList
                .stream()
                .min(Comparator.comparing(PlaySite::getQueSize))
                .orElseThrow(NoSuchElementException::new);

        if (minQuePlaySite.getPlayerCapacity() >= minQuePlaySite.getQueSize()) {
            return false;
        } else {
            if (waitIsOK) {
                minQuePlaySite.getWaitingQue().add(playerId);
                playSiteService.updatePlaySite(minQuePlaySite);
                return true;
            } else if (isVip) {
                addVipPlayerToPlaySite(playerId, minQuePlaySite);
                return true;
            } else {
                if (minQuePlaySite.getWaitingQue().size() == 0) {
                    playSiteService.updatePlaySite(minQuePlaySite);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    private void addVipPlayerToPlaySite(long playerId, PlaySite minQuePlaySite) {
        minQuePlaySite.getWaitingQue().add(playerId);
    }

    @Override
    public Boolean removePlayerFormPlaySite(long playerId, String playSiteName) {
        List<PlaySite> playSiteList = playSiteService.getPlaySiteByName(playSiteName);
        playSiteList.stream().forEach(p -> p.getWaitingQue().remove(playerId));
        return true;
    }

    @Override
    public void setSnapShotPeriod(long ms) {
        TimerTask task = new TimerTask() {
            public void run() {
                takeSnapShot();
            }
        };

        Timer timer = new Timer("Timer");

        long delay = ms;
        timer.schedule(task, delay);
    }

    @Override
    public List<SnapShot> getSnapHost(Date day) {
        return snapShotRepository.findAllBySnapShotTime(day);
    }

    @Override
    public void startPlayGraund(long ms) {
        TimerTask task = new TimerTask() {
            public void run() {
                executePlays();
            }
        };

        Timer timer = new Timer("Timer");

        long delay = ms;
        timer.schedule(task, delay);
    }

    @Override
    public Map<Long, Long> getVisitorRecordReportForDay(Date date) {
        List<Play> record = playRepository.findAllByPlayTime(date);
        Map<Long, Long> report = new HashMap<>();

        record.stream().forEach(p -> {
            report.put(p.getPlayerId(), playRepository.countAllByPlayerSiteIdAndPlayTime(p.getPlayerSiteId(), date));
        });

        return report;

    }

    @Override
    public Map<Long, Long> getUtilisationReportForDay(Date date) {
        return null;
    }

    private void executePlays() {
        List<PlaySite> playSites = playSiteService.listPlaySite();
        playSites.stream().forEach(p -> {
            Queue<Long> waitingQue = p.getWaitingQue();
            for (int i = 0; i < p.getPlayerCapacity(); i++) {
                if (waitingQue.size() > 0) {
                    Play play = new Play(waitingQue.poll(), p.getId(), new Date());
                    playRepository.save(play);
                }
            }

        });
    }

    private void takeSnapShot() {
        List<PlaySite> playSiteList = playSiteService.listPlaySite();
        snapShotRepository.save(new SnapShot(playSiteList, new Date()));
    }


}
