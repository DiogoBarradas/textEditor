package edt.textui.main;
/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
*/

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;


/**
 * Shows the text element with the id given.
 */
public class ShowTextElement extends Command<App> {

    /**
     * Constructor da classe
     * 
     * @param app App
     */
    public ShowTextElement(App app) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        Form f = new Form();
        InputString inS = new InputString(f,Message.requestElementId());
        f.parse();

        try{
          display.addNewLine(entity().getDocument().getTextElement(inS.value()).getContent());
        }
        catch(IndexOutOfBoundsException e){
          display.addNewLine(Message.noSuchTextElement(inS.value()));
        }
        catch(NullPointerException e){
          display.addNewLine(Message.noSuchTextElement(inS.value()));
        }
        display.display();
    }
}