package fr.univlille1.m2iagl.bacquetdurey.model;

import java.util.ArrayList;
import java.util.List;

public class MethodModel extends AbstractElementModel{
	
	String returnType;
	
	String name;
	
	String visibility;
	
	List<ParameterModel> parametersModel;
	
	String commentText;
	
	String commentTextReturn;
	
	public MethodModel(String visibility, String returnType, String name, String commentText){
		this.visibility = visibility;
		this.returnType = returnType;
		this.name = name;
		
		this.commentText = commentText;

		this.parametersModel = new ArrayList<>();
	}

	public void addParameterModel(ParameterModel parameterModel){
		parametersModel.add(parameterModel);
	}
	
	public void addParametersModel(List<ParameterModel> parametersModel){
		for(ParameterModel parameterModel : parametersModel){
			addParameterModel(parameterModel);
		}
	}
	
	@Override
	public String toString() {
		return "MethodModel [returnType=" + returnType + ", name=" + name
				+ ", visibility=" + visibility + ", parametersModel="
				+ parametersModel + ", commentText=" + commentText
				+ ", commentTextReturn=" + commentTextReturn + "]";
	}

	@Override
	public String getName() {
		return name;
	}
	
	public String getVisibility(){
		return visibility;
	}
	
	public String getReturnType(){
		return returnType;
	}
	
	public List<ParameterModel> getParameters(){
		return parametersModel;
	}
	
	public void setCommentTextReturn(String commentTextReturn){
		this.commentTextReturn = commentTextReturn;
	}
	
	public String getCommentTextReturn(){
		return commentTextReturn;
	}
	
	@Override
	public String getCommentText(){
		return commentText;
	}
	
	

}
