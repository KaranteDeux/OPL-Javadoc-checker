package fr.univlille1.m2iagl.bacquetdurey.controller;

import java.io.PrintWriter;

import fr.univlille1.m2iagl.bacquetdurey.analysis.AnalysisModel;
import fr.univlille1.m2iagl.bacquetdurey.analysis.ClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.PackageModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class ResultWriter{
	
	PrintWriter printWriter;
	
	AnalysisModel analysisModel;
	
	public ResultWriter(PrintWriter printWriter, AnalysisModel analysisModel){
		this.printWriter = printWriter;
		this.analysisModel = analysisModel;
	}
	
	public void write(){
		
		for(ClassAnalysis classModel : analysisModel.getClassesAnalysis()){
			writeClassAnalysis(classModel);
		}
		
		printWriter.close();
	}

	public void writeClassAnalysis(ClassAnalysis classAnalysis){
		
		printWriter.write(" - " + classAnalysis.getAnalysisMessage());
		
		/*for(FieldModel fieldModel : analysisModel.getFields()){
			writeFieldModel(fieldModel);
		}
		
		for(ConstructorModel constructorModel : analysisModel.getConstructors()){
			writeConstructorModel(constructorModel);
		}
		
		for(MethodModel methodModel : analysisModel.getMethods()){
			writeMethodModel(methodModel);
		}
			*/

	}
/*
	public void writeConstructorModel(ConstructorModel constructorModel){
		
		printWriter.write("\t");

	}

	public void writeFieldModel(FieldModel fieldModel){
		
		String info = "\t* " + fieldModel.getName() + "-"  + fieldModel.getType() + " " + fieldModel.getName() + " - ";
		String javadoc = "// ";
		
		if(fieldModel.getCommentText() != "")
			javadoc += fieldModel.getCommentText();
		else
			javadoc += "EMPTY";
		
		printWriter.write(info);
		printWriter.write(javadoc);
		

	}
	
	public void writeMethodModel(MethodModel methodModel){
		
		String partialSignature = methodModel.getVisibility() + " " + methodModel.getReturnType() + " " + methodModel.getName();
				
		printWriter.write("\t" + partialSignature + "\n");
		
		printWriter.write("\t(\n");
	
		for(ParameterModel parameterModel : methodModel.getParameters()){
			writeParameterModel(parameterModel);
		}
		
		printWriter.write("\t)");
	}

	public void writePackageModel(PackageModel packageModel){
		
	}

	public void writeParameterModel(ParameterModel parameterModel){
		
		String parameterInfo = parameterModel.getType() + " " + parameterModel.getName() + " // ";

		if(parameterModel.getCommentText() != "")
			parameterInfo += parameterModel.getCommentText();
		else
			parameterInfo += "EMPTY";
		
		printWriter.write("\t\t" + parameterInfo + "\n");

	}*/



}
