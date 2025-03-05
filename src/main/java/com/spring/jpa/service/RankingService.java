package com.spring.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring.jpa.dto.RankingReq;
import com.spring.jpa.dto.RankingRes;
import com.spring.jpa.entity.Ranking;
import com.spring.jpa.repository.RankingRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingService {
	final RankingRepository rankingRepository;
	
//	Ranking 저장하기
	@Transactional
	public Ranking addRanking(RankingReq rankingReq) {
		System.out.println("RankingReq==>"+rankingReq);
		
		Ranking ranking=rankingReq.toRanking(rankingReq); //DTO--> Entity로 변경
		
		System.out.println("toBoard==>"+ranking);
		
		//save 하고나서 다시 Entity를 반환한다..
		return rankingRepository.save(ranking);
	}
	
	// findByUserId
	public List<RankingRes> findByUserId(Long id) throws Exception{
		List<Ranking> list = rankingRepository.findByUser_UserId(id);
//		if(list==null || list.isEmpty())
//			throw new BoardSearchNotException("Title - getBoards 에러", "Message - 특정 회원이 작성한 글 없습니다.");
		return list.stream().map(RankingRes::new).collect(Collectors.toList());
	}
	
	// findTop3UsersByGuestHouseId
	public List<RankingRes> findTop3UsersByGuestHouseId(Long guestHouseId) throws Exception {
	    List<Ranking> rankingList = rankingRepository.findTop3UsersByGuestHouseId(guestHouseId);
	    return rankingList.stream()
	                      .map(RankingRes::new)
	                      .collect(Collectors.toList());
	}
	
	//deleteAllRankings()
	@Transactional
	public String deleteAllRankings() throws Exception{
		rankingRepository.deleteAllRankings();
		return "Deleted All Rankings";
	}
	
}


