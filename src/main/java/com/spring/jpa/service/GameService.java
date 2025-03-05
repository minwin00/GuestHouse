package com.spring.jpa.service;

import java.util.List;

public interface GameService {
	List<String> generateShuffledNames(String originalName);
	
}
