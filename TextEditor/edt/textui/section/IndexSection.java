package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;



/**
 * Command for indexing a subsection.
 */
public class IndexSection extends Command<Section> {
    private Document _document;

    /**
     * Constructor.
     * 
     * @param sec 
     */
    public IndexSection(Section sec,Document doc) {
        super(MenuEntry.NAME_SECTION, sec);
        _document=doc;
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        Form f = new Form();
        InputInteger inI = new InputInteger(f,Message.requestSectionId());
        InputString inS = new InputString(f,Message.requestUniqueId());
        f.parse();
        
        try{
            if(entity().getSection(inI.value()).isIndexed()){
                _document.indexElement(inS.value(), entity().getSection(inI.value()));
            }
            else{
                _document.removeFromIndex(entity().getSection(inI.value()));
                _document.indexElement(inS.value(), entity().getSection(inI.value()));
                display.addNewLine(Message.sectionNameChanged());
            }
        }
        catch(NullPointerException e){
            display.addNewLine(Message.noSuchSection(inI.value()));
        }
        catch(IndexOutOfBoundsException e){
        }
        display.display();   
    }
}
