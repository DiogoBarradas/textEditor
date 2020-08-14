package edt.core;

public class VisitorContent implements Visitor {
	private String content;
		
	public String visit(Section section ){	
		content = section.getHeadline() + "\n" ;

		for(Paragraph n : section.getParagraphs()){
			content+=n.getRealContent()+ "\n";
		}
		
		for(Section i :section.getSubsections()){
			content+=i.getContent()+ "\n";
		}	
		return content;
	}
		
	public String visit(Paragraph paragraph ){
		return paragraph.getRealContent();
	}			
}