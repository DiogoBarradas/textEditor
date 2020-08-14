package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    

    /**
     * Constructor.
     * 
     * @param entity aplication
     */
    public InsertParagraph(Section sec) {
        super(MenuEntry.INSERT_PARAGRAPH, sec);
        
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger inI = new InputInteger(f,Message.requestParagraphId());
        InputString inS = new InputString(f,Message.requestParagraphContent());
        f.parse();

        Paragraph par = new Paragraph(inS.value());
        entity().addParagraph(inI.value(),par);
    }
}
