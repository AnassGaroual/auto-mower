package com.mowitnow.automower.adapter.in;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.port.in.MowerControlPort;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FileInputAdapter {

	private final MowerControlPort mowerControlPort;

	public List<Mower> processFile(String filePath) throws Exception {
		try (var resource = new ClassPathResource(filePath).getInputStream();
				var reader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
			var lines = reader.lines().collect(Collectors.toList());
			var mowers = new ArrayList<Mower>();

			var lawnDimensions = lines.get(0).split(" ");
			var lawnWidth = Integer.parseInt(lawnDimensions[0]);
			var lawnHeight = Integer.parseInt(lawnDimensions[1]);

			for (int i = 1; i < lines.size(); i += 2) {
				var posAndOri = lines.get(i).split(" ");
				var initialX = Integer.parseInt(posAndOri[0]);
				var initialY = Integer.parseInt(posAndOri[1]);
				var orientation = posAndOri[2];
				var commands = Arrays.stream(lines.get(i + 1).split("")).map(Command::valueOf)
						.collect(Collectors.toList());

				var mower = mowerControlPort.processMowerInstructions(lawnWidth, lawnHeight, initialX, initialY,
						orientation, commands);
				mowers.add(mower);
			}
			return mowers;
		}
	}
}
