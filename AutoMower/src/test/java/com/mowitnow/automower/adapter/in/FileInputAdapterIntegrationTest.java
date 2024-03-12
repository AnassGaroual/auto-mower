package com.mowitnow.automower.adapter.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.domain.model.Orientation;
import com.mowitnow.automower.domain.model.Position;

@SpringBootTest
class FileInputAdapterIntegrationTest {

	@Autowired
	private FileInputAdapter fileInputAdapter;

	@Test
	void processFile_integrationWithActualService() throws Exception {

		// Given & When
		List<Mower> resultMowers = fileInputAdapter.processFile("testFile.txt");

		// Then
		assertTrue(resultMowers.size() == 2);
		assertThat(resultMowers.get(0).getOrientation().equals(Orientation.N));
		assertThat(resultMowers.get(0).getPosition().equals(Position.of(1, 3)));
		assertThat(resultMowers.get(1).getOrientation().equals(Orientation.E));
		assertThat(resultMowers.get(1).getPosition().equals(Position.of(5, 1)));

	}
}
