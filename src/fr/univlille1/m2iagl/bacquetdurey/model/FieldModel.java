package fr.univlille1.m2iagl.bacquetdurey.model;

public class FieldModel extends AbstractElementModel{
	
	String name;
	String type;
	
	String commentText;
	
	public FieldModel(String name, String type, String commentText){
		this.name = name;
		this.type = type;
		this.commentText = commentText;
	}

	@Override
	public String toString() {
		return "FieldModel [name=" + name + ", type=" + type + ", commentText="
				+ commentText + "]";
	}

	@Override
	public String getName() {
		return name;
	}
	
	public String getType(){
		return type;
	}
	
	@Override
	public String getCommentText(){
		return commentText;
	}
	
	
}
