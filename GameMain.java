import java.util.Scanner;

public class GameMain {

	private static Card[][] card = new Card[4][4];
	
	public static void main(String[] args) {
		
		
		
		card[0][0] = new Card('E');
		card[0][1] = new Card('A');
		card[0][2] = new Card('B');
		card[0][3] = new Card('F');
		card[1][0] = new Card('G');
		card[1][1] = new Card('A');
		card[1][2] = new Card('D');
		card[1][3] = new Card('H');
		card[2][0] = new Card('F');
		card[2][1] = new Card('C');
		card[2][2] = new Card('D');
		card[2][3] = new Card('H');
		card[3][0] = new Card('E');
		card[3][1] = new Card('G');
		card[3][2] = new Card('B');
		card[3][3] = new Card('C');
		
		//GameArea();
		while(GameisEnd() == false) {
			
			GameArea();
			Guess();
			
		}
		GameArea();
		System.out.println("Game Over very well !!!");

	}
	
	public static void Guess() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("First guess (Enter i and j with one space between them) : ");
		int i1 = scanner.nextInt();
		int j1 = scanner.nextInt();
		
		card[i1][j1].setGuess(true);
		GameArea();
		
		
		System.out.print("Second guess (Enter i and j with one space between them) : ");
		int i2 = scanner.nextInt();
		int j2 = scanner.nextInt();
		
		if(card[i1][j1].getValue() == card[i2][j2].getValue()) {
			
			System.out.println("Guess is true well done...");
			card[i2][j2].setGuess(true);
			
		}
		else {
			System.out.println("Wrong guess...");
			card[i1][j1].setGuess(false);
		}
		
	}
	
	public static boolean GameisEnd() {
		
		for(int i = 0; i < 4; i++) {
			
			for(int j = 0; j < 4; j++) {
				
				if(card[i][j].isGuess() == false) {
					
					return false;
					
				}
				
			}
			
		}
		return true;
		
	}
	
	public static void GameArea() {
		
		for(int i = 0; i < 4; i++) {
			
			System.out.println("____________________");
			
			for(int j = 0; j < 4; j++) {
				
				if(card[i][j].isGuess()) {
					
					System.out.print(" |" + card[i][j].getValue() + "| ");
					
				}
				else {
					
					System.out.print(" | | ");
					
				}// end if
				
				
			}// end inner for
			
			System.out.println("");
			
		}// end outer for
		
		System.out.println("____________________");
		
	}// end func

}
