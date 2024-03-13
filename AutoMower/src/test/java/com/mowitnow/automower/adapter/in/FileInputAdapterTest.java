package com.mowitnow.automower.adapter.in;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mowitnow.automower.domain.model.Lawn;
import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.domain.model.Orientation;
import com.mowitnow.automower.domain.model.Position;
import com.mowitnow.automower.port.in.MowerControlPort;

class FileInputAdapterTest {

	private MowerControlPort mowerControlPort;
	private FileInputAdapter fileInputAdapter;

	@BeforeEach
	void setUp() {
		mowerControlPort = mock(MowerControlPort.class);
		fileInputAdapter = new FileInputAdapter(mowerControlPort);
	}

	@Test
	void processFile_shouldProcessMowersCorrectly() throws Exception {
		Mower expectedMower = new Mower(Position.of(0, 0), Orientation.N, new Lawn(5, 5));
		when(mowerControlPort.processMowerInstructions(anyInt(), anyInt(), anyInt(), anyInt(), anyString(), anyList()))
				.thenReturn(expectedMower);

		List<Mower> resultMowers = fileInputAdapter.processFile("testFile.txt");
		verify(mowerControlPort, times(2)).processMowerInstructions(anyInt(), anyInt(), anyInt(), anyInt(), anyString(),
				anyList());
		assertTrue(resultMowers.size() == 2);
	}
}
