package fr.univlille1.m2iagl.bacquetdurey.doclet;

import java.io.File;
import java.io.PrintWriter;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;
import fr.univlille1.m2iagl.bacquetdurey.parser.Parser;

public class GetJavadocDoclet {
	public static boolean start(RootDoc root) {
		
		ClassDoc[] classes = root.classes();
		
		for (int i = 0; i < classes.length; ++i) {
			ClassDoc classDoc = classes[i];
			
			ClassModel classModel = Parser.parseClass(classDoc);
			Model.actualModel.addClassModel(classModel);

		}

		return true;
	}
}