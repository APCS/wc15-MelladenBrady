
/**
 * WC15 - This is a review of all kinds of concepts.
 * Only use AP official subset methods for ArrayLists, Strings, 1D arrays, etc.
 * These methods focus on various arrays, loops, and whatever else I think
 * you need practice on.
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class WC15
{
  /**
   * 
   * Given a string of odd length, return the string length 3 from its middle,
   * so "Candy" yields "and".
   * 
   * <pre>
   * The string length will be at least 3.
   * 
   * middleThree("Candy") -> "and" 
   * middleThree("and") -> "and"
   * middleThree("solving") -> "lvi"
   * </pre>
   * 
   * @param letters
   * @return
   */
  public static String centralThree(String letters)
  {

    return letters.substring((letters.length() / 2) - 1,
      (letters.length() / 2) + 2);
  }

  /**
   * Given a string, return a version without the first 2 chars. Except keep the
   * first char if it is 'a' and keep the second char if it is 'b'. The string
   * may be any length. Harder than it looks.
   * 
   * <pre>
   * PRECONDITION: str will be lowercase and length will be at least two
   * deFront("Hello") -> "llo" 
   * deFront("java") -> "va" 
   * deFront("away") -> "aay"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String chopFront(String str)
  {
    String answer = "";

    if (str.substring(0, 1).equals("a"))
    {
      answer += "a";
    }
    if (str.substring(1, 2).equals("b"))
    {
      answer += "b";
    }
    answer += str.substring(2);
    return answer;

  }

  /**
   * 
   * Given a string, if one or both of the first 2 chars is 'x', return the
   * string without those 'x' chars, and otherwise return the string unchanged.
   * This is a little harder than it looks.
   * 
   * <pre>
   * withoutX2("xHi") -> "Hi" 
   * withoutX2("Hxi") -> "Hi" 
   * withoutX2("Hi") -> "Hi"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String hateX(String str)
  {
    String answer = "";

    if (!str.substring(0, 1).equals("x"))
    {
      answer += str.substring(0, 1);
    }
    if (!str.substring(1, 2).equals("x"))
    {
      answer += str.substring(1, 2);
    }
    answer += str.substring(2);
    return answer;

  }

  /**
   * Swaps all values in the specified 2 rows of mat.
   * 
   * @param mat
   *          the array
   * @param rowAIndex
   *          the index of a row to be swapped
   * @param rowBIndex
   *          the index of a row to be swapped
   */
  public static void swapRows(int[][] mat, int rowAIndex, int rowBIndex)
  {
    int[] arr = mat[rowAIndex];
    mat[rowAIndex] = mat[rowBIndex];
    mat[rowBIndex] = arr;
  }

  /**
   * Swaps all values in the specified 2 columns of mat. fortnite
   * 
   * @param mat
   *          the array
   * @param colAIndex
   *          the index of a column to be swapped
   * @param colBIndex
   *          the index of a column to be swapped
   */
  public static void swapColumns(int[][] mat, int colAIndex, int colBIndex)
  {
    int[] tempArr = new int[mat[0].length];

    for (int r = 0; r < mat.length; r++)
    {
      tempArr[r] = mat[r][colAIndex];
    }
    for (int r = 0; r < mat.length; r++)
    {
      mat[r][colAIndex] = mat[r][colBIndex];
    }
    for (int r = 0; r < mat.length; r++)
    {
      mat[r][colBIndex] = tempArr[r];
    }

  }

  /**
   * Returns an array with the specified number of rows and columns containing
   * the characters from str in row-major order. If str.length() is greater than
   * rows * cols, extra characters are ignored. If str.length() is less than
   * rows * cols, the remaining elements in the returned array contain null.
   * 
   * @param str
   *          the string to be placed in an array
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the characters from str in row-major order
   */
  public static String[][] fill2DWithLetters(String str, int rows, int cols)
  {
    int stringCount = 0;
    String[][] answer = new String[rows][cols];

    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols; c++)
      {
        if (stringCount >= str.length())
        {
        }
        else
        {
          answer[r][c] = str.substring(stringCount, stringCount + 1);
        }
        stringCount++;
      }
    }

    return answer;
  }

  /**
   * Returns an array with the specified number of rows and columns that
   * contains the elements of vals in the order specified below. Elements from
   * vals are placed in the array by moving down the first column, up the second
   * column and so on.
   * 
   * <pre>
   * For example, if vals was:
   * {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
   * 
   * rows was 3 and cols was 4,
   * the returned array would be:
   * { {1, 6, 7, 12},
   *   {2, 5, 8, 11},
   *   {3, 4, 9, 10} }
   * 
   * Precondition: vals.length == rows * cols
   * </pre>
   * 
   * @param vals
   *          the elements
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the elements from vals in the specified order
   */
  public static int[][] fillDownAndUp(int[] vals, int rows, int cols)
  {
    int val = 0;
    int[][] arr = new int[rows][cols];
    boolean pass = false;

    for (int c = 0; c < cols; c++)
    {
      if (pass == false)
      {
        for (int r = 0; r < rows; r++)
        {
          arr[r][c] = vals[val];
          val++;

        }
        pass = true;
      }
      else
      {
        for (int r = rows - 1; r >= 0; r--)
        {
          arr[r][c] = vals[val];
          val++;
        }
        pass = false;
      }
    }
    return arr;
  }

  /**
   * Returns a smaller array containing the elements in the specified range of
   * the mat.
   * 
   * For example,
   * 
   * <pre>
   * mat: { {10, 9, 8, 7}, 
   *        {6, 5, 4, 3}, 
   *        {2, 1, -1, 0} }
   * 
   * startRow: 0, startCol: 1, endRow: 1, endCol: 2
   * 
   * would yield: { {9, 8},
   *                {5, 4} }
   * </pre>
   * 
   * @param mat
   *          the 2D array containing the original elements
   * @param startRow
   *          the first row to be kept
   * @param startCol
   *          the first column to be kept
   * @param endRow
   *          the last row to be kept
   * @param endCol
   *          the last column to be kept
   * @return a smaller array containing the specified elements
   */
  public static int[][] crop2D(int[][] mat, int startRow, int startCol,
    int endRow, int endCol)
  {
    int row = 0;
    int col = 0;
    int[][] arr = new int[endRow - startRow + 1][endCol - startCol + 1];

    for (int r = startRow; r <= endRow; r++)
    {
      col = 0;
      for (int c = startCol; c <= endCol; c++)
      {
        arr[row][col] = mat[r][c];
        col++;
      }
      row++;
    }

    return arr;

  }

}