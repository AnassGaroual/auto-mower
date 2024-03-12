package cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Lawn;
import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.domain.model.Orientation;
import com.mowitnow.automower.domain.model.Position;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MowerOperationSteps {

	private Lawn lawn;
	private Mower mower;

	@Given("the lawn is defined with an upper-right corner at {int} {int}")
	public void the_lawn_is_defined_with_an_upper_right_corner_at(int maxX, int maxY) {
		lawn = new Lawn(maxX, maxY);
	}

	@Given("a mower is initially positioned at {int} {int} facing {word}")
	public void a_mower_is_initially_positioned_at_X_Y_facing(int startX, int startY, String startDirection) {
		Position startPosition = Position.of(startX, startY);
		Orientation orientation = Orientation.valueOf(startDirection);
		mower = new Mower(startPosition, orientation, lawn);
	}

	@When("the mower executes navigation instructions {word}")
	public void the_mower_executes_navigation_instructions(String instructions) {
		List<Command> commands = Arrays.stream(instructions.split("")).map(Command::valueOf)
				.collect(Collectors.toList());
		commands.forEach(command -> mower.executeCommand(command));
	}

	@Then("the mower should finish at {int} {int} facing {word}")
	public void the_mower_should_finish_at_X_Y_facing(int endX, int endY, String endDirection) {
		assertEquals(Position.of(endX, endY), mower.getPosition());
		assertEquals(Orientation.valueOf(endDirection), mower.getOrientation());
	}
}
