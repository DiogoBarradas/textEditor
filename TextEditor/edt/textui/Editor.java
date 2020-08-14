package edt.textui;

import static pt.utl.ist.po.ui.UserInteraction.IO;
import java.io.FileNotFoundException;
import java.io.IOException;
import pt.utl.ist.po.ui.Menu;
import edt.core.*;
import edt.textui.main.*;
import edt.textui.section.*;
import edt.parser.Parser;

/**
 * The main class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception  {
        
        Document doc = new Document();
        App app = new App();
        String fileName = System.getProperty("import");
 
        if(fileName !=null){
            Parser parser = new Parser();
            doc = parser.parse(fileName);
            app.setDocument(doc);}
            else{app.setDocument(doc);}

        
        IO.setTitle(doc.getFilename());
        Menu mainMenu = new MainMenu(app);
        mainMenu.open();

        IO.close();
    }
}
