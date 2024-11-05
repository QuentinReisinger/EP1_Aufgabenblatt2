/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    public static void printNumCharsInString(String text, int startIndex, int numChar) {
        String result = "";
        for(int i = startIndex; i < startIndex + numChar; i++) {
            result += text.charAt(i);
        }
        System.out.println(result);

    }

    public static void printNumbersInInterval(int start, int end){
        for(int i = end; i >= start; i--) {
            if(i % 3 == 0){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isCharNTimesInString(String text, char character, int nTimes){
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == character){
                count++;
            }
        }
        if(count == nTimes){
            return true;
        }
        return false;
    }

    public static String changeLettersInString(String text){
        String result = "";
        for(int i = 0; i < text.length(); i++) {
            if((text.charAt(i) >= 'b' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'B' && text.charAt(i) <= 'Z')){
                result += (char) (text.charAt(i) - 1);
            }else{
                result += (char) text.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.

        assert (isCharNTimesInString("nennenswerte Worte", 'n', 4));
        assert (!isCharNTimesInString("nennenswerte Worte", 'n', 3));
        assert (!isCharNTimesInString("nennenswerte Worte", 'e', 6));
        assert (isCharNTimesInString("Test", 'x', 0));

        assert (changeLettersInString("Hello World!").equals("Gdkkn Vnqkc!"));
        assert (changeLettersInString("Anfang und Ende.").equals("Ameamf tmc Dmcd."));
        assert (changeLettersInString("+ABC_123_DEF#").equals("+AAB_123_CDE#"));
        assert (changeLettersInString("ABCDYZ_abcdyz").equals("AABCXY_aabcxy"));

        //**********************************************************************

        printNumCharsInString("test", 0, 2);
        printNumbersInInterval(0,9);
    }
}
