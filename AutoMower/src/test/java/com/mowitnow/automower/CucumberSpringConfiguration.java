package com.mowitnow.automower;

import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = AutoMowerApplication.class)
public class CucumberSpringConfiguration {
}
