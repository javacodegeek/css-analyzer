import java.io.*;
import java.util.*;

class Main {

	private static Analyzer urlAnalyzer = Analyzer.getInstance();

	public static void main (String args[]) {
     for (int i = 0; i < args.length; i++) {
        System.out.println(urlAnalyzer.validatekUrl(args[i]));
     }
	}

}
