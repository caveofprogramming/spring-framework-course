package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * Dummy implementation of logger.
 */

public class Logger {

	// @Autowired - can autowire properties themselves; don't even need the set
	// methods!
	private ConsoleWriter consoleWriter;

	// @Autowired -- uncomment this if you want to autowire directly rather
	// than via the set method.
	private FileWriter fileWriter;

	/* Can autowire constructors, and you can even mix autowiring constructors
	 * with autowiring properties, directly or via set methods.
	@Autowired
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}
	*/

	/*
	 * Note, the names of the set methods don't matter; this autowiring works
	 * purely by type. As always, there must be no ambiguity! There must be one
	 * and only one autowire candidate bean for each property that you're autowiring.
	 */
	
	@Autowired
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	@Autowired
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}

}
