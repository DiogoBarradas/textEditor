package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {
    private Document _document;
  
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Section sec, Document doc) {
        super(MenuEntry.NAME_PARAGRAPH, sec);
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
        InputString inS = new InputString(f,Message.requestUniqueId());
        f.parse();

        try{
            if(entity().getParagraph(inI.value()).isIndexed()){
                _document.indexElement(inS.value(),(entity().getParagraph(inI.value())));  
            }
            else{
                _document.removeFromIndex(entity().getParagraph(inI.value()));
                _document.indexElement(inS.value(),(entity().getParagraph(inI.value())));
                display.addNewLine(Message.paragraphNameChanged());
            }
        }
        catch(NullPointerException e){
            display.addNewLine(Message.noSuchParagraph(inI.value()));
        }
        catch(IndexOutOfBoundsException e){
        }
        display.display();
    }
}
