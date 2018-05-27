package com.slowiak.turek.smoG.repository;

import com.slowiak.turek.smoG.model.HistoricalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalDataRepository extends JpaRepository<HistoricalData, Integer> {
}
