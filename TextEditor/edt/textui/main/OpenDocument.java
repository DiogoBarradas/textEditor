package edt.textui.main;

import edt.core.*;

import java.io.*;
import edt.core.Document;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
  * @author     Ruben Condesso  Nº 81969
  * @author     Diogo Barradas  Nº 81975
  * @author     Miguel Carreiro Nº 82012   
  *
  * Command to open document on editor. 
  */
public class OpenDocument extends Command<App> {

    /**
     * Constructor.
     * 
     * @param app of entity
     */
    public OpenDocument(App app) { 
        super(MenuEntry.OPEN, app);
    }

    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation{
        Display display = new Display();
        Form f = new Form();
        InputString inS = new InputString(f,Message.openFile());
        f.parse();
            
        try{
            Document doc = entity().getDocument().loadDocument(inS.value());
            entity().setDocument(doc);
        }
        catch(IOException e ){
            display.add(Message.fileNotFound(inS.value())).display();
        }
        catch(ClassNotFoundException g){
            display.add(Message.fileNotFound(inS.value())).display();
        }
    }
}
