package fr.univlille1.m2iagl.bacquetdurey.model;

public class ParameterModel extends AbstractElementModel{
	
	String name;
	String type;
	
	String commentText;
	
	public ParameterModel(String type, String name, String commentText){
		this.name = name;
		this.type = type;
		this.commentText = commentText;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public String getType(){
		return type;
	}
	
	public String getCommentText(){
		return commentText;
	}
}
