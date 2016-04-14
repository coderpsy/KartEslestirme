
import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 *Omer Faruk Ozefe
 *Jul 31, 2015
 *4:12:44 PM
 */
public class Kart extends JLabel
{
    public boolean isAcik;
    ImageIcon acikResim, kapaliResim;
    /**
     * num parametresini alarak kart nesnesini olusturur.
     * 
     * @param num 
     */
    public Kart(int num) 
    {
        
        setSize(128, 128);
        try
        {
            
            URL imgURL = this.getClass().getResource("icons/"+num+".png");
            acikResim = new ImageIcon(imgURL);
            URL noneURL= this.getClass().getResource("icons/kapali.png");
            kapaliResim = new ImageIcon(noneURL);
            
            this.setIcon(kapaliResim);
            isAcik = false;
        } catch (Exception e) { e.printStackTrace(); }
    }
    /**
     * kart aciksa true dondurur.
     * @return 
     */
    public boolean acikMi()
    {
        return isAcik;
    }
    /**
     * 
     * karti acar.
     */
    public void kartAc()
    {
        isAcik = true;
        this.setIcon(acikResim);
    }
    /**
     * karti kapar.
     */
    public void kartKapat()
    {
        isAcik = false;
        this.setIcon(kapaliResim);
    }
    
    
}
