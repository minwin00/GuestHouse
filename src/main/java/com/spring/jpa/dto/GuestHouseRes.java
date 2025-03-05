package com.spring.jpa.dto;

import java.util.List;

import com.spring.jpa.entity.GuestHouse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GuestHouseRes {
	private Long id;
	private String name;
	private String location;
	private Integer price;
	private Integer capacity;
	private Integer totalRooms;
	private Integer bookedRooms;
	
	public GuestHouseRes(GuestHouse guestHouse) {
		id = guestHouse.getGuestHouseId();
		name = guestHouse.getName();
		location = guestHouse.getLocation();
		price = guestHouse.getPrice();
		capacity = guestHouse.getCapacity();
		totalRooms = guestHouse.getTotalRooms();
		bookedRooms = guestHouse.getBookedRooms();
	}
}
