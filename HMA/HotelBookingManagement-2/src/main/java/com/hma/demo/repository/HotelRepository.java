package com.hma.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hma.demo.entity.Hotel; 


public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
