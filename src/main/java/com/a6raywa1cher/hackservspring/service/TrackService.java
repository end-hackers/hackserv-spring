package com.a6raywa1cher.hackservspring.service;

import com.a6raywa1cher.hackservspring.model.Team;
import com.a6raywa1cher.hackservspring.model.Track;
import com.a6raywa1cher.hackservspring.model.VoteCriteria;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface TrackService {
    Track create(String trackName);
    Optional<Track> getById(Long id);
    Stream<Track> getById(Collection<Long> ids);
    Track editTrack(Track track, String trackName, List<VoteCriteria> criteriaList, List<Team> teams);
    Stream<Track> getAllTracks();
    void delete(Track track);
}
