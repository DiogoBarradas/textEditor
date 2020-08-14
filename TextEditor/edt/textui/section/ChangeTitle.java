package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;



/**
* Changes title of current section.
*/
public class ChangeTitle extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param entity aplication
     */
    public ChangeTitle(Section sec) {
        super(MenuEntry.CHANGE_TITLE,sec);
    }

    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputString inS = new InputString(f,Message.requestSectionTitle());
        f.parse();
        
        entity().setTitle(inS.value());

    }
}
