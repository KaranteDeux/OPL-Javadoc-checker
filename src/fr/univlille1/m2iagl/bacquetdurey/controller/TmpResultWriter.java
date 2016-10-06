package fr.univlille1.m2iagl.bacquetdurey.controller;

import java.io.PrintWriter;

import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;
import fr.univlille1.m2iagl.bacquetdurey.model.PackageModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class TmpResultWriter{
	
	PrintWriter printWriter;
	
	Model model;
	
	public TmpResultWriter(PrintWriter printWriter, Model model){
		this.printWriter = printWriter;
		this.model = model;
	}
	
	public void write(){
		
		for(ClassModel classModel : model.getClassModel()){
			writeClassModel(classModel);
		}
		
		printWriter.close();
		
		
	}

	public void writeClassModel(ClassModel classModel){
		
		printWriter.write(" - " + classModel.getName());
		
		for(FieldModel fieldModel : classModel.getFields()){
			writeFieldModel(fieldModel);
		}
		
		for(ConstructorModel constructorModel : classModel.getConstructors()){
			writeConstructorModel(constructorModel);
		}
		
		for(MethodModel methodModel : classModel.getMethods()){
			writeMethodModel(methodModel);
		}
			

	}

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

	}



}