package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Degree {
	BE_CSE("BE_CSE"), BE_NON_CSE("BE_CSE"),PG("PG"),PHD("PHD");
	
	private final String degreeType;

}
