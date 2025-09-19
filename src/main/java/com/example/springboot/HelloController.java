package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HelloController {

	@GetMapping("/getBet")
	public String index() {
		return getBet();
	}

	@GetMapping("/getChispazo")
	public String getChispazo() {
		return getChizpazoNumbers();
	}

	private String getBet() {
		int progol = 14, rematch = 7;
		StringBuffer bet = new StringBuffer("Progol\n");
		getResultsFor(progol, bet);
		bet.append("\n").append("\n").append("Revanchal").append("\n");
		System.out.println();
		getResultsFor(rematch, bet);
		return bet.toString();
	}

	private void getResultsFor(int gamesInt, StringBuffer bet) {
		int min = 1, max = 4;
		for(int i =0; i < gamesInt; i++) {
			bet.append((i + 1)).append(" ").append(castIntToRes(getRandomInt(min, max))).append("\n");
		}
	}

	private String castIntToRes(int intNum) {
		if(intNum == 1) {
			return "LOCAL";
		} else if(intNum == 2) {
			return "EMPATE";
		} else {
			return "VISITA";
		}
	}

	private String getChizpazoNumbers() {
		int min = 1, max = 28;
		Map<Integer,Integer> chizpazoNumbers = new HashMap<>();
		addDifferentNumbers(chizpazoNumbers, min, max);
		List<Integer> chizpazoNumbersList = new ArrayList<>(chizpazoNumbers.values());
		Collections.sort(chizpazoNumbersList);
		return chizpazoNumbersList.toString();
	}

	private void addDifferentNumbers(Map<Integer,Integer> chizpazoNumbers, int min, int max) {
		while(chizpazoNumbers.size() < 5) {
			int currentNumber = getRandomInt(min, max);
			if(chizpazoNumbers.containsKey(currentNumber)) {
				addDifferentNumbers(chizpazoNumbers, min, max);
			} else {
				chizpazoNumbers.put(currentNumber, currentNumber);
			}
		}
	}

	private int getRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
