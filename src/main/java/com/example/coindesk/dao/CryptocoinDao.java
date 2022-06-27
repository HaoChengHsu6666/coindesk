package com.example.coindesk.dao;

import com.example.coindesk.entity.Cryptocoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocoinDao extends JpaRepository<Cryptocoin, Integer>{

//    @Modifying
//    @Query("UPDATE Cryptocoin SET name = :name, code = :code WHERE id = :id")
//    int updateCryptocoin(@Param("id") int id, @Param("name") String name, @Param("code") String code);

}
