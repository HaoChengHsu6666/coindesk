package com.example.coindesk.dao;

import com.example.coindesk.entity.Cryptocoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocoinDao extends JpaRepository<Cryptocoin, Integer>{

      Cryptocoin getCoinById(Integer id);

//    @Modifying
//    @Query("UPDATE Cryptocoin SET name = :name, code = :code WHERE id = :id")
//    int updateCryptocoin(@Param("id") int id, @Param("name") String name, @Param("code") String code);

}
