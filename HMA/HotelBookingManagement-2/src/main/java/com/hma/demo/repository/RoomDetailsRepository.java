package com.hma.demo.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hma.demo.entity.RoomDetails;



@Repository
public interface RoomDetailsRepository extends JpaRepository<RoomDetails,Integer> {
//List<RoomDetailsEntity> findByRatePerDay(Double rate);
//List<RoomDetailsEntity> findByIsAvailableAndRatePerDay(Boolean available,Double rate);
}
