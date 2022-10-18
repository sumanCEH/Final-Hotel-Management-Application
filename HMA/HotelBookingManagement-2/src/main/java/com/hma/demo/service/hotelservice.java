package com.hma.demo.service;



import java.util.List; 

import com.hma.demo.entity.Hotel;




public interface hotelservice  {

	

	public List<Hotel> getHotels();

	public Hotel gethotel(int id) ;

	public Hotel addhotel(Hotel htl) throws Exception;

	public Hotel updatehotel(Hotel ht);

	public String deletehotel(int parseInt);
	


}
