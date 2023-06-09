    
/**
 * Write a description of class Ex14 here.
 *
 * @author (shira giladi)
 * @version (04/05/22   213707235)
 */
public class Ex14
{

    /**
     * This method is a recursive static method that takes an array of integers, and returns the length of the maximum subset 
     * that is a flat series. A flat series is a series of integers if all the numbers in it are the same number Or the series
     * consists of two consecutive numbers. An empty series, or a series that has one limb is considered a flat series
     *@param arr from which the method will return the length of the largest flat subset.
     *@return The method will return the length of the largest flat sub-series
     */
    public static int longestFlatSequence(int[] arr)//Shell method
    {
        return longestFlatSequence(arr,0);
    }

    /**
     * This method is the method to which the shell method sends the array and another value that represents the index
     * and its value is initially zero. This method returns who is the length of the longest subset.
     * @param arr from which the method will return the length of the largest flat subset.
     * @param index Represents the cell position in the array.
     * @return  shell method sends the array and another value that represents the index
     * and its value is initially zero. This method returns who is the length of the longest subset.
     */
    public static int longestFlatSequence(int[] arr,int  index)
    {
        if(index+1 == arr.length)
        {
            return 1; 
        }
        
        return Math.max(lengthFlat(arr , index , arr[index] , arr[index+1] , 1),longestFlatSequence(arr , index+1));
    }

    /**
     * This method is an auxiliary method that helps to calculate the length of the subset of the flat series from a certain place until it stops.
     * @param arr from which the method will return the length of the largest  subset.
     * @param index Represents the cell position in the array. 
     * @param num Represents the first number of the flat subseries
     * Represents the length of the flat series
     *@return Returns the length of the flat series from place to place until it stop.    ‏
     */
    public static int lengthFlat(int[] arr, int index, int num , int num1 , int counter)
    {

        if(index+1 == arr.length-1)
        {
            if(num== num1)
            {
                return counter+1; 
            }
            if((num == num1 + 1) || (num == num1 - 1))
            {
                if((arr[index+1] == num )||(arr[index+1] == num1))
                {
                    return counter+1; 
                }
            }
            return counter;
        }

        if(((num != num1+1) && (num != num1 -1) && (num != num1)) || ((num != arr[index+1]) && (num1 != arr[index+1])))
        {
            return counter;
        }

        if(num == num1)
        {
            return lengthFlat (arr, index+1 , arr[index+1]  , arr[index+2] , counter+1);  
        }
        return lengthFlat (arr, index+1 , num , num1 , counter+1);
    }

    /**
     * Given a two-dimensional array mat, whose values ​​are integers -1, 0 or 1.
     *The number of rows is not necessarily equal to the number of columns. The number of columns in all rows is equal.
     *We will define a route in the array if it meets the following conditions:
     *1.The first cell in the trajectory is [0] [0] mat ( first row and first column)
     *2. The pathway passes only in cells that contain 1 or 0.
     *3. In a row with a double index, you can only go to the cell on the right in the same row or go down to the next row in the same column.
     *4. In a row with an odd index, you can only go to the cell on the left in the same row or go down to the next row in the same column.
     *Each passage of a trajectory in the cell where the value 1 appears gives one point.
     *Passage of the path in the cell in which
     *The value 0 appears does not give any point. Remember, the route must not pass through cells where the value is -1.
     *This method is a recursive static method that receives the above two-dimensional array, which returns the highest amount of points that can be reached in 
     *any trajectory in the two-dimensional array mat.
     *If in cell [0] [0] the value is -1 the method will return -1.
     *@param mat The array on which the method will operate
     *@return The highest amount of points that can be reached in any trajectory in the two-dimensional array mat.‏
     */
    public static int findMaximum(int [][] mat)//shele methode
    {
        if(mat[0][0] == 1)
        {
            return findMaximum(mat , 0 , 0 , 1); 
        }
        return findMaximum(mat , 0 , 0 , 0); 
    }

