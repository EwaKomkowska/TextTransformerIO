package main_package;

public class Placeholder {
    private String text;
    private int classID;
    private int functionID;

    public Placeholder(){}

    public Placeholder(String text, int classID, int functionID) {
        this.functionID = functionID;
        this.text = text;
        this.classID = classID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getClassID() {
        return classID;
    }

    public int getFunctionID() {
        return functionID;
    }
}