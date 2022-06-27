package com.example.coindesk.dao;

import com.example.coindesk.entity.CrytocoinExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrytocoinExchangeRateDao extends JpaRepository<CrytocoinExchangeRate, Integer> {
}
