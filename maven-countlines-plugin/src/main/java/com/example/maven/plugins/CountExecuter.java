
package com.example.maven.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class CountExecuter {

	private File directory;

	private String[] extensions;

	public CountExecuter(File directory, String[] extensions) {
		this.directory = directory;
		this.extensions = extensions;
	}

	@SuppressWarnings("unchecked")
	public void count() throws IOException {

		Collection<File> files = FileUtils.listFiles(directory, extensions,true);
		int count = 0;
		int cnt = 0;
		if ((files != null) && (!files.isEmpty())) {
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
				cnt++;
				count += countLines(f);
			}
		}
		System.out.println("count"+cnt);
		System.out.println("Total Linenumber is " + count + " .");
		System.out.println("directory " + directory.getPath());
		System.out.println("hello");
		System.out.println("aaaa");
		System.out.println("bbb");
		System.out.println("cccc");
		System.out.println("dddd");
		System.out.println("hhh");
		System.out.println()
		System.out.println("1103");
		
		
		System.out.println("0932");
		System.out.println("0946");
		System.out.println("0947");
		System.out.println("0958");
		System.out.println("1027");
		System.out.println("1029");
		System.out.println("1606");
	}

	private int countLines(File file) throws IOException {
		int linenum = 0;

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			@SuppressWarnings("unused")
			String line = null;
			while ((line = br.readLine()) != null) {
				linenum++;
			}
		} finally {
			IOUtils.closeQuietly(br);
			IOUtils.closeQuietly(fr);
		}
		return linenum;
	}
}
