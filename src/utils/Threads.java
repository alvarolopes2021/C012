/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import models.Box;
import models.Truck;
import models.Worker;
import views.Scene;

/**
 *
 * @author alvar
 */
public class Threads extends Thread {

    String nome; //nome da thread

    private JFrame frame;
    private Scene cena;

    public int firstColumnDx = 50;
    public int secondColumnDx = 20;

    private Worker worker;
    private JLabel workerLabel;
    public int workerDx;
    private Truck truck;
    private JLabel truckLabel;

    public List<JLabel> boxPileImages;

    public Threads(String name, List<JLabel> boxPileImage, Truck truck, Scene cena) {
        this.truck = truck;
        this.nome = name;
        this.cena = cena;
        this.boxPileImages = boxPileImage;
    }

    @Override
    public void run() {
        int boxToRemove = 7;

        while (true) {
            System.out.println("eu sou o " + worker.getName());

            if (this.truck.getCapacity() <= 0 && this.boxPileImages.size() <= 0) {
                System.out.println("JOB WELL DONE");
                break;
            } 
            
                        
            else if (this.workerLabel.getX() > this.firstColumnDx && !this.worker.isFull()) {
                System.out.println("going to get packages");
                this.worker.setIsUnloading(false);
                this.workerLabel.setBounds(
                        this.workerLabel.getX() - 20,
                        this.workerLabel.getY(),
                        this.workerLabel.getWidth(),
                        this.workerLabel.getHeight()
                );
                ImageIcon image;
                if (this.worker.getName().equals("JAVA")) {
                    image = new ImageIcon(getClass().getResource("../resources/worker1-left.png"));
                } else {
                    image = new ImageIcon(getClass().getResource("../resources/worker2-left.png"));
                }
                this.workerLabel.setIcon(image);
                this.frame.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            else if (this.workerLabel.getX() <= this.firstColumnDx && !this.worker.isFull()) {
                System.out.println("loading");
                Container parent = this.boxPileImages.get(boxToRemove).getParent();
                if (boxToRemove <= 7) {
                    parent.remove(this.boxPileImages.get(boxToRemove));
                    this.boxPileImages.remove(boxToRemove);
                    parent.repaint();
                    boxToRemove--;
                    System.out.println("tamanho da pilha: " + this.boxPileImages.size());
                }
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.worker.setIsLoading(true);
                this.worker.setFull(true);

            }
            
            
            else if (this.workerLabel.getX() <= this.truckLabel.getX() && this.worker.isFull()) {
                System.out.println("going back");
                this.worker.setIsLoading(false);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
                ImageIcon image;
                if (this.worker.getName().equals("JAVA")) {
                    image = new ImageIcon(getClass().getResource("../resources/worker1-right.png"));
                } else {
                    image = new ImageIcon(getClass().getResource("../resources/worker2-right.png"));
                }
                this.workerLabel.setIcon(image);
                this.workerLabel.setBounds(
                        this.workerLabel.getX() + 20,
                        this.workerLabel.getY(),
                        this.workerLabel.getWidth(),
                        this.workerLabel.getHeight()
                );
                this.frame.repaint();
            } 
            
            
            else if (this.workerLabel.getX() > this.truckLabel.getX() && this.worker.isFull()) {
                System.out.println("unloading");
                if (this.truck.getCapacity() > 0) {
                    int load = this.truck.getCapacity();
                    this.truck.setLoad(load - (load - 1));
                    this.truck.setCapacity(this.truck.getCapacity() - 1);
                    System.out.println(this.truck.getPlate() + " com capacidade: " + this.truck.getCapacity());
                }
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.worker.setIsUnloading(true);
                this.worker.setFull(false);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public JLabel getWorkerLabel() {
        return workerLabel;
    }

    public JLabel getTruckLabel() {
        return truckLabel;
    }

    public void setTruckLabel(JLabel truckLabel) {
        this.truckLabel = truckLabel;
    }

    public void setWorkerLabel(JLabel workerLabel) {
        this.workerLabel = workerLabel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

}
