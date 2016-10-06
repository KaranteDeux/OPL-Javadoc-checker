package fr.univlille1.m2iagl.bacquetdurey.main;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.analysis.AnalysisModel;
import fr.univlille1.m2iagl.bacquetdurey.controller.JavadocAnalyser;
import fr.univlille1.m2iagl.bacquetdurey.controller.ResultWriter;
import fr.univlille1.m2iagl.bacquetdurey.doclet.DocletLauncher;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;


public class Start {

	private static String masterBranch = "../Test/src";

	private static String pullRequestBranch = "../TestPullRequest/src";

	public static void main(String [] args) throws Exception{

		List<String> packages = new ArrayList<>();
		packages.add("com.test");

		DocletLauncher docletLauncher = new DocletLauncher();

		docletLauncher.start(masterBranch, packages, Model.masterBranchModel);

		docletLauncher.start(pullRequestBranch, packages, Model.pullRequestBranchModel);

		JavadocAnalyser analyser = new JavadocAnalyser(Model.masterBranchModel, Model.pullRequestBranchModel);
		analyser.analyse();
		
		
		File file = new File("javadoc_analysis.txt");

		ResultWriter resultWriter = new ResultWriter(new PrintWriter(file), AnalysisModel.currentAnalysisModel);
		resultWriter.write();
/*
		File fileBis = new File("javadoc_analysis_bis.txt");

		ResultWriter resultWriterBis = new ResultWriter(new PrintWriter(fileBis), Model.pullRequestBranchModel);
		resultWriterBis.write();
		
		*/

		//	GitChecker gitChecker = new GitChecker(Git.open(new File(REMOTE_URL)));

		//	System.out.println(gitChecker.listSrcFilesFromRepository().toString());
	}
}
