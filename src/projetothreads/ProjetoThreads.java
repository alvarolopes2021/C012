/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetothreads;

import javax.swing.JLabel;
import views.Scene;
/**
 *
 * @author alvar
 */
public class ProjetoThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProjetoThreads app = new ProjetoThreads();
        app.start();
    }
    
    void start(){
        Scene scene = new Scene();
        scene.setVisible(true);
    }
    
}
