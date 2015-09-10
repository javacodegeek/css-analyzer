/**
*@autor Evgeniy Safronov <a href="https://github.com/javacodegeek">github</>
*@version 1.0
*/

import java.io.*;
import java.util.*;

public class StyleAnalyzer {

	private static Core core = Core.getInstance();

	public static void main (String args[]) {
     for (int i = 0; i < args.length; i++) {
        System.out.println(core.validateUrl(args[i]));
				if (core.validateUrl(args[i])) {
						Core.getStyleContent(Core.getPageContent(args[i]), "link");
				}
     }
	}

}
