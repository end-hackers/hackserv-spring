package com.a6raywa1cher.hackservspring.rest.req;

import com.a6raywa1cher.hackservspring.utils.jackson.HtmlEscape;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
public class PutVoteCriteriaInfoRequest {
	@NotBlank
	@HtmlEscape
	private String name;

	@PositiveOrZero
	private int maxValue;

	@HtmlEscape
	private String description;
}
