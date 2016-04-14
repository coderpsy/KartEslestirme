
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * kart sınıfından nesne alarak oyunun ana penceresini olusturur.
 * 
 * @author faruk
 */
public class Ana extends javax.swing.JFrame implements MouseListener, KeyListener {

    int booleancnt = 0;
    int hamlesayisi = 0;
    int acilankartsayisi = 0;
    ArrayList<Kart> kL = new ArrayList<>();
    Kart temp;
    int jpx, jpy;
    boolean keypresscheck = false;
    Kart hilek;

    /**
     * Method aciklamasi: parametre olarak dosya yolu alır. yoldaki .wav
     * dosyasını çalar.
     *
     * @param yol dosya yolu(String)
     *
     */
    public void sesCal(String yol) {

        File fses = new File(yol); //parametrede yolu verilen ses dosyasını çalar
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fses);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex)
        {
            System.out.println("ses calma hatasi");
            ex.printStackTrace();
        }

    }

    public Ana() {
        initComponents();
        setLocationRelativeTo(null);
        setFocusable(true);
        int cnt = 0;

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Kart k = new Kart(cnt % 8);
                cnt++;
                kL.add(k);
                //16 kapali kart olusturuldu.
            }
        }

        Collections.shuffle(kL);//kartlar karistirildi.
        cnt = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Kart k = kL.get(cnt++);
                this.add(k);
                k.setVisible(true);
                k.setLocation(10 + ((128 * j) + 10), 10 + ((128 * i) + 10));
                k.addMouseListener(this);

                //kartlar ekranda yerlerini yerlestirildi.
            }
        }
        jpx = 4 * 140;
        jpy = 4 * 142;
        setSize(jpx, jpy);
        setResizable(false);

        Ana.ImagePanel panel = new Ana.ImagePanel(new ImageIcon("src/icons/bg.png").getImage());
        panel.setBounds(0, 0, jpx, jpy);
        getContentPane().add(panel);
        setVisible(true);
        addKeyListener(this);
        
    }

 /**  ImagePanel Sınıf Acıklaması:
 *
 *  instance olusturulurken parametre olarak image alir.
 *  ornek: ImagePanel(new ImageIcon("c:/resimler/resim1.jpg").getImage());
 * @param Image
 */
    class ImagePanel extends JPanel {

        public Image img;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {
            this.img = img;
            Dimension size = new Dimension(Ana.this.getWidth(), Ana.this.getHeight());
            setSize(size);
            setLayout(null);
        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("hamle sayisi:");

        jLabel2.setText("hileyi açıp kapatmak için bir kez ctrl ye basınız.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 474, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Ana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    @Override
    public void mouseClicked(MouseEvent e) {
        if (keypresscheck)
        {
            return;
        }
        jLabel1.setText("hamle sayısı: " + hamlesayisi); //hamle sayısını gosterir.

        Kart k = (Kart) e.getSource();

        if (k.acikMi()) //eger acik karta tiklanirsa o karti kapat ve return
        {
            booleancnt--;
            k.kartKapat();
            hamlesayisi++;

            return;
        }
        if (booleancnt == 0)//eger butun kartlar kapalıyken kapali karta tiklanirsa
        {                   //o karti temp e at,karti aç ve return
            if (!k.acikMi())
            {
                temp = k;
                booleancnt++;
                k.kartAc();
                hamlesayisi++;

            }
            return;
        }

        if (booleancnt < 2) //eger 1 kart acikken kapali karta tiklanirsa
        {                   //karti ac
            if (!k.acikMi())
            {
                booleancnt++;
                k.kartAc();
                hamlesayisi++;
            }
        }
        if (booleancnt == 2)//eger 2 kart aciksa 
        {
            new Thread(new Runnable() {

                @Override
                public void run() {

                    try
                    {
                        Thread.sleep(1000);//1 saniye bekle
                    } catch (Exception err)
                    {
                        err.printStackTrace();
                    }
                    if (k.acikResim.toString().equals(temp.acikResim.toString()))//temp ile acila kartin dosya yollari ayniysa
                    {
                        if (k.getLocation().toString().equals(temp.getLocation().toString()))//pozisyonları aynıysa return,bug onlemek için
                        {
                            System.out.println(k.getLocation() + "" + "" + temp.getLocation());
                            return;
                        }
                        sesCal("src/sound/ayni_kart.wav");
                        k.setVisible(false);
                        temp.setVisible(false); //aynı kartları ekrandan kaldır
                        Container parent = k.getParent();
                        parent.remove(k);
                        parent.validate();
                        //aynı kartları sil.
                        parent.remove(temp);
                        parent.validate();

                        acilankartsayisi++;
                        booleancnt = 0;
                        if (acilankartsayisi == 8)
                        {
                            sesCal("src/sound/oyun_bitti.wav");
                            JOptionPane.showMessageDialog(parent, "Oyun Bitti. Hamle Sayısı: "+hamlesayisi, "!!!", JOptionPane.INFORMATION_MESSAGE);

                        }

                    } else//eger kartlar aynıysa
                    {
                        sesCal("src/sound/farkli_kart.wav");
                        k.kartKapat();
                        temp.kartKapat();
                        booleancnt = 0;
                    }
                }
            }).start();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Kart k = (Kart) e.getSource();
        hilek = (Kart) e.getSource();
        if (keypresscheck)//hile acikken mouse resmin uzerine gelince karti ac
        {
            k.kartAc();
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        Kart k = (Kart) e.getSource();
        if (keypresscheck)
        {
            if (k.acikMi())//hile acikken mouse resimden cikinca karti kapat.
            {

                k.kartKapat();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CONTROL)
        {
            if (!keypresscheck)
            {
                JOptionPane.showMessageDialog(rootPane, "):", "Hile Aktif", 2);
                keypresscheck = true;//ctrl basınca hileyi aktiflestir.
                return;
            }
            if (keypresscheck)
            {

                hilek.kartKapat();
                JOptionPane.showMessageDialog(rootPane, ":)", "Hile Kapatıldı", 2);

                keypresscheck = false;
                return;
            }

        }
    }

}
