package edt.textui.section;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {
  
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListSections(Section sec) {
        super(MenuEntry.LIST_SECTIONS, sec);
        
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        for(Section s : entity().getSubsections()){
            display.addNewLine(Message.sectionIndexEntry(s.getKey(),s.getTitle()));
            for(Section t : s.getSubsections()){
                display.addNewLine(Message.sectionIndexEntry(t.getKey(),t.getTitle()));
                for(Section u : t.getSubsections()){
                    display.addNewLine(Message.sectionIndexEntry(u.getKey(),u.getTitle()));
                }
            }
        }
        display.display();   
    }
}
