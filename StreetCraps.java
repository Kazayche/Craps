import java.util.Scanner;
import java.util.Random;

public class StreetCraps {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random dice = new Random();
        //starting amounts
        int playerMoney = 100;
        int computerMoney = 100;
        
        
        
        // Play until someone loses all money
        while (playerMoney > 0 && computerMoney > 0) {
            
            System.out.println("Your money: $" + playerMoney);
            System.out.println("Computer money: $" + computerMoney);
            
            System.out.print("Enter bet: $");
            int bet = input.nextInt();
            
            // Check if bet is valid
            if (bet > playerMoney || bet > computerMoney || bet <= 0) {
                System.out.println("Try again.");
                continue;
            }
            
            System.out.println("Press enter to roll");
            input.nextLine();
            input.nextLine();
            
            // Roll two dice
            int die1 = dice.nextInt(6) + 1;
            int die2 = dice.nextInt(6) + 1;
            int total = die1 + die2;
            
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + total);
            
            // Check if someone won instantly
            if (total == 7 || total == 11) {
                System.out.println("You win!");
                playerMoney = playerMoney + bet;
                computerMoney = computerMoney - bet;
            } 
            else if (total == 2 || total == 3 || total == 12) {
                System.out.println("Computer wins!");
                playerMoney = playerMoney - bet;
                computerMoney = computerMoney + bet;
            } 
            else {
                // Set the point
                int point = total;
                System.out.println("Point = " + point);
                System.out.println("Roll " + point + " before rolling 7 to win");
                
                boolean gameOver = false;
                
                // Keep rolling
                while (gameOver == false) {
                    System.out.println("Press enter to roll");
                    input.nextLine();
                    
                    die1 = dice.nextInt(6) + 1;
                    die2 = dice.nextInt(6) + 1;
                    total = die1 + die2;
                    
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + total);
                    
                    if (total == point) {
                        System.out.println("You win!");
                        playerMoney = playerMoney + bet;
                        computerMoney = computerMoney - bet;
                        gameOver = true;
                    } 
                    else if (total == 7) {
                        System.out.println("Computer wins!");
                        playerMoney = playerMoney - bet;
                        computerMoney = computerMoney + bet;
                        gameOver = true;
                    }
                }
            }                     
        }
        
        // Show final winner
        System.out.println("Game over!");
        if (playerMoney > 0) {
            System.out.println("You won the game!");
        } else {
            System.out.println("Computer won the game!");
        }
        
        input.close();
    }
}
