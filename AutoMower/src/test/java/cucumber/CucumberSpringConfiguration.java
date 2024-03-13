package cucumber;

import org.springframework.boot.test.context.SpringBootTest;

import com.mowitnow.automower.AutoMowerApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = AutoMowerApplication.class)
public class CucumberSpringConfiguration {
}
