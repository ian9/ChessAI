/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itschess;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author Ian
 */
public class ItsChess 
{
    //public static Timer timer = new Timer();
    static InputStreamReader reader = new InputStreamReader (System.in);
    // Wrap the reader with a buffered reader.
    static BufferedReader buf_in = new BufferedReader (reader);
	/**
	 * @param args
	 */
    public static int turns = 0;
        
    public static void main(String[] args) throws IOException {
        
    	//gameLoop();
        
        AlphaBetaSearch.alphaBetaSearch();
        
    }
    
    public static String fetchOtherMove() throws MalformedURLException, IOException
    {
    	String gameID = "85";
        String head = "http://www.bencarle.com/chess/poll/154/2/1a77594c/";
        String head2 = "http://www.bencarle.com/chess/poll/89/1/32c68cae/";
        String test;
        boolean moveRead = false;
        String otherMove = "";
    	
        String serverText = "";
        int moveIndex;

        URL url = new URL(head);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader res = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuffer sBuffer = new StringBuffer();
        String inputLine;
        while ((inputLine = res.readLine()) != null)
        	sBuffer.append(inputLine);
        res.close();
        serverText = sBuffer.toString();
        moveIndex = serverText.indexOf(":") + 1;
        String testfas = serverText.substring(moveIndex,sBuffer.indexOf(",")).trim();
        if(testfas.equals("true"))
        {
        	moveRead = true;
        	otherMove = serverText.substring(serverText.lastIndexOf(":")+3, serverText.lastIndexOf("}")-1);
        	return otherMove;
        }
        return "";
    	
    }
    
    public static void gameLoop() throws MalformedURLException, IOException 
    {
    	//timer.schedule(new FetchOtherMove(), 5 * 1000);
        
    }
}
