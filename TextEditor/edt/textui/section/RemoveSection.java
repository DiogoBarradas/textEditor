package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {
    private Document _document;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveSection(Section sec,Document doc) {
        super(MenuEntry.REMOVE_SECTION, sec);
        _document = doc;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger inI = new InputInteger(f,Message.requestSectionId());
        f.parse();

        try{
            entity().removeSection(inI.value(),_document);
        }
        catch(IndexOutOfBoundsException e){
        }
    }
}