    /**
     * The method A shell method sends to it
     *@param mat The array on which the method will operate
     *@param i Representing the rows in the array
     *@param j Representing the cols in the array.
     *@param sum Represents the maximum number of points accumulated from the array
     **@param mat The array on which the method will operate
     *@return The highest amount of points that can be reached in any trajectory in the two-dimensional array mat.
     */
    public static int findMaximum(int[][] mat , int i , int j , int sum)
    {
        if(mat[i][j] != (-1))
        {
            if(i == mat.length-1)
            {
                if((i % 2 == 0) && (j < mat[0].length-1))
                {
                    if(mat[i][j+1] == -1)
                    {
                        return sum;
                    }
                    if(mat[i][j+1] == 0)
                    {
                        return findMaximum(mat , i , j+1 , sum);
                    }
                    if(mat[i][j+1] == 1)
                    {
                        return findMaximum(mat , i , j+1 , sum+1);
                    }
                }

                if((i%2 != 0) && (j > 0))
                {
                    if(mat[i][j-1] == -1)
                    {
                        return sum;
                    }
                    if(mat[i][j-1] == 0)
                    {
                        return findMaximum(mat , i , j-1 , sum);
                    }
                    if(mat[i][j-1] == 1)
                    {
                        return findMaximum(mat , i , j-1 , sum+1);
                    }
                }
            }

            if((i%2 == 0) && (i != mat.length-1) && (j == mat[0].length-1))
            {
                if(mat[i+1][j] == -1)
                {
                    return sum;
                }
                if(mat[i+1][j] == 0)
                {
                    return findMaximum(mat , i+1 , j , sum);
                }
                if(mat[i+1][j] == 1)
                {
                    return findMaximum(mat , i+1 , j , sum+1);
                }
            }

            if((i%2 != 0) && (i != mat.length-1) && (j == 0))
            {
                if(mat[i+1][j] == -1)
                {
                    return sum;
                }
                if(mat[i+1][j] == 0)
                {
                    return findMaximum(mat , i+1 , j , sum);
                }
                if(mat[i+1][j] == 1)
                {
                    return findMaximum(mat , i+1 , j , sum+1);
                }
            }

            if((i%2 == 0) && (j < mat[0].length-1) && (i != mat.length-1))
            {
                if((mat[i][j+1] == -1) && (mat[i+1][j] == -1))
                {
                    return sum;
                }
                if((mat[i][j+1] == 1) && (mat[i+1][j] == 1))
                {
                    return Math.max(findMaximum(mat , i , j+1 , sum+1) , findMaximum(mat , i+1 , j , sum+1));
                }
                if((mat[i][j+1] == 0) && (mat[i+1][j] == 0))
                {
                    return Math.max(findMaximum(mat , i , j+1 , sum) , findMaximum(mat , i+1 , j , sum));
                }
                if((mat[i][j+1] == 1) && (mat[i+1][j] == 0))
                {
                    return Math.max(findMaximum(mat , i , j+1 , sum+1) , findMaximum(mat , i+1 , j , sum));
                }
                if((mat[i][j+1] == 0) && (mat[i+1][j] == 1))
                {
                    return Math.max(findMaximum(mat , i , j+1 , sum) , findMaximum(mat , i+1 , j , sum+1));
                }
                if(mat[i][j+1] == -1)
                {
                    if(mat[i+1][j] == 0)
                    {
                        return findMaximum(mat , i+1 , j , sum);
                    }
                    else
                    {
                        return findMaximum(mat , i+1 , j , sum+1);
                    }
                }
                if(mat[i+1][j] == -1)
                {
                    if(mat[i][j+1] == 0)
                    {
                        return findMaximum(mat , i , j+1 , sum);
                    }
                    else
                    {
                        return findMaximum(mat , i , j+1 , sum+1);
                    }
                }
            }

            if((i%2 != 0) && (j > 0) && (i != mat.length-1))
            {
                if((mat[i][j-1] == -1) && (mat[i+1][j] == -1))
                {
                    return sum;
                }
                if((mat[i][j-1] == 1) && (mat[i+1][j] == 1))
                {
                    return Math.max(findMaximum(mat , i , j-1 , sum+1) , findMaximum(mat , i+1 , j , sum+1));
                }
                if((mat[i][j-1] == 0) && (mat[i+1][j] == 0))
                {
                    return Math.max(findMaximum(mat , i , j-1 , sum) , findMaximum(mat , i+1 , j , sum));
                }
                if((mat[i][j-1] == 1) && (mat[i+1][j] == 0))
                {
                    return Math.max(findMaximum(mat , i , j-1 , sum+1) , findMaximum(mat , i+1 , j , sum));
                }
                if((mat[i][j-1] == 0) && (mat[i+1][j] == 1))
                {
                    return Math.max(findMaximum(mat , i , j-1 , sum) , findMaximum(mat , i+1 , j , sum+1));
                }
                if(mat[i][j-1] == -1)
                {
                    if(mat[i+1][j] == 0)
                    {
                        return findMaximum(mat , i+1 , j , sum);
                    }
                    else
                    {
                        return findMaximum(mat , i+1 , j , sum+1);
                    }
                }
                if(mat[i+1][j] == -1)
                {
                    if(mat[i][j-1] == 0)
                    {
                        return findMaximum(mat , i , j-1 , sum);
                    }
                    else
                    {
                        return findMaximum(mat , i , j-1 , sum+1);
                    }
                }
            }
            return sum;
        }
        return -1;
    }
}



