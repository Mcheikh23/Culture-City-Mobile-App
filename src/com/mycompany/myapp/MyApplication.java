package com.mycompany.myapp;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import com.mycompany.GUI.ListeClub;
//import com.mycompany.GUI.ConsulterSalle;
import com.mycompany.GUI.ListeEvennements;
//import com.mycompany.GUI.ListeProgramme;
 import com.mycompany.GUI.Login;
//import com.mycompany.GUI.listCommande;
import java.io.IOException;
 
//import com.mycompany.GUI.Login;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
      //  ProgrammeService pp = new ProgrammeService();
      //  pp.consulterProgrammes();
     //   System.out.println( pp.consulterProgrammes().size());
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start()  {
        if(current != null){
            current.show();
            return;
        }
       Login a = new Login (theme);
        new Login(theme).show();
     //  ListeClub lc = new  ListeClub(theme);
     //  lc.getF().show();
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }
////
}
