import java.util.Arrays;
import org.apache.commons.math3.stat.descriptive.rank.Median;


public class TicketInfo
{
    public static void main(String[] args)
    {

        //the array of tickets
        int[] cheapTickets = {54, 159, 35, 57, 52, 49, 59, 33, 48, 33, 40, 14, 58, 37, 47, 33, 29, 25, 25}; //array that holds ticket price
        double[] doubleTickets = {54, 159, 35, 57, 52, 49, 59, 33, 48, 33, 40, 14, 58, 37, 47, 33, 29, 25, 25}; // this is for the apache commons method since it accepts doubles

        //call method to find average
        arrAverage(cheapTickets);

        //call method to find max value

        arrMax(cheapTickets);



        //call method to find min value

        arrMin(cheapTickets);

        //call method to find median value

        arrMedian(cheapTickets);

        //call alternative median method
        getMedian(doubleTickets);


    } // end of main


    //avg method
    public static double arrAverage(int[] cheapTickets)
    {
        int total = 0;
        double average;
        int sum = 0;

        for(int i = 0; i < cheapTickets.length; i++) // goes through the array
        {
            total += cheapTickets[i]; // adds each value to the total
            sum++; // counts how many values
        }

        average = (total/(sum*1.0)); // takes the total amount for all the tickets, then divides by the number of bands
        return average;
    } // end of Avg method



    //max method
    public static int arrMax(int[] cheapTickets)
    {

        int highest = cheapTickets[0];
        for(int index = 1; index < cheapTickets.length; index++)
        {
            if(cheapTickets[index] > highest)
            {
                highest = cheapTickets[index];

            }
        }
        return highest;


    } // end of max method

    //min method
    public static int arrMin(int[] cheapTickets)
    {

        int lowest = cheapTickets[0];
        for(int index = 1; index < cheapTickets.length; index++)
        {
            if(cheapTickets[index] < lowest)
            {
                lowest = cheapTickets[index];

            }
        }
        return lowest;


    } // end of min method

    public static int arrMedian(int[] cheapTickets)
    {
        Arrays.sort(cheapTickets); // sorts the array

        int middle = cheapTickets.length/2; // in this case, 19 /2 = 9
        int medianValue = 0; //declare variable


        if (cheapTickets.length%2 == 1) // again 19%2 = 9 r 1
        {
            medianValue = cheapTickets[middle];
        }
        else
        {
            medianValue = (cheapTickets[middle-1] + cheapTickets[middle]) / 2;
        }

        return medianValue;

    } // end of median method

    public static double getMedian(double[] values)// uses the Apache Commons median
    {
        Median median = new Median();
        double medianValue = median.evaluate(values);
        System.out.println(medianValue);
        return medianValue;
    }

} // end of program
