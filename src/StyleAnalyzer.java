import java.io.*;
import java.util.*;

class StyleAnalyzer {

	private static Core core = Core.getInstance();

	public static void main (String args[]) {
     for (int i = 0; i < args.length; i++) {
        System.out.println(core.validatekUrl(args[i]));
				if (core.validatekUrl(args[i])) {
							//System.out.println(Analyzer.getPageContent(args[i]));
						Core.getContentInStyleTag(Core.getPageContent(args[i]));
				}
     }
	}

}
