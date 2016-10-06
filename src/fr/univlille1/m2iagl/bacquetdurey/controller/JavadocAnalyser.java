package fr.univlille1.m2iagl.bacquetdurey.controller;

import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.analysis.AnalysisModel;
import fr.univlille1.m2iagl.bacquetdurey.analysis.ClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.helper.ListHelper;
import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class JavadocAnalyser {

	private Model masterModel;
	private Model pullRequestModel;

	public JavadocAnalyser(Model masterModel, Model pullRequestModel){
		this.masterModel = masterModel;
		this.pullRequestModel = pullRequestModel;
	}

	public void analyse(){

		List<String> existingClassModelNames = ListHelper.retainAllClasses(masterModel.getClassModel(), pullRequestModel.getClassModel());


		for(String className : existingClassModelNames){
			ClassModel masterModelClass = ListHelper.getClassModelByName(masterModel.getClassModel(), className);
			ClassModel pullRequestModelClass = ListHelper.getClassModelByName(pullRequestModel.getClassModel(), className);

			AnalysisModel.currentAnalysisModel.addClassAnalysis(analyseClass(masterModelClass, pullRequestModelClass));
		}

	}

	public ClassAnalysis analyseClass(ClassModel masterModelClass, ClassModel pullRequestModelClass){
		
		String masterCommentText = masterModelClass.getCommentText();
		String pullRequestCommentText = pullRequestModelClass.getCommentText();
		
		ClassAnalysis classAnalysis;
		
		if(masterCommentText.equals(pullRequestCommentText)){
			classAnalysis = new UnchangedClassAnalysis(masterModelClass.getName(), masterCommentText);
		
		} else if(masterCommentText.equals("")){
			classAnalysis = new AddedClassAnalysis(masterModelClass.getName(), pullRequestCommentText);
		
		} else if(pullRequestCommentText.equals("")){
			classAnalysis = new RemovedClassAnalysis(masterModelClass.getName(), masterCommentText);
		
		} else {
			classAnalysis = new ChangedClassAnalysis(masterModelClass.getName(), masterCommentText, pullRequestCommentText);
		}
		
		
		/*
		 * 3 boucles for
		 */
		
		List<String> existingFieldModelNames = ListHelper.retainAllFields(masterModelClass.getFields(), pullRequestModelClass.getFields());


		for(String fieldName : existingFieldModelNames){
			FieldModel masterModelField = ListHelper.getFieldModelByName(masterModelClass.getFields(), fieldName);
			FieldModel pullRequestModelField = ListHelper.getFieldModelByName(pullRequestModelClass.getFields(), fieldName);

			classAnalysis.addFieldAnalysis(analyseField(masterModelField, pullRequestModelField));
		}
		
		return classAnalysis;
				
				
	}

	public void analyseField(FieldModel masterModelClass, FieldModel pullRequestModelClass){

	}

	public void analyseConstructor(ConstructorModel masterModelClass, ConstructorModel pullRequestModelClass){

	}

	public void analyseMethod(MethodModel masterModelClass, MethodModel pullRequestModelClass){

	}

	public void analyseParameter(ParameterModel masterModelClass, ParameterModel pullRequestModelClass){

	}



}
