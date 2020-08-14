package edt.core;
/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  *Class that defines aplication to run menu and get / set document.
  *@version 1
*/

import edt.core.Document;



public class App{
	private Document _doc=new Document();
	
	/**
	 * Construtor.
	 */

	public App (){
	}
	
	/**
	 * Get the document.
	 * @return Document 
	 */
	public Document getDocument(){
		return _doc; 
	}
	
	/**
	 * Set the document to be used.
	 * @param doc
	 */
	public void setDocument(Document doc){
		_doc=doc;

	}
	
	/**
	 * Create document.
	 */
	public void newDocument() {
		_doc = new Document();
	}
	

}