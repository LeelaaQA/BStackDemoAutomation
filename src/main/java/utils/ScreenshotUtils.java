package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String testName) {

		try {

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			Path destination = Path.of("test-output/screenshots/" + testName + ".png");

			Files.createDirectories(destination.getParent());

			Files.copy(source.toPath(), destination);

			return destination.toString();

		} catch (IOException e) {

			e.printStackTrace();

			return null;
		}
	}
}