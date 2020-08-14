package edt.textui.main;
/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
*/

import edt.core.*;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Main Menu of aplcation.
 */

public class MainMenu extends Menu {
  
   /**
     * Constructor
     * 
     * @param app App
     */
    public MainMenu(App app) {
        super(MenuEntry.TITLE,
              new Command<?>[] { new NewDocument(app),
                      new OpenDocument(app),
                      new SaveDocument(app),
                      new ShowMetadata(app),
                      new AddAuthor(app),
                      new ListTopSections(app),
                      new ShowTextElement(app),
                      new EditSection(app),
                      });
    }
}