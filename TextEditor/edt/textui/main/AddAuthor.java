package edt.textui.main;
/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
*/
import java.lang.*;
import java.io.*;
import edt.core.*;
import edt.textui.main.Message;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.Author;

/**
 * Add author to Document TreeMap of Authors.
 */
public class AddAuthor extends Command<App> {

    /**
     * Constructor
     * 
     * @param app App
     */
    public AddAuthor(App app) {
        super(MenuEntry.ADD_AUTHOR, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute(){
        Form f = new Form(title());
        InputString name = new InputString(f,Message.requestAuthorName());
        InputString email = new InputString(f,Message.requestEmail());
        Display display = new Display(title()); 
        f.parse();

        Author a1 = new Author(name.value(), email.value());
        entity().getDocument().addAuthor(a1);    
    }
}
