package com.evarion.workPicture;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ChangeGui frame = new ChangeGui();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
