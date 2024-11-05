/*
    Aufgabe 3) Schleifen und Methoden - Harshad-Zahlen
*/
public class Aufgabe3 {

    private static boolean isHarshadNumber(int number) {
        int result = 0;
        int saveNumb = number;
        while(number != 0){
            result += number % 10;
            number /= 10;
        }
        if(saveNumb % result == 0){
            return true;
        }
        return false; //Zeile kann geändert oder entfernt werden.
    }

    private static void printHarshadNumbersInInterval(int start, int end) {
        for(int i = start; i <= end; i++){
            if(isHarshadNumber(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHarshadNumber(...).
        System.out.println("1 --> " + isHarshadNumber(1));
        assert (isHarshadNumber(1));
        System.out.println("4 --> " + isHarshadNumber(4));
        assert (isHarshadNumber(4));
        System.out.println("13 --> " + isHarshadNumber(13));
        assert (!isHarshadNumber(13));
        System.out.println("97 --> " + isHarshadNumber(97));
        assert (!isHarshadNumber(97));
        System.out.println("777 --> " + isHarshadNumber(777));
        assert (isHarshadNumber(777));
        System.out.println("8316 --> " + isHarshadNumber(8316));
        assert (isHarshadNumber(8316));
        System.out.println("9214 --> " + isHarshadNumber(9214));
        assert (!isHarshadNumber(9214));
        System.out.println("172986 --> " + isHarshadNumber(172986));
        assert (isHarshadNumber(172986));
        //**********************************************************************

        printHarshadNumbersInInterval(51, 79);
        printHarshadNumbersInInterval(1, 10);
        printHarshadNumbersInInterval(103, 192);

        System.out.println(isHarshadNumber(192));
        System.out.println(isHarshadNumber(103));
    }
}
