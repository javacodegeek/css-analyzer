import java.io.*;
import java.util.*;

class Main {

	private static Analyzer urlAnalyzer = Analyzer.getInstance();

	public static void main (String args[]) {
     for (int i = 0; i < args.length; i++) {
        System.out.println(urlAnalyzer.validatekUrl(args[i]));
				if (urlAnalyzer.validatekUrl(args[i])) {
							//System.out.println(Analyzer.getPageContent(args[i]));
						Analyzer.getContentInStyleTag(Analyzer.getPageContent(args[i]));
				}
     }
	}

}
