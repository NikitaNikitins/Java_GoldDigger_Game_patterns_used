package game.objects.maps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import game.abstracts.AbstractGameMap;
import game.abstracts.AbstractGameObject;
import game.enums.GameObjectType;
import game.interfaces.gamemap.collections.GameCollection;
import game.objects.Coordinate;
import game.objects.creators.GameObjectCreator;

public class FSGameMap extends AbstractGameMap {
    
    public FSGameMap(){   
        super();
    }

    public FSGameMap(GameCollection gameCollection) {
        super(gameCollection);
    }

    @Override
    public boolean loadMap(Object source) {
        File file = new File(source.toString());
        if (!file.exists()) {
            throw new IllegalArgumentException("filename must not be empty!");
        }

        try {
            setExitExist(false);
            setGoldManExist(false);

            setHeight(getLineCount(file));

            BufferedReader br = new BufferedReader(new FileReader(file));

            String strLine = br.readLine().trim();
            
            setName(strLine.split(",")[0]);

            setTimeLimit(Integer.valueOf(strLine.split(",")[1]).intValue());
            setWidth(Integer.valueOf(strLine.split(",")[2]).intValue());

            int y = 0;
            int x = 0; 

            while ((strLine = br.readLine()) != null) {
                x = 0;

                for (String str : strLine.split(",")) {

                    createGameObject(str, new Coordinate(x, y));
                    x++;
                }
                y++;
            }

            if (!isValidMap()) {
                throw new Exception("The map is not valid!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;

    }

    private void createGameObject(String str, Coordinate coordinate) {

        GameObjectType type = GameObjectType.valueOf(str.toUpperCase());


        AbstractGameObject newObj = GameObjectCreator.getInstance().createObject(type, coordinate);

        getGameCollection().addGameObject(newObj);

        if (newObj.getType() == GameObjectType.EXIT) {
            setExitExist(true);
        } else if (newObj.getType() == GameObjectType.GOLDMAN) {
            setGoldManExist(true);
        }

    }

    @Override
    public boolean saveMap(Object source) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private int getLineCount(File file) {
        BufferedReader reader = null;
        int lineCount = 0;
        try {
            reader = new BufferedReader(new FileReader(file));

            while (reader.readLine() != null) {
                lineCount++;
            }
            lineCount = lineCount - 1;
        } catch (IOException ex) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lineCount;

    }
}
