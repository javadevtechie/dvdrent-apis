package com.dvd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvd.model.Actor;
import com.dvd.service.ActorService;

@RestController
@RequestMapping("movies")
public class ActorController {

	@Autowired
	private ActorService actorService;

	@GetMapping("/get/actors")
	public List<Actor> getAllActors() {
		return actorService.getAllActors();
	}

}
