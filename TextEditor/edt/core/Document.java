package edt.core ;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.io.*;

/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Class that define the main structure of document
  *@version 4
*/
public class Document extends Section {

	private String _filename="";
	private Map<String,Author> _authors=new TreeMap<String,Author>();
	private Map<String,TextElement> _textElements= new HashMap<String,TextElement>() ;

	/**
	 * Constructor.
	 */
	public Document(){
	}

	/**
	 * Constructor.
	 * @param title of the main section (document) 
	 */
	public Document(String title){
		super(title);
		
	}

	/**
	 * Add author to TreeMap.
	 * @param author
	 */
	public void addAuthor(Author author) {
		_authors.put(author._name,author);
	}

	/**
	 * Get all the authors.
	 * @return Map of authors
	 */	
	public Map<String,Author> getAuthors(){
		return _authors;
	}

	/**
	 * Get Text Element from HashMap.
	 * @param id of text element
	 * @return TextElement if exists, null if don't
	 */
	public TextElement getTextElement (String id){
			return _textElements.get(id);	
	}

	/**
	 * To the selected Text Element atribute id.
	 * @param id
	 * @param element
	 */
	public void indexElement (String id, TextElement element){
		if(getTextElement(id)==null){
			_textElements.put(id,element);
			element.setKey(id);
		}
		else{
			removeFromIndex(getTextElement(id));
			_textElements.put(id,element);
			element.setKey(id);
		}	
	}

	/**
	 * To the selected Text Element remove it from HashMap in Document.
	 *
	 * @param element
	 */
	public void removeFromIndex(TextElement element){
		_textElements.remove(element.getKey());
		element.setKey("");
	}

	/**
	 * Load the document with the name given.
	 * @param name of document
	 * @return Document
	 */
	public Document loadDocument(String name)
		throws IOException, ClassNotFoundException{
	  ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));

	  Document doc = (Document)in.readObject();
	  in.close();
	  return doc;
	}

	/**
	 * Save document with the name given.
	 * @param name of document
	 */
	public void saveDocument(String name) throws IOException{
	  	ObjectOutputStream out =
	    new ObjectOutputStream(new FileOutputStream(name));
	  	_filename= name;
	  	out.writeObject(this);
	  	out.close();
	}

	/**
	 * Get title of main section (Document).
	 * @return String title
	 */
	public String getTitle(){
		return super.getTitle();
	}

	/**
	 * Get section of Document.
	 * @param idx (section identifier)
	 * @return Section with the given idx
	 */
	public Section getSection(int idx) {
		
		return super.getSection(idx)  ;
	}


	/**
	 * Get filename of Document.
	 * @return String filename
	 */
	public String getFilename(){
		return _filename;
	}

	/**
	 * Set filename of Document.
	 * @param filename
	 */
	public void setFilename( String filename){
		_filename=filename;
	}

//--------------metodos adicionais --------------------------

	public Map<String,TextElement> getTextElements(){
		return _textElements;
	}
}