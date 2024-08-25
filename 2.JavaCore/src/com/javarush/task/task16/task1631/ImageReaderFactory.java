package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
	public static ImageReader getImageReader(ImageTypes imageTypes) {

		if (imageTypes == ImageTypes.BMP) {
			return new BmpReader();
		} else if (imageTypes == ImageTypes.PNG) {
			return new PngReader();
		} else if (imageTypes == ImageTypes.JPG) {
			return new JpgReader();
		} else
			throw new IllegalArgumentException("Неизвестный тип картинки");
	}
}
