package edt.core;


/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Class that defines structure and methods of Text Element.
  * @version 1
 */


public abstract class TextElement implements java.io.Serializable{

	private String _key="";

/**
  * Constructor.
  */
  public TextElement(){}

	
/**
  * Get id (key) of the current Text Element.
  * 
  * @return String _key
  */
	public String getKey(){
		return _key;
	}

/**
  * Set id (key) of the current Text Element.
  * 
  * @param key
  */
	public void setKey(String key){
		_key=key;
	}
	
/**
  * Hidden state method to know if is indexed.
  * 
  * @return boolean true
  */
	public boolean isIndexed(){
    return _key.equals("");
	}

/**
  * Abstract classes that will be defined
  * in subclasses.
  */
	public abstract String getContent();
	public abstract int getSize();

}