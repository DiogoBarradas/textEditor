package edt.core;

public interface Visitor {
 
    String visit(Section section);
    String visit(Paragraph paragraph);
}