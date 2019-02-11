package com.holelin.set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * ClassName: FileOperation
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/11
 */

public class FileOperation {
	public static boolean readFile(String fileName, ArrayList<String> words) {
		if (fileName == null || words == null) {
			System.out.println("FileName is null or words is null");
			return false;
		}
		Scanner scanner;
		try {
			File file = new File(fileName);
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
				scanner.useLocale(Locale.ENGLISH);
			} else {
				return false;
			}
			if (scanner.hasNextLine()) {
				String contents = scanner.useDelimiter("\\A").next();
				int start = firstCharacterIndex(contents, 0);
				for (int i = start + 1; i <= contents.length(); ) {
					if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
						String word = contents.substring(start, i).toLowerCase();
						words.add(word);
						start = firstCharacterIndex(contents, i);
						i = start + 1;
					} else {
						i++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	private static int firstCharacterIndex(String s, int start) {
		for (int i = start; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				return i;
			}
		}
		return s.length();

	}
}
