package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AddressType {
	PERMANANT("PERMANANT"),TEMPORARY("TEMPORARY");
	
	private final String addressType;

}
