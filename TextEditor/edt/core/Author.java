package edt.core;

/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Class that define methods of author.
  * @version 1
*/
public class Author implements java.io.Serializable {

	protected String _name;
	protected String _email;
	
	/**
	 * Constructor.
	 * @param  name of author
	 * @param  email of author
	 */
	public Author(String name, String email){
		_name=name;
		_email=email;
	}
	
	/**
	 * Get email of author.
	 * @return String _email
	 */
	public String getEmail(){
		return _email;
	}
	
	/**
	 * Get name of author.
	 * @return String _name 
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * Compare current author with given author.
	 * @param  author 
	 * @return int 0 if they are equal, 1 otherwise
	 */
	public int compareTo(Author author){
		if(this._name==author._name && this._email==author._email){
			return 0;
		}
		else{
			return 1;
		}	
	}
	
	/**
	 * Compare current author with object.
	 * @param  author 
	 * @return boolean true if equal, false otherwise
	 */	
	public boolean equals( Object obj ){
		return(this==obj);
	}
}