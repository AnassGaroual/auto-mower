package com.mowitnow.automower.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MowerOperationSteps {

	@Given("the lawn is defined with an upper-right corner at {int} {int}")
	public void the_lawn_is_defined_with_an_upper_right_corner_at(int maxX, int maxY) {
		throw new io.cucumber.java.PendingException();
	}

	@Given("a mower is initially positioned at {int} {int} facing {string}")
	public void a_mower_is_initially_positioned_at_facing(int startX, int startY, String startDirection) {
		throw new io.cucumber.java.PendingException();
	}

	@When("the mower executes navigation instructions {string}")
	public void the_mower_executes_navigation_instructions(String instructions) {
		throw new io.cucumber.java.PendingException();
	}

	@Then("the mower should finish at {int} {int} facing {string}")
	public void the_mower_should_finish_at_facing(int endX, int endY, String endDirection) {
		throw new io.cucumber.java.PendingException();
	}
}
