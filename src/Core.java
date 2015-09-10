/**
* This class is a core of aprogramm constrain all imoprtant method
*@autor Evgeniy Safronov <a href="https://github.com/javacodegeek">github</>
*@version 1.0
*/

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

public class Core {
    private static Core instance;
    private Core() {}

    public static Core getInstance() {
        if (instance == null) {
          instance = new Core();
        }
          return instance;
    }

    /**
    * This methid validate site url
    * @param url       Site url String
    * @return          <code>true</code> if url validate
    *                  <code>false</code> if url invalidate.
    */
    public static boolean validateUrl(String url) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(url);
          return m.matches();
    }

    /**
    * This method get content from site url
    * @param pageUrl    url as String
    * @return          <code>String[]</code> if have some Exception
    *                  <code>null</code> if have Exception
    */
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


    /**
    * This method get style content from page content
    * @param pageString content page from url as String
    * @styleType       <code>all</code>, <code>link</code>,
    *                  <code>import_url</code>, <code>style_tag</code>,
    * @return          <code>Content</code> if have some Exception
    *                  <code>null</code> if url invalidate.
    */
    public static String[] getStyleContent(String pageString, String styleType) {
        System.out.println("Method: 'getStyleContent'");
        System.out.println("    @param: styleType = " + styleType);

        String[] result = new String[1000];

        String regex;
        Pattern pattern;
        Matcher matcher;

        switch (styleType) {
            case "all":
                        /*
                          This code  join oint link, style_tag, import_url,
                        */
                        break;
            case "link":
                        //regex = "<link[^>]+?text/css[^>]*?>";
                        regex = "<link.+text/css.+>";

                        pattern = Pattern.compile(regex);
                        matcher = pattern.matcher(pageString);
                        try {
                            int i = 0;
                            while (matcher.find()) {
                                String match = matcher.group();
                                result[i] = match;
                                i++;
                            }

                        }catch(Exception e){
                            System.out.println(e.getMessage());
                              return null;
                        }
                        for(int i = 0; i < result.length; i++) {
                          if (result[i] == null){
                              break;
                          }
                          System.out.println(result[i]);
                        }
                        break;
            case "import_url":
                        /*
                          code for getting al import url style in pageUrl/pageUrl
                        */
                        break;
            case "style_tag":
                        regex = "<style.+style>";
                        pattern = Pattern.compile(regex);
                        matcher = pattern.matcher(pageString);
                        try {
                            int i = 0;
                            while (matcher.find()) {
                                String match = matcher.group();
                                result[i] = match;
                                i++;
                            }
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                              return null;
                        }

                        for(int i = 0; i < result.length; i++) {
                          if (result[i] == null){
                              break;
                          }
                          System.out.println(result[i]);
                        }

                        break;
            default:
                        break;
        }
          return result;

    }

}
