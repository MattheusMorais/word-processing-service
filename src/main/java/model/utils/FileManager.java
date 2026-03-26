package model.utils;

import model.exceptions.DbException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {


	public List<String> readWordBank() {
		InputStream words = getClass().getClassLoader().getResourceAsStream("wordBank/animals.txt");

		if (words == null) {
			throw new DbException("Arquivo não encontrado.");
		}

		try (BufferedReader myWords = new BufferedReader(new InputStreamReader(words))) {
			final List<String> wordList = new ArrayList<>();

			String word = "";
			while((word = myWords.readLine()) != null) {
				wordList.add(word.trim().toLowerCase());
			}
			return wordList;
		} catch (IOException e) {
            throw new RuntimeException("Erro ao ler do arquivo: " + e.getMessage());
        }
    }
}
