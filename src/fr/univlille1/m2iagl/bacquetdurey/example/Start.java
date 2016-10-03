package fr.univlille1.m2iagl.bacquetdurey.example;

import java.util.ArrayList;

import fr.univlille1.m2iagl.bacquetdurey.doclet.DocletLauncher;


public class Start {

	private static String REMOTE_URL = "/home/antonin/workspace/pje2/.git";

	private static String example_1 = "/home/antonin/workspace/pje2/src/";
	
	private static String example_2 = "/home/antonin/workspace/OPL-Javadoc-checker/src/";

	public static void main(String [] args) throws Exception{
		
		DocletLauncher docletLauncher = new DocletLauncher(example_1, new ArrayList<String>());
		
		docletLauncher.start();
		
	//	GitChecker gitChecker = new GitChecker(Git.open(new File(REMOTE_URL)));
		
	//	System.out.println(gitChecker.listSrcFilesFromRepository().toString());
	}
}
