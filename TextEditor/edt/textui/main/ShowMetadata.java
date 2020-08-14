package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.core.*;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Command that shows the atual carachteristics of document.
  * @version 2
 */
public class ShowMetadata extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app of entity
     */
    public ShowMetadata(App app) {
        super(MenuEntry.SHOW_METADATA, app);
    }

    /**
	   * Show the title of the document, authors by order,
	   * document bytes and document identifiers.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
		Display display = new Display(title()); 
		Set set = entity().getDocument().getAuthors().entrySet();
        Iterator iterator = set.iterator();
		display.addNewLine(Message.documentTitle((entity().getDocument()).getTitle()));
		while(iterator.hasNext()){
			Map.Entry m = (Map.Entry)iterator.next();	
			display.addNewLine(Message.author((((Author)m.getValue()).getName()),((Author)m.getValue()).getEmail()));
		}
				
		display.addNewLine(Message.documentSections((entity().getDocument()).getSubsections().size()));
		display.addNewLine(Message.documentBytes((entity().getDocument()).getSize()));
		display.addNewLine(Message.documentIdentifiers(entity().getDocument().getTextElements().size()));
		display.display();
		
		
    }
}
