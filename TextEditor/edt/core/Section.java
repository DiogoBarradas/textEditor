package edt.core;

import java.io.*;
import java.util.*;

/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Class that defines structure and methods of Section ( base of document).
  * @version 3
 */
public class Section extends TextElement {
	private String _title;

	private int numeroOrdem = 0;

	private List<Section> _listSections=new ArrayList<Section>();

	private List<Paragraph> _listParagraph= new ArrayList<Paragraph>();

	 

   /**
	 * Contructor.
	 *
	 * @param title of Section
	 */
	public Section(){
		_title = "";	 
	}

   /**
	 * Contructor.
	 *
	 * @param title of Section
	 */
	public Section (String title) {
		_title=title;	
		
	}


   /**
	 * Get Title of document / sections.
	 *            
	 * @return string title if document, title and key otherwise
	 */
	public String getHeadline() {
		if( this instanceof Document ){
			return "{"+_title+"}";
		}
		else{ 
			return "["+getKey()+"]"+" {"+_title+"}";
		}
	}
	

   /**
	 * Set title of current Section.
	 * @param title
	 */
	public void setTitle(String title) {
		_title = title;
	}

   /**
	 * Get title of current Section.
	 * @return String title 
	 */
	public String getTitle() {
		return _title;
	}

   /**
	 * Get size ( in bytes ) of current Section.
	 * @return int size
	 */
	public int getSize() {
		int tot=_title.length();
		
		for(Section i :_listSections){
			tot+=i.getSize();
		}	
		
		for(Paragraph n : _listParagraph){
			tot+=n.getSize();
		}	
		return tot;
	}

   /**
	 * Get content inside of current Section.
	 * @return String title
	 */
	public String getContent() {
		VisitorContent visitorcontent = new VisitorContent();
		return visitorcontent.visit(this);
	}

   /**
	 * Get subsections that exists in current Section.         
	 * @return List listSections 
	 */
	public List<Section> getSubsections() {
		return _listSections ;
	}

   /**
	 * Get Section with the id given.
	 * @param idx (Section identifier)
	 * @return Section section with idx
	 */
	public Section getSection(int idx) {
		if(idx < 0 || idx > _listSections.size()){
			return null;
		}
		else{
			return _listSections.get(idx);
		}
	}

   /**
	 * Get subsection identifier.
	 * @return int id
	 */
	public String getSubsectionIndex() { 
		return this.getKey() ;
	}

   /**
	 * Add Section to the list of Sections with the id given.
	 * @param idx
	 * @param sec
	 */
	public void addSection(int idx, Section sec) {
		if (idx < 0 || idx > _listSections.size()){
			_listSections.add(sec);
		}
		else{
			_listSections.add(idx, sec);
		}
	}

   /** 
     * Remove subsections and paragraphs and itself 
     * from given idx Section from list and Elements Hashmap.
	 * @param idx
	 * @param doc
	 * @return boolean true case it removes the section, false otherwise
	 */
	public boolean removeSection(int idx, Document doc) {
		int i=0;
		if(idx < 0 || idx > _listSections.size()){
			return false;
		}
		else{
			getSection(idx).clean(doc);
			_listSections.remove(idx);
			return true;
		}
	}

   /**
     * Add Paragraph after the given id to the list of Paragraphs.
	 * @param idx
	 * @param par
	 */
	public void addParagraph(int idx, Paragraph par) {
		if (idx < 0 || idx > _listParagraph.size()){
			_listParagraph.add(par);
		}
		else{
			_listParagraph.add(idx, par);
		}	
	}

   /**
     * Remove Paragraph with the given id to the list of Paragraphs and Elements HashMap.
	 * @param idx
	 * @param doc
	 * @return boolean true case can remove, false otherwise
	 */
	public boolean removeParagraph(int idx, Document doc) {
		if(idx < 0 || idx > _listParagraph.size()){
			return false;
		}
		else{
			if(getParagraph(idx).getKey().equals("")){
				doc.removeFromIndex(getParagraph(idx));
			}
			_listParagraph.remove(idx);
			return true;
		}
	}

   /**
     * Get Paragraph with the given id.
	 * @param idx
	 * @return Paragraph, null case Paragraph doesn't exists
	 */
	public Paragraph getParagraph(int idx) {
		if(idx < 0 || idx > _listParagraph.size()){
			return null;
		}
		else{
			return _listParagraph.get(idx);
		}
	}

//--------------------metodos adicionais------------------------
	/**
	 * Get paragraphs that exists in current Section.         
	 * @return List listparagraphs 
	 */
	public List<Paragraph> getParagraphs() {
		return _listParagraph;
	}

	/**
	 * Clean all the text elements under the section in Text Elements HashMap.       
	 * @param document 
	 */
	public void clean(Document document){
		document.removeFromIndex(this);
		for(Paragraph j : _listParagraph){
			j.clean(document);	
		}	
		for(Section i : _listSections){
			i.clean(document);
		}
	}
}