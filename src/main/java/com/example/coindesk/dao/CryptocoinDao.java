package com.example.coindesk.dao;

import com.example.coindesk.entity.Cryptocoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocoinDao extends JpaRepository<Cryptocoin, Integer> {
//      Integer insertCryptocoin(Cryptocoin cryptocoin);

}
