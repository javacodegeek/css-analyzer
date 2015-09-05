import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class Analyzer {
    private static Analyzer instance;
    private Analyzer() {}

    public static Analyzer getInstance() {
        if (instance == null) {
          instance = new Analyzer();
        }
          return instance;
    }

    public static boolean validatekUrl(String url) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(url);
          return m.matches();
    }

    public static String getPageContent (String pageUrl) {

      URL url;
      StringBuffer resultString = new StringBuffer();

  		try {
  		    url = new URL(pageUrl);
  		  	URLConnection conn = url.openConnection();

   			  BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

  			  String inputLine;

  			  while ((inputLine = br.readLine()) != null) {
  				      resultString.append(inputLine);
  			  }

   			  br.close();
  		} catch (MalformedURLException e) {
  			   System.out.println(e.getMessage());
            return null;
  		} catch (IOException e) {
           System.out.println(e.getMessage());
            return null;
  		}
          return resultString.toString();
    }
}
