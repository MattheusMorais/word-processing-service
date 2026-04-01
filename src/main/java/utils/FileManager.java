package utils;

import exceptions.DbException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável pela leitura de arquivos do sistema.
 */
public class FileManager {

	/**
	 * Lê o arquivo de palavras e retorna uma lista.
	 *
	 * @return lista de palavras
	 * @throws RuntimeException se ocorrer erro ao ler o arquivo
	 */
	public List<String> readWordBank() {
		InputStream words = getClass()
				.getClassLoader()
				.getResourceAsStream("wordBank/animals.txt");

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
		}
		catch (IOException e) {
            throw new RuntimeException("Erro ao ler do arquivo: " + e.getMessage());
        }
    }
}
