package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BloodGroup {
	
	O_NEGATIVE("O_NEGATIVE"), O_POSITIVE("O_POSITIVE"),A_NEGATIVE("A_NEGATIVE"),A_POSITIVE("A_POSITIVE"),
	B_NEGATIVE("O_NEGATIVE"), B_POSITIVE("O_POSITIVE"),AB_NEGATIVE("O_NEGATIVE"), AB_POSITIVE("O_POSITIVE");

	private final String bloodGroupType;
}
