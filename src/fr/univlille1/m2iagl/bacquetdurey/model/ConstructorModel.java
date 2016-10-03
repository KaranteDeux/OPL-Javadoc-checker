package fr.univlille1.m2iagl.bacquetdurey.model;

import java.util.ArrayList;
import java.util.List;

public class ConstructorModel extends AbstractElementModel{
	
	private String commentText;
	
	private List<ParameterModel> parametersModel;
	
	public ConstructorModel(String commentText){
		this.commentText = commentText;
		parametersModel = new ArrayList<>();
	}
	
	public void addParameterModel(ParameterModel parameterModel){
		parametersModel.add(parameterModel);
	}

	@Override
	public String toString() {
		return "ConstructorModel [commentText=" + commentText
				+ ", parametersModel=" + parametersModel + "]";
	}

	@Override
	public String getName() {
		return "constructor";
	}
	
	@Override
	public String getCommentText(){
		return commentText;
	}
	
	

}
