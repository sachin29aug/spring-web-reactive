package org.baeldung.springwebreactive.controller;

import java.time.Duration;
import java.util.stream.Stream;

import org.apache.commons.lang.RandomStringUtils;
import org.baeldung.springwebreactive.model.Foo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RestController
public class ReactiveFooController {

	@GetMapping(value = "/foos", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Foo> streamAllFoos() {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		Flux<Foo> fooFlux = Flux
				.fromStream(Stream.generate(() -> new Foo(Integer.valueOf(RandomStringUtils.randomNumeric(6)),
						RandomStringUtils.randomAlphabetic(10))));
		return Flux.zip(interval, fooFlux).map(Tuple2::getT2);
	}
}