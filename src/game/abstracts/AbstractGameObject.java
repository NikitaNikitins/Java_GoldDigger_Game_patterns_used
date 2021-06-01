package game.abstracts;

import java.util.Objects;

import javax.swing.ImageIcon;

import game.enums.GameObjectType;
import game.interfaces.gameobjects.StaticObject;
import game.objects.Coordinate;

//klaase, kura ir atbildiiga par jebkuro speeles obketu 
public abstract class AbstractGameObject implements StaticObject {
    
    private GameObjectType type;// katram objektam ir tips
    private Coordinate coordinate;// katram objetkam ir koordinaatas
    
    private ImageIcon icon = getImageIcon("/game/images/noicon.png");// default bilde

    protected AbstractGameObject() {
    }

    public void setIcon(ImageIcon currentIcon) {
        this.icon = currentIcon;
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    
    protected ImageIcon getImageIcon(String path){
        return new ImageIcon(getClass().getResource(path));
    }
    
    @Override
    public GameObjectType getType() {
        return type;
    }

    public void setType(GameObjectType type) {
        this.type = type;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 37 * hash + Objects.hashCode(this.coordinate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractGameObject other = (AbstractGameObject) obj;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    

   
}