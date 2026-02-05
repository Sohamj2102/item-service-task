package com.item.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

	private Long id;
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Description is required")
	private String description;
	@NotNull
	@Min(value=1,message = "Price must be greater than 0")
	private Double price;
	@Default
	@Min(value=0)
	private Integer quantity=0;
	
}
