package view;

public class MenuUI {

	public void showStartMenu() { // Do not pass scanner as parameter
			System.out.println("-------------------- Advinhar Palavras ---------------");
			System.out.println("1. Jogar");
			System.out.println("2. Sair do Jogo");
			System.out.println("------------------------------------------------------");
	}

	public void showDifficultyMenu() {
		System.out.println("-> Escolha a dificuldade:");
		System.out.println("1. Fácil");
		System.out.println("2. Difícil");
	}
}
