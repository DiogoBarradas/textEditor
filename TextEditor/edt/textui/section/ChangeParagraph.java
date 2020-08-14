package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ChangeParagraph(Section sec) {
        super(MenuEntry.EDIT_PARAGRAPH, sec);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        Form f = new Form();
        InputInteger inI = new InputInteger(f,Message.requestParagraphId());
        InputString inS = new InputString(f,Message.requestParagraphContent());
        f.parse();

        if((inI.value())<0 || (inI.value())>entity().getParagraphs().size()){
            display.add(Message.noSuchParagraph(inI.value()));
        }
        else{
            entity().getParagraph(inI.value()).setText(inS.value());
        }
        display.display();
        
   }
}
