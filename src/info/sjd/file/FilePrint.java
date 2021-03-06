package info.sjd.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import info.sjd.exceptions.MyException;

public class FilePrint {
	
	public static void printFileToConsole(Path filePath) {
		try {
			List<String> fileStrings = Files.readAllLines(filePath);
			for(String nextLine: fileStrings) {
				System.out.println(nextLine);
			}
		} catch (IOException e) {
			throw new MyException(e.getMessage());
		}
	}
}
