import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/*
Author:@Tristán
*/
public class Menu extends WindowAdapter{
    JFrame frame;
    JPanel selectPosition;
    JPanelBackground wallpaper;
    JButton charmanderImage, select [];
    String chain [] = {"Play","Information","Battle"};
    BorderLayout border;

public Menu(){}

public void main(){
    frame = new JFrame();
    /*Agregamos la palabra reservada getClass() y getResource, para que podamos obtener dicha clase y de esa clase
    Solamente aplica con JButton, con JPanelBackground solamente es String. Es importante agregar el punto al inicio
    de nuestra ruta, para que tenga un punto de inicio y pueda accederlo. Recordemos que estamos haciendo una ruta
    relativa.
    */
    wallpaper = new JPanelBackground (".\\Images\\landscape.png"); 
    charmanderImage = new JButton(new ImageIcon(getClass().getResource("\\Images\\charmander.gif")));
    selectPosition = new JPanel();
    selectPosition.setOpaque(false); //Quitamos opacidad, para que se vea transparente
    charmanderImage.setContentAreaFilled(false); //Quitamos área
    charmanderImage.setBorderPainted(false); //Quitamos contorno
    border = new BorderLayout();
    select = new JButton[3];
    for (int i=0; i<select.length;i++){
        select[i] = new JButton(chain[i]); //Agregamos un for, en este caso cada vez se creará un botón y se guardará agregando los Strings de nuestra cadena "chain",
        select[i].setContentAreaFilled(false); //Así nos evitamos hacer esto con cada uno de los botones y hacemos pocas líneas de código :)
        select[i].setBorderPainted(false);
        selectPosition.add(select[i]);
    }
    wallpaper.setLayout(border);
    frame.add(wallpaper);
    wallpaper.add(charmanderImage, BorderLayout.CENTER);
    wallpaper.add(selectPosition, BorderLayout.SOUTH);
    frame.setVisible(true);
    frame.setSize(600,600);
    frame.setResizable(false);
}

//-------------------Wallpaper-------------------\\
public class JPanelBackground extends JPanel{
    private Image background; //Creamos nuestra variable en privado, ya que nadie debe tener acceso ni modificarlo
    public JPanelBackground(String imagePath){ //Se crea método para nuestro background
        setBackground(imagePath);
    }
    public void paintComponent(Graphics g){ //Se crea otro método para pintar el alto y ancho.
        int width = this.getSize().width;
        int height= this.getSize().height;
        if(this.background != null){ //Si nuestro background es nulo, entonces dibujamos nuestra imagen, tomando en cuenta las coordenadas y el alto y ancho
            g.drawImage(this.background,0,0,width,height, null);
        }
        super.paintComponent(g); //Usamos la palabra reservada super y llamamos nuestro método paintComponent(g);
    }
    public void setBackground(String ruta){ //Realizamos otro método para hacer un set de nuestro background.
        this.setOpaque(false); //Lo ponemos opaco.
        this.background = new ImageIcon(ruta).getImage(); //Creamos nuevo icono de imagen y obtenemos la imagen.
        repaint(); //Lo pintamos.
    }
}

public void WindowClosing (WindowEvent e){System.exit(0);}

}