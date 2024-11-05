/*
    Aufgabe 1) Verschachtelte Schleifen - Optische Täuschung
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe1 {

    public static void main(String[] args) {
        int ws = 400;
        CodeDraw canvas = new CodeDraw(ws,ws);
        double r  = (1/60.) * ws;
        double radiusX = 2*r;
        double radiusY = 2*r;

        double startX = radiusX;
        double startY = radiusY;

        double recX = 0.25*ws+2*r;
        double recY = 0.25*ws+2*r;

        double startRecX = recX;
        double startRecY = recY;

        int row = 15;
        int col = 15;

        for(int i = 0; i < row; i++) {
            radiusX = startX;
            for(int j = 0; j < col; j++) {
                canvas.setColor(Palette.BLACK);
                canvas.fillCircle(radiusX, radiusY,r);
                canvas.setColor(Palette.GRAY);
                canvas.setLineWidth(3);
                canvas.drawCircle(radiusX, radiusY,r);
                radiusX += r*4;
            }
            radiusY += r*4;
        }
        canvas.setColor(Palette.WHITE);
        canvas.fillRectangle(0.25*ws+r, 0.25*ws+r,0.5*ws-2*r ,0.5*ws-2*r );
        canvas.setColor(Palette.BLACK);
        canvas.setLineWidth(1);
        canvas.drawRectangle(0.25*ws+r, 0.25*ws+r,0.5*ws-2*r ,0.5*ws-2*r );

        for(int i = 0; i < 7; i++){
            recX = startRecX;
            for(int j = 0; j < 7; j++){
                canvas.drawRectangle(recX, recY, 2*r,2*r);
                recX += r*4;
            }
            recY += r*4;
        }
        canvas.show();
    }
}
