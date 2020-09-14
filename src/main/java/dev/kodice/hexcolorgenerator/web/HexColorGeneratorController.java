package dev.kodice.hexcolorgenerator.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.kodice.hexcolorgenerator.services.RandomColorsPack;
import models.dto.RandomColorsResponse;

@RestController
@RequestMapping(path = "/random")
public class HexColorGeneratorController {

	@Autowired
	private RandomColorsPack randomColorsPack;

	@GetMapping
	public RandomColorsResponse defaultHexColor(@RequestParam(defaultValue = "1") int nColors,
			@RequestParam(defaultValue = "28") int seed) {
		List<String> colors = this.randomColorsPack.colorsArray(nColors, seed);
		RandomColorsResponse response = new RandomColorsResponse(colors, seed);
		return response;
	}

}
