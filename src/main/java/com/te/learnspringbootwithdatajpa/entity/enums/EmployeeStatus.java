package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmployeeStatus {
	
	ABSCONDED("ABSCONDED"), TERMINATED("TERMINATED"), ACTIVE("ACTIVE"),INACTIVE("INACTIVE");
	
    private final String status;
}
