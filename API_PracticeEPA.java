import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

// okay let's start by using some packages of the Java API you may not have yet seen

// I am trying out IntelliJ as my IDE and when I posted this program into it, it automatically commented out the import statements below and added the imports above. Pretty neat and helpful!
// But I thought I should write a comment saying why it got changed!
// import java.net.*;
// import java.io.*;

//  NOTE::  You probably can't answer these without reading ahead through the code and making some best guesses !
// Question 1 : why are we using java.net package ? What classes are used from that package ? which methods of those classes?

					/* We are using the java.net package because we need our program to connect  over the internet to another
						computer. Java by itself cannot do this, so we need to import these packages to supplement it. This program
						uses the URL class in order to create a reference to a resource on the WWW. As for methods, most of them are returning
						   information from the other computer. The methods in these classes create a URL from a string representation.  */

// Question 2: why use the java.io package ? Which classes are we using ? why? which methods ?
/* We are using the .io package because it is a way to stream input and output data. we are using the bufferedReader and inputStreamReader.
 * Both of these help mitigate the stream coming through over the connection from the URL class. A bufferedReader will help mitiage the
 * strain on the computer because it slows down the stream over the connection. While the streamReader converts the byte stream to character streams
 * so that it can be read. Both of these classes are just making it more efficient for the computer to take in all this new data. */

//


public class API_PracticeEPA
{

    // this first line states that the program may bail out , ie throw an Exception.
    //Q2: using the java api page for the class URL, find what Exception the constructor for the URL class can throw
                /* the "throws MalformedURLException"  is the exceptions the URL class can throw
                The MalFormedURLException is when the protocol for the URL is not known. .
                 */

    public static void main(String[] args) throws Exception {

        // for later.... !
        String[] zipCodes={ "33021", "19025", "19075"};
        // Now we are going to use a Web Service from the EPA, the Environmental Protection Agency.
        //
        // We'll create a query
        // and have the EPA server talk to our program and send us the information we request. This is the main
        //mechanism for communication and xmission of information over the Internet, not printing to the screen!
        //
        //
        // Two popular formats that allow two computers to communicate are XML and JSON. As beginners we'll
        // just use an easier format called CSV.
        // Q3. What is CSV?
        /* A CSV (Comma Separated Values) is a text file that stores lists of data that are seperated by commas. One
         * example I found was "Name,Email,Phone Number,Address". Just a simple way to store clumps of data and move them around from different programs.  */

        // Q4: Go to the documentation page for the EPA API.
        //   https://www.epa.gov/enviro/web-services#hourlyzip
        // Run this program with the URL query as it is written below. What happens?
        /* It takes in the ZIP Code and the type of file for the output (in this case, 87101 in a CSV file), and then prints out the order, the ZIP, the date and the UV value of whatever
         * the ZIP entered was. */
        // Copy the URL from the line below into a new tab of your browser. What does it return?
        /* It starts a download of the type of file you wish (CSV here), and when you click the file it opens up all the information that is printed in the compiler here. */
        //
        for (int i = 0; i < zipCodes.length; i++) {
            URL epaServer = new URL("https://iaspub.epa.gov/enviro/efservice/getEnvirofactsUVHOURLY/ZIP/" + zipCodes[i] + "/CSV");


            URLConnection ac = epaServer.openConnection();


            InputStreamReader inputStream = new InputStreamReader(ac.getInputStream(), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            StringBuilder responseBuilder = new StringBuilder();


            String line;

            while ((line = bufferedReader.readLine()) != null) {
                responseBuilder.append(line + "\n");

            }
            bufferedReader.close();

            // would rather just have you look at this in the debugger, but for now we'll print !
            System.out.println(responseBuilder.toString());
        }



        // Q5:: edit this program so that you query the EPA for UV levels at a list of locations (Central Campus, West Campus and Albuquerque, NM)
        // Your program should automatically run through this list of locations and retrieve the data from the EPA for each.

    }  // end of main
}// end of program


