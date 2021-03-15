package com.udacity.jdnd.course3.data.dao;

import com.udacity.jdnd.course3.data.CandyData;

import java.util.List;

public interface CandyDAO {
    List<CandyData> getAllCandies();
    void addToDelivery(Long candyId, Long deliveryId);
    List<CandyData> getAllCandiesForDelivery(Long deliveryId);
}
