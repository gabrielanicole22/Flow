/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package flow;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Gaby
 */
public class JustAGirl extends javax.swing.JFrame {

    boolean reproduciendo = false;
    String archi = "slayy.ts";
    String rutaCancion = "";
    long puntero = 0;
    String cancionActual = "";
    MP3Player reproduciendoCancion;
    private ArrayList<String> cancionesSeleccionadas = new ArrayList<>();
    Color SELECT_COLOR = new Color(83, 152, 254);
    private Color colorOriginal;
    private Color colorOriginal2;
    private Color colorOriginal3;
    private Color colorOriginal4;

    private void cargarFromFile(File selectedSongsFile) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(selectedSongsFile));
            String line;
            DefaultListModel<String> model = new DefaultListModel<>();
            while ((line = lector.readLine()) != null) {
                cancionesSeleccionadas.add(line);
                model.addElement(line);
            }
            lector.close();
            listitaCancionesBonitas.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        colorOriginal4 = jLabel3.getForeground();
        colorOriginal3 = jLabel2.getForeground();
        colorOriginal2 = song.getForeground();
        colorOriginal = btnSelect.getForeground();
    }

    private void guardarSongs() {
        try {
            BufferedWriter guarda = new BufferedWriter(new FileWriter("selected_songs.txt"));
            for (String song : cancionesSeleccionadas) {
                guarda.write(song);
                guarda.newLine();
            }
            guarda.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cambiosGuardar(String rutaCancion, long puntero, String songName) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(archi, "rw");
            archivo.writeUTF(rutaCancion);
            archivo.writeLong(puntero);
            archivo.writeUTF(songName);
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> ubiCanciones(String rutaCancion) {
        if (rutaCancion.equals("")) {
            return new ArrayList<String>();
        }
        File folder = new File(rutaCancion);
        ArrayList<String> canciones = new ArrayList<>();
        for (File f : folder.listFiles()) {
            if (f.getName().endsWith(".mp3")) {
                canciones.add(f.getName().replace(".mp3", ""));
            }
        }
        return canciones;
    }

    private void botonesEstado(boolean enabled) {
        btnPlay.setEnabled(enabled);
        btnPrevious.setEnabled(enabled);
        btnNext.setEnabled(enabled);
        btnAleatorio.setEnabled(enabled);
        btnLoop.setEnabled(enabled);
        btnSelect.setEnabled(enabled);
    }

    private void rem() {
        DefaultListModel<String> model = new DefaultListModel<>();
        listitaCancionesBonitas.setModel(model);
    }

    public void reproducir(String songName) {
        String path = rutaCancion + File.separator + songName + ".mp3";
        if (reproduciendoCancion != null) {
            reproduciendoCancion.stop();
        }
        reproduciendoCancion = new MP3Player(new File(path));
        reproduciendoCancion.play();
        reproduciendo = true;
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listitaCancionesBonitas = new javax.swing.JList<>();
        song = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnPrevious = new javax.swing.JLabel();
        btnPlay = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnSelect = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnLoop = new javax.swing.JLabel();
        btnAleatorio = new javax.swing.JLabel();
        btnAddPlaylist = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPUTANDOKISSKISS");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listitaCancionesBonitas.setBackground(new java.awt.Color(0, 0, 0));
        listitaCancionesBonitas.setForeground(new java.awt.Color(204, 0, 102));
        jScrollPane2.setViewportView(listitaCancionesBonitas);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 790, 220));

        song.setBackground(new java.awt.Color(102, 0, 102));
        song.setFont(new java.awt.Font("Rage Italic", 0, 24)); // NOI18N
        song.setForeground(new java.awt.Color(255, 153, 255));
        song.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                songMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                songMouseExited(evt);
            }
        });
        jPanel2.add(song, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 790, 60));

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anterior.png"))); // NOI18N
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siguiente.png"))); // NOI18N
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        btnSelect.setFont(new java.awt.Font("Parchment", 1, 60)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(204, 204, 255));
        btnSelect.setText("Seleccionar");
        btnSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelectMouseExited(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnLoop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/repetir.png"))); // NOI18N
        btnLoop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoopMouseClicked(evt);
            }
        });

        btnAleatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aleatorio.png"))); // NOI18N
        btnAleatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAleatorioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAleatorioMouseEntered(evt);
            }
        });

        btnAddPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir-lista.png"))); // NOI18N
        btnAddPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPlaylistMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("add playlist");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("add canción");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnAleatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrevious)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlay)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)
                        .addGap(33, 33, 33)
                        .addComponent(btnLoop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnSelect)
                        .addGap(38, 38, 38)
                        .addComponent(btnAddPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelect)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAddPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPlay, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnPrevious, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(btnAleatorio)
                            .addComponent(btnLoop)
                            .addComponent(btnNext))
                        .addGap(14, 14, 14)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 790, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wp.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAleatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAleatorioMouseClicked
        // TODO add your handling code here:
        if (reproduciendoCancion != null) {
            reproduciendoCancion.stop();
        }
        ArrayList<String> canciones = ubiCanciones(rutaCancion);
        if (!canciones.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(canciones.size());
            cancionActual = canciones.get(randomIndex);
            cambiosGuardar(rutaCancion, puntero, cancionActual);
            song.setText(cancionActual);
            File canci = new File(rutaCancion + File.separator + cancionActual + ".mp3");
            reproduciendoCancion = new MP3Player(canci);
            reproduciendoCancion.play();
            reproduciendo = true;
            btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png")));
            botonesEstado(true);
            cambiosGuardar(rutaCancion, puntero, cancionActual);
        }
    }//GEN-LAST:event_btnAleatorioMouseClicked

    private void btnPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseClicked
        // TODO add your handling code here:
        if (reproduciendoCancion != null) {
            reproduciendoCancion.skipBackward();
            for (int i = 0; i < listitaCancionesBonitas.getModel().getSize(); i++) {
                String n = listitaCancionesBonitas.getModel().getElementAt(i);
                if (n.equals(cancionActual)) {
                    if (i - 1 == -1) {
                        cancionActual = listitaCancionesBonitas.getModel().getElementAt(0);
                    } else {
                        cancionActual = listitaCancionesBonitas.getModel().getElementAt(i - 1);
                    }
                    song.setText(cancionActual);
                    cambiosGuardar(rutaCancion, puntero, cancionActual);
                    reproducir(cancionActual);
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnPreviousMouseClicked

    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        // TODO add your handling code here:
        if (reproduciendo) {
            reproduciendo = false;
            btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/detener.png")));
            reproduciendoCancion.pause();
        } else {
            reproduciendo = true;
            btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png")));
            reproduciendoCancion.play();
        }
    }//GEN-LAST:event_btnPlayMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:
        if (reproduciendoCancion != null) {
            reproduciendoCancion.skipForward();
            for (int i = 0; i < listitaCancionesBonitas.getModel().getSize(); i++) {
                String n = listitaCancionesBonitas.getModel().getElementAt(i);
                if (n.equals(cancionActual)) {
                    if (i + 1 == listitaCancionesBonitas.getModel().getSize()) {
                        cancionActual = listitaCancionesBonitas.getModel().getElementAt(0);
                    } else {
                        cancionActual = listitaCancionesBonitas.getModel().getElementAt(i + 1);
                    }
                    song.setText(cancionActual);
                    cambiosGuardar(rutaCancion, puntero, cancionActual);
                    reproducir(cancionActual);
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnNextMouseClicked

    private void reiniciarCancionActual() {
        if (reproduciendoCancion != null) {
            reproduciendoCancion.stop();
            reproduciendoCancion.play();
            reproduciendo = true;
            btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png")));
        }
    }
    private void btnLoopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoopMouseClicked
        // TODO add your handling code here:
        reiniciarCancionActual();
    }//GEN-LAST:event_btnLoopMouseClicked

    private void cargarCanciones() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String song : cancionesSeleccionadas) {
            model.addElement(song);
        }
        listitaCancionesBonitas.setModel(model);
        botonesEstado(false);
        song.setText("PONGAN CHERRY");
    }
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        if (reproduciendoCancion != null) {
            reproduciendoCancion.stop();
        }
        try {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(this);
            File selectedFile = chooser.getSelectedFile();
            if (selectedFile == null) {
                return;
            }
            rutaCancion = selectedFile.getParent();
            cancionActual = selectedFile.getName().replace(".mp3", "");
            cambiosGuardar(rutaCancion, puntero, cancionActual);
            song.setText(cancionActual);
            File canci = new File(selectedFile.getAbsolutePath());
            reproduciendoCancion = new MP3Player(canci);
            reproduciendoCancion.play();
            reproduciendo = true;
            btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png")));
            botonesEstado(true);
            cancionesSeleccionadas.add(cancionActual);
            DefaultListModel<String> model = new DefaultListModel<>();
            for (String song : cancionesSeleccionadas) {
                model.addElement(song);
            }
            listitaCancionesBonitas.setModel(model);
            guardarSongs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseClicked
        // TODO add your handling code here:
        if (reproduciendoCancion != null) {
            reproduciendoCancion.stop();
        }
        if (listitaCancionesBonitas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona qué quieres escuchar (TAYLOR SWIFT/LDR).");
            return;
        }
        cancionActual = listitaCancionesBonitas.getSelectedValue();
        cambiosGuardar(rutaCancion, puntero, cancionActual);
        song.setText(cancionActual);
        File canci = new File(rutaCancion + File.separator + cancionActual + ".mp3");
        reproduciendoCancion = new MP3Player(canci);
        reproduciendoCancion.play();
        reproduciendo = true;
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png")));
        botonesEstado(true);
        cambiosGuardar(rutaCancion, puntero, cancionActual);
    }//GEN-LAST:event_btnSelectMouseClicked

    private void cargarPlaylists() {
        ArrayList<String> canciones = ubiCanciones(rutaCancion);

        listitaCancionesBonitas.removeAll();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String song : canciones) {
            model.addElement(song);
        }
        listitaCancionesBonitas.setModel(model);
        botonesEstado(false);
        song.setText("PONGAN A TAYLOR");
    }
    private void btnAddPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPlaylistMouseClicked
        // TODO add your handling code here:
        if (reproduciendoCancion != null) {
            reproduciendoCancion.stop();
        }
        try {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showOpenDialog(this);
            File selectedFolder = chooser.getSelectedFile();
            if (selectedFolder == null) {
                return;
            }
            rutaCancion = selectedFolder.getCanonicalPath();
            puntero = 0;
            cancionActual = "";
            cambiosGuardar(rutaCancion, puntero, cancionActual);

            ArrayList<String> canciones = ubiCanciones(rutaCancion);
            cancionesSeleccionadas.addAll(canciones);
            DefaultListModel<String> m = new DefaultListModel<>();
            for (String song : cancionesSeleccionadas) {
                m.addElement(song);
            }
            listitaCancionesBonitas.setModel(m);
            guardarSongs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddPlaylistMouseClicked

    private void btnSelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseEntered
        // TODO add your handling code here:
        btnSelect.setForeground(SELECT_COLOR);
        setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnSelectMouseEntered

    private void btnSelectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseExited
        // TODO add your handling code here:
        btnSelect.setForeground(colorOriginal);
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnSelectMouseExited

    private void btnAleatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAleatorioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAleatorioMouseEntered

    private void songMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_songMouseEntered
        // TODO add your handling code here:
        song.setForeground(SELECT_COLOR);
        setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_songMouseEntered

    private void songMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_songMouseExited
        // TODO add your handling code here:
        song.setForeground(colorOriginal2);
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_songMouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setForeground(SELECT_COLOR);
        setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jLabel2.setForeground(colorOriginal3);
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        jLabel3.setForeground(SELECT_COLOR);
        setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        jLabel3.setForeground(colorOriginal4);
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jLabel3MouseExited

    public JustAGirl() {
        initComponents();
        try {
            File info = new File("slayy.ts");
            File selectedSongsFile = new File("selected_songs.txt");

            rem();
            if (!info.exists()) {
                info.createNewFile();
                RandomAccessFile archivo = new RandomAccessFile(info, "rw");
                archivo.writeUTF("");
                archivo.writeLong(0);
                archivo.writeUTF("");
                archivo.close();
                song.setText("");
                botonesEstado(false);
            } else {
                RandomAccessFile archivo = new RandomAccessFile(info, "rw");
                archivo.seek(0);
                rutaCancion = archivo.readUTF();
                puntero = archivo.readLong();
                cancionActual = archivo.readUTF();
                cargarCanciones();
                cargarPlaylists();
                cargarFromFile(selectedSongsFile);
                ultimaS();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ultimaS() {
        if (cancionActual.equals("")) {
            song.setText("");
            botonesEstado(false);
        } else {
            boolean halladap = false;
            for (int i = 0; i < listitaCancionesBonitas.getModel().getSize(); i++) {
                String I = listitaCancionesBonitas.getModel().getElementAt(i);
                if (I.equals(cancionActual)) {
                    String path = rutaCancion + File.separator + cancionActual + ".mp3";
                    reproduciendoCancion = new MP3Player(new File(path));
                    song.setText(cancionActual);
                    reproduciendo = false;
                    btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/detener.png")));
                    botonesEstado(true);
                    halladap = true;
                    continue;
                }
                if (halladap) {
                    String name = listitaCancionesBonitas.getModel().getElementAt(i);
                    String path = rutaCancion + File.separator + name + ".mp3";
                    reproduciendoCancion.addToPlayList(new File(path));
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JustAGirl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JustAGirl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JustAGirl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JustAGirl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JustAGirl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnAddPlaylist;
    private javax.swing.JLabel btnAleatorio;
    private javax.swing.JLabel btnLoop;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPlay;
    private javax.swing.JLabel btnPrevious;
    private javax.swing.JLabel btnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listitaCancionesBonitas;
    private javax.swing.JButton song;
    // End of variables declaration//GEN-END:variables
}
