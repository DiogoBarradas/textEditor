package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.textui.main.EditSection;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Section> {

    private Document _document;
    

    /**
     * Constructor.
     * 
     * @param app of entity
     */
    public SelectSection(Section sec, Document doc) {
        super(MenuEntry.SELECT_SECTION, sec);
        _document=doc;
        
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        Form f = new Form();
        InputInteger inI = new InputInteger(f,Message.requestSectionId());
        f.parse();

        try{
            if((inI.value())<0 || (inI.value())>entity().getSubsections().size()){
                display.addNewLine(Message.noSuchSection(inI.value())).display();
            }
            else{
                Menu m = new EditMenu(entity().getSection(inI.value()),_document);
                display.addNewLine(Message.newActiveSection(inI.value())).display();
                m.open();
            }
        }
        catch(IndexOutOfBoundsException e){
            display.addNewLine(Message.noSuchSection(inI.value())).display();
        }
    }
}
