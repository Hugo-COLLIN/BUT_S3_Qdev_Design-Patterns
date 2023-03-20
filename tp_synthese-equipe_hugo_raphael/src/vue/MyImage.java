package vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Classe permettant le rendu des pizzas
 */
public class MyImage {

    /**
     * Image correspondante
     */
    Image image;

    /**
     * Chemin d'acces de l'image
     */
    String imPath;

    /**
     * Representation de l'image dans un StackPane
     */
    StackPane sp;



    public MyImage(String path, StackPane s) {
        try{
            //this.image = new Image(MainLogo.class.getResource(path).toString());
            image = new Image(path);
            this.imPath=path;
            if (s==null) {
                this.sp=new StackPane();
                sp.setMinSize(200,200);
                ImageView img = new ImageView();
                img.setFitWidth(200);
                img.setFitHeight(200);
                img.setImage(image);
                sp.getChildren().add(img);
            }
            else sp=s;
        }
        catch(Exception e)
        {
            System.out.println("Error creating image with path "+path);
            System.out.println(e);
        }
    }
    /*
    --- GETTERS ---
     */

    /**7
     * Getter de sp
     * @return l'image dans un StackPane
     */
    public StackPane getSp() {
        return sp;
    }

    /**
     * Getter de imPath
     * @return chemin de l'image
     */
    public String getImPath(){
        return imPath;
    }

    /**
     * Superposition d'une autre image sur l'image courante
     *
     * @param imageAAjouter
     *            designe le chemin ou trouver l'image a ajouter au dessus de
     *            l'image courante stockee dans this
     */
    public void superposer(String imageAAjouter) {
        // on charge l'image
        image = new Image(imageAAjouter);
        ImageView img = new ImageView();
        img.setFitHeight(200);
        img.setFitWidth(200);
        img.setImage(image);
        sp.getChildren().add(img);
    }

}
