package org.baeldung.springwebreactive.model;

public class Foo {
	private final Integer id;
	private final String name;

	public Foo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
