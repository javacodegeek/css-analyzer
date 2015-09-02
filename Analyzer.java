import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
