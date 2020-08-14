package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {
    private Document _document;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(Section sec,Document doc) {
        super(MenuEntry.REMOVE_PARAGRAPH, sec);
        _document=doc;

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
        f.parse();
        
        try{
            entity().removeParagraph(inI.value(), _document);
        }
        catch(IndexOutOfBoundsException e){
            display.add(Message.noSuchParagraph(inI.value()));
        }
        display.display();
    }
}
