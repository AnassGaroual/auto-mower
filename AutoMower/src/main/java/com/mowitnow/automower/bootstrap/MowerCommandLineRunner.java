package com.mowitnow.automower.bootstrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mowitnow.automower.adapter.in.FileInputAdapter;
import com.mowitnow.automower.domain.model.Mower;

@Component
public class MowerCommandLineRunner implements CommandLineRunner {

	private final FileInputAdapter fileInputAdapter;
	@Value("${mower.instructions.file}")
	String filePath;

	public MowerCommandLineRunner(FileInputAdapter fileInputAdapter) {
		this.fileInputAdapter = fileInputAdapter;
	}

	@Override
	public void run(String... args) throws Exception {
		List<Mower> mowers = fileInputAdapter.processFile(filePath);
		mowers.forEach(mower -> System.out.println(mower.getPosition().getX() + " " + mower.getPosition().getY() + " "
				+ mower.getOrientation().toString()));
	}
}
