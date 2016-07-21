/**
 *
 * @author PUMPY
 */
public class MathArray {
    private int table[][];
    private int row[];

    public MathArray(int[][] table, int[] row) {
        setTable(table);
        setRow(row);
    }
    public int[][] getTable() {
        int[][] retTable = new int[table.length][table[0].length];
        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                retTable[i][j] = table[i][j];
            }
        }
        return retTable;
    }
    public void setTable(int[][] table) {
        this.table = new int[table.length][table[0].length];
        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                this.table[i][j] = table[i][j];
            }
        }
    }
    public int[] getRow() {
        int retRow[] = new int[row.length];
        for(int i=0; i<row.length;i++)
            retRow[i] = row[i];
        return retRow;
    }

    public void setRow(int[] row) {
        this.row = new int[row.length];
        for(int i=0;i<row.length;i++)
            this.row[i] = row[i];
    }

    public int maxTableElement(){
        int maxElement = table[0][0];
        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                if(table[i][j] > maxElement)
                    maxElement = table[i][j];
            }
        }
        return maxElement;
    }
    public double averageByRow()
    {
        double average = 0;
        double sum = 0;
        for(int i=0;i<row.length;i++)
            sum += row[i];
        average = sum/row.length;
        return average;
    }
    public int[] sortRow()
    {
        int[] rowCopy = getRow();
        boolean doMore = true;
        while (doMore) {
            doMore = false;  // assume this is last pass over array
            for (int i=0; i<rowCopy.length-1; i++) {
                if (rowCopy[i] > rowCopy[i+1]) {
                   // exchange elements
                   int temp = rowCopy[i];
                   rowCopy[i] = rowCopy[i+1];
                   rowCopy[i+1] = temp;
                   doMore = true;  // after an exchange, must look again 
                }
            }
        }
        return rowCopy;
    }
    public double rowLength()
    {
        double length = 0;
        int scalar = 0;
        for(int i=0;i<row.length;i++)
            scalar += row[i]*row[i];
        length = Math.sqrt(scalar);
        return length;
    }
    public static int[][] transpose(int[][] matrix)
    {
        int[][] transposed = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
    public static String rowToStr(int[] row)
    {
        String rowStr = "";
        for(int i=0;i<row.length-1;i++)
        {
            rowStr += row[i]+", ";
        }
        rowStr += row[row.length-1];
        return rowStr;
    }
    public static String matrixToStr(int[][] matrix)
    {
        String matrixStr = "";
        for(int i=0;i<matrix.length-1;i++)
        {
            for(int j=0;j<matrix[i].length-1;j++)
            {
                matrixStr += matrix[i][j]+", ";
            }
            matrixStr += matrix[i][matrix[i].length-1];
            matrixStr += "\n";
        }
        for(int j=0;j<matrix[matrix.length-1].length;j++)
        {
            matrixStr += matrix[matrix.length-1][j]+", ";
        }
        return matrixStr;
    }
    @Override
    public String toString() {
        String retStr = "Table:\n"+matrixToStr(table);
        retStr += "\nRow: "+rowToStr(row);
        return retStr;
    }
}
