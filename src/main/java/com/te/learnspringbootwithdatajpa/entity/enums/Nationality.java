package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Nationality {
	INDIAN("INDIA"), CHINA("CHINA"),RUSSIA("RUSSIA"),SRILANKA("SRILANKA");
	
	private final String nation;

}