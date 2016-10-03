package fr.univlille1.m2iagl.bacquetdurey.model;

import java.util.ArrayList;
import java.util.List;

public class ClassModel extends AbstractElementModel{
	
	private String name;
	
	private List<FieldModel> fieldsModel;
	
	private List<ConstructorModel> constructorsModel;
	
	private List<MethodModel> methodsModel;
	
	private String commentText;
	
	public ClassModel(String name, String commentText){
		this.name = name;
		this.commentText = commentText;
		
		fieldsModel = new ArrayList<>();
		constructorsModel = new ArrayList<>();
		methodsModel = new ArrayList<>();
		
	}
	
	public void addFieldModel(FieldModel fieldModel){
		fieldsModel.add(fieldModel);
	}
	
	public void addConstructorModel(ConstructorModel constructorModel){
		constructorsModel.add(constructorModel);
	}
	
	public void addMethodModel(MethodModel methodModel){
		methodsModel.add(methodModel);
	}

	
	@Override
	public String toString() {
		return "ClassModel [name=" + name + ", fieldsModel=" + fieldsModel
				+ ", constructorsModel=" + constructorsModel
				+ ", methodsModel=" + methodsModel + ", commentText="
				+ commentText + "]";
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getCommentText(){
		return commentText;
	}
	
	public List<FieldModel> getFields(){
		return fieldsModel;
	}
	
	public List<ConstructorModel> getConstructors(){
		return constructorsModel;
	}
	
	public List<MethodModel> getMethods(){
		return methodsModel;
	}
	
	

}
