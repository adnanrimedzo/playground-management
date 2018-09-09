package com.some.playgraund.controller;

import com.some.playgraund.model.PlaySite;
import com.some.playgraund.model.Player;
import com.some.playgraund.model.SnapShot;
import com.some.playgraund.service.PlayGraundService;
import com.some.playgraund.service.PlaySiteService;
import com.some.playgraund.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("playgraund")
public class PlaygraundController {

    @Autowired
    PlayGraundService playGraundService;

    @Autowired
    PlaySiteService playSiteService;

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/addplayertosite", method = RequestMethod.POST)
    public boolean addPlayerToPlaySite(@RequestParam(value = "playerId", required = true) long playerId,
                                       @RequestParam(value = "waitIsOK", required = true) boolean waitIsOK,
                                       @RequestParam(value = "isVip", required = true) boolean isVip) {
        return playGraundService.addPlayerToPlaySite(playerId, waitIsOK, isVip);
    }

    @RequestMapping(value = "/removeplayerfromsite", method = RequestMethod.POST)
    public boolean removePlayerToPlaySite(@RequestParam(value = "playerId", required = true) long playerId,
                                          @RequestParam(value = "playSiteName", required = true) String playSiteName) {
        return playGraundService.removePlayerFormPlaySite(playerId, playSiteName);
    }

    @RequestMapping(value = "/setsnapshotperiod", method = RequestMethod.POST)
    public boolean setSnapShotPeriod(@RequestParam(value = "ms", required = true) long ms) {
        playGraundService.setSnapShotPeriod(ms);
        return true;
    }

    @RequestMapping(value = "/getsnapshost", method = RequestMethod.POST)
    public List<SnapShot> getSnapHost(@RequestParam(value = "day", required = true) Date day) {
        return playGraundService.getSnapHost(day);
    }

    @RequestMapping(value = "/startplaygraund", method = RequestMethod.POST)
    public boolean startPlayGraund(@RequestParam(value = "ms", required = true) Long ms) {
        playGraundService.startPlayGraund(ms);
        return true;
    }

    @RequestMapping(value = "/getvisitorrecord", method = RequestMethod.POST)
    public Map<Long, Long> getVisitorRecordReportForDay(@RequestParam(value = "day", required = true) Date day) {
        return playGraundService.getVisitorRecordReportForDay(day);
    }

    @RequestMapping(value = "/getutilisationreport", method = RequestMethod.POST)
    public Map<Long, Long> getUtilisationReportForDay(@RequestParam(value = "day", required = true) Date day) {
        return playGraundService.getUtilisationReportForDay(day);
    }

    @RequestMapping(value = "/addplaysite", method = RequestMethod.POST)
    public PlaySite addPlaySite(@RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "playerCapacity", required = true) int playerCapacity,
                                @RequestParam(value = "queCapacity", required = true) int queCapacity) {

        PlaySite playSite = new PlaySite();
        playSite.setName(name);
        playSite.setPlayerCapacity(playerCapacity);
        playSite.setQueCapacity(queCapacity);

        return playSiteService.addPlaySite(playSite);
    }

    @RequestMapping(value = "/deleteplaysite", method = RequestMethod.POST)
    public boolean deletePlaySite(@RequestParam(value = "name", required = true) Long playSiteid) {
        playSiteService.deletePlaySite(playSiteid);
        return true;
    }

    @RequestMapping(value = "/getplaysite", method = RequestMethod.POST)
    public List<PlaySite> getPlaySiteByName(@RequestParam(value = "name", required = true) String playSiteName) {
        return playSiteService.getPlaySiteByName(playSiteName);
    }

    @RequestMapping(value = "/listplaysite", method = RequestMethod.POST)
    public List<PlaySite> listPlaySite() {
        return playSiteService.listPlaySite();
    }

    @RequestMapping(value = "/addplayer", method = RequestMethod.POST)
    public Player addplayer(@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "age", required = true) int age,
                               @RequestParam(value = "ticketPlaySiteName", required = true) String ticketPlaySiteName) {
        Player player = new Player();
        player.setAge(age);
        player.setName(name);
        player.setTicketPlaySiteName(ticketPlaySiteName);

        return playerService.addPlayer(player);
    }

    @RequestMapping(value = "/deleteplayer", method = RequestMethod.POST)
    public boolean deleteplayer(@RequestParam(value = "playerId", required = true) long playerId) {
        playerService.deletePlayer(playerId);
        return true;
    }

    @RequestMapping(value = "/gethistory", method = RequestMethod.POST)
    public List<Player> getPlayerHistoryByName(@RequestParam(value = "name", required = true) String  name) {
        return playerService.getPlayerHistoryByName(name);
    }

}
