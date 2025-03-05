package com.spring.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="guestHouse")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GuestHouse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="guesthouse_id")
	private long guestHouseId;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
    private String location;

    @Column(nullable = true)
    private Integer price;

    @Column(nullable = true)
    private Integer capacity;

    @Column(name = "total_rooms", nullable = true)
    private Integer totalRooms;

    @Column(name = "booked_rooms", nullable = true)
    private Integer bookedRooms;
	
	@Override
	public String toString() {
		return "GuestHouse [id=" + guestHouseId + ", name=" + name + "]";
	}
}
