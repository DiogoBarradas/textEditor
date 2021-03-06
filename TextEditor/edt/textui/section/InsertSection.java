package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertSection(Section sec) {
        super(MenuEntry.INSERT_SECTION, sec);
        
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger inI = new InputInteger(f,Message.requestSectionId());
        InputString inS = new InputString(f,Message.requestSectionTitle());
        f.parse();

        Section sec = new Section(inS.value());
        entity().addSection(inI.value(), sec); 
    }
}