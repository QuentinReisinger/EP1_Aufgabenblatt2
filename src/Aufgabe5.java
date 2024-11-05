import javax.sound.midi.Soundbank;
import java.util.*;

/*
    Aufgabe 5) Kreativaufgabe
*/
public class Aufgabe5 {
    private static final Map<String, Integer[]> ITEMS = new HashMap<>();
    private static int playerHealth = 20;
    private static int playerAttack = 5;
    private static List<String> equippedItems = new ArrayList<>();
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ITEMS.put("Eisenschwert", new Integer[]{0, 5}); //erster Wert ist Health Wert, zweiter Attack Wert
        ITEMS.put("Titanschwert", new Integer[]{0, 10});
        ITEMS.put("Elementschwert", new Integer[]{0, 20});
        ITEMS.put("Lederrüstung", new Integer[]{5, 0});
        ITEMS.put("Titanrüstung", new Integer[]{10, 0});
        ITEMS.put("Elementrüstung", new Integer[]{20, 0});
        ITEMS.put("Magischer Stab", new Integer[]{0, 7});
        ITEMS.put("Stärketrank", new Integer[]{20, 20});

        System.out.println("Willkommen bei Loot and Win");

        boolean playAgain;
        do{
            resetGame();
            openChests();
            fightBoss();
            System.out.println("\nMöchtest du ein neues Spiel starten? (ja/nein): ");
            String response = scanner.nextLine();
            playAgain = response.equals("ja");
        }while(playAgain);

        System.out.println("Danke fürs Spielen! Bis zum nächsten Mal.");

    }

    //alles zurücksetzen
    private static void resetGame(){
        equippedItems.clear();
        playerHealth = 20;
        playerAttack = 5;
    }

    private static void openChests(){
        System.out.println("Du hast 3 Kisten, drücke Enter um sie zu öffnen.");
        for(int i = 0; i < 3; i++){
            scanner.nextLine();
            String item = (String) ITEMS.keySet().toArray()[random.nextInt(ITEMS.keySet().size())];
            equippedItems.add(item);
            System.out.println("Du hast " + item + " gefunden und ausgerüstet!");
        }
        //Playerstats berechnen
        for(String item : equippedItems){
            Integer[] stats = ITEMS.get(item);
            playerHealth += stats[0];
            playerAttack += stats[1];
        }
        System.out.println();
        System.out.println("Deine aktuellen Lebenspunkte: " + playerHealth);
        System.out.println("Deine aktuellen Angriffspunkte: " + playerAttack);
    }

    private static void fightBoss(){
        int bossHealth = 40 + random.nextInt(30);
        int bossAttack = 10 + random.nextInt(15);

        System.out.println();
        System.out.println("Ein Boss mit " + bossHealth + " Lebenspunkten und " + bossAttack + " Angriffskraft erscheint!");
        System.out.println("Drücke Enter um anzugreifen.");

        while(bossHealth > 0 && playerHealth > 0){
            //Spieler greift an
            int playerAttackRound = playerAttack - random.nextInt(7); //variabler Schaden
            scanner.nextLine();
            System.out.println("Du greifst den Boss an und verursachst " + playerAttackRound + " Schaden!");
            bossHealth -= playerAttackRound;

            //Prüfe ob nach dem Angriff der Boss besiegt wurde
            if (bossHealth <= 0) {
                System.out.println("Du hast den Boss besiegt!");
                break;
            }

            //Boss greift an
            scanner.nextLine();
            System.out.println("Der Boss greift dich an und verursacht " + bossAttack + " Schaden!");
            playerHealth -= bossAttack;

            //Prüfe ob nach dem Angriff der Spieler besiegt wurde
            if (playerHealth <= 0) {
                System.out.println("Du wurdest vom Boss besiegt... :(");
                break;
            }
            System.out.println("Der Boss hat noch " + bossHealth + " Lebenspunkte!");
            System.out.println("Du hast noch " + playerHealth + " Lebenspunkte!");
        }
    }
}
