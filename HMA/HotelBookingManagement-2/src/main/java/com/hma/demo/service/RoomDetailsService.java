package com.hma.demo.service;

import java.util.List; 

import com.hma.demo.entity.RoomDetails;

public interface RoomDetailsService {

	public String addRoomDetails(RoomDetails room) throws Exception;
	public String updateRoomDetails(RoomDetails room);
	public String removeRoomDetails(Integer rid);
	public List<RoomDetails> showAllRoomDetails();
	public  RoomDetails showRoomDetails(Integer id);
}
