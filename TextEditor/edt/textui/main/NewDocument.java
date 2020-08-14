package edt.textui.main;
/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
*/

import edt.core.*;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Initializes document.
 */
public class NewDocument extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app App
     */
    public NewDocument(App app) {
        super(MenuEntry.NEW, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        entity().setDocument(new Document());
    }
}