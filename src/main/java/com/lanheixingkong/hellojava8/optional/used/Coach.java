package com.lanheixingkong.hellojava8.optional.used;

import java.util.Optional;

import lombok.Data;

@Data
public class Coach {

	private String name;
	private Optional<Assistant> assistant; 
}
