package view;

public class MenuUI {

	public void showStartMenu() {
			System.out.println("-------------------- Adivinhar Palavras ---------------");
			System.out.println("1. Jogar");
			System.out.println("2. Ver ranking (Top 5)");
			System.out.println("3. Resetar pontuações");
			System.out.println("4. Restaurar pontuações");
			System.out.println("5. Sair do Jogo");
			System.out.println("------------------------------------------------------");
	}

	public void showDifficultyMenu() {
		System.out.println("-> Escolha a dificuldade:");
		System.out.println("1. Fácil");
		System.out.println("2. Difícil");
	}
}
