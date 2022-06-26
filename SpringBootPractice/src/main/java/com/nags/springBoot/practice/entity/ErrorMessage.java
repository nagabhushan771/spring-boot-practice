package com.nags.springBoot.practice.entity;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	private HttpStatus status;
	private String messageString;
}
