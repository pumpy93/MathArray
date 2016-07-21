import java.util.Random;

/**
 *
 * @author PUMPY
 */
public class MathArrayTest {
    public static void main(String args[])
    {
        int rows = 6;
        int columns = 8;
        int myRowCount = 7;
        Random random = new Random();
        int[][] myTable = new int[columns][rows];
        for(int i=0;i<myTable.length;i++)
        {
            for(int j=0;j<myTable[i].length;j++)
            {
                myTable[i][j] = 10+random.nextInt(31);
            }
        }
        int[] myRow = new int[myRowCount];
        for(int i=0; i<myRow.length;i++)
        {
            myRow[i] = 5+random.nextInt(11);
        }
        MathArray mathArray = new MathArray(myTable, myRow);
        System.out.println(mathArray);
        System.out.println("Max table element: "+mathArray.maxTableElement());
        System.out.println("Row length: "+mathArray.rowLength());
        System.out.println("Row average: "+mathArray.averageByRow());
        System.out.println("Sorted row: "+
                MathArray.rowToStr(mathArray.sortRow()));
        System.out.println("Transposed Matrix:\n"+
                MathArray.matrixToStr(
                MathArray.transpose(mathArray.getTable())));
    }
}