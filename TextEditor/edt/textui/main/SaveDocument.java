package edt.textui.main;

import edt.core.*;
import java.io.IOException;
import java.io.ObjectOutputStream;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.io.*;

/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Command to save the current Document.
  */
public class SaveDocument extends Command<App> {

    /**
     * Constructor. 
     * 
     * @param app of entity
     */
    public SaveDocument(App app) {
        super(MenuEntry.SAVE, app);
    }

    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        Display display = new Display();
        Document doc = new Document();
        Form f = new Form();

        if((entity().getDocument().getFilename()).equals("")){
            InputString inS = new InputString(f,Message.newSaveAs());
            display.display();
            f.parse();
            try{
              (entity().getDocument()).saveDocument(inS.value());
            }
            catch(IOException e ){
              display.add(Message.fileNotFound(doc.getFilename()));
              display.display();
            }     
        }
        else{
          try{
            entity().getDocument().saveDocument(entity().getDocument().getFilename());
          }
          catch(IOException e ){
            display.add(Message.fileNotFound(doc.getFilename()));
            display.display();
          }
        }   
    }
}
