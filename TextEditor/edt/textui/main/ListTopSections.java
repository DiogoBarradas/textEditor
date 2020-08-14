package edt.textui.main;
/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
*/

import edt.core.*;

import java.util.SortedSet;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app App
     */
    public ListTopSections(App app) {
        super(MenuEntry.SHOW_INDEX, app);
    }

    /**
     * Execute the command.
     * Get and display all the top sections.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display(title()); 

        display.addNewLine("{"+entity().getDocument().getTitle()+"}");
        for(Section i : entity().getDocument().getSubsections()){
            display.addNewLine(Message.sectionIndexEntry(i.getKey(),i.getTitle()));
        }
        display.display();   
    }
}
