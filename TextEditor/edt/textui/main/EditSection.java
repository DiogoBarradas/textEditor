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
import edt.textui.section.EditMenu;

/**
 * Open Edit Menu with the current section. 
 */
public class EditSection extends Command<App> {

    /**
     * Constructor.
     * 
     * @param App app
     */
    public EditSection(App app) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Menu m = new EditMenu(entity().getDocument(),entity().getDocument());
        m.open();    
    }  
}
