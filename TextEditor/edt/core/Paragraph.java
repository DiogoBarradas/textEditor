package edt.core;

/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Class that define the structure and methods of Text Element
  *@version 1
*/
public class Paragraph extends TextElement{
	private String _text;


	/**
	 * Constructor.
	 * @param text contained by paragraph
	 */
	public Paragraph(String text){
		_text=text;
	}

	/**
	 * Set the text of paragraph.
	 * @param text
	 */
	public void setText(String text){
		_text=text;
	}

	/**
	 * Get text of paragraph by visitor.
	 * @return text
	 */
	public String getContent(){
		VisitorContent visitorcontent = new VisitorContent();
		return visitorcontent.visit(this);	
	}

	/**
	 * Get size of paragraph (text inside).
	 * @return size
	 */
	public int getSize(){
		return _text.length();
	}

//----------------------metodo adicional (visitor)----------------
	/**
	 * Get text of paragraph.Same as getcontent().
	 * @return text
	 */
	public String getRealContent(){
		return _text;
	}

	/**
	 * Remove from Text Elements HashMap the information
	 * about itself 
	 * @return document
	 */
	public void clean(Document document){
		document.removeFromIndex(this);
	}	
}