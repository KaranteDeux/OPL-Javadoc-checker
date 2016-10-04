package fr.univlille1.m2iagl.bacquetdurey.example;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import fr.univlille1.m2iagl.bacquetdurey.doclet.DocletLauncher;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;
import fr.univlille1.m2iagl.bacquetdurey.writer.ResultWriter;


public class Start {

	private static String example_1 = "../Test/src";
	
	public static void main(String [] args) throws Exception{
		
		DocletLauncher docletLauncher = new DocletLauncher(example_1, new ArrayList<String>());
		
		docletLauncher.start();
		
		File file = new File("javadoc_analysis.txt");
		
		ResultWriter resultWriter = new ResultWriter(new PrintWriter(file), Model.actualModel);
		resultWriter.write();
		
	//	GitChecker gitChecker = new GitChecker(Git.open(new File(REMOTE_URL)));
		
	//	System.out.println(gitChecker.listSrcFilesFromRepository().toString());
	}
}
