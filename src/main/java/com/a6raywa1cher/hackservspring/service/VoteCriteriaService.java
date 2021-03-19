package com.a6raywa1cher.hackservspring.service;
import com.a6raywa1cher.hackservspring.model.VoteCriteria;
import com.a6raywa1cher.hackservspring.service.dto.VoteCriteriaInfo;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface VoteCriteriaService {
    VoteCriteria create(String criteriaName, int maxValue);
    Optional<VoteCriteria> getById(Long id);
    Stream<VoteCriteria> getById(Collection<Long> ids);
    Stream<VoteCriteria> getAllCriterias();
    VoteCriteria editCriteria(VoteCriteria criteria, String criteriaName, int maxValue);
    VoteCriteria editCriteriaInfo(VoteCriteria criteria, VoteCriteriaInfo criteriaInfo);
    void deleteCriteria(VoteCriteria criteria);
}
