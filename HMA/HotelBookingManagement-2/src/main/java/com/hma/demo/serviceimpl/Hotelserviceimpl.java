package com.hma.demo.serviceimpl;

import java.util.List;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hma.demo.entity.Hotel;
import com.hma.demo.exception.DetailsNotFoundException;
import com.hma.demo.repository.HotelRepository;
import com.hma.demo.service.hotelservice;


@Service
public class Hotelserviceimpl implements hotelservice {
	@Autowired
	private HotelRepository hrepo;

	@Override
	public List<Hotel> getHotels() throws DetailsNotFoundException{
		List<Hotel> list = hrepo.findAll();
		if(list.isEmpty())
			throw new DetailsNotFoundException("Hotel details are not found");
		return list;
	}


	@Override
	public Hotel gethotel(int id) throws DetailsNotFoundException{
		if(hrepo.findById(id).isPresent()) {
			Hotel h = hrepo.getById(id);
			return h;
		}
		else
			throw new DetailsNotFoundException("Hotel details are not found");
	}


	@Override
	public Hotel addhotel(Hotel h) throws Exception{
		try{hrepo.save(h);
		return h;
		}catch (Exception e) {
			throw new Exception("Details are mismatched");
		}
	}


	@Override
	public Hotel updatehotel(Hotel ht) throws DetailsNotFoundException{
		if(hrepo.findById(ht.getHotel_id()).isPresent()) {
			Hotel h = hrepo.getById(ht.getHotel_id());
			h.setHotel_name(ht.getHotel_name());
			h.setAddress(ht.getAddress());
			h.setAvg_rate_per_day(ht.getAvg_rate_per_day());
			h.setCity(ht.getCity());
			h.setDescription(ht.getDescription());
			h.setEmail(ht.getEmail());
			h.setPhone1(ht.getPhone1());
			h.setPhone2(ht.getPhone2());
			h.setWebsite(ht.getWebsite());
			hrepo.save(h);
			return h;
		}
		else
			throw new DetailsNotFoundException("Hotel details are not found");
	}


	@Override
	public String deletehotel(int hid) throws DetailsNotFoundException{
		if(hrepo.findById(hid).isPresent()) {
			Hotel h = hrepo.getById(hid);
			hrepo.deleteById(hid);
			return "Hotel details are deleted";
		}
		else
			throw new DetailsNotFoundException("Hotel details are not found");
	}

}
